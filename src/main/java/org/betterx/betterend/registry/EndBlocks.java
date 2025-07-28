package org.betterx.betterend.registry;

import org.betterx.bclib.api.v3.tag.BCLBlockTags;
import org.betterx.bclib.blocks.BaseOreBlock;
import org.betterx.bclib.blocks.BaseVineBlock;
import org.betterx.bclib.blocks.SimpleLeavesBlock;
import org.betterx.bclib.blocks.StalactiteBlock;
import org.betterx.bclib.trait.block.*;
import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.blocks.*;
import org.betterx.betterend.blocks.EndPortalBlock;
import org.betterx.betterend.blocks.basis.*;
import org.betterx.betterend.complexmaterials.*;
import org.betterx.betterend.complexmaterials.types.*;
import org.betterx.betterend.item.material.EndArmorTier;
import org.betterx.betterend.item.material.EndToolTier;
import org.betterx.betterend.trait.block.IceBlockTrait;
import org.betterx.betterend.trait.block.SnowBlockTrait;
import org.betterx.betterend.trait.block.StalactiteBlockTrait;
import org.betterx.betterend.trait.block.TerrainBlockTrait;
import org.betterx.wover.block.api.BlockRegistry;
import org.betterx.wover.block.api.DefaultBlockDefinition;
import org.betterx.wover.block.api.VanillaBlockDefinition;
import org.betterx.wover.block.api.client.model.ModelTraitLibrary;
import org.betterx.wover.block.api.client.trait.ClientBlockTraits;
import org.betterx.wover.block.api.trait.BlockTraits;
import org.betterx.wover.recipe.api.RecipeMaterial;
import org.betterx.wover.recipe.api.RecipeTraitLibrary;
import org.betterx.wover.sets.api.blocks.SlotMap;
import org.betterx.wover.sets.api.blocks.SlotType;
import org.betterx.wover.tag.api.predefined.CommonBlockTags;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.List;
import java.util.function.Function;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

public class EndBlocks {
    private static BlockRegistry BLOCKS_REGISTRY;

    // Terrain //
    public static final Block ENDSTONE_DUST = defineBlock("endstone_dust", EndstoneDustBlock::new)
            .replacePropertiesWithCopy(Blocks.SAND)
            .mapColor(Blocks.END_STONE.defaultMapColor())
            .buildAndRegister();

    public static final Block END_MYCELIUM = registerEndTerrain("end_mycelium", MapColor.COLOR_LIGHT_BLUE);


    public static final Block END_MOSS = registerEndTerrain(
            "end_moss", MapColor.COLOR_CYAN,
            BCLBlockTags.BONEMEAL_SOURCE_END_STONE, BlockTags.NYLIUM
    );

    public static final Block CHORUS_NYLIUM = registerEndTerrain(
            "chorus_nylium", MapColor.COLOR_MAGENTA,
            BCLBlockTags.BONEMEAL_SOURCE_END_STONE, BlockTags.NYLIUM
    );

    public static final Block CAVE_MOSS = registerEndTerrain(
            "cave_moss", MapColor.COLOR_PURPLE,
            BCLBlockTags.BONEMEAL_SOURCE_END_STONE, BlockTags.NYLIUM
    );

    public static final Block CRYSTAL_MOSS = registerEndTerrain(
            "crystal_moss", MapColor.COLOR_CYAN,
            BCLBlockTags.BONEMEAL_SOURCE_END_STONE, BlockTags.NYLIUM
    );

    public static final Block SHADOW_GRASS = registerEndTerrain(
            "shadow_grass", MapColor.COLOR_BLACK,
            ShadowGrassBlock::new,
            BCLBlockTags.BONEMEAL_SOURCE_END_STONE, BlockTags.NYLIUM
    );

    public static final Block PINK_MOSS = registerEndTerrain(
            "pink_moss", MapColor.COLOR_PINK,
            BCLBlockTags.BONEMEAL_SOURCE_END_STONE, BlockTags.NYLIUM
    );

    public static final Block AMBER_MOSS = registerEndTerrain(
            "amber_moss", MapColor.COLOR_ORANGE,
            BCLBlockTags.BONEMEAL_SOURCE_END_STONE, BlockTags.NYLIUM
    );

    public static final Block JUNGLE_MOSS = registerEndTerrain(
            "jungle_moss", MapColor.COLOR_GREEN,
            BCLBlockTags.BONEMEAL_SOURCE_END_STONE, BlockTags.NYLIUM
    );

    public static final Block SANGNUM = registerEndTerrain(
            "sangnum", MapColor.COLOR_RED,
            BCLBlockTags.BONEMEAL_SOURCE_END_STONE, BlockTags.NYLIUM
    );

    public static final Block RUTISCUS = registerEndTerrain(
            "rutiscus", MapColor.COLOR_ORANGE,
            BCLBlockTags.BONEMEAL_SOURCE_END_STONE, BlockTags.NYLIUM
    );

    public static final Block PALLIDIUM_FULL = registerEndTerrain(
            "pallidium_full", MapColor.COLOR_LIGHT_GRAY,
            p -> new PallidiumBlock(p, "full", null),
            BCLBlockTags.BONEMEAL_SOURCE_END_STONE, BlockTags.NYLIUM
    );
    public static final Block PALLIDIUM_HEAVY = registerEndTerrain(
            "pallidium_heavy", MapColor.COLOR_LIGHT_GRAY,
            p -> new PallidiumBlock(p, "heavy", PALLIDIUM_FULL),
            BCLBlockTags.BONEMEAL_SOURCE_END_STONE, BlockTags.NYLIUM
    );
    public static final Block PALLIDIUM_THIN = registerEndTerrain(
            "pallidium_thin", MapColor.COLOR_LIGHT_GRAY,
            p -> new PallidiumBlock(p, "thin", PALLIDIUM_FULL),
            BCLBlockTags.BONEMEAL_SOURCE_END_STONE, BlockTags.NYLIUM
    );
    public static final Block PALLIDIUM_TINY = registerEndTerrain(
            "pallidium_tiny", MapColor.COLOR_LIGHT_GRAY,
            p -> new PallidiumBlock(p, "tiny", PALLIDIUM_FULL),
            BCLBlockTags.BONEMEAL_SOURCE_END_STONE, BlockTags.NYLIUM
    );

