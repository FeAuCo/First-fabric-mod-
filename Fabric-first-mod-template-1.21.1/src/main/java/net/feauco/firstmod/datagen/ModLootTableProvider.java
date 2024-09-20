package net.feauco.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.feauco.firstmod.blocks.ModBlocks;
import net.feauco.firstmod.items.ModItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SPIKES);
        addDrop(ModBlocks.ACCELERATING_BUTTON);
        addDrop(ModBlocks.ACCELERATING_STAIRS);
        addDrop(ModBlocks.INVISIBLE_PRESSURE_PLATE);
        addDrop(ModBlocks.PIVAS_ORE, oreDrops(ModBlocks.PIVAS_ORE, ModItems.RAW_PIVAS_ORE));
    }
}
