package org.betterx.betterend.blocks;

import org.betterx.betterend.blocks.basis.PottableFeatureSapling;
import org.betterx.betterend.interfaces.survives.SurvivesOnJungleMoss;
import org.betterx.betterend.registry.features.EndConfiguredVegetation;
import org.betterx.betterend.world.features.trees.UmbrellaTreeFeature;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class UmbrellaTreeSaplingBlock extends PottableFeatureSapling<UmbrellaTreeFeature, NoneFeatureConfiguration> implements SurvivesOnJungleMoss {
    public UmbrellaTreeSaplingBlock(Properties props) {
        super(props, (level, pos, state, rnd) -> EndConfiguredVegetation.UMBRELLA_TREE.placeInWorld(level, pos, rnd));
    }
}
