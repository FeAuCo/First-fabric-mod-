package net.feauco.firstmod.blocks;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.feauco.firstmod.FirstMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StainedGlassBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block ACCELERATOR = registerBlock("accelerator", new Block(AbstractBlock.Settings.create().strength(4f).sounds(BlockSoundGroup.BASALT).velocityMultiplier(3)));
    public static final Block ILLUMINATOR = registerBlock("illuminator", new Block(AbstractBlock.Settings.create().noCollision().luminance(value -> 15).breakInstantly()));

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(FirstMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FirstMod.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        FirstMod.LOGGER.info("Registering Blocks for" + FirstMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {entries.add(ModBlocks.ACCELERATOR); entries.add(ModBlocks.ILLUMINATOR);});
    }
}
