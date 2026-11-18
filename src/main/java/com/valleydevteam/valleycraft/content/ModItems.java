package com.valleydevteam.valleycraft.content;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.util.IdProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public enum ModItems implements IdProvider, ItemLike {
    example_item(p -> p.food(new FoodProperties.Builder().alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    ModItems() {
        this(p -> p);
    }

    ModItems(UnaryOperator<Item.Properties> propsFun) {
        this(Item::new, propsFun);
    }

    ModItems(Function<Item.Properties, ? extends Item> itemFun, UnaryOperator<Item.Properties> itemPropsFun) {
        this.id = ValleyCraft.makeId(name());
        this.itemFun = itemFun;
        this.itemPropsFun = itemPropsFun;
    }

    public static void init(DeferredRegister.Items items) {
        for (var item : values()) {
            item.load(items);
        }
    }

    private void load(DeferredRegister.Items items) {
        item = items.registerItem(name(), itemFun, itemPropsFun);
    }

    private DeferredItem<Item> item;
    private final Identifier id;
    private final Function<Item.Properties, ? extends Item> itemFun;
    private final UnaryOperator<Item.Properties> itemPropsFun;

    public Item get() {
        return item.get();
    }

    public DeferredItem<Item> getItem() {
        return item;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public Item asItem() {
        return item.get();
    }

    public ItemStack getStack() {
        return get().getDefaultInstance();
    }
}
