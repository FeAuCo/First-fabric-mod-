package net.feauco.firstmod.items;

import net.feauco.firstmod.FirstMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> JEWISH_ARMOR_MATERIAL = registerArmorMaterial("jewish_armor", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {map.put(ArmorItem.Type.BOOTS, 18);map.put(ArmorItem.Type.LEGGINGS, 30);map.put(ArmorItem.Type.CHESTPLATE, 40);map.put(ArmorItem.Type.BODY, 35);map.put(ArmorItem.Type.HELMET, 15);}), 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, () -> Ingredient.ofItems(ModItems.EXPLOSIVE_DIAMOND), List.of(new ArmorMaterial.Layer(Identifier.of(FirstMod.MOD_ID, "jewish_armor"))), 0, 0));



    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material){
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(FirstMod.MOD_ID, name), material.get());
    }
}