    // Paths //
    public static final Block END_MYCELIUM_PATH = registerPath("end_mycelium_path", END_MYCELIUM);
    public static final Block END_MOSS_PATH = registerPath("end_moss_path", END_MOSS);
    public static final Block CHORUS_NYLIUM_PATH = registerPath("chorus_nylium_path", CHORUS_NYLIUM);
    public static final Block CAVE_MOSS_PATH = registerPath("cave_moss_path", CAVE_MOSS);
    public static final Block CRYSTAL_MOSS_PATH = registerPath("crystal_moss_path", CRYSTAL_MOSS);
    public static final Block SHADOW_GRASS_PATH = registerPath("shadow_grass_path", SHADOW_GRASS);
    public static final Block PINK_MOSS_PATH = registerPath("pink_moss_path", PINK_MOSS);
    public static final Block AMBER_MOSS_PATH = registerPath("amber_moss_path", AMBER_MOSS);
    public static final Block JUNGLE_MOSS_PATH = registerPath("jungle_moss_path", JUNGLE_MOSS);
    public static final Block SANGNUM_PATH = registerPath("sangnum_path", SANGNUM);
    public static final Block RUTISCUS_PATH = registerPath("rutiscus_path", RUTISCUS);

    public static final Block MOSSY_OBSIDIAN = defineBlock("mossy_obsidian", MossyObsidian::new)
            .replacePropertiesWithCopy(Blocks.OBSIDIAN)
            .addTags(BCLBlockTags.BONEMEAL_SOURCE_OBSIDIAN)
            .addTrait(BlockTraits.LOOT_TABLE.dropWithSilktouch(Blocks.OBSIDIAN))
            .addTrait(BlockTraits.OBSIDIAN_BLOCK)
            .randomTicks()
            .destroyTime(3)
            .buildAndRegister();

    public static final Block DRAGON_BONE_BLOCK = defineBlock("dragon_bone_block", RotatedPillarBlock::new)
            .replacePropertiesWithCopy(Blocks.BONE_BLOCK)
            .addTags(EndTags.BONEMEAL_TARGET_DRAGON_BONE)
            .addTrait(ModelTraitLibrary.pillar())
            .addTrait(BlockTraits.LOOT_TABLE.dropSelf())
            .buildAndRegister();

    public static final Block DRAGON_BONE_STAIRS = defineEndBlock("dragon_bone_stairs")
            .addTrait(BlockTraits.STAIR_BLOCK)
            .addTrait(ModelTraitLibrary.stairs(() -> DRAGON_BONE_BLOCK))
            .addTrait(RecipeTraitLibrary.stairs(RecipeMaterial.of(DRAGON_BONE_BLOCK)))
            .buildAndRegister();

    public static final Block DRAGON_BONE_SLAB = defineEndBlock("dragon_bone_slab")
            .addTrait(BlockTraits.SLAB_BLOCK)
            .addTrait(ModelTraitLibrary.slab(() -> DRAGON_BONE_BLOCK))
            .addTrait(RecipeTraitLibrary.slab(RecipeMaterial.of(DRAGON_BONE_BLOCK)))
            .buildAndRegister();

    public static final Block MOSSY_DRAGON_BONE = defineBlock("mossy_dragon_bone", MossyDragonBoneBlock::new)
            .replacePropertiesWithCopy(DRAGON_BONE_BLOCK)
            .addTags(EndTags.BONEMEAL_SOURCE_DRAGON_BONE)
            .addTrait(BlockTraits.LOOT_TABLE.dropWithSilktouch(DRAGON_BONE_BLOCK))
            .addTrait(BlockTraits.STONE_BLOCK)
            .randomTicks()
            .destroyTime(0.5f)
            .buildAndRegister();


    // Rocks //
    public static final StoneMaterial FLAVOLITE = new StoneMaterial("flavolite", MapColor.SAND);
    public static final StoneMaterial VIOLECITE = new StoneMaterial("violecite", MapColor.COLOR_PURPLE);
    public static final StoneMaterial SULPHURIC_ROCK = new StoneMaterial("sulphuric_rock", MapColor.COLOR_BROWN);
    public static final StoneMaterial VIRID_JADESTONE = new StoneMaterial("virid_jadestone", MapColor.COLOR_GREEN);
    public static final StoneMaterial AZURE_JADESTONE = new StoneMaterial(
            "azure_jadestone",
            MapColor.COLOR_LIGHT_BLUE
    );
    public static final StoneMaterial SANDY_JADESTONE = new StoneMaterial(
            "sandy_jadestone",
            MapColor.COLOR_YELLOW
    );
    public static final StoneMaterial UMBRALITH = new StoneMaterial("umbralith", MapColor.DEEPSLATE);
    public static final Block BRIMSTONE = defineBlock("brimstone", BrimstoneBlock::new)
            .replacePropertiesWithCopy(Blocks.END_STONE)
            .addTrait(BlockTraits.STONE_BLOCK)
            .mapColor(MapColor.COLOR_BROWN)
            .randomTicks()
            .buildAndRegister();

    public static final Block SULPHUR_CRYSTAL = defineBlock("sulphur_crystal", SulphurCrystalBlock::new)
            .addTrait(ClientBlockTraits.RENDER_LAYER.cutout())
            .mapColor(MapColor.COLOR_YELLOW)
            .sound(SoundType.GLASS)
            .requiresCorrectToolForDrops()
            .noCollission()
            .buildAndRegister();

    public static final Block MISSING_TILE = defineBlock("missing_tile", Block::new)
            .replacePropertiesWithCopy(Blocks.END_STONE)
            .addTrait(BlockTraits.STONE_BLOCK)
            .buildAndRegister();

    // Vanilla Stone Sets
    public static final VanillaStoneSet END_STONE_SET = new VanillaStoneSet(
            "end_stone", Blocks.END_STONE,
            SlotMap.of(FlowerPot.SLOT, StoneLantern.SLOT, Furnace.SLOT)
    );

    public static final VanillaStoneSet ANDESITE_SET = new VanillaStoneSet(
            "andesite", Blocks.ANDESITE,
            SlotMap.of(Pedestal.SLOT, StoneLantern.SLOT)
    );

    public static final VanillaStoneSet DIORITE_SET = new VanillaStoneSet(
            "diorite", Blocks.DIORITE,
            SlotMap.of(Pedestal.SLOT, StoneLantern.SLOT)
    );

    public static final VanillaStoneSet GRANITE_SET = new VanillaStoneSet(
            "granite", Blocks.GRANITE,
            SlotMap.of(Pedestal.SLOT, StoneLantern.SLOT)
    );

