package com.github.CrumCreators.lustrousness.mixin;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.SheepEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;


@Mixin(SheepEntity.class)
public abstract class MixinSheepEntity {

    private static int min = 10;
    private static int max = 50;

    private static int rngout = (int)Math.floor(Math.random()*(max-min+1)+min);

    /**
     * @author QPCrummer
     * @reason Tater is reason
     */
    @Overwrite
    public static DefaultAttributeContainer.Builder createSheepAttributes() {
        return MobEntity.createMobAttributes();
    }
}
