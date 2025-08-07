package com.taiyitistmc.mapletree;

import com.taiyitistmc.mapletree.common.init.ModBlocks;
import com.taiyitistmc.mapletree.common.init.ModCreativeModeTabs;
import com.taiyitistmc.mapletree.common.init.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(MapleTree.MODID)
public class MapleTree {

    public static final String MODID = "mapletree";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MapleTree(IEventBus modEventBus, ModContainer modContainer) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);
    }
}