    public static final VanillaStoneSet QUARTZ_SET = new VanillaStoneSet(
            "quartz", Blocks.QUARTZ_BLOCK,
            SlotMap.of(Pedestal.SLOT, StoneLantern.SLOT)
    );

    public static final VanillaStoneSet PURPUR_SET = new VanillaStoneSet(
            "purple", Blocks.PURPUR_BLOCK,
            SlotMap.of(Pedestal.SLOT, StoneLantern.SLOT)
    );

    public static final VanillaStoneSet BLACKSTONE_SET = new VanillaStoneSet(
            "blackstone", Blocks.BLACKSTONE,
            SlotMap.of(StoneLantern.SLOT)
    );

    // Vanilla Metal Sets
    public static final VanillaMetalSet IRON_SET = new VanillaMetalSet(
            "iron", Blocks.IRON_BLOCK, Items.IRON_INGOT,
            SlotMap.of(Chandelier.SLOT, BulbLantern.SLOT)
    );
    public static final VanillaMetalSet GOLD_SET = new VanillaMetalSet(
            "iron", Blocks.GOLD_BLOCK, Items.GOLD_INGOT,
            SlotMap.of(Chandelier.SLOT)
    );

    public static final Block FLAVOLITE_RUNED = defineBlock("flavolite_runed", RunedFlavolite::new)
            .replacePropertiesWithCopy(EndBlocks.FLAVOLITE.getBlock(SlotType.POLISHED))
            .strength(1, Blocks.OBSIDIAN.getExplosionResistance())
            .lightLevel(state -> state.getValue(RunedFlavolite.ACTIVATED) ? 8 : 0)
            .buildAndRegister();

    public static final Block FLAVOLITE_RUNED_ETERNAL = defineBlock("flavolite_runed_eternal", RunedFlavolite::new)
            .replacePropertiesWithCopy(EndBlocks.FLAVOLITE.getBlock(SlotType.POLISHED))
            .strength(-11, Blocks.BEDROCK.getExplosionResistance())
            .lightLevel(state -> state.getValue(RunedFlavolite.ACTIVATED) ? 8 : 0)
            .buildAndRegister();

    public static final Block HYDROTHERMAL_VENT = defineBlock("hydrothermal_vent", HydrothermalVentBlock::new)
            .addTrait(BlockTraits.STONE_BLOCK)
            .sound(SoundType.STONE)
            .noCollission()
            .requiresCorrectToolForDrops()
            .buildAndRegister();

    public static final Block VENT_BUBBLE_COLUMN = defineBlockOnly("vent_bubble_column", VentBubbleColumnBlock::new)
            .replacePropertiesWithCopy(Blocks.BUBBLE_COLUMN)
            .noOcclusion().noCollission().noLootTable()
            .buildAndRegister();

    public static final Block DENSE_SNOW = defineBlock("dense_snow", Block::new)
            .addTrait(SnowBlockTrait.withDefault())
            .buildAndRegister();

    public static final Block EMERALD_ICE = defineBlock("emerald_ice", EmeraldIceBlock::new)
            .addTrait(IceBlockTrait.withBase(Blocks.ICE))
            .randomTicks()
            .buildAndRegister();

    public static final Block DENSE_EMERALD_ICE = defineBlock("dense_emerald_ice", Block::new)
            .addTrait(IceBlockTrait.withBase(Blocks.PACKED_ICE))
            .buildAndRegister();

    public static final Block ANCIENT_EMERALD_ICE = defineBlock("ancient_emerald_ice", AncientEmeraldIceBlock::new)
            .addTrait(IceBlockTrait.withBase(Blocks.BLUE_ICE))
            .randomTicks()
            .buildAndRegister();
    ;

    public static final Block END_STONE_STALACTITE = defineBlock("end_stone_stalactite", StalactiteBlock::new)
            .addTrait(StalactiteBlockTrait.withSource(Blocks.END_STONE))
            .buildAndRegister();

    public static final Block END_STONE_STALACTITE_CAVEMOSS = defineBlock(
            "end_stone_stalactite_cavemoss",
            StalactiteBlock::new
    ).addTrait(StalactiteBlockTrait.withSource(CAVE_MOSS))
     .buildAndRegister();

    // Wooden Materials And Trees //
    public static final Block MOSSY_GLOWSHROOM_SAPLING = defineBlock(
            "mossy_glowshroom_sapling",
            MossyGlowshroomSaplingBlock::new
    ).addTrait(SaplingBlockTrait.withLight(7))
     .addTrait(SurvivesOnBlockTrait.withTag(EndTags.SURVIVES_ON_MOSS_OR_MYCELIUM))
     .buildAndRegister();

    public static final Block MOSSY_GLOWSHROOM_CAP = defineBlock("mossy_glowshroom_cap", MossyGlowshroomCapBlock::new)
            .addTrait(BlockTraits.WOOD_BLOCK)
            .buildAndRegister();

    public static final Block MOSSY_GLOWSHROOM_HYMENOPHORE = defineBlock(
            "mossy_glowshroom_hymenophore",
            GlowingHymenophoreBlock::new
    ).addTrait(BlockTraits.MINEABLE_WITH.needsAxe())
     .addTrait(ClientBlockTraits.MODEL.with(
             (key, block, generator) ->
                     GlowingHymenophoreBlock.provideUnshadedCubeModel(generator, block)
     ))
     .addTrait(BlockTraits.LOOT_TABLE)
     .lightLevel((_s) -> 15)
     .sound(SoundType.WART_BLOCK)
     .buildAndRegister();

    public static final Block MOSSY_GLOWSHROOM_FUR = defineBlock("mossy_glowshroom_fur", FurBlock::new)
            .addTrait(LeavesBlockTrait.withColor(MapColor.COLOR_LIGHT_BLUE, 15, true, 16, MOSSY_GLOWSHROOM_SAPLING))
            .buildAndRegister();

    public static final EndWoodenComplexMaterial MOSSY_GLOWSHROOM = new EndWoodenComplexMaterial(
            "mossy_glowshroom",
            MapColor.COLOR_GRAY,
            MapColor.WOOD,
            Blocks.GRAY_WOOL
    ).init();

    public static final Block PYTHADENDRON_SAPLING = defineBlock("pythadendron_sapling", PythadendronSaplingBlock::new)
            .addTrait(SaplingBlockTrait.withColor(MapColor.COLOR_PURPLE))
            .addTrait(SurvivesOnBlockTrait.withTag(EndTags.SURVIVES_ON_CHORUS_NYLIUM))
            .buildAndRegister();

