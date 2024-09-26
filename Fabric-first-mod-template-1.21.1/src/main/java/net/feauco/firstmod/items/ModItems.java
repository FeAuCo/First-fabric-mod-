package net.feauco.firstmod.items;

import net.feauco.firstmod.FirstMod;
import net.feauco.firstmod.items.custom.PoisonedDagger;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.ComponentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item EXPLOSIVE_DIAMOND = registerItem("explosive_diamond", new Item(new Item.Settings()));
    public static final Item PIVAS_BOTTLE = registerItem("pivas_bottle", new Item(new Item.Settings()));
    public static final Item RAW_PIVAS_ORE = registerItem("raw_pivas_ore", new Item(new Item.Settings())
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.firstmod.raw_pivas_ore"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item POISONED_DAGGER = registerItem("poisoned_dagger", new PoisonedDagger(new Item.Settings().maxDamage(250)));

    public static final Item HYDROGEN = registerItem("hydrogen", new Item(new Item.Settings().food(ModFoodComponents.HYDROGEN)));

    public static final Item PICKAXE_EXP = registerItem("pickaxe_exp", new PickaxeItem(ModToolMaterials.CUSTOM_TOOLS, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.CUSTOM_TOOLS, 5, -2))));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(FirstMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FirstMod.LOGGER.info("Registering Items for " + FirstMod.MOD_ID);
    }

}
