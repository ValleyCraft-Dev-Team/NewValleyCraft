package com.valleydevteam.valleycraft.content;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.util.IdProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public enum ModBlocks implements IdProvider, ItemLike {
    example_block(p -> p,p -> p),
    example_block_two(p -> p.instabreak().noCollision());

    ModBlocks() {
        this(p -> p);
    }

    ModBlocks(UnaryOperator<BlockBehaviour.Properties> propsFun) {
        this.id = ValleyCraft.makeId(name());
        this.blockFun = Block::new;
        this.blockPropsFun = propsFun;
        this.itemPropsFun = null;
    }

    ModBlocks(UnaryOperator<BlockBehaviour.Properties> blockPropsFun, UnaryOperator<Item.Properties> itemPropsFun) {
        this(Block::new, blockPropsFun, itemPropsFun);
    }

    ModBlocks(Function<BlockBehaviour.Properties, ? extends Block> blockFun, UnaryOperator<BlockBehaviour.Properties> blockPropsFun, UnaryOperator<Item.Properties> itemPropsFun) {
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
    private final Function<BlockBehaviour.Properties, ? extends Block> blockFun;
    private final UnaryOperator<BlockBehaviour.Properties> blockPropsFun;
    private final @Nullable UnaryOperator<Item.Properties> itemPropsFun;

    public Item getI() {
        return block.asItem();
    }

    public DeferredItem<BlockItem> getItem() {
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
        return block.asItem();
    }

    public ItemStack getDefaultStack() {
        return asItem().getDefaultInstance();
    }
}
