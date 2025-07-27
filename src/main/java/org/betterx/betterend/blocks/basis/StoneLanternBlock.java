package org.betterx.betterend.blocks.basis;

import org.betterx.bclib.behaviours.interfaces.BehaviourStone;
import org.betterx.bclib.client.models.BCLModels;
import org.betterx.bclib.interfaces.CustomColorProvider;
import org.betterx.betterend.registry.EndBlocks;
import org.betterx.wover.block.api.client.trait.BlockModelTrait;
import org.betterx.wover.block.api.client.trait.ClientBlockTraits;
import org.betterx.wover.block.api.trait.BlockTraitLookup;
import org.betterx.wover.sets.api.blocks.BlockSet;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.jetbrains.annotations.NotNull;

public class StoneLanternBlock extends EndLanternBlock implements CustomColorProvider, BehaviourStone {
    private static final VoxelShape SHAPE_CEIL = box(3, 1, 3, 13, 16, 13);
    private static final VoxelShape SHAPE_FLOOR = box(3, 0, 3, 13, 15, 13);

    public StoneLanternBlock(BlockBehaviour.Properties props) {
        super(props);
    }

    @Override
    public BlockColor getProvider() {
        return ((CustomColorProvider) EndBlocks.AURORA_CRYSTAL).getProvider();
    }


    @Override
    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
        return state.getValue(IS_FLOOR) ? SHAPE_FLOOR : SHAPE_CEIL;
    }

    @Environment(EnvType.CLIENT)
    public static BlockModelTrait buildModel(BlockSet<?> set, BlockTraitLookup traitLookup) {
        return ClientBlockTraits.MODEL.with(
                (key, block, generator) -> {
                    //get id of this block from registry
                    final boolean isVanilla = key.location().getNamespace().equals("minecraft");
                    final var mapping = new TextureMapping()
                            .put(BCLModels.GLASS, TextureMapping.getBlockTexture(EndBlocks.AURORA_CRYSTAL))
                            .put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top"))
                            .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"))
                            .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(block, "_bottom"));

                    final var floorModel = BCLModels.STONE_LANTERN_FLOOR.createWithSuffix(
                            block,
                            "_floor",
                            mapping,
                            generator.vanillaGenerator.modelOutput
                    );
                    final var ceilModel = BCLModels.STONE_LANTERN_CEIL.create(
                            block,
                            mapping,
                            generator.vanillaGenerator.modelOutput
                    );

                    final var floorCeilDispatch = PropertyDispatch
                            .modify(IS_FLOOR)
                            .select(true, (variant) -> BlockModelGenerators.plainModel(floorModel))
                            .select(false, (variant) -> BlockModelGenerators.plainModel(ceilModel));

                    generator.acceptBlockState(MultiVariantGenerator
                            .dispatch(block, BlockModelGenerators.plainVariant(ceilModel))
                            .with(floorCeilDispatch));
                });
    }
}
