package com.gildedgames.aether.common.block.construction;

import com.gildedgames.aether.common.registry.AetherBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.GrassPathBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class AetherDirtPathBlock extends GrassPathBlock {
    public AetherDirtPathBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos())
                ? Block.pushEntitiesUp(this.defaultBlockState(), AetherBlocks.AETHER_DIRT.get().defaultBlockState(), context.getLevel(), context.getClickedPos())
                : this.defaultBlockState();
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        AetherFarmlandBlock.turnToDirt(state, worldIn, pos);
    }
}
