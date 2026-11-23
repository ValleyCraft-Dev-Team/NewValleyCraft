package com.valleydevteam.valleycraft.datagen;

import java.util.Set;
import java.util.stream.Stream;

import com.valleydevteam.valleycraft.content.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

public class ValleyCraftBlockLoot extends BlockLootSubProvider {

    public ValleyCraftBlockLoot(Context output) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), output);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Stream.of(ModBlocks.values()).map(ModBlocks::get).toList();
    }

    @Override
    protected void generate() {
        for (var modBlock : ModBlocks.values()) {
            var block = modBlock.get();
            if (modBlock.hasItem()) {
                dropSelf(block);
            } else {
                add(block, noDrop());
            }
        }
    }
}
