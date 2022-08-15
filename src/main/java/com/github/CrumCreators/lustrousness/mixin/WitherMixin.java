package com.github.CrumCreators.lustrousness.mixin;

import net.minecraft.client.render.entity.feature.SkinOverlayOwner;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;
import java.util.Random;

@Mixin(WitherEntity.class)
public abstract class WitherMixin extends HostileEntity implements SkinOverlayOwner, RangedAttackMob {

    protected WitherMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "mobTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlockState(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;"))
    public void mobTick(CallbackInfo ci) {
    Random random = new Random();
    if (this.getAttacker() != null && this.getAttacker().isPlayer() && random.nextInt(16) == 0 && this.world.getNonSpectatingEntities(WitherSkeletonEntity.class, Box.of(this.getPos(), 128, 320, 128)).size() <= 10 * this.world.getNonSpectatingEntities(PlayerEntity.class, Box.of(this.getPos(), 128, 320, 128)).size()) {
        WitherSkeletonEntity witherSkeleton = EntityType.WITHER_SKELETON.create(this.world);
        assert witherSkeleton != null;
        witherSkeleton.refreshPositionAndAngles(this.getBlockPos(), 0, 0);
        witherSkeleton.initialize(Objects.requireNonNull(this.getServer()).getWorld(this.getWorld().getRegistryKey()), this.world.getLocalDifficulty(this.getBlockPos()), SpawnReason.MOB_SUMMONED, null, null);
        Objects.requireNonNull(this.getServer().getWorld(this.world.getRegistryKey())).spawnEntity(witherSkeleton);
    }
    }
    @ModifyArg(method = "mobTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/boss/WitherEntity;heal(F)V"))
    private float inject(float par1) {
        return (float) ((this.getMaxHealth() * 0.666)/22);
    }
}
