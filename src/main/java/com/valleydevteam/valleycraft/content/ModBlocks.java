package com.valleydevteam.valleycraft.content;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.content.block.*;
import com.valleydevteam.valleycraft.util.IdProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public enum ModBlocks implements IdProvider, ItemLike {
    small_acacia_sapling(CustomModel.block, p -> new SmallSaplingBlock(() -> Blocks.ACACIA_SAPLING, p), SmallSaplingBlock::defaultProps, p -> p),
    small_birch_sapling(CustomModel.block, p -> new SmallSaplingBlock(() -> Blocks.BIRCH_SAPLING, p), SmallSaplingBlock::defaultProps, p -> p),
    small_oak_sapling(CustomModel.block, p -> new SmallSaplingBlock(() -> Blocks.OAK_SAPLING, p), SmallSaplingBlock::defaultProps, p -> p),
    small_dark_oak_sapling(CustomModel.block, p -> new SmallSaplingBlock(() -> Blocks.DARK_OAK_SAPLING, p), SmallSaplingBlock::defaultProps, p -> p),
    small_spruce_sapling(CustomModel.block, p -> new SmallSaplingBlock(() -> Blocks.SPRUCE_SAPLING, p), SmallSaplingBlock::defaultProps, p -> p),
    brown_mushroom_grow_lamp(CustomModel.both, BigMushroomBlock::new, p -> BigMushroomBlock.defaultProps(p).lightLevel(s -> 14).mapColor(MapColor.DIRT), p -> p),
    ancient_camera(CustomModel.both, CameraDisplayedBlock::new, CameraDisplayedBlock::defaultProps, p -> p),
    candle_bottle(CustomModel.both, CandleBottleBlock::new, CandleBottleBlock::defaultProps, p -> p),
    clam(CustomModel.block, ClamBlock::new, ClamBlock::defaultProps, p -> p),
    rope_horizontal(CustomModel.both, RopeHorizontalBlock::new, RopeBlockExt::defaultProps),
    rope_vertical(CustomModel.both, RopeVerticalBlock::new, RopeBlockExt::defaultProps);

    ModBlocks(CustomModel model) {
        this(model, p -> p);
    }

    ModBlocks(CustomModel model, UnaryOperator<BlockBehaviour.Properties> propsFun) {
        this.model = model;
        this.id = ValleyCraft.makeId(name());
        this.blockFun = Block::new;
        this.blockPropsFun = propsFun;
        this.itemPropsFun = null;
    }

    ModBlocks(CustomModel model, UnaryOperator<BlockBehaviour.Properties> blockPropsFun, UnaryOperator<Item.Properties> itemPropsFun) {
        this(model, Block::new, blockPropsFun, itemPropsFun);
    }

    ModBlocks(CustomModel model, Function<BlockBehaviour.Properties, ? extends Block> blockFun, UnaryOperator<BlockBehaviour.Properties> blockPropsFun) {
        this(model, blockFun, blockPropsFun, null);
    }


    ModBlocks(CustomModel model, Function<BlockBehaviour.Properties, ? extends Block> blockFun, UnaryOperator<BlockBehaviour.Properties> blockPropsFun, UnaryOperator<Item.Properties> itemPropsFun) {
        if (itemPropsFun == null && !model.item()) {
            throw new IllegalStateException("Cannot create a block that use item for data-gen without item properties");
        }
        this.model = model;
        this.id = ValleyCraft.makeId(name());
        this.blockFun = blockFun;
        this.blockPropsFun = blockPropsFun;
        this.itemPropsFun = itemPropsFun;
    }

    public static void init(DeferredRegister.Blocks blocks, DeferredRegister.Items items) {
        for (var block : values()) {
            block.load(blocks, items);
        }
    }

    private void load(DeferredRegister.Blocks blocks, DeferredRegister.Items items) {
        // Creates a new Block with the id "valleycraft:example_block", combining the namespace and path
        block = blocks.registerBlock(name(), blockFun, blockPropsFun);
        // Creates a new BlockItem with the id "valleycraft:example_block", combining the namespace and path
        if (itemPropsFun != null) {
            item = items.registerSimpleBlockItem(name(), block, itemPropsFun);
        }
    }

    private DeferredBlock<Block> block;
    private @Nullable DeferredItem<BlockItem> item;
    private final Identifier id;
    private final CustomModel model;
    private final Function<BlockBehaviour.Properties, ? extends Block> blockFun;
    private final UnaryOperator<BlockBehaviour.Properties> blockPropsFun;
    private final @Nullable UnaryOperator<Item.Properties> itemPropsFun;

    public Block get() {
        return block.get();
    }

    public DeferredBlock<Block> getBlock() {
        return block;
    }

    public DeferredItem<? extends Item> getItem() {
        return item == null ? ModItems.get(BuiltInRegistries.ITEM.getKey(asItem()).getPath()) : item;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public Item asItem() {
        return block.asItem();
    }

    public ItemStack getDefaultStack() {
        return asItem().getDefaultInstance();
    }

    public boolean blockDataGen() {
        return !model.block();
    }

    public boolean itemDataGen() {
        return !model.item();
    }

    public boolean hasItem() {
        return asItem() != null;
    }

    public ResourceKey<Block> getBlockRK() {
        return BuiltInRegistries.BLOCK.getResourceKey(block.get()).orElseThrow();
    }

    public ResourceKey<Item> getItemRK() {
        return BuiltInRegistries.ITEM.getResourceKey(block.asItem()).orElseThrow();
    }
}
