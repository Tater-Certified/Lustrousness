package com.github.CrumCreators.lustrousness;// Created 2022-22-06T20:08:33

import com.mojang.logging.LogUtils;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Properties;
import java.util.random.RandomGenerator;

/**
 * Configuration carrier for Lustrousness.
 * <p>
 * Note, this is a general catch-all class.
 *
 * @author Ampflower
 * @since ${version}
 **/
public abstract class Config {
    private static final Logger logger = LogUtils.getLogger();
    private static final String CURRENT_CONFIG_VERSION = "1.0";

    /**
     * Base directory for Lustrousness's configs.
     */
    private static final Path baseConfigDirectory = FabricLoader.getInstance().getConfigDir().resolve("lustrousness");
    private static final Path mainConfig = baseConfigDirectory.resolve("lustrousness.properties");
    private static final Path randomHealthConfig = baseConfigDirectory.resolve("random-health.properties");
    public static final HashMap<EntityType<?>, IntegerRange> randomHealthRanges = new HashMap<>();
    public static Properties mainProperties;

    private Config() {
        throw new UnsupportedOperationException();
    }

    /**
     * (Re)Loads the configuration of the mod.
     * <p>
     * Note: Mixins do <em>not</em> retroactively apply.
     *
     * @throws IOException When any part of config loading or creation fails.
     *                     All live settings will be left untouched when this error occurs.
     */
    public static void reload() throws IOException {
        Properties mainProperties, randomHealthProperties;

        if (Files.notExists(baseConfigDirectory)) {
            Files.createDirectory(baseConfigDirectory);
            // Create the base configuration.
            mainProperties = new Properties();
            // Will be discarded after this round.
            randomHealthProperties = new Properties();

            createMainConfig(mainProperties);
            createRandomHealthConfig(randomHealthProperties);
        } else {

            // Create temporary properties instances to allow for swapping in on success.
            mainProperties = tryLoadConfig(null, null, mainConfig, Config::createMainConfig);

            // Note: Main config must come first, as the following configs will
            // be dependent on the main config loading correctly first.

            randomHealthProperties = tryLoadConfig(mainProperties, ConfigConstants.RANDOM_HEALTH,
                    randomHealthConfig, Config::createRandomHealthConfig);

        }

        // We've made it to the end, lets parse down and make the configs take effect.
        Config.mainProperties = mainProperties;
        randomHealthRanges.clear();

        for (var rangeEntry : randomHealthProperties.entrySet()) {
            var entityType = Registry.ENTITY_TYPE.getOrEmpty(Identifier.tryParse((String) rangeEntry.getKey()));
            var valuesRaw = rangeEntry.getValue();

            // Check to make sure the entry's valid.
            if (entityType.isEmpty() || !(valuesRaw instanceof String stringValue) || stringValue.isBlank()) {
                logger.warn("Invalid entry of {} -> {}", rangeEntry.getKey(), rangeEntry.getValue());
                continue;
            }

            var values = stringValue.split("-");
            var range = values.length == 1 ?
                    new IntegerRange(Integer.parseInt(values[0])) :
                    new IntegerRange(Integer.parseInt(values[0]), Integer.parseInt(values[1]));

            randomHealthRanges.put(entityType.get(), range);
        }
    }

    /**
     * Try to load or create &amp; parse the config if possible.
     *
     * @param main     The main properties. Null if loading the main properties itself.
     * @param property The property of the main config to check if it should load.
     * @param path     The path of the configuration files. Must be not-null.
     * @param create   Method for creating the config.
     * @return The parsed out properties if read or created, empty otherwise.
     */
    private static Properties tryLoadConfig(@Nullable Properties main, @Nullable String property, @NotNull Path path,
                                            @NotNull ConfigCallable create) throws IOException {
        // Temporary container for properties.
        var properties = new Properties();

        // We check to see if both main and property are both null
        // in the case of main properties, or if the config evaluates
        // to true. If either condition is the case, the config will be
        // created or read as necessary.
        if (main == null || property == null || Boolean.parseBoolean(main.getProperty(property))) {
            if (Files.notExists(path)) {
                // The doesn't exist. Try to create the config.
                try {
                    create.invoke(properties);
                } catch (Exception e) {
                    // We failed. Just throw an IOException.
                    throw new IOException("Unable to create " + path, e);
                }
            } else {
                try (var configStream = Files.newInputStream(path)) {
                    properties.load(configStream);
                }
            }
        }
        return properties;
    }

