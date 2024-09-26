package net.feauco.firstmod.component;

import net.feauco.firstmod.FirstMod;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.Codecs;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final ComponentType<Integer> HIT_COUNT = register("hit_count", builder -> builder.codec(Codecs.NONNEGATIVE_INT));

    private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator){
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(FirstMod.MOD_ID, name), builderOperator.apply(ComponentType.builder()).build());
    }


    public static void registerDataComponentTypes(){
        FirstMod.LOGGER.info("Registering Data Component Types for " + FirstMod.MOD_ID);
    }
}
