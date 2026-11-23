package com.valleydevteam.valleycraft.content;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/** @see ModCreativeTabs to register it */
public interface CreativeTabItems {
    static void valleyCraftTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        var items = new ArrayList<Enum<? extends ItemLike>>(1000);
        items.addAll(Arrays.asList(ModItems.values()));
        for (var block : ModBlocks.values()) {
            if (block.hasItem()) {
                items.add(block);
            }
        }
        output.acceptAll(items.stream().sorted(Comparator.comparing(Enum::name)).map(e -> ((ItemLike)e).asItem().getDefaultInstance()).toList());
    }
}
