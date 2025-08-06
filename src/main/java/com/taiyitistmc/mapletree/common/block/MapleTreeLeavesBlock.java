package com.taiyitistmc.mapletree.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class MapleTreeLeavesBlock extends LeavesBlock {

    public MapleTreeLeavesBlock() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(Blocks::ocelotOrParrot).isSuffocating(MapleTreeLeavesBlock::never).isViewBlocking(MapleTreeLeavesBlock::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(MapleTreeLeavesBlock::never));
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }
}
