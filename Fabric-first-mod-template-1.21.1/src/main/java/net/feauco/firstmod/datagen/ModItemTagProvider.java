package net.feauco.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.feauco.firstmod.items.ModItems;
import net.feauco.firstmod.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;


import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.ITEMS_TO_DESTROY).add(ModItems.PIVAS_BOTTLE).add(Items.GLASS_BOTTLE).add(Items.APPLE);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.PICKAXE_EXP).add(ModItems.PICKAXE_3X3);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(ModItems.KIPPAH);
    }
}
