package com.taiyitistmc.mapletree.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class EggplantCropBlock extends CropBlock {

    public static final MapCodec<EggplantCropBlock> CODEC = simpleCodec(EggplantCropBlock::new);

    public EggplantCropBlock() {
        this(Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY));
    }

    public EggplantCropBlock(Properties properties) {
        super(properties);
    }

    protected ItemLike getBaseSeedId() {
        return Items.CARROT;
    }

    @Override
    public MapCodec<EggplantCropBlock> codec() {
        return CODEC;
    }
}
