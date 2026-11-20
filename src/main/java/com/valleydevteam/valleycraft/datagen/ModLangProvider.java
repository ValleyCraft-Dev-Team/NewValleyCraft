package com.valleydevteam.valleycraft.datagen;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.content.ModItems;
import com.valleydevteam.valleycraft.util.Util;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.HashMap;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput output) {
        super(output, ValleyCraft.MOD_ID, "en_us");
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
        add("valleycraft.configuration.title", "ValleyCraft Configs");
        add("valleycraft.configuration.section.valleycraft.common.toml", "ValleyCraft Configs");
        add("valleycraft.configuration.section.valleycraft.common.toml.title", "ValleyCraft Configs");
        add("valleycraft.configuration.override_minecraft_recipes", "Override Minecraft Recipes");
        add("valleycraft.configuration.override_minecraft_loot_tables", "Override Minecraft Loot Tables");
    }
}
