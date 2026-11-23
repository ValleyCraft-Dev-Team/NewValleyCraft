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
        var itemAutoLang = new AutoLang<Item>();

        for (var item : ModItems.values()) {
            itemAutoLang.put(item.asItem(), Util.toText(item.getId()));
        }

        for (var block : ModBlocks.values()) {
            if (block.hasItem()) {
                itemAutoLang.put(block.asItem(), Util.toText(block.getId()));
            }
        }

        itemAutoLang.put(ModBlocks.small_acacia_sapling.asItem(), "Acacia Seed");
        itemAutoLang.put(ModBlocks.small_birch_sapling.asItem(), "Birch Seed");
        itemAutoLang.put(ModBlocks.small_dark_oak_sapling.asItem(), "Dark Acorn Seed");
        itemAutoLang.put(ModBlocks.small_oak_sapling.asItem(), "Acorn Seed");
        itemAutoLang.put(ModBlocks.small_spruce_sapling.asItem(), "Pine Cone Seeds");

        itemAutoLang.addAll();

        add("itemGroup.valleycraft", "ValleyCraft Tab");
        add("valleycraft.configuration.title", "ValleyCraft Configs");
        add("valleycraft.configuration.section.valleycraft.common.toml", "ValleyCraft Configs");
        add("valleycraft.configuration.section.valleycraft.common.toml.title", "ValleyCraft Configs");
        add("valleycraft.configuration.override_minecraft_recipes", "Override Minecraft Recipes");
        add("valleycraft.configuration.override_minecraft_loot_tables", "Override Minecraft Loot Tables");
    }

    private class AutoLang<T> {
        final HashMap<T, String> autoLang = new HashMap<>();

        void put(T key, String text) {
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
