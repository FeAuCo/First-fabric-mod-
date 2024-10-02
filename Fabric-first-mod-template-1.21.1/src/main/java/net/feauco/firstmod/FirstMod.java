package net.feauco.firstmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.feauco.firstmod.blocks.ModBlocks;
import net.feauco.firstmod.component.ModDataComponentTypes;
import net.feauco.firstmod.items.ModItemGroups;
import net.feauco.firstmod.items.ModItems;
import net.feauco.firstmod.util.Pickaxe3x3UsageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMod implements ModInitializer {
	public static final String MOD_ID = "firstmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModDataComponentTypes.registerDataComponentTypes();
		FuelRegistry.INSTANCE.add(ModItems.HYDROGEN, 2000);
		PlayerBlockBreakEvents.BEFORE.register(new Pickaxe3x3UsageEvent());
	}
}