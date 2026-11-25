package com.valleydevteam.valleycraft.content.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

/**
 * Commonly used for blocks with horizontal facing. Overriding the method such
 * as appendProperties and getPlacementState without calling the subclass method
 * 'super.createBlockStateDefinition()' is prone to break block's horizontal facing.
 * <p>
 * DON'T COPY THIS CLASS! Just extend it.
 */
public class HorizontalBlock extends HorizontalDirectionalBlock {
    // DON'T COPY THIS CLASS! Just extend it.

    public HorizontalBlock(Properties props) {
        super(props);
        registerDefaultState();
    }

    /** A common method to set its default state. */
    protected final void registerDefaultState() {
        registerDefaultState(newDefaultState(Direction.NORTH));
    }

    /** A common method to get a new default state. */
    protected BlockState newDefaultState(Direction direction) {
        return stateDefinition.any().setValue(FACING, direction);
    }

    /**
     * Please call this subclass method to append facing property:
     * <code>super.createBlockStateDefinition(builder)</code>
     */
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    /**
     * Override {@link getDirection(BlockPlaceContext)} if you only modify
     * face direction placement.
     */
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return super.defaultBlockState().setValue(FACING, getDirection(ctx));
    }

    /** Override this method for custom facing. */
    protected Direction getDirection(BlockPlaceContext ctx) {
        return ctx.getHorizontalDirection();
    }

    /**
     * Utility method for horizontal side. If the block place on vertical side, then
     * get the player's yaw facing.
     */
    protected static Direction getSideElseUserFacing(BlockPlaceContext ctx) {
        final Direction side = ctx.getClickedFace();
        return side.getAxis().isVertical() ? ctx.getHorizontalDirection() : side.getOpposite();
    }
}