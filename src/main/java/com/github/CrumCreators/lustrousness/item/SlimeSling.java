package com.github.CrumCreators.lustrousness.item;

import com.github.CrumCreators.lustrousness.util.PolyLustUtils;
import eu.pb4.polymer.api.item.SimplePolymerItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class SlimeSling extends SimplePolymerItem {
    public SlimeSling(Settings settings, Item polymerItem) {
        super(settings, polymerItem);
    }

    public static Item SLIME_SLING;

    public static void registerSlimeSling() {
        SLIME_SLING = PolyLustUtils.ofModelled("slime_sling", Items.SLIME_BALL, ItemGroup.TOOLS);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {

        user.teleport(10,10,10);

        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return super.getUseAction(stack);
    }
}
