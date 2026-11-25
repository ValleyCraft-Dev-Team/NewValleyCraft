package com.valleydevteam.valleycraft.content;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.*;

/** @see ModCreativeTabs to register it */
public interface CreativeTabItems {
    static void valleyCraftTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        var items = new HashSet<Item>(1000);
        for (var block : ModBlocks.values()) {
            if (block.hasItem()) {
                items.add(block.asItem());
            }
        }
        items.addAll(Arrays.stream(ModItems.values()).map(ItemLike::asItem).toList());
        addAllOrdered(items, output);
    }

    static void addAllOrdered(Collection<Item> collection, CreativeModeTab.Output output) {
        output.acceptAll(collection.stream().sorted(Comparator.comparing(i -> BuiltInRegistries.ITEM.getKey(i).getPath())).map(Item::getDefaultInstance).toList());
    }
}
