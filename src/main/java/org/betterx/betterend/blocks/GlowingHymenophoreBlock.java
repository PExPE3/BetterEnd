package org.betterx.betterend.blocks;

import org.betterx.bclib.blocks.BaseBlock;
import org.betterx.bclib.interfaces.tools.AddMineableAxe;
import org.betterx.betterend.client.models.EndModels;
import org.betterx.wover.block.api.model.BlockModelProvider;
import org.betterx.wover.block.api.model.WoverBlockModelGenerators;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.world.level.block.Block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class GlowingHymenophoreBlock extends BaseBlock.Wood implements AddMineableAxe, BlockModelProvider {
    public GlowingHymenophoreBlock(Properties props) {
        super(props);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void provideBlockModels(WoverBlockModelGenerators generator) {
        provideUnshadedCubeModel(generator, this);
    }

    public static void provideUnshadedCubeModel(
            WoverBlockModelGenerators generator,
            Block glowingHymenophoreBlock
    ) {
        generator.acceptBlockState(BlockModelGenerators.createSimpleBlock(
                glowingHymenophoreBlock,
                BlockModelGenerators.plainVariant(EndModels.CUBE_NO_SHADE.create(
                        glowingHymenophoreBlock,
                        TextureMapping.defaultTexture(glowingHymenophoreBlock),
                        generator.modelOutput()
                ))
        ));
    }
}
