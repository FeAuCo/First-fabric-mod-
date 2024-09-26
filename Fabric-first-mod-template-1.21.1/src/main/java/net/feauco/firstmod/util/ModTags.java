package net.feauco.firstmod.util;

import net.minecraft.block.Block    ;
import net.feauco.firstmod.FirstMod;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;


public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_CUSTOM_TOOLS = createTag("needs_custom_tools");
        public static final TagKey<Block> INCORRECT_FOR_CUSTOM_TOOL = createTag("incorrect_for_custom_tool");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(FirstMod.MOD_ID, name));
        }
    }

    public static class Items{
        public static TagKey<Item> ITEMS_TO_DESTROY = createTag("items_to_destroy");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(FirstMod.MOD_ID, name));
        }
    }
}
