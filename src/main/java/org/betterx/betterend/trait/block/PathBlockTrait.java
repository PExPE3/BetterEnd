package org.betterx.betterend.trait.block;

import org.betterx.bclib.client.models.BCLModels;
import org.betterx.betterend.BetterEnd;
import org.betterx.wover.block.api.BlockDefinition;
import org.betterx.wover.block.api.client.trait.BlockModelTrait;
import org.betterx.wover.block.api.client.trait.ClientBlockTraits;
import org.betterx.wover.block.api.trait.BlockTraitKey;
import org.betterx.wover.block.api.trait.GenericBlockTrait;
import org.betterx.wover.block.api.trait.behaviour.LootTableTrait;
import org.betterx.wover.block.impl.trait.BlockTraitImpl;

import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class PathBlockTrait extends BlockTraitImpl<Block, GenericBlockTrait> {
    private static final BlockTraitKey KEY = BlockTraitKey.ofUnique(BetterEnd.C, "path");
    public static final PathBlockTrait DEFAULT = new PathBlockTrait();

    private PathBlockTrait() {
    }

    @Override
    public BlockTraitKey key() {
        return KEY;
    }

    @Override
    public void configure(BlockDefinition<Block, ? extends BlockDefinition<Block, ?>> definition) {
        definition.isValidSpawn((state, world, pos, type) -> false);
    }

    public static LootTableTrait.LootTableFactory drops(Block source) {
        return (tableKey, blockKey, block, provider) -> {
            return provider.dropWithSilkTouch(block, source, ConstantValue.exactly(1));
        };
    }

    @Environment(EnvType.CLIENT)
    public static BlockModelTrait buildModel(Block source) {
        return ClientBlockTraits.MODEL.with(
                (key, block, generator) -> {
                    var side = TextureMapping.getBlockTexture(block, "_side");
                    side = ResourceLocation.fromNamespaceAndPath(
                            side.getNamespace(), side
                                    .getPath()
                                    .replace("_path", "")
                    );

                    var mapping = new TextureMapping()
                            .put(TextureSlot.SIDE, side)
                            .put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top"))
                            .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(source));
                    var location = BCLModels.PATH.create(block, mapping, generator.modelOutput());

                    generator.acceptBlockState(generator.randomTopModelVariant(block, location));
                });
    }
}