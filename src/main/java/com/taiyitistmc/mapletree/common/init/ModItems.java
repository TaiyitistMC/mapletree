package com.taiyitistmc.mapletree.common.init;

import com.taiyitistmc.mapletree.MapleTree;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MapleTree.MODID);

    /*
    public static final DeferredItem<Item> EGGPLANT_SEEDS =
            ITEMS.registerItem("eggplant_seeds",
                    properties -> new ItemNameBlockItem(ModBlocks.EGGPLANT_CROP.get(), new Item.Properties()));*/

    public static DeferredItem<Item> registerFood(String name, FoodProperties food) {
        return registerSimpleItem(name, new Item.Properties().food(food));
    }

    public static DeferredItem<Item> registerSimpleItem(String name, Item.Properties properties) {
        return ITEMS.registerItem(name, item -> new Item(properties));
    }
}
