package net.feauco.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.feauco.firstmod.blocks.ModBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool acceleratorPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ACCELERATOR);

        acceleratorPool.stairs(ModBlocks.ACCELERATING_STAIRS);
        acceleratorPool.button(ModBlocks.ACCELERATING_BUTTON);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PIVAS_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ILLUMINATOR);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}

