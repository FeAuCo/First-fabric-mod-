package net.feauco.firstmod.items;

import net.feauco.firstmod.FirstMod;
import net.feauco.firstmod.items.custom.PoisonedDagger;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item EXPLOSIVE_DIAMOND = registerItem("explosive_diamond", new Item(new Item.Settings()));
    public static final Item PIVAS_BOTTLE = registerItem("pivas_bottle", new Item(new Item.Settings()));
    public static final Item RAW_PIVAS_ORE = registerItem("raw_pivas_ore", new Item(new Item.Settings()));

    public static final Item POISONED_DAGGER = registerItem("poisoned_dagger", new PoisonedDagger(new Item.Settings().maxDamage(250)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(FirstMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FirstMod.LOGGER.info("Registering Items for " + FirstMod.MOD_ID);
    }

}
