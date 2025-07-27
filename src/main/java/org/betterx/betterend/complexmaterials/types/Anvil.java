package org.betterx.betterend.complexmaterials.types;

import org.betterx.bclib.blocks.BaseAnvilBlock;
import org.betterx.bclib.blocks.LeveledAnvilBlock;
import org.betterx.betterend.complexmaterials.MetalMaterial;
import org.betterx.wover.block.api.BlockDefinition;
import org.betterx.wover.block.api.BlockRegistry;
import org.betterx.wover.block.api.client.trait.BlockModelTrait;
import org.betterx.wover.block.api.trait.BlockRecipeTrait;
import org.betterx.wover.block.api.trait.BlockTraitLookup;
import org.betterx.wover.block.api.trait.BlockTraits;
import org.betterx.wover.recipe.api.RecipeBuilder;
import org.betterx.wover.sets.api.blocks.BlockSet;
import org.betterx.wover.sets.api.blocks.SlotFromDefinition;

import net.minecraft.tags.BlockTags;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Anvil extends SlotFromDefinition {
    public final int level;

    public Anvil(int level) {
        super(MetalMaterial.ANVIL);
        this.level = level;
    }

    @Override
    protected @Nullable BlockDefinition<?, ?> startBlockDefinition(
            @NotNull BlockRegistry registry,
            @NotNull BlockSet<?> set,
            @NotNull String name
    ) {
        return registry.defineDefaultBlock(
                name, (def) -> new LeveledAnvilBlock(
                        def.getProperties(),
                        level
                )
        );
    }

    @Override
    protected void addSlotSpecificDefinitions(BlockSet<?> set, BlockDefinition<?, ?> def) {
        super.addSlotSpecificDefinitions(set, def);
        def.addTags(BlockTags.ANVIL);
    }

    @Override
    protected BlockRecipeTrait buildRecipe(BlockSet<?> set, BlockTraitLookup traitLookup) {
        return BlockTraits.RECIPE.with(
                (key, block, context) -> {
                    RecipeBuilder
                            .crafting(key.location(), block)
                            .shape("###", " I ", "III")
                            .addMaterial('#', set.getBaseBlock(), set.getBlock(MetalMaterial.TILE))
                            .addMaterial('I', set.getItem(MetalMaterial.INGOT))
                            .group("end_metal_anvil")
                            .build(context);
                });
    }

    @Override
    protected BlockModelTrait buildModel(BlockSet<?> set, BlockTraitLookup traitLookup) {
        return BaseAnvilBlock.buildModel(set, traitLookup);
    }


}
