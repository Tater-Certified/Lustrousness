package com.github.CrumCreators.lustrousness.magic.trinket;

import com.github.CrumCreators.lustrousness.util.ModelledTrinketPolymerItem;
import dev.emi.trinkets.api.SlotReference;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class LavaMedallion extends ModelledTrinketPolymerItem {

    public LavaMedallion(Settings settings, PolymerModelData customModelData) {
        super(settings, customModelData);
    }
    public void fireProt(LivingEntity entity) {
        if (entity.isOnFire()) {
            entity.setStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 60, 0, true, false, false), entity);
            entity.extinguish();
        }
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        fireProt(entity);
    }
}
