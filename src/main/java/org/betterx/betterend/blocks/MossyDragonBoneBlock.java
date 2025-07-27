package org.betterx.betterend.blocks;

import org.betterx.bclib.blocks.BaseTerrainBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("deprecation")
public class MossyDragonBoneBlock extends RotatedPillarBlock {
    public MossyDragonBoneBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }


    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (random.nextInt(16) == 0 && !canSurvive(state, world, pos)) {
            world.setBlockAndUpdate(pos, Blocks.BONE_BLOCK.defaultBlockState().setValue(AXIS, state.getValue(AXIS)));
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldView, BlockPos pos) {
        return BaseTerrainBlock.willSurvive(state, worldView, pos);
    }
}
