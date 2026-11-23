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

        item(ModBlocks.small_acacia_sapling, "acacia_seed", itemModels);
        item(ModBlocks.small_birch_sapling, "birch_seed", itemModels);
        item(ModBlocks.small_dark_oak_sapling, "dark_acorn_seed", itemModels);
        item(ModBlocks.small_oak_sapling, "acorn_seed", itemModels);
        item(ModBlocks.small_spruce_sapling, "pine_cone_seeds", itemModels);
    }

    // Assumes there is a texture referenced as '#base'
    // Can be resolved by either specifying 'base' or 'all'
    public static final TextureSlot BASE = TextureSlot.create("base", TextureSlot.ALL);

    // Assume there exists some model 'examplemod:block/example_template'
    public static final ModelTemplate EXAMPLE_TEMPLATE = new ModelTemplate(
            // The parent model location
            Optional.of(
                    ModelLocationUtils.decorateBlockModelLocation("examplemod:example_template")
            ),
            // The suffix to apply to the end of any model that uses this template
            Optional.of("_example"),
            // All texture slots that must be defined
            // Should be as specific as possible based on what's undefined in the parent model
            TextureSlot.PARTICLE,
            BASE
    );

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
