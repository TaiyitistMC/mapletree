package com.taiyitistmc.mapletree.datagen;

import com.taiyitistmc.mapletree.MapleTree;
import com.taiyitistmc.mapletree.common.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProviderZh extends LanguageProvider {

    public ModLanguageProviderZh(PackOutput output) {
        super(output, MapleTree.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.maple_tree", "枫树-农业");
        add(ModBlocks.MAPLE_TREE_LOG.get(), "枫树原木");
        add(ModBlocks.RED_MAPLE_TREE_LEAVES.get(), "枫叶（红）");
        add(ModBlocks.YELLOW_MAPLE_TREE_LEAVES.get(), "枫叶（黄）");
        add(ModBlocks.ORANGE_MAPLE_TREE_LEAVES.get(), "枫叶（橙）");
        add(ModBlocks.LIME_MAPLE_TREE_LEAVES.get(), "枫叶（黄绿）");
        add(ModBlocks.RED_MAPLE_TREE_SAPLING.get(), "枫树苗（红）");
        add(ModBlocks.YELLOW_MAPLE_TREE_SAPLING.get(), "枫树苗（黄）");
        add(ModBlocks.ORANGE_MAPLE_TREE_SAPLING.get(), "枫树苗（橙）");
        add(ModBlocks.LIME_MAPLE_TREE_SAPLING.get(), "枫树苗（黄绿）");
        add(ModBlocks.MAPLE_TREE_PLANKS.get(), "枫树木板");
    }
}
