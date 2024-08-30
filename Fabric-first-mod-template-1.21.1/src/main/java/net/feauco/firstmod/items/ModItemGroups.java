package net.feauco.firstmod.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.feauco.firstmod.FirstMod;
import net.feauco.firstmod.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CUSTOM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(FirstMod.MOD_ID, "custom_items"), FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PIVAS_BOTTLE)).displayName(Text.translatable("itemgroup.firstmod.custom_items")).entries((displayContext, entries) -> {entries.add(ModItems.PIVAS_BOTTLE);entries.add(ModItems.EXPLOSIVE_DIAMOND);}).build());
    public static final ItemGroup CUSTOM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(FirstMod.MOD_ID, "custom_blocks"), FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.ACCELERATOR)).displayName(Text.translatable("itemgroup.firstmod.custom_blocks")).entries((displayContext, entries) -> {entries.add(ModBlocks.ACCELERATOR);entries.add(ModBlocks.ILLUMINATOR);}).build());


    public static void registerItemGroups(){
        FirstMod.LOGGER.info("Registering Item Groups for " + FirstMod.MOD_ID);

    }
}
