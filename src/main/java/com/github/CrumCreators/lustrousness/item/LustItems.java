package com.github.CrumCreators.lustrousness.item;// Created 2022-15-07T20:07:09

import com.github.CrumCreators.lustrousness.util.PolyLustUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;

/**
 * @author Ampflower
 * @since ${version}
 **/
public final class LustItems {

    public static final Item TINY_BACKPACK = backpack("tiny_backpack", 1);
    public static final Item SMALL_BACKPACK = backpack("small_backpack", 2);
    public static final Item MEDIUM_BACKPACK = backpack("medium_backpack", 3);
    public static final Item LARGE_BACKPACK = backpack("large_backpack", 4);
    public static final Item ADVENTURE_BACKPACK = backpack("adventure_backpack", 5);

    public static final Item THUNDER_STAFF = staff("thunder_staff");

    public static final Item AXE_HEAD_STENCIL = stencil("axe_head_stencil");
    public static final Item BATTLE_AXE_HEAD_STENCIL = stencil("battle_axe_head_stencil");
    public static final Item BINDING_STENCIL = stencil("binding_stencil");
    public static final Item BLADE_STENCIL = stencil("blade_stencil");
    public static final Item BLOCK_STENCIL = stencil("block_stencil");
    public static final Item BOMB_STENCIL = stencil("bomb_stencil");
    public static final Item BOOMERANG_STENCIL = stencil("boomerang_stencil");
    public static final Item BOW_LIMB_STENCIL = stencil("bow_limb_stencil");
    public static final Item LONGBOW_LIMB_STENCIL = stencil("longbow_limb_stencil");
    public static final Item CLAWS_STENCIL = stencil("claws_stencil");
    public static final Item CLIPPERS_STENCIL = stencil("clippers_stencil");
    public static final Item CROSSBOW_BODY_STENCIL = stencil("crossbow_body_stencil");
    public static final Item DRILL_BASE_STENCIL = stencil("drill_base_stencil");
    public static final Item DRILL_HEAD_STENCIL = stencil("drill_head_stencil");
    public static final Item EXCAVATOR_HEAD_STENCIL = stencil("excavator_head_stencil");
    public static final Item FISHING_ROD_STENCIL = stencil("fishing_rod_stencil");
    public static final Item FRANCISCA_HEAD_STENCIL = stencil("francisca_head_stencil");
    public static final Item GREAT_BLADE_STENCIL = stencil("great_blade_stencil");
    public static final Item GUARD_STENCIL = stencil("guard_stencil");
    public static final Item HAMMER_HEAD_STENCIL = stencil("hammer_head_stencil");
    public static final Item HOE_HEAD_STENCIL = stencil("hoe_head_stencil");
    public static final Item INGOT_STENCIL = stencil("ingot_stencil");
    public static final Item KATANA_BLADE_STENCIL = stencil("katana_blade_stencil");
    public static final Item KNIFE_BLADE_STENCIL = stencil("knife_blade_stencil");
    public static final Item LIGHTER_STENCIL = stencil("lighter_stencil");
    public static final Item MOLOTOV_STENCIL = stencil("molotov_stencil");
    public static final Item NUGGET_STENCIL = stencil("nugget_stencil");
    public static final Item PICKAXE_HEAD_STENCIL = stencil("pickaxe_head_stencil");
    public static final Item REINFORCED_BINDING_STENCIL = stencil("reinforced_binding_stencil");
    public static final Item REINFORCED_GUARD_STENCIL = stencil("reinforced_guard_stencil");
    public static final Item REINFORCED_ROD_STENCIL = stencil("reinforced_rod_stencil");
    public static final Item ROD_STENCIL = stencil("rod_stencil");
    public static final Item SCYTHE_HEAD_STENCIL = stencil("scythe_head_stencil");
    public static final Item SHEARS_STENCIL = stencil("shears_stencil");
    public static final Item SHORT_BLADE_STENCIL = stencil("short_blade_stencil");
    public static final Item SHOVEL_HEAD_STENCIL = stencil("shovel_head_stencil");
    public static final Item SHURIKEN_STENCIL = stencil("shuriken_stencil");
    public static final Item SPEAR_TIP_STENCIL = stencil("spear_tip_stencil");
    public static final Item SPELL_BOOK_STENCIL = stencil("spell_book_stencil");
    public static final Item STAFF_STENCIL = stencil("staff_stencil");
    public static final Item STRIKER_STENCIL = stencil("striker_stencil");
    public static final Item STENCIL = stencil("stencil");
    public static final Item SUMMONER_STENCIL = stencil("summoner_stencil");
    public static final Item TRIDENT_HEAD_STENCIL = stencil("trident_head_stencil");
    public static final Item WAND_STENCIL = stencil("wand_stencil");

    public static final Item SLIME_SLING = slimeSling("slime_sling");

