package com.taiyitistmc.mapletree.datagen;

import com.taiyitistmc.mapletree.MapleTree;
import com.taiyitistmc.mapletree.common.block.MapleTreeLeavesBlock;
import com.taiyitistmc.mapletree.common.block.MapleTreeLogBlock;
import com.taiyitistmc.mapletree.common.init.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MapleTree.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModBlocks.BLOCKS.getEntries().forEach(block -> {
            if (block.get() instanceof MapleTreeLeavesBlock) {
                simpleBlock(block.get(), cubeAll(block.get()));
            } else if (block.get() instanceof MapleTreeLogBlock mapleTreeLogBlock) {
                logBlock(mapleTreeLogBlock);
            } else if (block.get().getDescriptionId().contains("sapling")) {
                crossBlock(block.get());
            }else {
                simpleBlock(block.get());
            }
        });
    }

    public void crossBlock(Block block) {
        this.simpleBlock(block, this.cross(block));
    }

    public ModelFile cubeAll(Block block) {
        return this.models().cubeAll(this.getName(block), this.blockTexture(block));
    }

    public ModelFile cross(Block block) {
        return this.models().cross(this.getName(block), this.blockTexture(block));
    }

    private String getName(Block block) {
        return this.getKey(block).getPath();
    }

    private ResourceLocation getKey(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}