    public static final Block PYTHADENDRON_LEAVES = defineBlock("pythadendron_leaves", PottableLeavesBlock::new)
            .addTrait(LeavesBlockTrait.withColor(MapColor.COLOR_MAGENTA, 0, false, PYTHADENDRON_SAPLING))
            .buildAndRegister();

    public static final EndWoodenComplexMaterial PYTHADENDRON = new EndWoodenComplexMaterial(
            "pythadendron",
            MapColor.COLOR_MAGENTA,
            MapColor.COLOR_PURPLE,
            Blocks.BLACK_WOOL
    ).init();

    public static final Block END_LOTUS_SEED = defineBlock("end_lotus_seed", EndLotusSeedBlock::new)
            .addTrait(WaterSeedBlockTrait.withColor(MapColor.COLOR_CYAN))
            .buildAndRegister();

    public static final Block END_LOTUS_STEM = defineBlock("end_lotus_stem", EndLotusStemBlock::new)
            .addTrait(BlockTraits.WOOD_BLOCK)
            .addTrait(ClientBlockTraits.RENDER_LAYER.cutout())
            .buildAndRegister();

    public static final Block END_LOTUS_LEAF = defineBlockOnly("end_lotus_leaf", EndLotusLeafBlock::new)
            .addTrait(PlantBlockTrait.compostableWithColor(MapColor.COLOR_PINK, true, true))
            .buildAndRegister();

    public static final Block END_LOTUS_FLOWER = defineBlockOnly("end_lotus_flower", EndLotusFlowerBlock::new)
            .addTrait(PlantBlockTrait.compostableWithColor(MapColor.COLOR_PINK, true, true))
            .lightLevel((bs) -> 15)
            .buildAndRegister();

    public static final EndWoodenComplexMaterial END_LOTUS = new EndWoodenComplexMaterial(
            "end_lotus",
            MapColor.COLOR_LIGHT_BLUE,
            MapColor.COLOR_CYAN,
            Blocks.LIGHT_BLUE_WOOL
    ).init();

    public static final Block LACUGROVE_SAPLING = defineBlock("lacugrove_sapling", LacugroveSaplingBlock::new)
            .addTrait(SaplingBlockTrait.withColor(MapColor.COLOR_CYAN))
            .buildAndRegister();

    public static final Block LACUGROVE_LEAVES = defineBlock("lacugrove_leaves", PottableLeavesBlock::new)
            .addTrait(LeavesBlockTrait.withColor(MapColor.COLOR_CYAN, 0, false, LACUGROVE_SAPLING))
            .buildAndRegister();

    public static final EndWoodenComplexMaterial LACUGROVE = new EndWoodenComplexMaterial(
            "lacugrove",
            MapColor.COLOR_BROWN,
            MapColor.COLOR_YELLOW,
            Blocks.CYAN_WOOL
    ).init();

    public static final Block DRAGON_TREE_SAPLING = defineBlock("dragon_tree_sapling", DragonTreeSaplingBlock::new)
            .addTrait(SaplingBlockTrait.withColor(MapColor.COLOR_MAGENTA))
            .buildAndRegister();

    public static final Block DRAGON_TREE_LEAVES = defineBlock("dragon_tree_leaves", PottableLeavesBlock::new)
            .addTrait(LeavesBlockTrait.withColor(MapColor.COLOR_MAGENTA, 0, false, DRAGON_TREE_SAPLING))
            .buildAndRegister();

    public static final EndWoodenComplexMaterial DRAGON_TREE = new EndWoodenComplexMaterial(
            "dragon_tree",
            MapColor.COLOR_BLACK,
            MapColor.COLOR_MAGENTA
            , Blocks.BLACK_WOOL
    ).init();

    public static final Block TENANEA_SAPLING = defineBlock("tenanea_sapling", TenaneaSaplingBlock::new)
            .addTrait(SaplingBlockTrait.withColor(MapColor.COLOR_PINK))
            .addTrait(SurvivesOnBlockTrait.withTag(EndTags.SURVIVES_ON_PINK_MOSS))
            .buildAndRegister();

    public static final Block TENANEA_LEAVES = defineBlock("tenanea_leaves", PottableLeavesBlock::new)
            .addTrait(LeavesBlockTrait.withColor(MapColor.COLOR_PINK, 0, false, TENANEA_SAPLING))
            .buildAndRegister();

    public static final Block TENANEA_FLOWERS = defineBlock("tenanea_flowers", TenaneaFlowersBlock::new)
            .addTrait(VineBlockTrait.withColor(MapColor.COLOR_PINK, 15))
            .buildAndRegister();

    public static final Block TENANEA_OUTER_LEAVES = defineBlock("tenanea_outer_leaves", FurBlock::new)
            .addTrait(LeavesBlockTrait.withColor(MapColor.COLOR_PINK, 32, TENANEA_SAPLING))
            .buildAndRegister();

    public static final EndWoodenComplexMaterial TENANEA = new EndWoodenComplexMaterial(
            "tenanea",
            MapColor.COLOR_BROWN,
            MapColor.COLOR_PINK,
            Blocks.PINK_WOOL
    ).init();

    public static final Block HELIX_TREE_SAPLING = defineBlock("helix_tree_sapling", HelixTreeSaplingBlock::new)
            .addTrait(SaplingBlockTrait.withColor(MapColor.COLOR_ORANGE))
            .addTrait(SurvivesOnBlockTrait.withTag(EndTags.SURVIVES_ON_AMBER_MOSS))
            .buildAndRegister();

    public static final Block HELIX_TREE_LEAVES = defineBlock("helix_tree_leaves", HelixTreeLeavesBlock::new)
            .addTrait(LeavesBlockTrait.withColor(MapColor.COLOR_ORANGE, 8, HELIX_TREE_SAPLING))
            .sound(SoundType.WART_BLOCK)
            .buildAndRegister();

    public static final EndWoodenComplexMaterial HELIX_TREE = new EndWoodenComplexMaterial(
            "helix_tree",
            MapColor.COLOR_GRAY,
            MapColor.COLOR_ORANGE,
            Blocks.GRAY_WOOL
    ).init();

