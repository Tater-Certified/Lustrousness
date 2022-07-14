package com.github.CrumCreators.lustrousness.item;

import com.github.CrumCreators.lustrousness.groups.Groups;
import com.github.CrumCreators.lustrousness.util.PolyLustUtils;
import eu.pb4.polymer.api.item.SimplePolymerItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class Attributes extends SimplePolymerItem {

    public Attributes(Settings settings, Item polymerItem) {
        super(settings, polymerItem);
    }

    public static Item attribute(String path) {
        return PolyLustUtils.ofModelled(path, Items.ENCHANTED_BOOK, Groups.WATTRIBUTES_GROUP);
    }
    //Universal
    public static Item MENDING;
    public static Item HELLS_TOUCH;
    public static Item REINFORCED;
    public static Item HASTY;
    public static Item RECHARGEABLE;
    public static Item BLAST_PROOF;
    public static Item REVIVAL;
    //Armor
    public static Item ARMORED;
    public static Item KEVLAR;
    public static Item BREATHING;
    public static Item AQUA_AFFINITY;
    public static Item BLAST_PROTECTION;
    public static Item WATER_WALKING;
    public static Item FEATHER_FALLING;
    public static Item FLAME_RETARDANT;
    public static Item ICY;
    public static Item SOUL_SPEED;
    public static Item STEALTHY;
    public static Item SPIKES;
    public static Item LIGHT;
    //Weapon
    public static Item DECAPITATION;
    public static Item WITHERING;
    public static Item KNOCKBACK;
    public static Item CHANNELLING;
    //Melee
    public static Item POINTY;
    public static Item ABSORPTION;
    public static Item SMITE;
    public static Item BANE_OF_ARTHRO;
    public static Item CLEAVING;
    public static Item WITHER_STORM;
    //Tool
    public static Item FORTUNATE;
    public static Item GENTLE;
    //Ranged
    public static Item QUICK_DRAW;
    public static Item MULTISHOT;
    public static Item PIERCING;
    //Trident
    public static Item RETRIEVING;
    public static Item RIPTIDE;
    //Summoner
    public static Item MULTIPLY;
    //Magic
    public static Item WIZARDRY;
    public static Item WITCHCRAFT;
    public static Item NECROMANCY;
    public static Item ORDER_OF_THE_PHOENIX;
    public static Item LIGHT_SHIELD;
    public static Item DARK_PROMISE;
    public static Item STUNNING;
    public static Item SPELL_FURY;
    public static Item FEED_THE_BEAST;
    public static Item HERMES_TRUST;
    public static Item SACRIFICE;
    public static Item GODS_GIFT;
    //Hammer
    public static Item SHOCKWAVE;



    public static void registerAttributes() {
        MENDING = attribute("mending_attribute");
        HELLS_TOUCH = attribute("hells_touch_attribute");
        REINFORCED = attribute("reinforced_attribute");
        HASTY = attribute("hasty_attribute");
        RECHARGEABLE = attribute("rechargeable_attribute");
        BLAST_PROOF = attribute("blast_proof_attribute");
        REVIVAL = attribute("revival_attribute");
        ARMORED = attribute("armored_attribute");
        KEVLAR = attribute("kevlar_attribute");
        BREATHING = attribute("breathing_attribute");
        AQUA_AFFINITY = attribute("aqua_affinity_attribute");
        BLAST_PROTECTION = attribute("blast_protection_attribute");
        WATER_WALKING = attribute("water_walking_attribute");
        FEATHER_FALLING = attribute("feather_falling_attribute");
        FLAME_RETARDANT = attribute("flame_retardant_attribute");
        ICY = attribute("icy_attribute");
        SOUL_SPEED = attribute("soul_speed_attributes");
        STEALTHY = attribute("stealthy_attribute");
        SPIKES = attribute("spiky_attribute");
        LIGHT = attribute("light_attribute");
        DECAPITATION = attribute("decapitation_attribute");
        WITHERING = attribute("withering_attribute");
        KNOCKBACK = attribute("knockback_attribute");
        CHANNELLING = attribute("channelling_attribute");
        POINTY = attribute("pointy_attribute");
        ABSORPTION = attribute("absorption_attribute");
        SMITE = attribute("smite_attribute");
        BANE_OF_ARTHRO = attribute("bane_of_arthropods_attribute");
        CLEAVING = attribute("cleaving_attribute");
        WITHER_STORM = attribute("wither_storm_attribute");
        FORTUNATE = attribute("fortunate_attribute");
        GENTLE = attribute("gentle_attribute");
        QUICK_DRAW = attribute("quick_draw_attribute");
        MULTISHOT = attribute("multishot_attribute");
        PIERCING = attribute("piercing_attribute");
        RETRIEVING = attribute("retrieving_attribute");
        RIPTIDE = attribute("riptide_attribute");
        MULTIPLY = attribute("multiply_attribute");
        WIZARDRY = attribute("wizardry_attribute");
        WITCHCRAFT = attribute("witchcraft_attribute");
        NECROMANCY = attribute("necromancy_attribute");
        ORDER_OF_THE_PHOENIX = attribute("order_of_the_phoenix");
        LIGHT_SHIELD = attribute("light_shield_attribute");
        DARK_PROMISE = attribute("dark_promise_attribute");
        STUNNING = attribute("stunning_attribute");
        SPELL_FURY = attribute("spell_fury_attribute");
        FEED_THE_BEAST = attribute("feed_the_beast_attribute");
        HERMES_TRUST = attribute("hermes_trust_attribute");
        SACRIFICE = attribute("sacrifice_attribute");
        GODS_GIFT = attribute("gods_gift_attribute");
        SHOCKWAVE = attribute("shockwave_attribute");
    }

}
