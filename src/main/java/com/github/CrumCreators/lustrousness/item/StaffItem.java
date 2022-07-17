package com.github.CrumCreators.lustrousness.item;

import com.github.CrumCreators.lustrousness.util.ModelledPolymerItem;
import eu.pb4.polydex.api.PolydexTarget;
import eu.pb4.polymer.api.resourcepack.PolymerModelData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StaffItem extends ModelledPolymerItem {
    public StaffItem(Settings settings, PolymerModelData customModelData) {
        super(settings, customModelData);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.isSneaking()) {
            double tau = Math.PI * 2;
            double step = tau / 16D;
            double mul = 8D;
            for(double value = 0D; value < tau; value += step) {
                double x = Math.fma(Math.sin(value), mul, user.getX());
                double z = Math.fma(Math.cos(value), mul, user.getZ());
                world.spawnEntity(EntityType.LIGHTNING_BOLT.spawnFromItemStack((ServerWorld) world, getDefaultStack(), user, new BlockPos(x, user.getY(), z), SpawnReason.TRIGGERED, true, false));
                user.getItemCooldownManager().set(this, 1200);
            }
        } else {
            world.spawnEntity(EntityType.LIGHTNING_BOLT.spawnFromItemStack((ServerWorld) world, getDefaultStack(), user, PolydexTarget.get((ServerPlayerEntity) user).getTargetPos(), SpawnReason.TRIGGERED, true, false));
            user.getItemCooldownManager().set(this, 200);
        }
        return super.use(world, user, hand);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }
}
