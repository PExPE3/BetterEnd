package org.betterx.betterend.blocks;

import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.blocks.basis.PedestalBlock;
import org.betterx.betterend.client.models.EndModels;
import org.betterx.wover.block.api.client.trait.BlockModelTrait;
import org.betterx.wover.block.api.client.trait.ClientBlockTraits;
import org.betterx.wover.block.api.trait.BlockTraitLookup;
import org.betterx.wover.sets.api.blocks.BlockSet;

import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class EndPedestal extends PedestalBlock {
    public EndPedestal(BlockBehaviour.Properties props) {
        super(props);
    }


    @Environment(EnvType.CLIENT)
    protected static TextureMapping createTextureMapping(Block parent) {
        final var parentTexture = BetterEnd.C.convertNamespace(TextureMapping.getBlockTexture(parent));
        final var polishedTexture = BetterEnd.C.convertNamespace(TextureMapping.getBlockTexture(parent, "_polished"));
        return new TextureMapping()
                .put(TextureSlot.TOP, polishedTexture)
                .put(TextureSlot.BOTTOM, polishedTexture)
                .put(EndModels.BASE, polishedTexture)
                .put(EndModels.PILLAR, parentTexture.withSuffix("_pillar_side"));
    }


    @Environment(EnvType.CLIENT)
    public static BlockModelTrait buildModel(BlockSet<?> set, BlockTraitLookup traitLookup) {
        return ClientBlockTraits.MODEL.with(
                (key, block, generator) -> {
                    provideBlockModel(generator, createTextureMapping(set.getBaseBlock()), block);
                }
        );
    }
}
