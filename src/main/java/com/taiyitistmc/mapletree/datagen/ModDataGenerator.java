package com.taiyitistmc.mapletree.datagen;

import com.taiyitistmc.mapletree.MapleTree;
import com.taiyitistmc.mapletree.datagen.levelgen.ModBiomeModiferProvider;
import com.taiyitistmc.mapletree.datagen.levelgen.ModConfiguredFeatureProvider;
import com.taiyitistmc.mapletree.datagen.levelgen.ModPlacedFeatureProvider;
import com.taiyitistmc.mapletree.datagen.loot.ModLootTableProvider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;

@SuppressWarnings("removal")
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = MapleTree.MODID)
public class ModDataGenerator {


    public static RegistrySetBuilder BUILDER =
            new RegistrySetBuilder()
                    .add(Registries.PLACED_FEATURE,
                            ModPlacedFeatureProvider::placedFeature)
                    .add(Registries.CONFIGURED_FEATURE,
                            ModConfiguredFeatureProvider::configuredFeatures)
                    .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS,
                            ModBiomeModiferProvider::addBiomeModifiers);

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        var gen = event.getGenerator();
        var pack = gen.getPackOutput();
        var helper = event.getExistingFileHelper();
        var lookup = event.getLookupProvider();
        event.addProvider(new ModBlockStateProvider(pack, helper));
        event.addProvider(new ModItemModelProvider(pack, helper));
        event.addProvider(new ModLanguageProviderEn(pack));
        event.addProvider(new ModLanguageProviderZh(pack));
        event.addProvider(new ModLanguageProviderJa(pack));
        event.addProvider(new DatapackBuiltinEntriesProvider(pack,
                lookup, BUILDER,
                Set.of(MapleTree.MODID)));
        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(pack, lookup, helper);
        event.addProvider(blockTagsProvider);
        event.addProvider(new ModItemTagsProvider(pack, lookup, blockTagsProvider.contentsGetter(), helper));
        event.addProvider(new ModLootTableProvider(pack, lookup));
    }
}
