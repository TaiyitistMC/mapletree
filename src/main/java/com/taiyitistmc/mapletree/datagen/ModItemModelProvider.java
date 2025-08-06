package com.taiyitistmc.mapletree.datagen;

import com.taiyitistmc.mapletree.MapleTree;
import com.taiyitistmc.mapletree.common.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;


public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MapleTree.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModItems.ITEMS.getEntries().forEach(itemDeferredHolder -> {
            boolean isBlockItem =
                    itemDeferredHolder.get() instanceof BlockItem;
            if (isBlockItem) {
                simpleBlockItem(Block.byItem(itemDeferredHolder.get()));
            } else {
                basicItem(itemDeferredHolder.get());
            }
        });
    }
}
