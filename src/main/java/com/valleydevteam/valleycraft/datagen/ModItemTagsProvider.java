package com.valleydevteam.valleycraft.datagen;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.content.ModBlocks;
import com.valleydevteam.valleycraft.content.block.AnemoneBlock;
import com.valleydevteam.valleycraft.content.tag.ModBlockTags;
import com.valleydevteam.valleycraft.content.tag.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.LanternBlock;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

/** @see ModBlockTagsProvider */
public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ValleyCraft.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider regs) {
        tag(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.applewood_stairs.getItemRK());
        tag(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.applewood_slab.getItemRK());
        tag(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.applewood_button.getItemRK());
        tag(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.applewood_fence.getItemRK());
        tag(ItemTags.FENCE_GATES)
                .add(ModBlocks.applewood_fence_gate.getItemRK());
        for (var block : ModBlocks.values()) {
            var name = block.name();
            if (name.endsWith("_planks")) {
                tag(ItemTags.PLANKS).add(block.getItemRK());
            }
            if (name.endsWith("_wood")) {
                tag(Tags.BlockItems.NATURAL_WOODS.item()).add(block.getItemRK());
            }
            if (block.get() instanceof AnemoneBlock) {
                tag(ModItemTags.anemone.get()).add(block.getItemRK());
            }
        }
    }
}