    public static final Block UMBRELLA_TREE_SAPLING = defineBlock(
            "umbrella_tree_sapling",
            UmbrellaTreeSaplingBlock::new
    ).addTrait(SaplingBlockTrait.withColor(MapColor.COLOR_BLUE))
     .addTrait(SurvivesOnBlockTrait.withTag(EndTags.SURVIVES_ON_JUNGLE_MOSS))
     .addTrait(ClientBlockTraits.RENDER_LAYER.translucent())
     .buildAndRegister();

    public static final Block UMBRELLA_TREE_MEMBRANE = defineBlock(
            "umbrella_tree_membrane",
            UmbrellaTreeMembraneBlock::new
    ).replacePropertiesWithCopy(Blocks.SLIME_BLOCK)
     .addTrait(LeavesBlockTrait.withColor(MapColor.COLOR_BLUE, 8, UMBRELLA_TREE_SAPLING))
     .addTrait(ClientBlockTraits.RENDER_LAYER.translucent())
     .buildAndRegister();

    public static final Block UMBRELLA_TREE_CLUSTER = defineBlock(
            "umbrella_tree_cluster",
            UmbrellaTreeClusterBlock::new
    ).replacePropertiesWithCopy(Blocks.NETHER_WART_BLOCK)
     .addTrait(BlockTraits.WOOD_BLOCK)
     .addTrait(BlockTraits.LOOT_TABLE)
     .mapColor(MapColor.COLOR_PURPLE)
     .lightLevel((bs) -> 15)
     .buildAndRegister();

    public static final Block UMBRELLA_TREE_CLUSTER_EMPTY = defineBlock(
            "umbrella_tree_cluster_empty",
            UmbrellaTreeClusterEmptyBlock::new
    ).replacePropertiesWithCopy(Blocks.NETHER_WART_BLOCK)
     .addTrait(BlockTraits.WOOD_BLOCK)
     .addTrait(BlockTraits.LOOT_TABLE)
     .mapColor(MapColor.COLOR_PURPLE)
     .randomTicks()
     .buildAndRegister();

    public static final EndWoodenComplexMaterial UMBRELLA_TREE = new EndWoodenComplexMaterial(
            "umbrella_tree",
            MapColor.COLOR_BLUE,
            MapColor.COLOR_GREEN,
            Blocks.MAGENTA_WOOL
    ).init();

    public static final Block JELLYSHROOM_CAP_PURPLE = defineBlock(
            "jellyshroom_cap_purple",
            p -> new JellyshroomCapBlock(
                    p,
                    217, 142, 255,
                    164, 0, 255
            )
    ).replacePropertiesWithCopy(Blocks.SLIME_BLOCK)
     .mapColor(MapColor.COLOR_PURPLE)
     .addTrait(BlockTraits.LOOT_TABLE)
     .addTrait(ClientBlockTraits.RENDER_LAYER.translucent())
     .buildAndRegister();

    public static final EndWoodenComplexMaterial JELLYSHROOM = new EndWoodenComplexMaterial(
            "jellyshroom",
            MapColor.COLOR_PURPLE,
            MapColor.COLOR_LIGHT_BLUE,
            Blocks.PURPLE_WOOL
    ).init();

    public static final Block LUCERNIA_SAPLING = registerBlock("lucernia_sapling", new LucerniaSaplingBlock());
    public static final Block LUCERNIA_LEAVES = registerBlock(
            "lucernia_leaves",
            new PottableLeavesBlock(
                    LUCERNIA_SAPLING,
                    MapColor.COLOR_ORANGE
            )
    );
    public static final Block LUCERNIA_OUTER_LEAVES = registerBlock(
            "lucernia_outer_leaves",
            new FurBlock(MapColor.COLOR_RED, LUCERNIA_SAPLING, 32)
    );
    public static final EndWoodenComplexMaterial LUCERNIA = new EndWoodenComplexMaterial(
            "lucernia",
            MapColor.COLOR_ORANGE,
            MapColor.COLOR_ORANGE,
            Blocks.WHITE_WOOL
    ).init();

    public static final EndWoodenComplexMaterial LUCERNIA_JELLY = new JellyLucerniaWoodMaterial().init();

    // Small Plants //
    public static final Block UMBRELLA_MOSS = registerBlock("umbrella_moss", new UmbrellaMossBlock());
    public static final Block UMBRELLA_MOSS_TALL = registerBlock("umbrella_moss_tall", new UmbrellaMossTallBlock());
    public static final Block CREEPING_MOSS = registerBlock("creeping_moss", new GlowingMossBlock(11));
    public static final Block CHORUS_GRASS = registerBlock("chorus_grass", new ChorusGrassBlock());
    public static final Block CAVE_GRASS = registerBlock(
            "cave_grass",
            new TerrainPlantBlock(CAVE_MOSS)
    );
    public static final Block CRYSTAL_GRASS = registerBlock(
            "crystal_grass",
            new TerrainPlantBlock(CRYSTAL_MOSS)
    );
    public static final Block SHADOW_PLANT = registerBlock(
            "shadow_plant",
            new TerrainPlantBlock(SHADOW_GRASS)
    );
    public static final Block BUSHY_GRASS = registerBlock(
            "bushy_grass",
            new TerrainPlantBlock(PINK_MOSS)
    );
    public static final Block AMBER_GRASS = registerBlock(
            "amber_grass",
            new TerrainPlantBlock(AMBER_MOSS)
    );
    public static final Block TWISTED_UMBRELLA_MOSS = registerBlock(
            "twisted_umbrella_moss",
            new TwistedUmbrellaMossBlock()
    );
    public static final Block TWISTED_UMBRELLA_MOSS_TALL = registerBlock(
            "twisted_umbrella_moss_tall",
            new TwistedUmbrellaMossTallBlock()
    );
    public static final Block JUNGLE_GRASS = registerBlock(
            "jungle_grass",
            new TerrainPlantBlock(JUNGLE_MOSS)
    );
    public static final Block BLOOMING_COOKSONIA = registerBlock(
            "blooming_cooksonia",
            new TerrainPlantBlock(END_MOSS)
    );
    public static final Block SALTEAGO = registerBlock("salteago", new TerrainPlantBlock(END_MOSS));
    public static final Block VAIOLUSH_FERN = registerBlock("vaiolush_fern", new TerrainPlantBlock(END_MOSS));
    public static final Block FRACTURN = registerBlock("fracturn", new TerrainPlantBlock(END_MOSS));
    public static final Block CLAWFERN = registerBlock(
            "clawfern",
            new TerrainPlantBlock(
                    SANGNUM,
                    MOSSY_OBSIDIAN,
                    MOSSY_DRAGON_BONE
            )
    );
    public static final Block GLOBULAGUS = registerBlock(
            "globulagus",
            new TerrainPlantBlock(
                    SANGNUM,
                    MOSSY_OBSIDIAN,
                    MOSSY_DRAGON_BONE
            )
    );
    public static final Block ORANGO = registerBlock("orango", new TerrainPlantBlock(RUTISCUS));
    public static final Block AERIDIUM = registerBlock("aeridium", new TerrainPlantBlock(RUTISCUS));
    public static final Block LUTEBUS = registerBlock("lutebus", new TerrainPlantBlock(RUTISCUS));
    public static final Block LAMELLARIUM = registerBlock("lamellarium", new TerrainPlantBlock(RUTISCUS));
    public static final Block INFLEXIA = registerBlock(
            "inflexia",
            new TerrainPlantBlock(
                    PALLIDIUM_FULL,
                    PALLIDIUM_HEAVY,
                    PALLIDIUM_THIN,
                    PALLIDIUM_TINY
            )
    );
    public static final Block FLAMMALIX = registerBlock("flammalix", new FlammalixBlock());


