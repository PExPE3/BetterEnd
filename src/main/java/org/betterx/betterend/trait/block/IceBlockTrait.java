package org.betterx.betterend.trait.block;

import org.betterx.betterend.BetterEnd;
import org.betterx.wover.block.api.BlockDefinition;
import org.betterx.wover.block.api.client.model.ModelTraitLibrary;
import org.betterx.wover.block.api.client.trait.ClientBlockTraits;
import org.betterx.wover.block.api.trait.BlockTraitKey;
import org.betterx.wover.block.api.trait.BlockTraits;
import org.betterx.wover.block.api.trait.GenericBlockTrait;
import org.betterx.wover.block.impl.trait.BlockTraitImpl;
import org.betterx.wover.tag.api.predefined.MineableTags;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class IceBlockTrait extends BlockTraitImpl<Block, GenericBlockTrait> {
    private static final BlockTraitKey KEY = BlockTraitKey.ofUnique(BetterEnd.C, "ice");
    public static final IceBlockTrait DEFAULT = new IceBlockTrait(Blocks.ICE);
    public static final IceBlockTrait PACKED = new IceBlockTrait(Blocks.PACKED_ICE);
    public static final IceBlockTrait BLUE = new IceBlockTrait(Blocks.BLUE_ICE);

    public final Block baseIceBlock;

    private IceBlockTrait(Block baseIceBlock) {
        super();
        this.baseIceBlock = baseIceBlock;
    }

    @Override
    public BlockTraitKey key() {
        return KEY;
    }

    @Override
    public void configure(BlockDefinition<Block, ? extends BlockDefinition<Block, ?>> definition) {
        definition
                .replacePropertiesWithCopy(baseIceBlock)
                .addTags(MineableTags.PICKAXE)
                .addTrait(ClientBlockTraits.RENDER_LAYER.translucent())
                .addTrait(BlockTraits.LOOT_TABLE.dropWithSilktouch())
                .addTrait(ModelTraitLibrary.cube())
        ;
        ;
    }
}
