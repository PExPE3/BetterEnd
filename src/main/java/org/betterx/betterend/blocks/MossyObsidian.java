package org.betterx.betterend.blocks;

import org.betterx.bclib.blocks.BaseTerrainBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class MossyObsidian extends Block {
    public MossyObsidian(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (random.nextInt(16) == 0 && !canSurvive(state, world, pos)) {
            world.setBlockAndUpdate(pos, Blocks.OBSIDIAN.defaultBlockState());
        }
    }

    @SuppressWarnings("deprecation")
    public boolean canSurvive(BlockState state, LevelReader worldView, BlockPos pos) {
        return BaseTerrainBlock.willSurvive(state, worldView, pos);
    }
}
