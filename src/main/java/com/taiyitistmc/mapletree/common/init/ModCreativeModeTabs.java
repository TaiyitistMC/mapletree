package com.taiyitistmc.mapletree.common.init;

import com.taiyitistmc.mapletree.MapleTree;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MapleTree.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAPLE_TREE = CREATIVE_MODE_TABS.register("maple_tree", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.maple_tree")).withTabsBefore(CreativeModeTabs.COMBAT).icon(
            () -> ModBlocks.RED_MAPLE_TREE_LEAVES.get().asItem().getDefaultInstance()).displayItems((parameters, output) -> {
                ModBlocks.BLOCKS.getEntries().forEach(blockDeferredHolder -> {
                    output.accept(blockDeferredHolder.get());
                });
    }).build());
}
