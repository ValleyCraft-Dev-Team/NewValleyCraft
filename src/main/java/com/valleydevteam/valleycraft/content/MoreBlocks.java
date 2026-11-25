package com.valleydevteam.valleycraft.content;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.AABB;

import java.util.function.Function;
import java.util.function.Supplier;

interface MoreBlocks {
    BlockBehaviour.StateArgumentPredicate<AABB> NEAR_PLANE_INTERSECTS_OUTLINE = (state, level, blockPos, nearPlaneBox) -> {
        for (AABB outlineBox : state.getOcclusionShape().toAabbs()) {
            if (outlineBox.move(blockPos).intersects(nearPlaneBox)) {
                return true;
            }
        }

        return false;
    };

    static BlockBehaviour.Properties copy(Block block) {
        return BlockBehaviour.Properties.ofFullCopy(block);
    }

    static BlockBehaviour.Properties blockProps() {
        return BlockBehaviour.Properties.of();
    }

    static Item.Properties itemProps() {
        return new Item.Properties();
    }

    static Supplier<Item.Properties> item() {
        return Item.Properties::new;
    }

    static Function<BlockBehaviour.Properties, Block> block() {
        return Block::new;
    }

    static Function<BlockBehaviour.Properties, Block> stair(ModBlocks block) {
        return p -> new StairBlock(block.get().defaultBlockState(), p);
    }

    static BlockBehaviour.Properties stairProps(Block base) {
        return BlockBehaviour.Properties.ofFullCopy(base).isViewBlocking(NEAR_PLANE_INTERSECTS_OUTLINE);
    }

    static BlockBehaviour.Properties slab(Block base) {
        return BlockBehaviour.Properties.ofFullCopy(base).isViewBlocking(NEAR_PLANE_INTERSECTS_OUTLINE);
    }
}
