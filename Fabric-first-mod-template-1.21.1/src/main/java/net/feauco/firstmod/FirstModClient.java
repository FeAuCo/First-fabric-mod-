package net.feauco.firstmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.feauco.firstmod.blocks.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class FirstModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ILLUMINATOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPIKES, RenderLayer.getCutout());

    }
}
