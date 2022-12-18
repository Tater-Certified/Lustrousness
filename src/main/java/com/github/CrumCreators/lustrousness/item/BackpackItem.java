package com.github.CrumCreators.lustrousness.item;

import com.github.CrumCreators.lustrousness.util.ModelledPolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.sgui.api.gui.SimpleGui;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import static net.minecraft.util.ActionResult.PASS;
import static net.minecraft.util.ActionResult.SUCCESS;

public class BackpackItem extends ModelledPolymerItem {

    public BackpackItem(Settings settings, PolymerModelData modelData) {
        super(settings, modelData);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (user instanceof ServerPlayerEntity serverPlayer) {
            SimpleGui backpackgui = new SimpleGui(ScreenHandlerType.GENERIC_9X1, serverPlayer, false);
            backpackgui.open();
            System.out.println("GUI OPEN");
            return new TypedActionResult<>(SUCCESS, stack);
        }
        return new TypedActionResult<>(PASS, stack);
    }
}
