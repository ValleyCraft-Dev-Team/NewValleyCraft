package com.valleydevteam.valleycraft;

import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.conditions.ICondition;

import java.util.function.Supplier;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

//    public static final ModConfigSpec.BooleanValue OVERRIDE_RECIPES = BUILDER
//            .comment("Whether to override the Minecraft's item recipes with ValleyCraft's")
//            .define("override_minecraft_recipes", true);
//
//    public static final ModConfigSpec.BooleanValue OVERRIDE_LOOT_TABLES = BUILDER
//            .comment("Whether to override the Minecraft's loot tables with ValleyCraft's")
//            .define("override_minecraft_loot_tables", true);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static void init() {
        
    }
}
