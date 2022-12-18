package com.github.CrumCreators.lustrousness.mixin;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.pathing.LandPathNodeMaker;
import net.minecraft.util.TypeFilter;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EntityType.class)
public abstract class EntityTypeMixin<T extends Entity> implements TypeFilter<Entity, T> {

    @Shadow @Final private ImmutableSet<Block> canSpawnInside;

    @Shadow @Final private boolean fireImmune;

    /**
     * @author QPCrummer
     * @reason Ampflower will fix this later
     */
    @Overwrite
    public boolean isInvalidSpawn(BlockState state) {
        if (this.canSpawnInside.contains(state.getBlock())) {
            return false;
        } else if (!this.fireImmune && LandPathNodeMaker.inflictsFireDamage(state)) {
            return true;
        } else {
            return state.isOf(Blocks.WITHER_ROSE) || state.isOf(Blocks.SWEET_BERRY_BUSH) || state.isOf(Blocks.CACTUS) || state.isOf(Blocks.POWDER_SNOW) || state.isOf(Blocks.NETHER_PORTAL);
        }
    }
}
