package com.valleydevteam.valleycraft.datagen;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.content.ModBlocks;
import com.valleydevteam.valleycraft.content.block.AnemoneBlock;
import com.valleydevteam.valleycraft.content.tag.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.LanternBlock;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

/** @see ModItemTagsProvider */
public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ValleyCraft.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider regs) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.brown_mushroom_grow_lamp.getBlockRK());

        tag(BlockTags.CLIMBABLE)
                .add(ModBlocks.rope_horizontal.getBlockRK())
                .add(ModBlocks.rope_vertical.getBlockRK());

        tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.applewood_stairs.getBlockRK());

        tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.applewood_slab.getBlockRK());

        tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.applewood_button.getBlockRK());

        tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.applewood_fence.getBlockRK());

        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.applewood_fence_gate.getBlockRK());

        for (var block : ModBlocks.values()) {
            var name = block.name();
            if (name.endsWith("_planks")) {
                tag(BlockTags.PLANKS).add(block.getBlockRK());
            }
            if (name.endsWith("_wood")) {
                tag(Tags.BlockItems.NATURAL_WOODS.block()).add(block.getBlockRK());
            }
            if (name.endsWith("_log")) {
                tag(BlockTags.LOGS).add(block.getBlockRK());
            }
            if (block.get() instanceof LanternBlock) {
                tag(BlockTags.LANTERNS).add(block.getBlockRK());
            }
            if (block.get() instanceof AnemoneBlock) {
                tag(ModBlockTags.anemone.get()).add(block.getBlockRK());
            }
        }
    }
}
