package com.github.CrumCreators.lustrousness.armor;

import com.github.CrumCreators.lustrousness.groups.Groups;
import eu.pb4.polymer.api.item.PolymerItem;
import eu.pb4.polymer.api.item.SimplePolymerItem;
import eu.pb4.polymer.api.resourcepack.PolymerModelData;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;

import static com.github.CrumCreators.lustrousness.Main.modid;

public class Armor extends ArmorItem implements PolymerItem {
    private final PolymerModelData customModelData;
    public static final ArmorMaterial SLIME_ARMOR_MATERIAL = new SlimeBoots();

    public Armor(Settings settings, PolymerModelData customModelData) {
        super(SLIME_ARMOR_MATERIAL, EquipmentSlot.FEET, settings);
        this.customModelData = customModelData;
    }

    public static Item SLIME_BOOTS = new SimplePolymerItem((SlimeBoots) SLIME_ARMOR_MATERIAL, Items.LEATHER_BOOTS);

    public static void registerCrongness() {
        Registry.register(Registry.ITEM, new Identifier(modid, "slime_boots"), SLIME_BOOTS);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return customModelData.item();
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        if (customModelData != null) {
            return customModelData.value();
        }
        return -1;
    }
}
