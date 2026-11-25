package com.valleydevteam.valleycraft.datagen;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.content.ModBlocks;
import com.valleydevteam.valleycraft.content.ModItems;
import com.valleydevteam.valleycraft.util.Util;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.HashMap;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput output) {
        super(output, ValleyCraft.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        var autoLang = new AutoLang();

        for (var item : ModItems.values()) {
            autoLang.put(item.asItem(), Util.toText(item.getId()));
        }

        for (var block : ModBlocks.values()) {
            if (block.hasItem()) {
                autoLang.put(block.asItem(), Util.toText(block.getItem().getId()));
            } else {
                autoLang.put(block.get(), Util.toText(block.getId()));
            }
        }

        autoLang.put(ModBlocks.small_acacia_sapling.asItem(), "Acacia Seed");
        autoLang.put(ModBlocks.small_birch_sapling.asItem(), "Birch Seed");
        autoLang.put(ModBlocks.small_dark_oak_sapling.asItem(), "Dark Acorn Seed");
        autoLang.put(ModBlocks.small_oak_sapling.asItem(), "Acorn Seed");
        autoLang.put(ModBlocks.small_spruce_sapling.asItem(), "Pine Cone Seeds");

        autoLang.addAll();

        add("itemGroup.valleycraft", "ValleyCraft Tab");
        add("valleycraft.configuration.title", "ValleyCraft Configs");
        add("valleycraft.configuration.section.valleycraft.common.toml", "ValleyCraft Configs");
        add("valleycraft.configuration.section.valleycraft.common.toml.title", "ValleyCraft Configs");
    }

    private class AutoLang {
        final HashMap<Object, String> autoLang = new HashMap<>();

        void put(Object key, String text) {
            autoLang.put(key, text);
        }

        void addAll() {
            for (var lang : autoLang.entrySet()) {
                var object = lang.getKey();
                var text = lang.getValue();
                if (object instanceof Item item) {
                    add(item, text);
                }
                if (object instanceof Block item) {
                    add(item, text);
                }
                if (object instanceof String string) {
                    add(string, text);
                }
            }
        }
    }
}
