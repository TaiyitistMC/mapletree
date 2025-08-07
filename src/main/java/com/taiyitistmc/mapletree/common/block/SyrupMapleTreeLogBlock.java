package com.taiyitistmc.mapletree.common.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class SyrupMapleTreeLogBlock extends RotatedPillarBlock {

    public SyrupMapleTreeLogBlock(MapColor topMapColor, MapColor sideMapColor) {
        super(Properties.of().mapColor((p_152624_) -> p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava());
    }
}
