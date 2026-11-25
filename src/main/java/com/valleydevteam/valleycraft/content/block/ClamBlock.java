package com.valleydevteam.valleycraft.content.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ClamBlock extends HorizontalBlockWithWater {

    public static Properties defaultProps(Properties props) {
        return props.pushReaction(PushReaction.POPPED).sound(SoundType.CORAL_BLOCK);
    }

    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final BooleanProperty PEARL = ModBlockStateProps.pearl;

    private static final VoxelShape SHAPE = Block.column(10.0, 0.0, 4.0);

    public ClamBlock(Properties props) {
        super(props);
        registerDefaultState(stateDefinition.any().setValue(OPEN, false).setValue(PEARL, false));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (state.getValue(OPEN)) {
            level.setBlock(pos, state.setValue(OPEN, false), UPDATE_NEIGHBORS | UPDATE_CLIENTS);
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (player.getAbilities().mayBuild) {
            if (!state.getValue(OPEN)) {
                level.setBlock(pos, state.setValue(OPEN, true), UPDATE_NEIGHBORS | UPDATE_CLIENTS);
                level.scheduleTick(pos, this, 40);
            }
            return InteractionResult.SUCCESS;
        } else {
            return super.useWithoutItem(state, level, pos, player, hitResult);
        }
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(OPEN);
        builder.add(PEARL);
    }
}
