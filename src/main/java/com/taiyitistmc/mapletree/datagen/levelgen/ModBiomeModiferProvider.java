package com.taiyitistmc.mapletree.datagen.levelgen;

import com.taiyitistmc.mapletree.common.util.Helpers;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModiferProvider {

    public static final ResourceKey<BiomeModifier> ADD_RED_MAPLE_TREE =
            register("add_red_maple_tree");
    public static final ResourceKey<BiomeModifier> ADD_RED_MAPLE_TREES =
            register("add_red_maple_trees");
    public static final ResourceKey<BiomeModifier> ADD_YELLOW_MAPLE_TREE =
            register("add_yellow_maple_tree");
    public static final ResourceKey<BiomeModifier> ADD_YELLOW_MAPLE_TREES =
            register("add_yellow_maple_trees");
    public static final ResourceKey<BiomeModifier> ADD_ORANGE_MAPLE_TREE =
            register("add_orange_maple_tree");
    public static final ResourceKey<BiomeModifier> ADD_ORANGE_MAPLE_TREES =
            register("add_orange_maple_trees");
    public static final ResourceKey<BiomeModifier> ADD_LIME_MAPLE_TREE =
            register("add_lime_maple_tree");
    public static final ResourceKey<BiomeModifier> ADD_LIME_MAPLE_TREES =
            register("add_lime_maple_trees");
    public static final ResourceKey<BiomeModifier> ADD_RED_MAPLE_TREE_MOUNTAIN =
            register("add_red_maple_tree_mountain");
    public static final ResourceKey<BiomeModifier> ADD_RED_MAPLE_TREES_MOUNTAIN =
            register("add_red_maple_trees_mountain");
    public static final ResourceKey<BiomeModifier> ADD_YELLOW_MAPLE_TREE_MOUNTAIN =
            register("add_yellow_maple_tree_mountain");
    public static final ResourceKey<BiomeModifier> ADD_YELLOW_MAPLE_TREES_MOUNTAIN =
            register("add_yellow_maple_trees_mountain");
    public static final ResourceKey<BiomeModifier> ADD_ORANGE_MAPLE_TREE_MOUNTAIN =
            register("add_orange_maple_tree_mountain");
    public static final ResourceKey<BiomeModifier> ADD_ORANGE_MAPLE_TREES_MOUNTAIN =
            register("add_orange_maple_trees_mountain");
    public static final ResourceKey<BiomeModifier> ADD_LIME_MAPLE_TREE_MOUNTAIN =
            register("add_lime_maple_tree_mountain");
    public static final ResourceKey<BiomeModifier> ADD_LIME_MAPLE_TREES_MOUNTAIN =
            register("add_lime_maple_trees_mountain");

    public static void addBiomeModifiers(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> features = context.lookup(Registries.PLACED_FEATURE);
        context.register(ADD_RED_MAPLE_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_FOREST),
                HolderSet.direct(features.getOrThrow(ModPlacedFeatureProvider.RED_MAPLE_TREE_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_YELLOW_MAPLE_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_FOREST),
                HolderSet.direct(features.getOrThrow(ModPlacedFeatureProvider.YELLOW_MAPLE_TREE_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_ORANGE_MAPLE_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_FOREST),
                HolderSet.direct(features.getOrThrow(ModPlacedFeatureProvider.ORANGE_MAPLE_TREE_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_LIME_MAPLE_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_FOREST),
                HolderSet.direct(features.getOrThrow(ModPlacedFeatureProvider.LIME_MAPLE_TREE_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_RED_MAPLE_TREE_MOUNTAIN, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MOUNTAIN),
                HolderSet.direct(features.getOrThrow(ModPlacedFeatureProvider.RED_MAPLE_TREE_PLACED_MOUNTAIN)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_YELLOW_MAPLE_TREE_MOUNTAIN, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MOUNTAIN),
                HolderSet.direct(features.getOrThrow(ModPlacedFeatureProvider.YELLOW_MAPLE_TREE_PLACED_MOUNTAIN)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_ORANGE_MAPLE_TREE_MOUNTAIN, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MOUNTAIN),
                HolderSet.direct(features.getOrThrow(ModPlacedFeatureProvider.ORANGE_MAPLE_TREE_PLACED_MOUNTAIN)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_LIME_MAPLE_TREE_MOUNTAIN, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MOUNTAIN),
                HolderSet.direct(features.getOrThrow(ModPlacedFeatureProvider.LIME_MAPLE_TREE_PLACED_MOUNTAIN)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> register(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Helpers.identifier(name));
    }
}
