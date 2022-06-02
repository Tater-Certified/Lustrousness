package com.github.CrumCreators.lustrousness.mixin;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.SheepEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static com.github.CrumCreators.lustrousness.utils.RNG.rngout;


@Mixin(SheepEntity.class)
public abstract class MixinSheepEntity {

    @Overwrite
    public static DefaultAttributeContainer.Builder createSheepAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, rngout).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23000000417232513D);
    }
}
