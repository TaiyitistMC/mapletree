package com.taiyitistmc.mapletree.datagen;

import com.taiyitistmc.mapletree.MapleTree;
import com.taiyitistmc.mapletree.common.init.ModItems;
import com.taiyitistmc.mapletree.common.util.Helpers;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProviderEn extends LanguageProvider {


    public ModLanguageProviderEn(PackOutput output) {
        super(output, MapleTree.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.maple_tree", "MapleTree and agriculture");
        ModItems.ITEMS.getEntries().forEach(item -> {
            add(item.get(), formatFieldName(Helpers.getItemName(item.get())));
        });
    }


    private static String formatFieldName(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        boolean nextUpper = true;

        for (char c : input.toCharArray()) {
            if (c == '_') {
                result.append(' ');
                nextUpper = true;
            } else {
                if (nextUpper) {
                    result.append(Character.toUpperCase(c));
                    nextUpper = false;
                } else {
                    result.append(Character.toLowerCase(c));
                }
            }
        }

        return result.toString();
    }
}
