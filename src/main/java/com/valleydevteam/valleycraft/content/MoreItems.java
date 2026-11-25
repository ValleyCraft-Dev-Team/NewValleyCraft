package com.valleydevteam.valleycraft.content;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.AABB;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

interface MoreItems {
    static Supplier<Item.Properties> item() {
        return Item.Properties::new;
    }
    static Item.Properties props() {
        return new Item.Properties();
    }
    static Item.Properties food(int nut, float sat) {
        return props().food(new FoodProperties(nut, sat, true));
    }

    static Item.Properties food(int nut, float sat, Consumable c) {
        return props().food(new FoodProperties(nut, sat, true), c);
    }
}
