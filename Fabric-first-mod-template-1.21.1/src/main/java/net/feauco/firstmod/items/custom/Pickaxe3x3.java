package net.feauco.firstmod.items.custom;

import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

public class Pickaxe3x3 extends MiningToolItem {
    public Pickaxe3x3(ToolMaterial material, Settings settings) {
        super(material, BlockTags.PICKAXE_MINEABLE, settings);
    }

    public static List<BlockPos> getBlocksToDestroy(int range, BlockPos initialBlockPos, ServerPlayerEntity player) {
        HitResult hit = player.raycast(20, 0, false);
        List<BlockPos> blocks_coords = new ArrayList<>();
        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;
            if (blockHit.getSide() == Direction.DOWN || blockHit.getSide() == Direction.UP) {
                for (int x = -range; x <= range; x++) {
                    for (int z = -range; z <= range; z++) {
                        blocks_coords.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY(), initialBlockPos.getZ() + z));
                    }
                }
            }
            if (blockHit.getSide() == Direction.SOUTH || blockHit.getSide() == Direction.NORTH) {
                for (int x = -range; x <= range; x++) {
                    for (int y = -range; y <= range; y++) {
                        blocks_coords.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + y, initialBlockPos.getZ()));
                    }
                }
            }
            if (blockHit.getSide() == Direction.EAST || blockHit.getSide() == Direction.WEST) {
                for (int y = -range; y <= range; y++) {
                    for (int z = -range; z <= range; z++) {
                        blocks_coords.add(new BlockPos(initialBlockPos.getX(), initialBlockPos.getY() + y, initialBlockPos.getZ() + z));
                    }
                }
            }
        }
        return blocks_coords;
    }
}
