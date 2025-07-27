package org.betterx.betterend.complexmaterials.types;

import org.betterx.betterend.complexmaterials.MetalMaterial;
import org.betterx.wover.block.api.client.model.ModelTraitLibrary;
import org.betterx.wover.block.api.client.trait.BlockModelTrait;
import org.betterx.wover.block.api.trait.BlockRecipeTrait;
import org.betterx.wover.block.api.trait.BlockTraitLookup;
import org.betterx.wover.block.api.trait.BlockTraits;
import org.betterx.wover.recipe.api.RecipeBuilder;
import org.betterx.wover.sets.api.blocks.BlockSet;
import org.betterx.wover.sets.api.blocks.SlotFromDefinition;

public class Tile extends SlotFromDefinition {
    private final MetalMaterial metalMaterial;

    public Tile(MetalMaterial metalMaterial) {
        super(MetalMaterial.TILE);
        this.metalMaterial = metalMaterial;
    }

    @Override
    protected BlockRecipeTrait buildRecipe(BlockSet<?> set, BlockTraitLookup traitLookup) {
        return BlockTraits.RECIPE.with(
                (key, block, context) -> {
                    RecipeBuilder
                            .crafting(key.location(), block)
                            .outputCount(4)
                            .shape("##", "##")
                            .addMaterial('#', metalMaterial.getBaseBlock())
                            .group("end_metal_tiles")
                            .build(context);

                    RecipeBuilder
                            .stonecutting(key.location().withPrefix("_stonecutting"), block)
                            .input(metalMaterial.getBaseBlock())
                            .group("end_metal_tiles")
                            .build(context);
                });
    }

    @Override
    protected BlockModelTrait buildModel(BlockSet<?> set, BlockTraitLookup traitLookup) {
        return ModelTraitLibrary.cube();
    }
}
