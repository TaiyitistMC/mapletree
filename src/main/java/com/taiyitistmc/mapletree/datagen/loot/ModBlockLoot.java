package com.taiyitistmc.mapletree.datagen.loot;

import com.taiyitistmc.mapletree.common.init.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Set;

public class ModBlockLoot extends BlockLootSubProvider {

    protected ModBlockLoot(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, registries);
    }

    @Override
    protected void generate() {
        ModBlocks.BLOCKS.getEntries().forEach(blockDeferredHolder -> {
            String id = blockDeferredHolder.get().getDescriptionId();
            if (!id.contains("leaves")) {
                dropSelf(blockDeferredHolder.get());
            }
        });
        this.leavesDrop(ModBlocks.RED_MAPLE_TREE_LEAVES.get(), ModBlocks.RED_MAPLE_TREE_SAPLING.get());
        this.leavesDrop(ModBlocks.YELLOW_MAPLE_TREE_LEAVES.get(), ModBlocks.YELLOW_MAPLE_TREE_SAPLING.get());
        this.leavesDrop(ModBlocks.ORANGE_MAPLE_TREE_LEAVES.get(), ModBlocks.ORANGE_MAPLE_TREE_SAPLING.get());
        this.leavesDrop(ModBlocks.LIME_MAPLE_TREE_LEAVES.get(), ModBlocks.LIME_MAPLE_TREE_SAPLING.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries()
                .stream()
                .map(e -> (Block) e.value())
                .toList();
    }

    protected void leavesDrop(Block leaves, Block sapling) {
        this.add(leaves, factory -> this.createLeavesDrops(factory, sapling, NORMAL_LEAVES_SAPLING_CHANCES));
    }

    protected LootTable.Builder createLeavesWithFruitDrops(Block oakLeavesBlock, Block saplingBlock, ItemLike fruit, float... chances) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createLeavesDrops(oakLeavesBlock, saplingBlock, chances).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(this.doesNotHaveShearsOrSilkTouch()).add(((LootPoolSingletonContainer.Builder)this.applyExplosionCondition(oakLeavesBlock, LootItem.lootTableItem(fruit))).when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), new float[]{0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F}))));
    }

    private LootItemCondition.Builder doesNotHaveShearsOrSilkTouch() {
        return this.hasShearsOrSilkTouch().invert();
    }

    private LootItemCondition.Builder hasShearsOrSilkTouch() {
        return HAS_SHEARS.or(this.hasSilkTouch());
    }

}
