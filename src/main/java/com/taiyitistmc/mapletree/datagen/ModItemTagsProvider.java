package com.taiyitistmc.mapletree.datagen;

import com.taiyitistmc.mapletree.MapleTree;
import com.taiyitistmc.mapletree.common.init.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {


    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags,  @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, MapleTree.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        ModBlocks.BLOCKS.getEntries().forEach(
                blockDeferredHolder -> {
                    if (blockDeferredHolder.get().getDescriptionId().contains("planks")) {
                        tag(ItemTags.PLANKS).add(blockDeferredHolder.get().asItem());
                    }
                    if (blockDeferredHolder.get().getDescriptionId().contains("sapling")) {
                        tag(ItemTags.SAPLINGS).add(blockDeferredHolder.get().asItem());
                    }
                    if (blockDeferredHolder.get().getDescriptionId().contains("log")) {
                        tag(ItemTags.LOGS).add(blockDeferredHolder.get().asItem());
                    }
                    if (blockDeferredHolder.get().getDescriptionId().contains("leaves")) {
                        tag(ItemTags.LEAVES).add(blockDeferredHolder.get().asItem());
                    }
                }
        );
    }
}
