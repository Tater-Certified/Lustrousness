package com.github.CrumCreators.lustrousness.item;// Created 2022-15-07T20:37:10

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

/**
 * @author Ampflower
 * @since ${version}
 **/
public enum LustArmorMaterials implements ArmorMaterial {
    SLIME(1, new int[]{1, 2, 2, 1}, 0, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE,
            () -> Ingredient.ofItems(Items.SLIME_BALL), "slime", 0F, 0F),
    ;
    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final int durabilityMultiplier;
    private final int[] protectionAmount;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final Supplier<Ingredient> repairIngredient;
    private final String name;
    private final float toughness;
    private final float knockbackResistance;

    LustArmorMaterials(int durabilityMultiplier, int[] protectionAmount, int enchantability, SoundEvent equipSound,
                       Supplier<Ingredient> repairIngredient, String name, float toughness, float knockbackResistance) {
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmount = protectionAmount;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.repairIngredient = Suppliers.memoize(repairIngredient);
        this.name = name;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return protectionAmount[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
