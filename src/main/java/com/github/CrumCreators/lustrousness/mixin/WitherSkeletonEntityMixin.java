package com.github.CrumCreators.lustrousness.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(WitherSkeletonEntity.class)
public abstract class WitherSkeletonEntityMixin extends AbstractSkeletonEntity {

    protected WitherSkeletonEntityMixin(EntityType<? extends AbstractSkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    /**
     * @author QPCrummer
     * @reason Allow spawning with bows
     */
    @Overwrite
    public void initEquipment(Random random, LocalDifficulty localDifficulty) {
        boolean i = random.nextBoolean();
        if (i) {
            this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
        } else {
            this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
        }
        this.updateEnchantments(random, localDifficulty);
    }

    /**
     * @author QPCrummer
     * @reason Well... Mojank left it empty, let me fill it
     */
    @Overwrite
    public void updateEnchantments(Random random, LocalDifficulty localDifficulty) {
        int healthbonus = (int) ((this.getHealth()/ 100)+1);
        float f = localDifficulty.getClampedLocalDifficulty();
        if (random.nextFloat() < 0.25F * f) {
            this.equipStack(EquipmentSlot.MAINHAND, EnchantmentHelper.enchant(random, this.getMainHandStack(), (int)(5.0F + f * (float)random.nextInt(18*healthbonus)), false));
        }
    }
}