    public static final MultifaceBlock CRYSTAL_MOSS_COVER = registerBlock(
            "crystal_moss_cover",
            new CrystalMossCoverBlock(MapColor.COLOR_PINK)
    );

    public static final Block BLUE_VINE_SEED = registerBlock("blue_vine_seed", new BlueVineSeedBlock());
    public static final Block BLUE_VINE = registerEndBlockOnly("blue_vine", new BlueVineBlock());
    public static final Block BLUE_VINE_LANTERN = registerBlock("blue_vine_lantern", new BlueVineLanternBlock());
    public static final Block BLUE_VINE_FUR = registerBlock(
            "blue_vine_fur",
            new FurBlock(MapColor.COLOR_BLUE, BLUE_VINE_SEED, 15, 3, false)
    );

    public static final Block LANCELEAF_SEED = registerBlock("lanceleaf_seed", new LanceleafSeedBlock());
    public static final Block LANCELEAF = registerEndBlockOnly("lanceleaf", new LanceleafBlock());

    public static final Block GLOWING_PILLAR_SEED = registerBlock("glowing_pillar_seed", new GlowingPillarSeedBlock());
    public static final Block GLOWING_PILLAR_ROOTS = registerEndBlockOnly(
            "glowing_pillar_roots",
            new GlowingPillarRootsBlock()
    );
    public static final Block GLOWING_PILLAR_LUMINOPHOR = registerBlock(
            "glowing_pillar_luminophor",
            new GlowingPillarLuminophorBlock()
    );
    public static final Block GLOWING_PILLAR_LEAVES = registerBlock(
            "glowing_pillar_leaves",
            new FurBlock(MapColor.COLOR_ORANGE, GLOWING_PILLAR_SEED, 15, 3, false)
    );

    public static final Block SMALL_JELLYSHROOM = registerBlock("small_jellyshroom", new SmallJellyshroomBlock());
    public static final Block BOLUX_MUSHROOM = registerBlock("bolux_mushroom", new BoluxMushroomBlock());

    public static final Block LUMECORN_SEED = registerBlock("lumecorn_seed", new LumecornSeedBlock());
    public static final Block LUMECORN = registerEndBlockOnly("lumecorn", new LumecornBlock());

    public static final Block SMALL_AMARANITA_MUSHROOM = registerBlock(
            "small_amaranita_mushroom",
            new SmallAmaranitaBlock()
    );
    public static final Block LARGE_AMARANITA_MUSHROOM = registerEndBlockOnly(
            "large_amaranita_mushroom",
            new LargeAmaranitaBlock()
    );
    public static final Block AMARANITA_STEM = registerBlock("amaranita_stem", new AmaranitaStemBlock());
    public static final Block AMARANITA_HYPHAE = registerBlock("amaranita_hyphae", new AmaranitaStemBlock());
    public static final Block AMARANITA_HYMENOPHORE = registerBlock(
            "amaranita_hymenophore",
            new AmaranitaHymenophoreBlock()
    );
    public static final Block AMARANITA_LANTERN = registerBlock("amaranita_lantern", new GlowingHymenophoreBlock());
    public static final Block AMARANITA_FUR = registerBlock(
            "amaranita_fur",
            new FurBlock(MapColor.COLOR_CYAN, SMALL_AMARANITA_MUSHROOM, 15, 4, true)
    );
    public static final Block AMARANITA_CAP = registerBlock("amaranita_cap", new AmaranitaCapBlock());

    public static final Block NEON_CACTUS = registerBlock("neon_cactus", new NeonCactusPlantBlock());
    public static final Block NEON_CACTUS_BLOCK = registerBlock("neon_cactus_block", new NeonCactusBlock());
    public static final Block NEON_CACTUS_BLOCK_STAIRS = defineEndBlock("neon_cactus_stairs")
            .addTrait(BlockTraits.STAIR_BLOCK)
            .addTrait(ModelTraitLibrary.stairs(() -> NEON_CACTUS_BLOCK))
            .addTrait(RecipeTraitLibrary.stairs(RecipeMaterial.of(NEON_CACTUS_BLOCK)))
            .buildAndRegister();
    public static final Block NEON_CACTUS_BLOCK_SLAB = defineEndBlock("neon_cactus_slab")
            .addTrait(BlockTraits.SLAB_BLOCK)
            .addTrait(ModelTraitLibrary.slab(() -> NEON_CACTUS_BLOCK))
            .addTrait(RecipeTraitLibrary.slab(RecipeMaterial.of(NEON_CACTUS_BLOCK)))
            .buildAndRegister();
    ;

    // Crops
    public static final Block SHADOW_BERRY = registerBlock("shadow_berry", new ShadowBerryBlock());
    public static final Block BLOSSOM_BERRY = registerBlock(
            "blossom_berry_seed",
            new PottableCropBlock(EndItems.BLOSSOM_BERRY, PINK_MOSS)
    );
    public static final Block AMBER_ROOT = registerBlock(
            "amber_root_seed",
            new PottableCropBlock(EndItems.AMBER_ROOT_RAW, AMBER_MOSS)
    );
    public static final Block CHORUS_MUSHROOM = registerBlock(
            "chorus_mushroom_seed",
            new PottableCropBlock(
                    EndItems.CHORUS_MUSHROOM_RAW,
                    CHORUS_NYLIUM
            )
    );
    //public static final Block PEARLBERRY = registerBlock("pearlberry_seed", new PottableCropBlock(EndItems.BLOSSOM_BERRY, END_MOSS, END_MYCELIUM));
    public static final Block CAVE_PUMPKIN_SEED = registerBlock("cave_pumpkin_seed", new CavePumpkinVineBlock());
    public static final Block CAVE_PUMPKIN = registerBlock("cave_pumpkin", new CavePumpkinBlock());