    //Universal
    public static final Item MENDING = attribute("mending_attribute");
    public static final Item HELLS_TOUCH = attribute("hells_touch_attribute");
    public static final Item REINFORCED = attribute("reinforced_attribute");
    public static final Item HASTY = attribute("hasty_attribute");
    public static final Item RECHARGEABLE = attribute("rechargeable_attribute");
    public static final Item BLAST_PROOF = attribute("blast_proof_attribute");
    public static final Item REVIVAL = attribute("revival_attribute");
    //Armor
    public static final Item ARMORED = attribute("armored_attribute");
    public static final Item KEVLAR = attribute("kevlar_attribute");
    public static final Item BREATHING = attribute("breathing_attribute");
    public static final Item AQUA_AFFINITY = attribute("aqua_affinity_attribute");
    public static final Item BLAST_PROTECTION = attribute("blast_protection_attribute");
    public static final Item WATER_WALKING = attribute("water_walking_attribute");
    public static final Item FEATHER_FALLING = attribute("feather_falling_attribute");
    public static final Item FLAME_RETARDANT = attribute("flame_retardant_attribute");
    public static final Item ICY = attribute("icy_attribute");
    public static final Item SOUL_SPEED = attribute("soul_speed_attributes");
    public static final Item STEALTHY = attribute("stealthy_attribute");
    public static final Item SPIKES = attribute("spiky_attribute");
    public static final Item LIGHT = attribute("light_attribute");
    //Weapon
    public static final Item DECAPITATION = attribute("decapitation_attribute");
    public static final Item WITHERING = attribute("withering_attribute");
    public static final Item KNOCKBACK = attribute("knockback_attribute");
    public static final Item CHANNELLING = attribute("channelling_attribute");
    //Melee
    public static final Item POINTY = attribute("pointy_attribute");
    public static final Item ABSORPTION = attribute("absorption_attribute");
    public static final Item SMITE = attribute("smite_attribute");
    public static final Item BANE_OF_ARTHRO = attribute("bane_of_arthropods_attribute");
    public static final Item CLEAVING = attribute("cleaving_attribute");
    public static final Item WITHER_STORM = attribute("wither_storm_attribute");
    //Tool
    public static final Item FORTUNATE = attribute("fortunate_attribute");
    public static final Item GENTLE = attribute("gentle_attribute");
    //Ranged
    public static final Item QUICK_DRAW = attribute("quick_draw_attribute");
    public static final Item MULTISHOT = attribute("multishot_attribute");
    public static final Item PIERCING = attribute("piercing_attribute");
    //Trident
    public static final Item RETRIEVING = attribute("retrieving_attribute");
    public static final Item RIPTIDE = attribute("riptide_attribute");
    //Summoner
    public static final Item MULTIPLY = attribute("multiply_attribute");
    //Magic
    public static final Item WIZARDRY = attribute("wizardry_attribute");
    public static final Item WITCHCRAFT = attribute("witchcraft_attribute");
    public static final Item NECROMANCY = attribute("necromancy_attribute");
    public static final Item ORDER_OF_THE_PHOENIX = attribute("order_of_the_phoenix");
    public static final Item LIGHT_SHIELD = attribute("light_shield_attribute");
    public static final Item DARK_PROMISE = attribute("dark_promise_attribute");
    public static final Item STUNNING = attribute("stunning_attribute");
    public static final Item SPELL_FURY = attribute("spell_fury_attribute");
    public static final Item FEED_THE_BEAST = attribute("feed_the_beast_attribute");
    public static final Item HERMES_TRUST = attribute("hermes_trust_attribute");
    public static final Item SACRIFICE = attribute("sacrifice_attribute");
    public static final Item GODS_GIFT = attribute("gods_gift_attribute");
    //Hammer
    public static final Item SHOCKWAVE = attribute("shockwave_attribute");

    public static final Item SLIME_BOOTS = PolyLustUtils.ofModelled("slime_boots", Items.LEATHER_BOOTS,
            LustItemGroups.WARMOR_GROUP, LustArmorMaterials.SLIME);

    private static Item backpack(String path, int rows) {
        return PolyLustUtils.ofModelled(path, Items.LEATHER, ItemGroup.MISC, BackpackItem::new);
    }

    public static Item stencil(String path) {
        return PolyLustUtils.ofModelled(path, Items.PAPER, LustItemGroups.WTOOLS_GROUP);
    }

    public static Item slimeSling(String path) {
        return PolyLustUtils.ofModelled(path, Items.BOW, ItemGroup.TOOLS,
                (settings, modelData) -> new SlimeSlingItem(settings.maxCount(1), modelData));
    }

    public static Item attribute(String path) {
        return PolyLustUtils.ofModelled(path, Items.ENCHANTED_BOOK, LustItemGroups.WATTRIBUTES_GROUP);
    }

    public static Item staff(String path) {
        return PolyLustUtils.ofModelled(path, Items.FISHING_ROD, LustItemGroups.WMAGIC_GROUP,
                (settings, modelData) -> new StaffItem(settings.maxCount(1), modelData));
    }

    public static void init() {
    }

    private LustItems() {
        throw new UnsupportedOperationException();
    }
}
