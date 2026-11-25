package com.valleydevteam.valleycraft.datagen;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.content.ModBlocks;
import com.valleydevteam.valleycraft.content.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.Optional;
import java.util.stream.Stream;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, ValleyCraft.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        for (var item : ModItems.values()) {
            if (item.useDataGen()) {
                item(item, itemModels);
            }
        }

        for (var block : ModBlocks.values()) {
            if (block.itemDataGen()) {
                switch (block) {
                    case small_acacia_sapling -> item(block, "acacia_seed", itemModels);
                    case small_birch_sapling -> item(block, "birch_seed", itemModels);
                    case small_dark_oak_sapling -> item(block, "dark_acorn_seed", itemModels);
                    case small_oak_sapling -> item(block, "acorn_seed", itemModels);
                    case small_spruce_sapling -> item(block, "pine_cone_seeds", itemModels);
                    default -> item(block.asItem(), itemModels);
                }
            }
        }


    }

    private static void block(Block block,
                              BlockModelGenerators blockModels,
                              ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(block.asItem(), ModelTemplates.FLAT_ITEM);
    }

    private static void item(ItemLike item, ItemModelGenerators models) {
        models.generateFlatItem(item.asItem(), ModelTemplates.FLAT_ITEM);
    }

    private static void item(ItemLike item, String texName, ItemModelGenerators models) {
        var modelLoc = ModelLocationUtils.getModelLocation(item.asItem());
        var texture = TextureMapping.layer0(new Material(ValleyCraft.makeId("item/".concat(texName))));
        var id = ModelTemplates.FLAT_ITEM.create(modelLoc, texture, models.modelOutput);
        models.itemModelOutput.accept(item.asItem(), ItemModelUtils.plainModel(id));
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return Stream.of(ModBlocks.values()).filter(ModBlocks::blockDataGen).map(ModBlocks::getBlock);
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        var stream1 = Stream.of(ModItems.values()).filter(ModItems::useDataGen).map(ModItems::getItem);
        var stream2 = Stream.of(ModBlocks.values()).filter(ModBlocks::itemDataGen).map(ModBlocks::getItem);
        return Stream.concat(stream1, stream2);
    }
}
