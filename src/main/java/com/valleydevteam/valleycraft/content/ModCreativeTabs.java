package com.valleydevteam.valleycraft.content;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.util.IdProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

/** @see CreativeTabItems for items */
public enum ModCreativeTabs implements IdProvider {
    example_tab(() -> builder()
            .title(Component.translatable("itemGroup.valleycraft")) // The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(ModItems.fiber::getStack)
            .displayItems(CreativeTabItems::exampleTab).build());

    ModCreativeTabs(Supplier<CreativeModeTab> tabSup) {
        this.id = ValleyCraft.makeId(name());
        this.tabSub = tabSup;
    }

    private static CreativeModeTab.Builder builder() {
        return CreativeModeTab.builder();
    }

    public static void init(DeferredRegister<CreativeModeTab> tabs) {
        for (var tab : values()) {
            tab.load(tabs);
        }
    }

    private void load(DeferredRegister<CreativeModeTab> tabs) {
        tab = tabs.register(name(), tabSub);
    }

    private DeferredHolder<CreativeModeTab, CreativeModeTab> tab;
    private final Identifier id;
    private final Supplier<CreativeModeTab> tabSub;

    public CreativeModeTab get() {
        return tab.get();
    }

    public DeferredHolder<CreativeModeTab, CreativeModeTab> getTab() {
        return tab;
    }

    @Override
    public Identifier getId() {
        return id;
    }
}
