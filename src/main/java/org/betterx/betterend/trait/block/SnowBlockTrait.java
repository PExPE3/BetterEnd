package org.betterx.betterend.trait.block;

import org.betterx.betterend.BetterEnd;
import org.betterx.wover.block.api.BlockDefinition;
import org.betterx.wover.block.api.client.model.ModelTraitLibrary;
import org.betterx.wover.block.api.trait.BlockTraitKey;
import org.betterx.wover.block.api.trait.BlockTraits;
import org.betterx.wover.block.api.trait.GenericBlockTrait;
import org.betterx.wover.block.impl.trait.BlockTraitImpl;
import org.betterx.wover.tag.api.predefined.MineableTags;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class SnowBlockTrait extends BlockTraitImpl<Block, GenericBlockTrait> {
    private static final BlockTraitKey KEY = BlockTraitKey.ofUnique(BetterEnd.C, "snow");
    public static final SnowBlockTrait DEFAULT = new SnowBlockTrait();

    private SnowBlockTrait() {
    }

    @Override
    public BlockTraitKey key() {
        return KEY;
    }

    @Override
    public void configure(BlockDefinition<Block, ? extends BlockDefinition<Block, ?>> definition) {
        definition
                .mapColor(MapColor.SNOW)
                .requiresCorrectToolForDrops()
                .strength(0.2F)
                .sound(SoundType.SNOW)
                .addTags(MineableTags.SHOVEL)
                .addTrait(ModelTraitLibrary.cube())
                .addTrait(BlockTraits.LOOT_TABLE.dropSelf());
        ;
    }
}