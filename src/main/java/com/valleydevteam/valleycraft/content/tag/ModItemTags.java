package com.valleydevteam.valleycraft.content.tag;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.util.IdProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public enum ModItemTags implements IdProvider {
    anemone;

    private final Identifier id;
    private final TagKey<Item> tagKey;

    ModItemTags() {
        this.id = ValleyCraft.makeId(name());
        this.tagKey = TagKey.create(
                // The registry key. The type of the registry must match the generic type of the tag.
                Registries.ITEM,
                // The location of the tag. This example will put our tag at data/examplemod/tags/blocks/example_tag.json.
                id
        );
    }

    public static void init() {

    }

    public TagKey<Item> get() {
        return tagKey;
    }

    @Override
    public Identifier getId() {
        return id;
    }
}
