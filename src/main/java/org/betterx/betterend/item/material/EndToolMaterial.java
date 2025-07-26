package org.betterx.betterend.item.material;

import org.betterx.betterend.registry.EndBlocks;
import org.betterx.betterend.registry.EndTags;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

public class EndToolMaterial {
    public static final ToolMaterial THALLASIUM = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            320,
            7.0F,
            1.5F,
            9,
            EndBlocks.THALLASIUM.repairItems
    );

    public static final ToolMaterial TERMINITE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1230,
            8.5F,
            3.5F,
            9,
            EndBlocks.TERMINITE.repairItems
    );

    public static final ToolMaterial AETERNIUM = new ToolMaterial(
            EndTags.INCORRECT_FOR_AETERNIUM_TOOL,
            2196,
            10.0F,
            4.5F,
            10,
            EndBlocks.AETERNIUM.repairItems
    );
}
