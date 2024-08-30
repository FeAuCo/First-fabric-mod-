package net.feauco.firstmod;

import net.fabricmc.api.ModInitializer;

import net.feauco.firstmod.blocks.ModBlocks;
import net.feauco.firstmod.items.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMod implements ModInitializer {
	public static final String MOD_ID = "firstmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}