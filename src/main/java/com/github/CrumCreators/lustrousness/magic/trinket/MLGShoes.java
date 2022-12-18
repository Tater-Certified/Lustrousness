package com.github.CrumCreators.lustrousness.magic.trinket;

import com.github.CrumCreators.lustrousness.util.ModelledTrinketPolymerItem;
import dev.emi.trinkets.api.SlotReference;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public class MLGShoes extends ModelledTrinketPolymerItem {

    public MLGShoes(Settings settings, PolymerModelData customModelData) {
        super(settings, customModelData);
    }

    boolean used;

    public void mlg(LivingEntity entity) {
        if (entity.fallDistance > 3 && entity.fallDistance < 5 && entity.isSneaking() && !entity.getWorld().getBlockState(entity.getBlockPos().down()).isAir()) {
            BlockPos pos = entity.getBlockPos();
            entity.getWorld().setBlockState(pos, Blocks.WATER.getDefaultState());
            used = true;
        }
        else if (entity.fallDistance >=5 && entity.isSneaking() && !entity.getWorld().getBlockState(entity.getBlockPos().down(2)).isAir()) {
            BlockPos pos = entity.getBlockPos();
            entity.getWorld().setBlockState(pos, Blocks.WATER.getDefaultState());
            used = true;
        }
        else if (used && entity.isOnGround()) {
            BlockPos pos = entity.getBlockPos();
            entity.getWorld().setBlockState(pos, Blocks.AIR.getDefaultState());
            used = false;
        }
    }


    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        mlg(entity);
    }
}
