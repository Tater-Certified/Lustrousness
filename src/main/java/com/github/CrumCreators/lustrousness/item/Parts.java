package com.github.CrumCreators.lustrousness.item;

import com.github.CrumCreators.lustrousness.groups.Groups;
import com.github.CrumCreators.lustrousness.util.PolyLustUtils;
import eu.pb4.polymer.api.item.SimplePolymerItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class Parts extends SimplePolymerItem {

    public Parts(Settings settings, Item polymerItem) {
        super(settings, polymerItem);
    }

    public static Item stencil(String path) {
        return PolyLustUtils.ofModelled(path, Items.PAPER, Groups.WTOOLS_GROUP);
    }

    public static Item AXE_HEAD_STENCIL;
    public static Item BATTLE_AXE_HEAD_STENCIL;
    public static Item BINDING_STENCIL;
    public static Item BLADE_STENCIL;
    public static Item BLOCK_STENCIL;
    public static Item BOMB_STENCIL;
    public static Item BOOMERANG_STENCIL;
    public static Item BOW_LIMB_STENCIL;
    public static Item LONGBOW_LIMB_STENCIL;
    public static Item CLAWS_STENCIL;
    public static Item CLIPPERS_STENCIL;
    public static Item CROSSBOW_BODY_STENCIL;
    public static Item DRILL_BASE_STENCIL;
    public static Item DRILL_HEAD_STENCIL;
    public static Item EXCAVATOR_HEAD_STENCIL;
    public static Item FISHING_ROD_STENCIL;
    public static Item FRANCISCA_HEAD_STENCIL;
    public static Item GREAT_BLADE_STENCIL;
    public static Item GUARD_STENCIL;
    public static Item HAMMER_HEAD_STENCIL;
    public static Item HOE_HEAD_STENCIL;
    public static Item INGOT_STENCIL;
    public static Item KATANA_BLADE_STENCIL;
    public static Item KNIFE_BLADE_STENCIL;
    public static Item LIGHTER_STENCIL;
    public static Item MOLOTOV_STENCIL;
    public static Item NUGGET_STENCIL;
    public static Item PICKAXE_HEAD_STENCIL;
    public static Item REINFORCED_BINDING_STENCIL;
    public static Item REINFORCED_GUARD_STENCIL;
    public static Item REINFORCED_ROD_STENCIL;
    public static Item ROD_STENCIL;
    public static Item SCYTHE_HEAD_STENCIL;
    public static Item SHEARS_STENCIL;
    public static Item SHORT_BLADE_STENCIL;
    public static Item SHOVEL_HEAD_STENCIL;
    public static Item SHURIKEN_STENCIL;
    public static Item SPEAR_TIP_STENCIL;
    public static Item SPELL_BOOK_STENCIL;
    public static Item STAFF_STENCIL;
    public static Item STRIKER_STENCIL;
    public static Item STENCIL;
    public static Item SUMMONER_STENCIL;
    public static Item TRIDENT_HEAD_STENCIL;
    public static Item WAND_STENCIL;

    public static void registerStencils() {
         AXE_HEAD_STENCIL = stencil("axe_head_stencil");
         BATTLE_AXE_HEAD_STENCIL = stencil("battle_axe_head_stencil");
         BINDING_STENCIL = stencil("binding_stencil");
         BLADE_STENCIL = stencil("blade_stencil");
         BLOCK_STENCIL = stencil("block_stencil");
         BOMB_STENCIL = stencil("bomb_stencil");
         BOOMERANG_STENCIL = stencil("boomerang_stencil");
         BOW_LIMB_STENCIL = stencil("bow_limb_stencil");
         LONGBOW_LIMB_STENCIL = stencil("longbow_limb_stencil");
         CLAWS_STENCIL = stencil("claws_stencil");
         CLIPPERS_STENCIL = stencil("clippers_stencil");
         CROSSBOW_BODY_STENCIL = stencil("crossbow_body_stencil");
         DRILL_BASE_STENCIL = stencil("drill_base_stencil");
         DRILL_HEAD_STENCIL = stencil("drill_head_stencil");
         EXCAVATOR_HEAD_STENCIL = stencil("excavator_head_stencil");
         FISHING_ROD_STENCIL = stencil("fishing_rod_stencil");
         FRANCISCA_HEAD_STENCIL = stencil("francisca_head_stencil");
         GREAT_BLADE_STENCIL = stencil("great_blade_stencil");
         GUARD_STENCIL = stencil("guard_stencil");
         HAMMER_HEAD_STENCIL = stencil("hammer_head_stencil");
         HOE_HEAD_STENCIL = stencil("hoe_head_stencil");
         INGOT_STENCIL = stencil("ingot_stencil");
         KATANA_BLADE_STENCIL = stencil("katana_blade_stencil");
         KNIFE_BLADE_STENCIL = stencil("knife_blade_stencil");
         LIGHTER_STENCIL = stencil("lighter_stencil");
         MOLOTOV_STENCIL = stencil("molotov_stencil");
         NUGGET_STENCIL = stencil("nugget_stencil");
         PICKAXE_HEAD_STENCIL = stencil("pickaxe_head_stencil");
         REINFORCED_BINDING_STENCIL = stencil("reinforced_binding_stencil");
         REINFORCED_GUARD_STENCIL = stencil("reinforced_guard_stencil");
         REINFORCED_ROD_STENCIL = stencil("reinforced_rod_stencil");
         ROD_STENCIL = stencil("rod_stencil");
         SCYTHE_HEAD_STENCIL = stencil("scythe_head_stencil");
         SHEARS_STENCIL = stencil("shears_stencil");
         SHORT_BLADE_STENCIL = stencil("short_blade_stencil");
         SHOVEL_HEAD_STENCIL = stencil("shovel_head_stencil");
         SHURIKEN_STENCIL = stencil("shuriken_stencil");
         SPEAR_TIP_STENCIL = stencil("spear_tip_stencil");
         SPELL_BOOK_STENCIL = stencil("spell_book_stencil");
         STAFF_STENCIL = stencil("staff_stencil");
         STRIKER_STENCIL = stencil("striker_stencil");
         STENCIL = stencil("stencil");
         SUMMONER_STENCIL = stencil("summoner_stencil");
         TRIDENT_HEAD_STENCIL = stencil("trident_head_stencil");
         WAND_STENCIL = stencil("wand_stencil");
    }
}
