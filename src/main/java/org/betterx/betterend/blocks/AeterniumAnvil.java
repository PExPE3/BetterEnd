package org.betterx.betterend.blocks;

import org.betterx.bclib.blocks.LeveledAnvilBlock;
import org.betterx.bclib.items.BaseAnvilItem;
import org.betterx.betterend.item.material.EndToolMaterial;
import org.betterx.betterend.registry.EndBlocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class AeterniumAnvil extends LeveledAnvilBlock {
    public AeterniumAnvil() {
        super(EndBlocks.AETERNIUM_BLOCK.defaultMapColor(), EndToolMaterial.AETERNIUM.getLevel());
    }

    @Override
    public int getMaxDurability() {
        return 12;
    }

    @Override
    public BlockItem getCustomBlockItem(ResourceLocation blockID, Item.Properties settings) {
        return new BaseAnvilItem(this, settings.fireResistant());
    }
}