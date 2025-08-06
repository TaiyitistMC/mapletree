package com.taiyitistmc.mapletree.datagen;

import com.taiyitistmc.mapletree.MapleTree;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@SuppressWarnings("removal")
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = MapleTree.MODID)
public class ModDataGenerator {

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
    }
}
