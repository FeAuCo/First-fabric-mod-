package net.feauco.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.feauco.firstmod.blocks.ModBlocks;
import net.feauco.firstmod.items.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACCELERATOR).pattern("101").pattern("020").pattern("101").input('0', Items.WHITE_CONCRETE).input('1', Items.REDSTONE_BLOCK).input('2', ModItems.PIVAS_BOTTLE).criterion(hasItem(ModItems.PIVAS_BOTTLE), conditionsFromItem(ModItems.PIVAS_BOTTLE)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SPIKES).pattern("101").pattern("020").pattern("101").input('0', Items.GRAY_CONCRETE).input('1', Items.IRON_INGOT).input('2', Items.END_ROD).criterion(hasItem(Items.END_ROD), conditionsFromItem(Items.END_ROD)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PIVAS_BOTTLE).pattern(" 1 ").pattern(" 12").pattern(" 0 ").input('0', Items.GLASS_BOTTLE).input('1', Items.GLASS).input('2', Items.END_ROD).criterion(hasItem(Items.END_ROD), conditionsFromItem(Items.END_ROD)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POISONED_DAGGER).input(Items.IRON_SWORD).input(Items.PRISMARINE_SHARD).input(Items.SPIDER_EYE);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACCELERATING_BUTTON).input(ModBlocks.ACCELERATOR).criterion(hasItem(ModBlocks.ACCELERATOR), conditionsFromItem(ModBlocks.ACCELERATOR)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACCELERATING_STAIRS).pattern("0  ").pattern("00 ").pattern("000").input('0', ModBlocks.ACCELERATOR).criterion(hasItem(ModBlocks.ACCELERATOR), conditionsFromItem(ModBlocks.ACCELERATOR)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PICKAXE_EXP).pattern("111").pattern(" 0 ").pattern(" 0 ").input('0', Items.STICK).input('1', ModItems.EXPLOSIVE_DIAMOND).criterion(hasItem(ModItems.EXPLOSIVE_DIAMOND), conditionsFromItem(ModItems.EXPLOSIVE_DIAMOND)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PICKAXE_3X3).pattern("111").pattern(" 0 ").pattern(" 0 ").input('0', Items.STICK).input('1', Items.NETHERITE_BLOCK).criterion(hasItem(Items.NETHERITE_BLOCK), conditionsFromItem(Items.NETHERITE_BLOCK)).offerTo(exporter);
    }
}
