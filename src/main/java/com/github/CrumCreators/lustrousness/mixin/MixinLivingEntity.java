package com.github.CrumCreators.lustrousness.mixin;// Created 2022-24-06T12:28:59

import com.github.CrumCreators.lustrousness.Config;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.entity.attribute.EntityAttributes.GENERIC_MAX_HEALTH;

/**
 * @author Ampflower
 * @since ${version}
 **/
@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity {
    @Shadow
    @Nullable
    public abstract EntityAttributeInstance getAttributeInstance(EntityAttribute attribute);

    /**
     * Sets the max health of the entity for the first time at initialisation.
     * <p>
     * This will take effect in all ways of spawning, including spawn eggs,
     * summon and world spawning.
     */
    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getMaxHealth()F", ordinal = 0))
    public void lustousness$setMaxHealth(EntityType<?> entityType, World world, CallbackInfo ci) {
        var range = Config.randomHealthRanges.get(entityType);
        if (range != null) {
            int health = range.random(world.random);
            var maxHealthAttribute = getAttributeInstance(GENERIC_MAX_HEALTH);
            // This should never be null, but on the off chance it is, no crash.
            if (maxHealthAttribute != null) {
                maxHealthAttribute.setBaseValue(health);
            }
        }
    }
}
