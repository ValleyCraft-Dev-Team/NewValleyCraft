package com.valleydevteam.valleycraft.content.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RopeHorizontalBlock extends BlockWithWater implements RopeBlockExt {
    
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    
    protected static final VoxelShape Z_SHAPE = Block.box(6.5, 6.5, 0.0, 9.5, 9.5, 16.0);
    protected static final VoxelShape X_SHAPE = Block.box(0.0, 6.5, 6.5, 16.0, 9.5, 9.5);

    public RopeHorizontalBlock(Properties props) {
        super(props);
    }

    @Override
    protected BlockState newDefaultState() {
        return super.newDefaultState().setValue(AXIS, Direction.Axis.X);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(AXIS) == Direction.Axis.X ? X_SHAPE : Z_SHAPE;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        switch (rotation) {
            case COUNTERCLOCKWISE_90: 
            case CLOCKWISE_90: {
                return switch (state.getValue(AXIS)) {
                    case Z -> state.setValue(AXIS, Direction.Axis.Z);
                    case X -> state.setValue(AXIS, Direction.Axis.X);
                    default -> state;
                };
            }
            default: return state;
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(AXIS));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        var axis = ctx.getClickedFace().getAxis();
        if (axis.isVertical()) return null;
        return super.getStateForPlacement(ctx).setValue(AXIS, axis);
    }

    @Override
    public boolean isVertical() {
        return false;
    }
}
