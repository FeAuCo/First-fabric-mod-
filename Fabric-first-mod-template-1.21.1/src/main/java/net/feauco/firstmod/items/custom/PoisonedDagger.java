package net.feauco.firstmod.items.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class PoisonedDagger extends Item {
    public PoisonedDagger(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();
        if (!world.isClient && target instanceof LivingEntity) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 40, 2, false, true, true));
            if ((int) (Math.random() * 100) <= 15) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 2, false, true, true));
                world.playSound(null, target.getBlockPos(), SoundEvents.ITEM_MACE_SMASH_AIR, SoundCategory.MASTER, 10000, 1);
            }

        }
        return true;
    }
}
