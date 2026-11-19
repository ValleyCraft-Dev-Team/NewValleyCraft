package com.valleydevteam.valleycraft.datagen;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.content.ModItems;
import com.valleydevteam.valleycraft.util.Util;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.stream.Collectors;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput output) {
        super(output, ValleyCraft.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        var itemAutoLang = new HashMap<Item, String>();

        for (var item : ModItems.values()) {
            itemAutoLang.put(item.asItem(), Util.toText(item.getId()));
        }

        // Use this code to override the text
        //itemAutoLang.put(ModItems.apple_pie.asItem(), "Apple Pie");

        itemAutoLang.entrySet().forEach(entry -> add(entry.getKey(), entry.getValue()));

        add("itemGroup.valleycraft", "ValleyCraft Tab");
        add("block.valleycraft.example_block", "Example Block");
        add("item.valleycraft.example_item", "Example Item");
        add("valleycraft.configuration.title", "ValleyCraft Configs");
        add("valleycraft.configuration.section.valleycraft.common.toml", "ValleyCraft Configs");
        add("valleycraft.configuration.section.valleycraft.common.toml.title", "ValleyCraft Configs");
        add("valleycraft.configuration.items", "Item List");
        add("valleycraft.configuration.logDirtBlock", "Log Dirt Block");
        add("valleycraft.configuration.magicNumberIntroduction", "Magic Number Text");
        add("valleycraft.configuration.magicNumber", "Magic Number");
    }
}
