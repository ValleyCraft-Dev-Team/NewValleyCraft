package com.valleydevteam.valleycraft.content.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SupportType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

public class RopeVerticalBlock extends BlockWithWater implements RopeBlockExt {
    
    public static final BooleanProperty KNOT = BooleanProperty.create("knot");
    
    protected static final VoxelShape SHAPE = box(6.5, 0, 6.5, 9.5, 16, 9.5);
    protected static final VoxelShape SHAPE_KNOT = Shapes.or(box(6.5, 2, 6.5, 9.5, 16, 9.5), box(6, 3, 6, 10, 7, 10)) ;

    public RopeVerticalBlock(Properties props) {
        super(props);
    }
    
    @Override
    protected BlockState newDefaultState() {
        return super.newDefaultState().setValue(KNOT, false);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(KNOT) ? SHAPE_KNOT : SHAPE;
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        pos = pos.above();
        var upState = level.getBlockState(pos);
        if (upState.getBlock() instanceof RopeVerticalBlock) {
            return true;
        }
        return upState.isFaceSturdy(level, pos, Direction.DOWN, SupportType.CENTER);
    }
    
    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.canSurvive(level, pos)) {
            level.destroyBlock(pos, true);
        }
    }
    
    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(KNOT) ? SHAPE_KNOT : SHAPE;
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, @Nullable Orientation orientation, boolean movedByPiston) {

    }

    @Override
    protected BlockState updateShape(
            BlockState state,
            LevelReader level,
            ScheduledTickAccess ticks,
            BlockPos pos,
            Direction directionToNeighbour,
            BlockPos neighbourPos,
            BlockState neighbourState,
            RandomSource random
    ) {
        if (!state.canSurvive(level, pos)) {
            ticks.scheduleTick(pos, this, 1);
        }
        return toState(level, state, pos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return toState(ctx.getLevel(), super.getStateForPlacement(ctx), ctx.getClickedPos());
    }
    
    protected static BlockState toState(BlockGetter getter, BlockState state, BlockPos pos) {
        pos = pos.below();
        var downState = getter.getBlockState(pos);
        return state.setValue(KNOT, !(downState.getBlock() instanceof RopeVerticalBlock) && !downState.isFaceSturdy(getter, pos, Direction.UP, SupportType.CENTER));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(KNOT));
    }

    @Override
    public boolean isVertical() {
        return true;
    }
}
