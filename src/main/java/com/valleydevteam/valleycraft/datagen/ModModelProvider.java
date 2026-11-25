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
import net.minecraft.world.level.block.LanternBlock;

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

        woodFamily(blockModels, ModBlocks.applewood_log, ModBlocks.applewood_wood, ModBlocks.stripped_applewood_log,
                ModBlocks.stripped_applewood_wood, ModBlocks.applewood_planks, ModBlocks.applewood_slab,
                ModBlocks.applewood_stairs, ModBlocks.applewood_button, ModBlocks.applewood_fence, ModBlocks.applewood_fence_gate);

        // Auto generate block and item models
        for (var blockEnum : ModBlocks.values()) {
            var name = blockEnum.name();
            var block = blockEnum.get();
            if (blockEnum.blockAutoGen()) {
                switch (blockEnum.model) {
                    case cross -> blockModels.createCrossBlockWithDefaultItem(block, BlockModelGenerators.PlantType.NOT_TINTED);
                    case fullCube -> blockModels.createTrivialCube(block);
                }
                if (block instanceof LanternBlock) {
                    blockModels.createLantern(block);
                }
            } else if (blockEnum.itemAutoGen()) {
                switch (blockEnum) {
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

    private static void woodFamily(BlockModelGenerators models, ModBlocks log, ModBlocks wood, ModBlocks sLog, ModBlocks sWood, ModBlocks planks, ModBlocks slab, ModBlocks stairs, ModBlocks button, ModBlocks fence, ModBlocks fenceGate) {
        models.woodProvider(log.get()).logWithHorizontal(log.get()).wood(wood.get());
        models.woodProvider(sLog.get()).logWithHorizontal(sLog.get()).wood(sWood.get());
        models.family(planks.get()).slab(slab.get()).stairs(stairs.get()).button(button.get()).fence(fence.get()).fenceGate(fenceGate.get());
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
