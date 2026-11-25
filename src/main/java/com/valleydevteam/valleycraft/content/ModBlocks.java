package com.valleydevteam.valleycraft.content;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.content.block.*;
import com.valleydevteam.valleycraft.util.IdProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.valleydevteam.valleycraft.content.MoreBlocks.*;

public enum ModBlocks implements IdProvider, ItemLike {
    small_acacia_sapling(ModelType.customBlock, p -> new SmallSaplingBlock(() -> Blocks.ACACIA_SAPLING, p), SmallSaplingBlock::defaultProps, item()),
    small_birch_sapling(ModelType.customBlock, p -> new SmallSaplingBlock(() -> Blocks.BIRCH_SAPLING, p), SmallSaplingBlock::defaultProps, item()),
    small_oak_sapling(ModelType.customBlock, p -> new SmallSaplingBlock(() -> Blocks.OAK_SAPLING, p), SmallSaplingBlock::defaultProps, item()),
    small_dark_oak_sapling(ModelType.customBlock, p -> new SmallSaplingBlock(() -> Blocks.DARK_OAK_SAPLING, p), SmallSaplingBlock::defaultProps, item()),
    small_spruce_sapling(ModelType.customBlock, p -> new SmallSaplingBlock(() -> Blocks.SPRUCE_SAPLING, p), SmallSaplingBlock::defaultProps, item()),
    brown_mushroom_grow_lamp(ModelType.bothCustom, BigMushroomBlock::new, () -> BigMushroomBlock.defaultProps().lightLevel(s -> 14).mapColor(MapColor.DIRT), item()),
    ancient_camera(ModelType.bothCustom, CameraDisplayedBlock::new, CameraDisplayedBlock::defaultProps, item()),
    candle_bottle(ModelType.bothCustom, CandleBottleBlock::new, CandleBottleBlock::defaultProps, item()),
    clam(ModelType.customBlock, ClamBlock::new, ClamBlock::defaultProps, item()),
    rope_horizontal(ModelType.bothCustom, RopeHorizontalBlock::new, RopeBlockExt::defaultProps),
    rope_vertical(ModelType.bothCustom, RopeVerticalBlock::new, RopeBlockExt::defaultProps),
    dead_lantern(ModelType.dataGen, LanternBlock::new, DefaultBlockProps::lantern, item()),
    glowberry_lantern(ModelType.dataGen, LanternBlock::new, () -> DefaultBlockProps.lantern().lightLevel(s -> 15), item()),
    glowsquid_ink_lantern(ModelType.dataGen, LanternBlock::new, () -> DefaultBlockProps.lantern().lightLevel(s -> 15), item()),
    blue_anemone(ModelType.cross, AnemoneBlock::new, () -> AnemoneBlock.defaultProps().mapColor(MapColor.COLOR_BLUE), item()),
    green_anemone(ModelType.cross, AnemoneBlock::new, () -> AnemoneBlock.defaultProps().mapColor(MapColor.COLOR_LIGHT_GREEN), item()),
    red_anemone(ModelType.cross, AnemoneBlock::new, () -> AnemoneBlock.defaultProps().mapColor(MapColor.NETHER), item()),
    pink_anemone(ModelType.cross, AnemoneBlock::new, () -> AnemoneBlock.defaultProps().mapColor(MapColor.COLOR_PINK), item()),
    yellow_anemone(ModelType.cross, AnemoneBlock::new, () -> AnemoneBlock.defaultProps().mapColor(MapColor.GOLD), item()),
    applewood_planks(ModelType.manual, Block::new, () -> copy(Blocks.OAK_PLANKS), () -> itemProps().cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS)),
    applewood_log(ModelType.manual, RotatedPillarBlock::new, () -> copy(Blocks.OAK_LOG), () -> itemProps().cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS)),
    applewood_wood(ModelType.manual, RotatedPillarBlock::new, () -> copy(Blocks.OAK_WOOD), () -> itemProps().cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS)),
    applewood_slab(ModelType.manual, SlabBlock::new, () -> slab(applewood_planks.get()), () -> itemProps().cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_SLABS)),
    applewood_stairs(ModelType.manual, stair(applewood_planks), () -> stairProps(applewood_planks.get()), () -> itemProps().cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS)),
    stripped_applewood_log(ModelType.manual, RotatedPillarBlock::new, () -> copy(Blocks.STRIPPED_OAK_LOG), () -> itemProps().cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS)),
    stripped_applewood_wood(ModelType.manual, RotatedPillarBlock::new, () -> copy(Blocks.STRIPPED_OAK_WOOD), () -> itemProps().cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS)),
    applewood_button(ModelType.manual, p -> new ButtonBlock(ModBlockSetTypes.APPLEWOOD, 30, p), () -> copy(Blocks.OAK_BUTTON), () -> itemProps().cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_ITEMS_EXTRA_SMALL)),
    applewood_fence(ModelType.manual, FenceBlock::new, () -> copy(Blocks.OAK_FENCE), () -> itemProps().cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS)),
    applewood_fence_gate(ModelType.manual, p -> new FenceGateBlock(ModWoodTypes.APPLEWOOD, p), () -> copy(Blocks.OAK_FENCE_GATE), () -> itemProps().cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS)),;

    ModBlocks(ModelType model, Function<BlockBehaviour.Properties, Block> blockFun) {
        this(model, blockFun, null, null);
    }

    ModBlocks(ModelType model, Function<BlockBehaviour.Properties, Block> blockFun, Supplier<BlockBehaviour.Properties> blockPropsSub) {
        this(model, blockFun, blockPropsSub, null);
    }


    ModBlocks(ModelType model, Function<BlockBehaviour.Properties, Block> blockFun, Supplier<BlockBehaviour.Properties> blockPropsSub, Supplier<Item.Properties> itemPropsSub) {
        if (itemPropsSub == null && !model.customItem()) {
            throw new IllegalStateException("Cannot create a block that use item for data-gen without item properties");
        }
        this.model = model;
        this.id = ValleyCraft.makeId(name());
        this.blockFun = blockFun;
        this.blockPropsSub = blockPropsSub;
        this.itemPropsSub = itemPropsSub;
    }

    private static final HashMap<String, DeferredBlock<Block>> blockMap = new HashMap<>();

    public static void init(DeferredRegister.Blocks blocks, DeferredRegister.Items items) {
        for (var block : values()) {
            block.load(blocks, items);
        }
    }

    private void load(DeferredRegister.Blocks blocks, DeferredRegister.Items items) {
        block = blocks.registerBlock(name(), blockFun, blockPropsSub == null ? BlockBehaviour.Properties::of : blockPropsSub);
        blockMap.put(name(), block);
        if (itemPropsSub != null) {
            item = items.registerSimpleBlockItem(name(), block, itemPropsSub);
        }
    }

    public static DeferredBlock<Block> get(String name) {
        return Objects.requireNonNull(blockMap.get(name));
    }

    public final ModelType model;

    private DeferredBlock<Block> block;
    private @Nullable DeferredItem<BlockItem> item;
    private final Identifier id;
    private final Function<BlockBehaviour.Properties, ? extends Block> blockFun;
    private final @Nullable Supplier<BlockBehaviour.Properties> blockPropsSub;
    private final @Nullable Supplier<Item.Properties> itemPropsSub;

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

    public boolean blockAutoGen() {
        return model.autoGenBlock();
    }

    public boolean itemAutoGen() {
        return model.autoGenItem();
    }

    public boolean blockDataGen() {
        return model.dataGenBlock();
    }

    public boolean itemDataGen() {
        return model.dataGenItem();
    }

    public boolean hasItem() {
        return asItem() != null;
    }

    public ResourceKey<Block> getBlockRK() {
        return block.key();
    }

    public ResourceKey<Item> getItemRK() {
        return BuiltInRegistries.ITEM.getResourceKey(block.asItem()).orElseThrow();
    }
}
