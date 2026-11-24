package com.valleydevteam.valleycraft.datagen;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.content.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ValleyCraft.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider regs) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.brown_mushroom_grow_lamp.getBlockRK());
    }
}
