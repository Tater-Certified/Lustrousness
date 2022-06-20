package com.github.CrumCreators.lustrousness.item;

import com.github.CrumCreators.lustrousness.Main;
import eu.pb4.polymer.api.item.SimplePolymerItem;
import eu.pb4.sgui.api.gui.SimpleGui;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import static net.minecraft.util.ActionResult.PASS;
import static net.minecraft.util.ActionResult.SUCCESS;

public class Backpacks extends SimplePolymerItem {


    public Backpacks(Settings settings, Item polymerItem) {
        super(settings, polymerItem);
    }

    public static Item backpack() {
        return new SimplePolymerItem(new FabricItemSettings().group(ItemGroup.MISC), Items.LEATHER);
    }
    //Backpacks
    public static final Item TINY_BACKPACK = backpack();
    public static final Item SMALL_BACKPACK = backpack();
    public static final Item MEDIUM_BACKPACK = backpack();
    public static final Item LARGE_BACKPACK = backpack();
    public static final Item ADVENTURE_BACKPACK = backpack();

    //Register Backpacks
    public static void registerBackpacks() {
        Registry.register(Registry.ITEM, new Identifier(Main.modid, "tiny_backpack"), TINY_BACKPACK);
        Registry.register(Registry.ITEM, new Identifier(Main.modid, "small_backpack"), SMALL_BACKPACK);
        Registry.register(Registry.ITEM, new Identifier(Main.modid, "medium_backpack"), MEDIUM_BACKPACK);
        Registry.register(Registry.ITEM, new Identifier(Main.modid, "large_backpack"), LARGE_BACKPACK);
        Registry.register(Registry.ITEM, new Identifier(Main.modid, "adventure_backpack"), ADVENTURE_BACKPACK);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(user instanceof ServerPlayerEntity serverPlayer) {
            SimpleGui backpackgui = new SimpleGui(ScreenHandlerType.GENERIC_9X1, serverPlayer, false);
            backpackgui.open();
            System.out.println("GUI OPEN");
            return new TypedActionResult(SUCCESS, TINY_BACKPACK);
        }
        return new TypedActionResult(PASS, TINY_BACKPACK);
    }
}
