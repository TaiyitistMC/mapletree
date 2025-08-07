package com.taiyitistmc.mapletree.datagen.levelgen;

import com.taiyitistmc.mapletree.common.init.ModBlocks;
import com.taiyitistmc.mapletree.common.util.Helpers;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ModConfiguredFeatureProvider {

    public static final ResourceKey<ConfiguredFeature<?,?>> RED_MAPLE_TREE =
            register("red_maple_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> YELLOW_MAPLE_TREE =
            register("yellow_maple_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> ORANGE_MAPLE_TREE =
            register("orange_maple_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> LIME_MAPLE_TREE =
            register("lime_maple_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> RED_MAPLE_TREE_MOUNTAIN =
            register("red_maple_tree_mountain");
    public static final ResourceKey<ConfiguredFeature<?,?>> YELLOW_MAPLE_TREE_MOUNTAIN =
            register("yellow_maple_tree_mountain");
    public static final ResourceKey<ConfiguredFeature<?,?>> ORANGE_MAPLE_TREE_MOUNTAIN =
            register("orange_maple_tree_mountain");
    public static final ResourceKey<ConfiguredFeature<?,?>> LIME_MAPLE_TREE_MOUNTAIN =
            register("lime_maple_tree_mountain");

    public static void configuredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, RED_MAPLE_TREE, Feature.TREE, createMapleTree(ModBlocks.RED_MAPLE_TREE_LEAVES.get()).build());
        FeatureUtils.register(context, YELLOW_MAPLE_TREE, Feature.TREE, createMapleTree(ModBlocks.YELLOW_MAPLE_TREE_LEAVES.get()).build());
        FeatureUtils.register(context, ORANGE_MAPLE_TREE, Feature.TREE, createMapleTree(ModBlocks.ORANGE_MAPLE_TREE_LEAVES.get()).build());
        FeatureUtils.register(context, LIME_MAPLE_TREE, Feature.TREE, createMapleTree(ModBlocks.LIME_MAPLE_TREE_LEAVES.get()).build());
        FeatureUtils.register(context, RED_MAPLE_TREE_MOUNTAIN, Feature.TREE, createMapleTree(ModBlocks.RED_MAPLE_TREE_LEAVES.get()).build());
        FeatureUtils.register(context, YELLOW_MAPLE_TREE_MOUNTAIN, Feature.TREE, createMapleTree(ModBlocks.YELLOW_MAPLE_TREE_LEAVES.get()).build());
        FeatureUtils.register(context, ORANGE_MAPLE_TREE_MOUNTAIN, Feature.TREE, createMapleTree(ModBlocks.ORANGE_MAPLE_TREE_LEAVES.get()).build());
        FeatureUtils.register(context, LIME_MAPLE_TREE_MOUNTAIN, Feature.TREE, createMapleTree(ModBlocks.LIME_MAPLE_TREE_LEAVES.get()).build());
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> register(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Helpers.identifier(name));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createMapleTree(Block leavesBlock) {
        return createStraightBlobTree(ModBlocks.MAPLE_TREE_LOG.get(), leavesBlock, 5, 2, 0, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block logBlock, Block leavesBlock, int baseHeight, int heightRandA, int heightRandB, int radius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(logBlock), new StraightTrunkPlacer(baseHeight, heightRandA, heightRandB), BlockStateProvider.simple(leavesBlock), new BlobFoliagePlacer(ConstantInt.of(radius), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }
}