    // Water plants
    public static final Block BUBBLE_CORAL = registerBlock("bubble_coral", new BubbleCoralBlock());
    public static final Block MENGER_SPONGE = registerBlock("menger_sponge", new MengerSpongeBlock());
    public static final Block MENGER_SPONGE_WET = registerBlock("menger_sponge_wet", new MengerSpongeWetBlock());
    public static final Block CHARNIA_RED = registerBlock("charnia_red", new CharniaBlock());
    public static final Block CHARNIA_PURPLE = registerBlock("charnia_purple", new CharniaBlock());
    public static final Block CHARNIA_ORANGE = registerBlock("charnia_orange", new CharniaBlock());
    public static final Block CHARNIA_LIGHT_BLUE = registerBlock("charnia_light_blue", new CharniaBlock());
    public static final Block CHARNIA_CYAN = registerBlock("charnia_cyan", new CharniaBlock());
    public static final Block CHARNIA_GREEN = registerBlock("charnia_green", new CharniaBlock());

    public static final Block END_LILY = registerEndBlockOnly("end_lily", new EndLilyBlock());
    public static final Block END_LILY_SEED = registerBlock("end_lily_seed", new EndLilySeedBlock());

    public static final Block HYDRALUX_SAPLING = registerBlock("hydralux_sapling", new HydraluxSaplingBlock());
    public static final Block HYDRALUX = registerEndBlockOnly("hydralux", new HydraluxBlock());
    public static final Block HYDRALUX_PETAL_BLOCK = registerBlock("hydralux_petal_block", new HydraluxPetalBlock());
    public static final ColoredMaterial HYDRALUX_PETAL_BLOCK_COLORED = new ColoredMaterial(
            HydraluxPetalColoredBlock::new,
            HYDRALUX_PETAL_BLOCK,
            true
    );

    public static final Block POND_ANEMONE = registerBlock("pond_anemone", new PondAnemoneBlock());

    public static final Block FLAMAEA = registerBlock("flamaea", new FlamaeaBlock());

    public static final Block CAVE_BUSH = registerBlock(
            "cave_bush",
            new SimpleLeavesBlock(MapColor.COLOR_MAGENTA)
    );

    public static final Block MURKWEED = registerBlock("murkweed", new MurkweedBlock());
    public static final Block NEEDLEGRASS = registerBlock("needlegrass", new NeedlegrassBlock());

    // Wall Plants //
    public static final Block PURPLE_POLYPORE = registerBlock("purple_polypore", new EndWallMushroom(13));
    public static final Block AURANT_POLYPORE = registerBlock("aurant_polypore", new EndWallMushroom(13));
    public static final Block TAIL_MOSS = registerBlock("tail_moss", new EndWallPlantBlock(MapColor.COLOR_BLACK));
    public static final Block CYAN_MOSS = registerBlock("cyan_moss", new EndWallPlantBlock(MapColor.COLOR_CYAN));
    public static final Block TWISTED_MOSS = registerBlock(
            "twisted_moss",
            new EndWallPlantBlock(MapColor.COLOR_LIGHT_BLUE)
    );
    public static final Block TUBE_WORM = registerBlock(
            "tube_worm",
            new EndUnderwaterWallPlantBlock(MapColor.TERRACOTTA_BROWN)
    );
    public static final Block BULB_MOSS = registerBlock(
            "bulb_moss",
            new EndWallPlantBlock(MapColor.TERRACOTTA_ORANGE, 12)
    );
    public static final Block JUNGLE_FERN = registerBlock("jungle_fern", new EndWallPlantBlock(MapColor.COLOR_GREEN));
    public static final Block RUSCUS = registerBlock("ruscus", new EndWallPlantBlock(MapColor.COLOR_RED));

    // Vines //
    public static final Block DENSE_VINE = registerBlock("dense_vine", new BaseVineBlock(15, true));
    public static final Block TWISTED_VINE = registerBlock("twisted_vine", new BaseVineBlock());
    public static final Block BULB_VINE_SEED = registerBlock("bulb_vine_seed", new BulbVineSeedBlock());
    public static final Block BULB_VINE = registerBlock("bulb_vine", new BulbVineBlock());
    public static final Block JUNGLE_VINE = registerBlock("jungle_vine", new BaseVineBlock());
    public static final Block RUBINEA = registerBlock("rubinea", new BaseVineBlock());
    public static final Block MAGNULA = registerBlock("magnula", new BaseVineBlock());
    public static final Block FILALUX = registerBlock("filalux", new FilaluxBlock());
    public static final Block FILALUX_WINGS = registerBlock("filalux_wings", new FilaluxWingsBlock());
    public static final Block FILALUX_LANTERN = registerBlock("filalux_lantern", new FilaluxLanternBlock());

    // Mob-Related
    public static final Block SILK_MOTH_NEST = registerBlock("silk_moth_nest", new SilkMothNestBlock());
    public static final Block SILK_MOTH_HIVE = registerBlock("silk_moth_hive", new SilkMothHiveBlock());

    // Ores //
    public static final Block ENDER_ORE = registerBlock(
            "ender_ore",
            new BaseOreBlock(() -> EndItems.ENDER_SHARD, 1, 3, 5)
    );
    public static final Block AMBER_ORE = registerBlock(
            "amber_ore",
            new BaseOreBlock(() -> EndItems.RAW_AMBER, 1, 2, 4)
    );

    // Materials //
    public static final MetalMaterial THALLASIUM = MetalMaterial.makeNormal(
            "thallasium",
            MapColor.COLOR_BLUE,
            EndToolTier.THALLASIUM,
            EndArmorTier.THALLASIUM,
            EndTags.ANVIL_IRON_TOOL,
            EndTemplates.THALLASIUM_UPGRADE
    );

