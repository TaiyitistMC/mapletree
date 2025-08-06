package com.taiyitistmc.mapletree.common.util;

import com.taiyitistmc.mapletree.MapleTree;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

public class Helpers {

    public static ResourceLocation identifier(String name) {
        return ResourceLocation.fromNamespaceAndPath(MapleTree.MODID, name);
    }

    public static String getItemName(ItemLike itemLike) {
        return BuiltInRegistries.ITEM.getKey(itemLike.asItem()).getPath();
    }
}
