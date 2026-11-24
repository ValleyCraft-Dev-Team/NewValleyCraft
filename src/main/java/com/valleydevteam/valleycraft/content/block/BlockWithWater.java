package com.valleydevteam.valleycraft.content.block;

import com.valleydevteam.valleycraft.util.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

/**
 * Commonly used for blocks with facing and waterlogged. Overriding
 * some method without calling the subclass's method 'super.appendProperties()'
 * is prone to break block's facing and waterlogged.
 * <p>
 * DON'T COPY THIS CLASS! Just extend it.
 */
public class BlockWithWater extends Block implements SimpleWaterloggedBlock {

    protected static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;


    public BlockWithWater(Properties props) {
        super(props);
        registerDefaultState(newDefaultState());
    }

    protected BlockState newDefaultState() {
        return stateDefinition.any().setValue(WATERLOGGED, false);
    }

    /**
     * Please call this subclass method to append facing and
     * waterlogged properties: <code>super.createBlockStateDefinition(builder)</code>
     */
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return super.getStateForPlacement(ctx).setValue(WATERLOGGED, Util.inWater(ctx));
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
        if (state.getValue(WATERLOGGED)) {
            ticks.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(WATERLOGGED);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
}
