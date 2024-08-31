package net.feauco.firstmod.blocks;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.feauco.firstmod.FirstMod;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block ACCELERATOR = registerBlock("accelerator", new Block(AbstractBlock.Settings.create().strength(2f).sounds(BlockSoundGroup.BASALT).velocityMultiplier(1.5f)));
    public static final Block ILLUMINATOR = registerBlock("illuminator", new Block(AbstractBlock.Settings.create().noCollision().luminance(value -> 15).breakInstantly().resistance(-1)));
    public static final Block PIVAS_ORE = registerBlock("pivas_ore", new ExperienceDroppingBlock(UniformIntProvider.create(10, 20), AbstractBlock.Settings.create().luminance(value -> 4).requiresTool().strength(4, 4)));

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(FirstMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FirstMod.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        FirstMod.LOGGER.info("Registering Blocks for " + FirstMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {entries.add(ModBlocks.ACCELERATOR); entries.add(ModBlocks.ILLUMINATOR);});
    }
}
