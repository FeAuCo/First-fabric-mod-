package net.feauco.firstmod.util;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.feauco.firstmod.items.custom.Pickaxe3x3;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class Pickaxe3x3UsageEvent implements PlayerBlockBreakEvents.Before{
    private static final Set<BlockPos> BROKEN_BLOCKS = new HashSet<>();

    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity) {
        ItemStack mainHandItem = player.getMainHandStack();
        if (mainHandItem.getItem() instanceof Pickaxe3x3 pickaxe && player instanceof ServerPlayerEntity serverPlayer){
            if (BROKEN_BLOCKS.contains(pos)){
                return true;
            }

            for (BlockPos position : Pickaxe3x3.getBlocksToDestroy(1, pos, serverPlayer)){
                if (pos == position || !pickaxe.isCorrectForDrops(mainHandItem, world.getBlockState(position))) {
                    continue;
                }

                BROKEN_BLOCKS.add(position);
                serverPlayer.interactionManager.tryBreakBlock(position);
                BROKEN_BLOCKS.remove(position);
            }
        }
        return true;
    }
}
