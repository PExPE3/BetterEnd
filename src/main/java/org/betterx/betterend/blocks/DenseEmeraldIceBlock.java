package org.betterx.betterend.blocks;

import org.betterx.bclib.blocks.BaseBlock;
import org.betterx.wover.loot.api.LootLookupProvider;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.LootTable;

import org.jetbrains.annotations.NotNull;

public class DenseEmeraldIceBlock extends BaseBlock {
    public DenseEmeraldIceBlock(BlockBehaviour.Properties props) {
        super(props);
    }


    @Override
    public LootTable.Builder registerBlockLoot(
            @NotNull ResourceLocation location,
            @NotNull LootLookupProvider provider,
            @NotNull ResourceKey<LootTable> tableKey
    ) {
        return provider.dropWithSilkTouch(this);
    }
}
