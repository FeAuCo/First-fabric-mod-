package net.feauco.firstmod.blocks;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.feauco.firstmod.FirstMod;
import net.feauco.firstmod.blocks.custom.Lamp;
import net.feauco.firstmod.blocks.custom.Spikes;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;

public class ModBlocks {

    public static final Block ACCELERATOR = registerBlock("accelerator", new Block(AbstractBlock.Settings.create().strength(2f).sounds(BlockSoundGroup.BASALT).velocityMultiplier(1.5f)));
    public static final Block ILLUMINATOR = registerBlock("illuminator", new Block(AbstractBlock.Settings.create().noCollision().luminance(value -> 15).breakInstantly().resistance(-1)));
    public static final Block PIVAS_ORE = registerBlock("pivas_ore", new ExperienceDroppingBlock(UniformIntProvider.create(10, 20), AbstractBlock.Settings.create().luminance(value -> 4).requiresTool().strength(4, 4)));

    public static final Block SPIKES = registerBlock("spikes", new Spikes(AbstractBlock.Settings.create().requiresTool().strength(3, 3).velocityMultiplier(0.5f).sounds(BlockSoundGroup.METAL).nonOpaque()));

    public static final Block ACCELERATING_STAIRS = registerBlock("accelerating_stairs", new StairsBlock(ModBlocks.ACCELERATOR.getDefaultState(), AbstractBlock.Settings.create().strength(2, 2).sounds(BlockSoundGroup.BASALT).velocityMultiplier(1.5f)));
    public static final Block ACCELERATING_BUTTON = registerBlock("accelerating_button", new ButtonBlock(BlockSetType.IRON, 1, AbstractBlock.Settings.create().strength(2, 2))
    {
        @Override
        protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 40, 2, false, false, false));
            return ActionResult.SUCCESS;

        }
    });
    public static final Block INVISIBLE_PRESSURE_PLATE = registerBlock("invisible_pressure_plate", new PressurePlateBlock(BlockSetType.GOLD, AbstractBlock.Settings.create().strength(2, 2)));

    public static final Block LAMP = registerBlock("lamp", new Lamp(AbstractBlock.Settings.create().strength(1f).luminance(state -> state.get(Lamp.CLICKED) ? 15 : 0)));

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