    public static final MetalMaterial TERMINITE = MetalMaterial.makeOreless(
            "terminite",
            MapColor.WARPED_WART_BLOCK,
            7F,
            9F,
            EndToolTier.TERMINITE,
            EndArmorTier.TERMINITE,
            EndTags.ANVIL_DIAMOND_TOOL,
            EndTemplates.TERMINITE_UPGRADE
    );
    public static final Block AETERNIUM_BLOCK = registerBlock("aeternium_block", new AeterniumBlock());
    public static final Block CHARCOAL_BLOCK = registerBlock("charcoal_block", new CharcoalBlock());

    public static final Block ENDER_BLOCK = registerBlock("ender_block", new EnderBlock());
    public static final Block AURORA_CRYSTAL = registerBlock("aurora_crystal", new AuroraCrystalBlock());
    public static final Block AMBER_BLOCK = registerBlock("amber_block", new AmberBlock());
    public static final Block SMARAGDANT_CRYSTAL_SHARD = registerBlock(
            "smaragdant_crystal_shard",
            new SmaragdantCrystalShardBlock()
    );
    public static final Block SMARAGDANT_CRYSTAL = registerBlock("smaragdant_crystal", new SmaragdantCrystalBlock());
    public static final CrystalSubblocksMaterial SMARAGDANT_SUBBLOCKS = new CrystalSubblocksMaterial(
            "smaragdant_crystal",
            SMARAGDANT_CRYSTAL
    );
    public static final Block BUDDING_SMARAGDANT_CRYSTAL = registerBlock(
            "budding_smaragdant_crystal",
            new BuddingSmaragdantCrystalBlock(),
            CommonBlockTags.BUDDING_BLOCKS
    );

    public static final Block RESPAWN_OBELISK = registerBlock("respawn_obelisk", new RespawnObeliskBlock());

    // Lanterns
    public static final ColoredMaterial IRON_BULB_LANTERN_COLORED = new ColoredMaterial(
            BulbVineLanternColoredBlock::new,
            IRON_SET.getBlock(MetalMaterial.BULB_LANTERN),
            false
    );


    // Blocks With Entity //
    public static final Block END_STONE_SMELTER = registerBlock("end_stone_smelter", new EndStoneSmelter());
    public static final Block ETERNAL_PEDESTAL = registerBlock("eternal_pedestal", new EternalPedestal());
    public static final Block INFUSION_PEDESTAL = registerBlock("infusion_pedestal", new InfusionPedestal());
    public static final Block AETERNIUM_ANVIL = registerBlock("aeternium_anvil", new AeterniumAnvil());

    // Technical
    public static final Block END_PORTAL_BLOCK = registerEndBlockOnly("end_portal_block", new EndPortalBlock());

    // Variations
    public static final VanillaVariantStoneMaterial END_STONE_BRICK_VARIATIONS = new VanillaVariantStoneMaterial(
            "end_stone_brick",
            Blocks.END_STONE_BRICKS,
            MapColor.SAND
    ).init();

    public static final Block END_STONE_SLAB = defineEndBlock("end_stone_slab")
            .addTrait(BlockTraits.SLAB_BLOCK)
            .addTrait(ModelTraitLibrary.slab(() -> Blocks.END_STONE))
            .addTrait(RecipeTraitLibrary.slab(RecipeMaterial.of(Blocks.END_STONE)))
            .buildAndRegister();

    public static final Block END_STONE_STAIR = defineEndBlock("end_stone_stairs")
            .addTrait(BlockTraits.STAIR_BLOCK)
            .addTrait(ModelTraitLibrary.stairs(() -> Blocks.END_STONE))
            .addTrait(RecipeTraitLibrary.stairs(RecipeMaterial.of(Blocks.END_STONE)))
            .buildAndRegister();

    public static final Block END_STONE_WALLS = defineEndBlock("end_stone_wall")
            .addTrait(BlockTraits.WALL_BLOCK)
            .addTrait(ModelTraitLibrary.wall(() -> Blocks.END_STONE))
            .addTrait(RecipeTraitLibrary.wall(RecipeMaterial.of(Blocks.END_STONE)))
            .buildAndRegister();


    public static List<Block> getModBlocks() {
        return getBlockRegistry().allBlocks().toList();
    }

    @SafeVarargs
    public static <T extends Block> T registerBlock(
            String name,
            Function<BlockBehaviour.Properties, T> blockF,
            TagKey<Block>... tags
    ) {
        return defineBlock(name, blockF)
                .addTags(tags)
                .buildAndRegister();
    }

    @SafeVarargs
    public static EndTerrainBlock registerEndTerrain(
            String name,
            MapColor color,
            TagKey<Block>... tags
    ) {
        return registerEndTerrain(name, color, EndTerrainBlock::new, tags);
    }

    @SafeVarargs
    public static <T extends Block> T registerEndTerrain(
            String name,
            MapColor color,
            Function<BlockBehaviour.Properties, T> blockF,
            TagKey<Block>... tags
    ) {
        return (T) defineBlock(name, EndstoneDustBlock::new)
                .mapColor(color)
                .addTrait(TerrainBlockTrait.DEFAULT)
                .addTags(tags)
                .buildAndRegister();
    }

    public static Block registerPath(
            String name,
            Block source
    ) {
        return defineBlock(name, DirtPathBlock::new)
                .replacePropertiesWithCopy(source)
                .addTrait(PathBlockTrait.withSource(source))
                .buildAndRegister();
    }


    public static <T extends Block> DefaultBlockDefinition<T> defineBlock(
            String name,
            Function<BlockBehaviour.Properties, T> blockF
    ) {
        return getBlockRegistry()
                .defineDefaultBlock(name, def -> blockF.apply(def.getProperties()));
    }

    public static VanillaBlockDefinition defineEndBlock(String name) {
        return getBlockRegistry()
                .defineDefaultBlock(name);
    }

    public static <T extends Block> DefaultBlockDefinition<T> defineBlockOnly(
            String name,
            Function<BlockBehaviour.Properties, T> blockF
    ) {
        return defineBlock(name, blockF).withBlockItem((def, block) -> null);
    }

    public static Block registerEndBlockOnly(String name, Function<BlockBehaviour.Properties, Block> blockF) {
        return defineBlockOnly(name, blockF)
                .buildAndRegister();
    }

    @NotNull
    public static BlockRegistry getBlockRegistry() {
        if (BLOCKS_REGISTRY == null) {
            BLOCKS_REGISTRY = BlockRegistry.forMod(BetterEnd.C);
        }
        return BLOCKS_REGISTRY;
    }

    @ApiStatus.Internal
    public static void ensureStaticallyLoaded() {

    }
}
