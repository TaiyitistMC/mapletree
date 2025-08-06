package com.taiyitistmc.mapletree.common.block;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.Optional;

public class MapleTreeSaplingBlock extends SaplingBlock {

    public MapleTreeSaplingBlock(String name, ResourceKey<ConfiguredFeature<?, ?>> tree) {
        super(new TreeGrower(name, Optional.empty(), Optional.of(tree), Optional.empty()), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY));
    }
}