    /**
     * Creates and stores the main config.
     *
     * @param properties The properties instance to fill.
     */
    private static void createMainConfig(Properties properties) throws IOException {
        properties.setProperty(ConfigConstants.CONFIG_VERSION, CURRENT_CONFIG_VERSION);
        properties.setProperty(ConfigConstants.RANDOM_HEALTH, "true");

        try (var configStream = Files.newOutputStream(mainConfig, StandardOpenOption.CREATE)) {
            // TODO: Link to config documentation.
            properties.store(configStream, "");
        }
    }

    /**
     * Creates and stores the random health config.
     *
     * @param properties The properties instance to fill.
     */
    private static void createRandomHealthConfig(Properties properties) throws IOException {
        properties.setProperty("example:example", "10-35");

        try (var configStream = Files.newOutputStream(randomHealthConfig, StandardOpenOption.CREATE)) {
            properties.store(configStream, """
                    Expected format is the mob's identifier to the range of health.
                                        
                    Such example is setting the health range of a chicken to 10 to 100 would be...
                    minecraft\\:chicken=10-100
                                        
                    A single value is also accepted, such as setting the wither to use 32.
                    minecraft\\:wither=32
                                        
                    Do note, any colons a part of the identifier must have a backslash before it.
                    """);
        }
    }

    /**
     * Double range representation.
     *
     * @param lower Lower bound of the randomness range.
     * @param upper Upper bound of the randomness range.
     */
    public record DoubleRange(double lower, double upper) {
        /**
         * Helper method for setting lower = upper.
         *
         * @param value What to set {@link #lower} and {@link #upper} bounds to.
         */
        public DoubleRange(double value) {
            this(value, value);
        }

        /**
         * @param random The random instance to use.
         * @return A random value between {@link #lower} and {@link #upper}.
         */
        public double random(RandomGenerator random) {
            return random.nextDouble(lower, upper);
        }

        /**
         * @param random Minecraft's random instance to use.
         * @return A random value between {@link #lower} and {@link #upper}.
         */
        public double random(Random random) {
            return random.nextDouble() * (upper - lower) + lower;
        }
    }

    /**
     * Integer range representation.
     *
     * @param lower Lower bound of the randomness range.
     * @param upper Upper bound of the randomness range.
     */
    public record IntegerRange(int lower, int upper) {
        /**
         * Helper method for setting lower = upper.
         *
         * @param value What to set {@link #lower} and {@link #upper} bounds to.
         */
        public IntegerRange(int value) {
            this(value, value);
        }

        /**
         * @param random The random instance to use.
         * @return A random value between {@link #lower} and {@link #upper}.
         */
        public int random(RandomGenerator random) {
            return random.nextInt(lower, upper);
        }

        /**
         * @param random Minecraft's random instance to use.
         * @return A random value between {@link #lower} and {@link #upper}.
         */
        public int random(Random random) {
            return random.nextBetween(lower, upper);
        }
    }

    /**
     * Internal callable intended for create handlers.
     *
     * @see #createMainConfig(Properties)
     * @see #createRandomHealthConfig(Properties)
     * @see #tryLoadConfig(Properties, String, Path, ConfigCallable)
     */
    @FunctionalInterface
    private interface ConfigCallable {
        void invoke(Properties properties) throws IOException;
    }

    /**
     * Carrier of config constants that don't need to be changed.
     */
    private static class ConfigConstants {
        /**
         * Configuration version key. Do not touch.
         */
        static final String CONFIG_VERSION = "config-version";
        /**
         * Enables or disables mob health randomisation.
         */
        static final String RANDOM_HEALTH = "randomHealth";
    }
}
