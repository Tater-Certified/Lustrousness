package com.github.CrumCreators.lustrousness.item;

import com.github.CrumCreators.lustrousness.util.ModelledPolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class SlimeSlingItem extends ModelledPolymerItem {

    public SlimeSlingItem(Settings settings, PolymerModelData modelData) {
        super(settings, modelData);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (world.isClient || !user.isOnGround()) return;

        float force_multiplier = 2.5F;
        if (user.isSneaking()) {
            force_multiplier = 4.5F;
        }

        float base = BowItem.getPullProgress(getMaxUseTime(stack) - remainingUseTicks) * force_multiplier;

        float yaw = user.getHeadYaw() * MathHelper.RADIANS_PER_DEGREE;
        float pitch = user.getPitch() * MathHelper.RADIANS_PER_DEGREE;
        float mul = MathHelper.cos(pitch) * base;

        // This goes backwards on purpose.
        float x = MathHelper.sin(yaw) * mul;
        float y = MathHelper.sin(pitch) * base;
        float z = -MathHelper.cos(yaw) * mul;

        user.setVelocity(user.getVelocity().add(x, y, z));
        user.velocityModified = true;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }
}
