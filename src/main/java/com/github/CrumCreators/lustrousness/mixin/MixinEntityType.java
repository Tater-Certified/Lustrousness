package com.github.CrumCreators.lustrousness.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Objects;

import static net.minecraft.entity.attribute.EntityAttributes.GENERIC_MAX_HEALTH;

@Mixin(EntityType.class)
public abstract class MixinEntityType <T extends Entity> {

    @Inject(method="create(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/nbt/NbtCompound;Lnet/minecraft/text/Text;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/SpawnReason;ZZ)Lnet/minecraft/entity/Entity;", at=@At(value="INVOKE", target="Lnet/minecraft/entity/mob/MobEntity;playAmbientSound()V", shift= At.Shift.AFTER), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void create(ServerWorld world, NbtCompound itemNbt, Text name, PlayerEntity player, BlockPos pos, SpawnReason spawnReason, boolean alignPosition, boolean invertY, CallbackInfoReturnable<T> cir, Entity entity) {
        int health = (60-world.random.nextBetween(10, 50));
        Objects.requireNonNull(((MobEntity) entity).getAttributeInstance(GENERIC_MAX_HEALTH)).setBaseValue(health);
        ((MobEntity) entity).setHealth(health);
            System.out.println(health);
    }
}

