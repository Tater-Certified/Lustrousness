package com.github.CrumCreators.lustrousness.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.function.Predicate;

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

    /**
     * @author QPCrummer
     * @reason Make Wither Skeletons not attack Undead and Non-living-entities
     */
    @Overwrite
    public void initGoals() {
        final Predicate<LivingEntity> CAN_ATTACK_PREDICATE = (entity) -> entity.getGroup() != EntityGroup.UNDEAD && entity.isMobOrPlayer();
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, LivingEntity.class, 0, false, false, CAN_ATTACK_PREDICATE));
        this.goalSelector.add(1, new WanderAroundGoal(this, 1.0));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(3, new LookAroundGoal(this));
    }
}
