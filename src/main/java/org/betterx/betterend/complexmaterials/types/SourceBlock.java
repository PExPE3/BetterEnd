package org.betterx.betterend.complexmaterials.types;

import org.betterx.betterend.complexmaterials.MetalMaterial;
import org.betterx.wover.block.api.BlockDefinition;
import org.betterx.wover.block.api.client.model.ModelTraitLibrary;
import org.betterx.wover.block.api.client.trait.BlockModelTrait;
import org.betterx.wover.block.api.trait.BlockRecipeTrait;
import org.betterx.wover.block.api.trait.BlockTraitLookup;
import org.betterx.wover.block.api.trait.BlockTraits;
import org.betterx.wover.recipe.api.RecipeBuilder;
import org.betterx.wover.sets.api.blocks.BlockSet;
import org.betterx.wover.sets.api.blocks.SlotFromDefinition;
import org.betterx.wover.sets.api.blocks.SlotType;

import net.minecraft.tags.BlockTags;

public class SourceBlock extends SlotFromDefinition {
    private final MetalMaterial metalMaterial;

    public SourceBlock(MetalMaterial metalMaterial) {
        super(SlotType.SOURCE);
        this.metalMaterial = metalMaterial;
    }

    @Override
    public String getName(BlockSet<?> set) {
        return set.baseName + "_block";
    }

    @Override
    protected void addSlotSpecificDefinitions(BlockSet<?> set, BlockDefinition<?, ?> def) {
        super.addSlotSpecificDefinitions(set, def);
        def.addTags(BlockTags.BEACON_BASE_BLOCKS);
    }

    @Override
    protected BlockRecipeTrait buildRecipe(BlockSet<?> set, BlockTraitLookup traitLookup) {
        return BlockTraits.RECIPE.with(
                (key, block, context) -> {
                    RecipeBuilder.crafting(key.location(), block)
                                 .shape("###", "###", "###")
                                 .addMaterial('#', metalMaterial.equipment.ingot)
                                 .group("end_metal_blocks")
                                 .build(context);
                }
        );
    }

    @Override
    protected BlockModelTrait buildModel(BlockSet<?> set, BlockTraitLookup traitLookup) {
        return ModelTraitLibrary.cube(set::getBaseBlock);
    }
}
