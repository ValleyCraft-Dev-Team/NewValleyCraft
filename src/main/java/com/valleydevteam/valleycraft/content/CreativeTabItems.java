package com.valleydevteam.valleycraft.content;

import net.minecraft.world.item.CreativeModeTab;

import static com.valleydevteam.valleycraft.content.ModItems.*;

/** @see ModCreativeTabs to register it */
public interface CreativeTabItems {
    static void exampleTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        for (var item : ModItems.values()) {
            output.accept(item);
        }
    }
}
