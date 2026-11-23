package com.valleydevteam.valleycraft.content;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.content.block.SmallSapling;
import com.valleydevteam.valleycraft.util.IdProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public enum ModBlocks implements IdProvider, ItemLike {
    small_acacia_sapling(CustomModel.block, p -> new SmallSapling(() -> Blocks.ACACIA_SAPLING, p), SmallSapling::defaultProps, p -> p),
    small_birch_sapling(CustomModel.block, p -> new SmallSapling(() -> Blocks.BIRCH_SAPLING, p), SmallSapling::defaultProps, p -> p),
    small_oak_sapling(CustomModel.block, p -> new SmallSapling(() -> Blocks.OAK_SAPLING, p), SmallSapling::defaultProps, p -> p),
    small_dark_oak_sapling(CustomModel.block, p -> new SmallSapling(() -> Blocks.DARK_OAK_SAPLING, p), SmallSapling::defaultProps, p -> p),
    small_spruce_sapling(CustomModel.block, p -> new SmallSapling(() -> Blocks.SPRUCE_SAPLING, p), SmallSapling::defaultProps, p -> p);

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
        this(model, blockFun, blockPropsFun, p -> p);
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

    public DeferredItem<BlockItem> getItem() {
        if (item == null) {
            throw new IllegalStateException("Items are not yet supported");
        }
        return item;
    }

    public Block get() {
        return block.get();
    }

    public DeferredBlock<Block> getBlock() {
        return block;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public Item asItem() {
        if (item == null) {
            throw new IllegalStateException("Items are not yet supported");
        }
        return block.asItem();
    }

    public ItemStack getDefaultStack() {
        if (item == null) {
            throw new IllegalStateException("Items are not yet supported");
        }
        return asItem().getDefaultInstance();
    }

    public boolean blockDataGen() {
        return !model.block();
    }

    public boolean itemDataGen() {
        return !model.item();
    }

    public boolean hasItem() {
        return item != null;
    }
}
