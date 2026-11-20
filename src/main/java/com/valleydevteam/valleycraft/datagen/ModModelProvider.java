package com.valleydevteam.valleycraft.datagen;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.content.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.ItemLike;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, ValleyCraft.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        for (var item : ModItems.values()) {
            item(item, itemModels);
        }
    }

    private static void item(ItemLike item, ItemModelGenerators models) {
        models.generateFlatItem(item.asItem(), ModelTemplates.FLAT_ITEM);
    }
}
