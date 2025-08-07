package com.taiyitistmc.mapletree.datagen;

import com.taiyitistmc.mapletree.MapleTree;
import com.taiyitistmc.mapletree.common.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProviderJa extends LanguageProvider {

    public ModLanguageProviderJa(PackOutput output) {
        super(output, MapleTree.MODID, "ja_jp");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.maple_tree", "モミジ・農業");
        add(ModBlocks.MAPLE_TREE_LOG.get(), "モミジ原木");
        add(ModBlocks.RED_MAPLE_TREE_LEAVES.get(), "モミジ葉[赤]");
        add(ModBlocks.YELLOW_MAPLE_TREE_LEAVES.get(), "モミジ葉[黄]");
        add(ModBlocks.ORANGE_MAPLE_TREE_LEAVES.get(), "モミジ葉[橙]");
        add(ModBlocks.LIME_MAPLE_TREE_LEAVES.get(), "モミジ葉[黄緑]");
        add(ModBlocks.RED_MAPLE_TREE_SAPLING.get(), "モミジ苗木[赤]");
        add(ModBlocks.YELLOW_MAPLE_TREE_SAPLING.get(), "モミジ苗木[黄]");
        add(ModBlocks.ORANGE_MAPLE_TREE_SAPLING.get(), "モミジ苗木[橙]");
        add(ModBlocks.LIME_MAPLE_TREE_SAPLING.get(), "モミジ苗木[黄緑]");
    }
}
