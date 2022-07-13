package com.github.CrumCreators.lustrousness.item;

import eu.pb4.polymer.api.item.SimplePolymerItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.github.CrumCreators.lustrousness.Main.modid;

public class Parts extends SimplePolymerItem {

    public Parts(Settings settings, Item polymerItem) {
        super(settings, polymerItem);
    }

    public static Item stencil(String path) {
        Item item = new SimplePolymerItem(new FabricItemSettings().group(ItemGroup.MISC), Items.PAPER);
        Registry.register(Registry.ITEM, Identifier.of(modid, path), item);
        return item;
    }
    public static void registerStencils() {
        final Item AXE_HEAD_STENCIL = stencil("axe_head_stencil");
        final Item BATTLE_AXE_HEAD_STENCIL = stencil("battle_axe_head_stencil");
        final Item BINDING_STENCIL = stencil("binding_stencil");
        final Item BLADE_STENCIL = stencil("blade_stencil");
        final Item BOMB_STENCIL = stencil("bomb_stencil");
        final Item BOOMERANG_STENCIL = stencil("boomerang_stencil");
        final Item BOW_LIMB_STENCIL = stencil("bow_limb_stencil");
        final Item LONGBOW_LIMB_STENCIL = stencil("longbow_limb_stencil");
        final Item CLAWS_STENCIL = stencil("claws_stencil");
        final Item CLIPPERS_STENCIL = stencil("clippers_stencil");
        final Item CROSSBOW_BODY_STENCIL = stencil("crossbow_body_stencil");
        final Item DRILL_BASE_STENCIL = stencil("drill_base_stencil");
        final Item DRILL_HEAD_STENCIL = stencil("drill_head_stencil");
        final Item EXCAVATOR_HEAD_STENCIL = stencil("excavator_head_stencil");
        final Item FISHING_ROD_STENCIL = stencil("fishing_rod_stencil");
        final Item FRANCISCA_HEAD_STENCIL = stencil("francisca_head_stencil");
        final Item GREAT_BLADE_STENCIL = stencil("great_blade_stencil");
        final Item GUARD_STENCIL = stencil("guard_stencil");
        final Item HAMMER_HEAD_STENCIL = stencil("hammer_head_stencil");
        final Item HOE_HEAD_STENCIL = stencil("hoe_head_stencil");
        final Item KATANA_BLADE_STENCIL = stencil("katana_blade_stencil");
        final Item KNIFE_BLADE_STENCIL = stencil("knife_blade_stencil");
        final Item LIGHTER_STENCIL = stencil("lighter_stencil");
        final Item MOLOTOV_STENCIL = stencil("molotov_stencil");
        final Item PICKAXE_HEAD_STENCIL = stencil("pickaxe_head_stencil");
        final Item REINFORCED_BINDING_STENCIL = stencil("reinforced_binding_stencil");
        final Item REINFORCED_GUARD_STENCIL = stencil("reinforced_guard_stencil");
        final Item REINFORCED_ROD_STENCIL = stencil("reinforced_rod_stencil");
        final Item ROD_STENCIL = stencil("rod_stencil");
        final Item SCYTHE_HEAD_STENCIL = stencil("scythe_head_stencil");
        final Item SHEARS_STENCIL = stencil("shears_stencil");
        final Item SHORT_BLADE_STENCIL = stencil("short_blade_stencil");
        final Item SHOVEL_HEAD_STENCIL = stencil("shovel_head_stencil");
        final Item SHURIKEN_STENCIL = stencil("shuriken_stencil");
        final Item SPEAR_TIP_STENCIL = stencil("spear_tip_stencil");
        final Item SPELL_BOOK = stencil("spell_book");
        final Item STAFF_STENCIL = stencil("staff_stencil");
        final Item STEEL_STENCIL = stencil("steel_stencil");
        final Item STENCIL = stencil("stencil");
        final Item SUMMONER_STENCIL = stencil("summoner_stencil");
        final Item TRIDENT_STENCIL = stencil("trident_stencil");
        final Item WAND_STENCIL = stencil("wand_stencil");
    }
}
