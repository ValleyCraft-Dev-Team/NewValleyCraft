package com.valleydevteam.valleycraft.content.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RockPileBlock extends GroundBlockWithWater {

    public static Properties defaultProps() {
        return BlockBehaviour.Properties.of().mapColor(MapColor.STONE).pushReaction(PushReaction.POPPED).strength(0.5F).lightLevel(state -> 1).noOcclusion();
    }

    public static final VoxelShape SHAPE = column(12, 0, 3);

    public RockPileBlock(Properties props) {
        super(props);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
