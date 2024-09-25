package net.feauco.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.feauco.firstmod.blocks.ModBlocks;
import net.feauco.firstmod.blocks.custom.Lamp;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

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

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.LAMP).coordinate(BlockStateModelGenerator.createBooleanModelMap(Lamp.CLICKED, lampOnIdentifier, lampOffIdentifier)));


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}

