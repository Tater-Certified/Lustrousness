package com.github.CrumCreators.lustrousness.mixin;// Created 2022-15-07T21:11:48

import com.github.CrumCreators.lustrousness.Main;
import com.github.CrumCreators.lustrousness.item.LustItems;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * @author Ampflower
 * @since ${version}
 **/
@Mixin(Entity.class)
public class MixinEntity {
    @Redirect(method = "move",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;onEntityLand(Lnet/minecraft/world/BlockView;Lnet/minecraft/entity/Entity;)V"))
    private void lustrousness$onEntityLand$slimeBoots(Block instance, BlockView world, Entity entity) {
        if (!entity.isSneaking() && entity instanceof LivingEntity livingEntity && livingEntity.getEquippedStack(EquipmentSlot.FEET).isOf(LustItems.SLIME_BOOTS)) {
            Main.bounce(livingEntity);
        } else {
            instance.onEntityLand(world, entity);
            if (entity.fallDistance > 3) entity.damage(DamageSource.FALL, (entity.fallDistance-6)/2);
        }
    }
}
