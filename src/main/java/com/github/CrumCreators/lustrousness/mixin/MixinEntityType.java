package com.github.CrumCreators.lustrousness.mixin;

import com.github.CrumCreators.lustrousness.utils.RNG;
import net.minecraft.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityType.class)
public abstract class MixinEntityType {

    private static final RNG rng = new RNG();

    @Inject(at = @At("Head"), method = "create()V")
    private void create(CallbackInfoReturnable info) {
        //System.out.println("This line is printed by an example mod mixin!");
        rng.randomize();
    }
}

