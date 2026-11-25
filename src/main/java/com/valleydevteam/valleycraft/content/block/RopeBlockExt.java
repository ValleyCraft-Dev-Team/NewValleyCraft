package com.valleydevteam.valleycraft.content.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

public interface RopeBlockExt {
    static BlockBehaviour.Properties defaultProps() {
        return BlockBehaviour.Properties.of().noCollision().pushReaction(PushReaction.POPPED).noOcclusion().sound(SoundType.WOOL);
    }
    boolean isVertical();
    default boolean isHorizontal() {
        return !isVertical();
    }
}
