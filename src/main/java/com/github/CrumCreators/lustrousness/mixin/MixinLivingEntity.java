package com.github.CrumCreators.lustrousness.mixin;// Created 2022-24-06T12:28:59

import com.github.CrumCreators.lustrousness.Config;
import com.github.CrumCreators.lustrousness.item.LustItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.entity.attribute.EntityAttributes.GENERIC_MAX_HEALTH;

/**
 * @author Ampflower
 * @since ${version}
 **/
@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity extends Entity {

    public MixinLivingEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    @Nullable
    public abstract EntityAttributeInstance getAttributeInstance(EntityAttribute attribute);

    @Shadow
    public abstract ItemStack getEquippedStack(EquipmentSlot slot);

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
            int health = range.random(this.random);
            var maxHealthAttribute = getAttributeInstance(GENERIC_MAX_HEALTH);
            // This should never be null, but on the off chance it is, no crash.
            if (maxHealthAttribute != null) {
                maxHealthAttribute.setBaseValue(health);
            }
        }
    }

    @Inject(method = "fall", at = @At("HEAD"), cancellable = true)
    private void lustrousness$fall$redirectIfSlimeBoots(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition, CallbackInfo ci) {
        if (onGround && getEquippedStack(EquipmentSlot.FEET).isOf(LustItems.SLIME_BOOTS)) {
            if (!isSilent() && fallDistance > 0F) {
                var slime = BlockSoundGroup.SLIME;
                var fallSound = slime.getFallSound();
                world.playSound(null, getX(), getY(), getZ(), fallSound, SoundCategory.BLOCKS,
                        slime.getVolume() * .5F, slime.getPitch() * 0.75F);
            }

            onLanding();
            ci.cancel();
        }
    }

    @Inject(method = "handleFallDamage", at = @At("HEAD"), cancellable = true)
    private void lustrousness$handleFallDamage$cancelIfSlimeBoots(float fallDistance, float damageMultiplier, DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (getEquippedStack(EquipmentSlot.FEET).isOf(LustItems.SLIME_BOOTS)) {
            cir.setReturnValue(Boolean.FALSE);
        }
    }
}
