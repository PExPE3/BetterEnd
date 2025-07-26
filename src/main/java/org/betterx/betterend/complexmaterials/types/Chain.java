package org.betterx.betterend.complexmaterials.types;

import org.betterx.betterend.complexmaterials.MetalMaterial;
import org.betterx.wover.block.api.BlockDefinition;
import org.betterx.wover.block.api.client.trait.BlockModelTrait;
import org.betterx.wover.block.api.client.trait.ClientBlockTraits;
import org.betterx.wover.block.api.trait.BlockRecipeTrait;
import org.betterx.wover.block.api.trait.BlockTraitLookup;
import org.betterx.wover.block.api.trait.BlockTraits;
import org.betterx.wover.recipe.api.RecipeBuilder;
import org.betterx.wover.sets.api.blocks.BlockSet;
import org.betterx.wover.sets.api.blocks.SlotFromDefinition;

import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.world.level.block.SoundType;

public class Chain extends SlotFromDefinition {
    private final MetalMaterial metalMaterial;

    public Chain(MetalMaterial metalMaterial) {
        super(MetalMaterial.CHAIN);
        this.metalMaterial = metalMaterial;
    }

    @Override
    protected void addSlotSpecificDefinitions(BlockSet<?> set, BlockDefinition<?, ?> def) {
        super.addSlotSpecificDefinitions(set, def);
        def.addTrait(ClientBlockTraits.RENDER_LAYER.cutout());

        def.getProperties()
           .forceSolidOn()
           .requiresCorrectToolForDrops()
           .sound(SoundType.CHAIN)
           .noOcclusion();
    }

    @Override
    protected BlockRecipeTrait buildRecipe(BlockSet<?> set, BlockTraitLookup traitLookup) {
        return BlockTraits.RECIPE.with(
                (key, block, context) -> {
                    RecipeBuilder
                            .crafting(key.location(), block)
                            .shape("N", "#", "N")
                            .addMaterial('#', metalMaterial.equipment.ingot)
                            .addMaterial('N', metalMaterial.equipment.nugget)
                            .group("end_metal_chain")
                            .build(context);
                });
    }

    @Override
    protected BlockModelTrait buildModel(BlockSet<?> set, BlockTraitLookup traitLookup) {
        return ClientBlockTraits.MODEL.with(
                (key, block, generator) -> {
                    generator.vanillaGenerator.createAxisAlignedPillarBlockCustomModel(
                            block,
                            generator.vanillaGenerator.plainVariant(ModelLocationUtils.getModelLocation(block))
                    );
                });
    }
}
