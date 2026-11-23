package com.valleydevteam.valleycraft.datagen.block;

import com.valleydevteam.valleycraft.ValleyCraft;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.level.ItemLike;

public class ModelUtils {
    public static void item(ItemLike item, String name, ItemModelGenerators models) {
        models.generateFlatItem(item.asItem(), ValleyCraft.makeId(name), ModelTemplates.FLAT_ITEM);
    }
}
