package com.github.CrumCreators.lustrousness.item;

import com.github.CrumCreators.lustrousness.util.ModelledPolymerItem;
import com.github.CrumCreators.lustrousness.util.PolyLustUtils;
import eu.pb4.polymer.api.resourcepack.PolymerModelData;
import net.minecraft.block.SlimeBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class SlimeSling extends ModelledPolymerItem {

    public SlimeSling(Settings settings, PolymerModelData modelData) {
        super(settings, modelData);
    }

    public static Item SLIME_SLING;

    public static void registerSlimeSling() {
        SLIME_SLING = PolyLustUtils.ofModelled("slime_sling", Items.BOW, ItemGroup.TOOLS,
                (settings, modelData) -> new SlimeSling(settings.maxCount(1), modelData));
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (world.isClient || !user.isOnGround()) return;

        float force_multiplier = 0;
        if (user.isSneaking()) {
            force_multiplier = 4.5F;
        } else {
            force_multiplier = 2.5F;
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
