package com.valleydevteam.valleycraft.content.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public interface DefaultBlockProps {
    static BlockBehaviour.Properties lantern() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.METAL)
                .forceSolidOn()
                .strength(3.5F)
                .sound(SoundType.LANTERN)
                .noOcclusion()
                .pushReaction(PushReaction.POPPED);
    }
}
