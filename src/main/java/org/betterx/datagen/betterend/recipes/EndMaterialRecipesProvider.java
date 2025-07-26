package org.betterx.datagen.betterend.recipes;

import org.betterx.betterend.complexmaterials.MaterialManager;
import org.betterx.betterend.registry.EndItems;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.provider.WoverRecipeProvider;
import org.betterx.wover.recipe.api.RecipeBuilder;

public class EndMaterialRecipesProvider extends WoverRecipeProvider {
    public EndMaterialRecipesProvider(ModCore modCore) {
        super(modCore, "BetterEnd - Material Recipes");
    }

    @Override
    protected void bootstrap(RecipeBuilder.Context context) {
        EndItems.AETERNIUM_SET.registerRecipes(context);
        MaterialManager.stream().forEach(m -> m.registerRecipes(context));
    }
}
