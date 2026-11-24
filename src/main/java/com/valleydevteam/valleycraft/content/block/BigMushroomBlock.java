package com.valleydevteam.valleycraft.content.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BigMushroomBlock extends GroundBlock {

    public static Properties defaultProps(Properties props) {
        return props.strength(0.2F).sound(SoundType.WOOD).ignitedByLava();
    }

    private static final VoxelShape SHAPE = Block.column(12.0, 0.0, 12.0);

    public BigMushroomBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

}
