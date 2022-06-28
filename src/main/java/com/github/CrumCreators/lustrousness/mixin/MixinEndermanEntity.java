package com.github.CrumCreators.lustrousness.mixin;// Created 2022-27-06T22:45:18

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.mob.EndermanEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

/**
 * @author Ampflower
 * @since ${version}
 **/
@Mixin(EndermanEntity.class)
public class MixinEndermanEntity {

    /**
     * Disables aggravation against endermites.
     *
     * @param instance The goal selector.
     * @param priority The original priority as provided by Mojang.
     * @param goal     The original goal as provided by Mojang.
     * @author Ampflower
     * @reason Disables aggravation against endermites.
     */
    @Redirect(
            method = "initGoals",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ai/goal/GoalSelector;add(ILnet/minecraft/entity/ai/goal/Goal;)V", slice = "primary", ordinal = 0),
            slice = @Slice(
                    id = "primary",
                    from = @At(value = "INVOKE:FIRST", target = "Lnet/minecraft/entity/ai/goal/ActiveTargetGoal;<init>(Lnet/minecraft/entity/mob/MobEntity;Ljava/lang/Class;ZZ)V")))
    private void lustrousness$removeEndermiteSpawning(GoalSelector instance, int priority, Goal goal) {
        // no-op
    }
}
