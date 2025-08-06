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
        add(ModBlocks.RED_MAPLE_TREE_LEAVES.get(), "モミジ葉[赤]");
        add(ModBlocks.MAPLE_TREE_LOG.get(), "モミジ原木");
    }
}
