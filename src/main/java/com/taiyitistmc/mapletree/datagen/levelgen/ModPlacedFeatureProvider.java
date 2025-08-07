package com.taiyitistmc.mapletree.datagen.levelgen;

import com.google.common.collect.ImmutableList;
import com.taiyitistmc.mapletree.common.init.ModBlocks;
import com.taiyitistmc.mapletree.common.util.Helpers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;

import java.util.List;

public class ModPlacedFeatureProvider {

    private static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

    public static final ResourceKey<PlacedFeature> RED_MAPLE_TREE_PLACED =
            register("red_maple_tree_placed");
    public static final ResourceKey<PlacedFeature> YELLOW_MAPLE_TREE_PLACED =
            register("yellow_maple_tree_placed");
    public static final ResourceKey<PlacedFeature> ORANGE_MAPLE_TREE_PLACED =
            register("orange_maple_tree_placed");
    public static final ResourceKey<PlacedFeature> LIME_MAPLE_TREE_PLACED =
            register("lime_maple_tree_placed");
    public static final ResourceKey<PlacedFeature> RED_MAPLE_TREE_PLACED_MOUNTAIN =
            register("red_maple_tree_placed_mountain");
    public static final ResourceKey<PlacedFeature> YELLOW_MAPLE_TREE_PLACED_MOUNTAIN =
            register("yellow_maple_tree_placed_mountain");
    public static final ResourceKey<PlacedFeature> ORANGE_MAPLE_TREE_PLACED_MOUNTAIN =
            register("orange_maple_tree_placed_mountain");
    public static final ResourceKey<PlacedFeature> LIME_MAPLE_TREE_PLACED_MOUNTAIN =
            register("lime_maple_tree_placed_mountain");

    public static void placedFeature(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        PlacementModifier placementmodifier = SurfaceWaterDepthFilter.forMaxDepth(0);
        Holder<ConfiguredFeature<?, ?>> red_maple_tree_holder =
                holderGetter.getOrThrow(ModConfiguredFeatureProvider.RED_MAPLE_TREE);
        Holder<ConfiguredFeature<?, ?>> yellow_maple_tree_holder =
                holderGetter.getOrThrow(ModConfiguredFeatureProvider.YELLOW_MAPLE_TREE);
        Holder<ConfiguredFeature<?, ?>> orange_maple_tree_holder =
                holderGetter.getOrThrow(ModConfiguredFeatureProvider.ORANGE_MAPLE_TREE);
        Holder<ConfiguredFeature<?, ?>> lime_maple_tree_holder =
                holderGetter.getOrThrow(ModConfiguredFeatureProvider.LIME_MAPLE_TREE);
        Holder<ConfiguredFeature<?, ?>> red_maple_tree_holder_mountain =
                holderGetter.getOrThrow(ModConfiguredFeatureProvider.RED_MAPLE_TREE_MOUNTAIN);
        Holder<ConfiguredFeature<?, ?>> yellow_maple_tree_holder_mountain =
                holderGetter.getOrThrow(ModConfiguredFeatureProvider.YELLOW_MAPLE_TREE_MOUNTAIN);
        Holder<ConfiguredFeature<?, ?>> orange_maple_tree_holder_mountain =
                holderGetter.getOrThrow(ModConfiguredFeatureProvider.ORANGE_MAPLE_TREE_MOUNTAIN);
        Holder<ConfiguredFeature<?, ?>> lime_maple_tree_holder_mountain =
                holderGetter.getOrThrow(ModConfiguredFeatureProvider.LIME_MAPLE_TREE_MOUNTAIN);
        PlacementUtils.register(context, RED_MAPLE_TREE_PLACED, red_maple_tree_holder, PlacementUtils.countExtra(5, 0.1F, 1), InSquarePlacement.spread(), placementmodifier, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(ModBlocks.RED_MAPLE_TREE_SAPLING.get().defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome());
        PlacementUtils.register(context, YELLOW_MAPLE_TREE_PLACED, yellow_maple_tree_holder, treePlacement(placementmodifier, ModBlocks.YELLOW_MAPLE_TREE_SAPLING.get()));
        PlacementUtils.register(context, ORANGE_MAPLE_TREE_PLACED, orange_maple_tree_holder, treePlacement(placementmodifier, ModBlocks.ORANGE_MAPLE_TREE_SAPLING.get()));
        PlacementUtils.register(context, LIME_MAPLE_TREE_PLACED, lime_maple_tree_holder, treePlacement(placementmodifier, ModBlocks.LIME_MAPLE_TREE_SAPLING.get()));
        PlacementUtils.register(context, RED_MAPLE_TREE_PLACED_MOUNTAIN, red_maple_tree_holder_mountain, treePlacement(placementmodifier, ModBlocks.RED_MAPLE_TREE_SAPLING.get()));
        PlacementUtils.register(context, YELLOW_MAPLE_TREE_PLACED_MOUNTAIN, yellow_maple_tree_holder_mountain,  treePlacement(placementmodifier, ModBlocks.YELLOW_MAPLE_TREE_SAPLING.get()));
        PlacementUtils.register(context, ORANGE_MAPLE_TREE_PLACED_MOUNTAIN, orange_maple_tree_holder_mountain,  treePlacement(placementmodifier, ModBlocks.ORANGE_MAPLE_TREE_SAPLING.get()));
        PlacementUtils.register(context, LIME_MAPLE_TREE_PLACED_MOUNTAIN, lime_maple_tree_holder_mountain, treePlacement(placementmodifier, ModBlocks.LIME_MAPLE_TREE_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> register(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Helpers.identifier(name));
    }

    public static List<PlacementModifier> treePlacement(PlacementModifier placement, Block saplingBlock) {
        return ((ImmutableList.Builder<PlacementModifier>) (Object) treePlacementBase(placement)).add(BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(saplingBlock.defaultBlockState(), BlockPos.ZERO))).build();
    }

    private static ImmutableList.Builder<?> treePlacementBase(PlacementModifier placement) {
        return ImmutableList.builder().add(placement).add(InSquarePlacement.spread()).add(TREE_THRESHOLD).add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR).add(BiomeFilter.biome());
    }
}
