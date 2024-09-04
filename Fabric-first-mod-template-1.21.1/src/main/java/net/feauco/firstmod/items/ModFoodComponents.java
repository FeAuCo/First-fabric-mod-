package net.feauco.firstmod.items;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;

public class ModFoodComponents {
    public static final FoodComponent HYDROGEN = new FoodComponent.Builder().snack().nutrition(6).alwaysEdible().saturationModifier(0.9f).usingConvertsTo(Items.AIR).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 40, 2), 1f).build();
}
