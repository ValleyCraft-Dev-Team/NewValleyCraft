package com.valleydevteam.valleycraft.content.item;

import com.valleydevteam.valleycraft.content.ModBlocks;
import com.valleydevteam.valleycraft.content.block.RopeBlockExt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

import java.util.Map;
import java.util.function.Supplier;

public class RopeItem extends BlockItem {

    protected final Supplier<Block> verticalBlock = ModBlocks.rope_vertical::get;
    protected final Supplier<Block> horizontalBlock = ModBlocks.rope_horizontal::get;
    
    public RopeItem(Properties props) {
        super(Blocks.AIR, props);
    }

    @Override
    protected @Nullable BlockState getPlacementState(BlockPlaceContext context) {
        var block = context.getClickedFace().getAxis().isVertical() ? verticalBlock.get() : horizontalBlock.get();
        var state = block.getStateForPlacement(context);
        return state != null && this.canPlace(context, state) ? state : null;
    }

    @Override
    public @Nullable BlockPlaceContext updatePlacementContext(BlockPlaceContext context) {
        if (context.getPlayer() == null) return context;
        var world = context.getLevel();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace().getOpposite());
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof RopeBlockExt rope) {
            var isVertical = rope.isVertical();
            var facing = isVertical ? Direction.DOWN : context.getHorizontalDirection();
            var mutable = pos.mutable().move(facing);
            int i = 0;
            while (i < 5) {
                state = world.getBlockState(mutable);
                if (state.getBlock() instanceof RopeBlockExt block && block.isVertical() == isVertical) {
                    mutable.move(facing);
                    ++i;
                } else {
                    if (!state.canBeReplaced(context)) break;
                    return BlockPlaceContext.at(context, mutable, facing);
                }
            }
            return null;
        }
        return context;
    }
    
    @Override
    public Block getBlock() {
    	return verticalBlock.get();
    }
    
    @Override
    public void registerBlocks(Map<Block, Item> map, Item item) {
    	map.put(verticalBlock.get(), item);
        map.put(horizontalBlock.get(), item);
    }
}
