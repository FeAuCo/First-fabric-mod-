package net.feauco.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.feauco.firstmod.blocks.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.PIVAS_ORE).add(ModBlocks.SPIKES);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.PIVAS_ORE);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SPIKES);
    }
}
