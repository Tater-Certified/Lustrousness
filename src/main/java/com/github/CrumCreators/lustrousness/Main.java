package com.github.CrumCreators.lustrousness;

import com.github.CrumCreators.lustrousness.item.Backpacks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Properties;


public class Main implements ModInitializer {
    //modid
    public static String modid = "lustrousness";

    //Config Version
    public String cfgver;

    public Properties properties = new Properties();

    @Override
    public void onInitialize() {
        //create config
        createCfg();
        //register items
        Backpacks.registerBackpacks();
    }


    public void createCfg() {
        var path = FabricLoader.getInstance().getConfigDir().resolve("lustrouness.properties");

        if (Files.notExists(path)) {
            try {
                mkfile();
                System.out.println("Creating Lustrousness config");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                loadcfg();
            } catch (IOException e) {
                e.printStackTrace();
            }
            cfgver = properties.getProperty("config-version");
            if (!(Objects.equals(cfgver, "1.0"))) {
                try {
                    mkfile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Updating Lustrousness config");
            } else {
                parse();
            }
        }
    }


    public void mkfile() throws IOException {
        OutputStream output = new FileOutputStream(String.valueOf(FabricLoader.getInstance().getConfigDir().resolve("lustrousness.properties")));
        if (!properties.contains("config-version")) {properties.setProperty("config-version", "1.0");}
        properties.store(output, null);
        parse();
    }

    public void loadcfg() throws IOException {
        InputStream input = new FileInputStream(String.valueOf(FabricLoader.getInstance().getConfigDir().resolve("lustrousness.properties")));
        properties.load(input);
    }

    public void parse() {
        cfgver = properties.getProperty("config-version");
    }
}