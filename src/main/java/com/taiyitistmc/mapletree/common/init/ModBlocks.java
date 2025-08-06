package com.taiyitistmc.mapletree.common.init;

import com.taiyitistmc.mapletree.MapleTree;
import com.taiyitistmc.mapletree.common.block.MapleTreeLeavesBlock;
import com.taiyitistmc.mapletree.common.block.MapleTreeLogBlock;
import com.taiyitistmc.mapletree.common.block.MapleTreeSaplingBlock;
import com.taiyitistmc.mapletree.datagen.levelgen.ModConfiguredFeatureProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MapleTree.MODID);

    public static final DeferredBlock<Block> MAPLE_TREE_LOG =
            register("maple_tree_log", () -> new MapleTreeLogBlock(MapColor.COLOR_RED, MapColor.PODZOL));
    public static final DeferredBlock<Block> RED_MAPLE_TREE_LEAVES =
            register("red_maple_tree_leaves", MapleTreeLeavesBlock::new);
    public static final DeferredBlock<Block> YELLOW_MAPLE_TREE_LEAVES =
            register("yellow_maple_tree_leaves", MapleTreeLeavesBlock::new);
    public static final DeferredBlock<Block> ORANGE_MAPLE_TREE_LEAVES =
            register("orange_maple_tree_leaves", MapleTreeLeavesBlock::new);
    public static final DeferredBlock<Block> LIME_MAPLE_TREE_LEAVES =
            register("lime_maple_tree_leaves", MapleTreeLeavesBlock::new);
    public static final DeferredBlock<Block> RED_MAPLE_TREE_SAPLING =
            register("red_maple_tree_sapling", () -> new MapleTreeSaplingBlock("red_maple_tree", ModConfiguredFeatureProvider.RED_MAPLE_TREE));

    public static DeferredBlock<Block> register(String name, BlockBehaviour.Properties properties) {
        var block = BLOCKS.registerSimpleBlock(name, properties);
        ModItems.ITEMS.registerSimpleBlockItem(block);
        return block;
    }

    public static <B extends Block> DeferredBlock<B> register(String name, Supplier<B> sup) {
        var block = BLOCKS.register(name, sup);
        ModItems.ITEMS.registerSimpleBlockItem(block);
        return block;
    }

    public static <B extends Block> DeferredBlock<B> register(String name, Supplier<B> sup, Item.Properties properties) {
        var block = BLOCKS.register(name, sup);
        ModItems.ITEMS.registerSimpleBlockItem(block, properties);
        return block;
    }
}
