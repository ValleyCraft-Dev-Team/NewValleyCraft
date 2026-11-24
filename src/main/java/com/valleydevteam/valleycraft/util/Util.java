package com.valleydevteam.valleycraft.util;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.Nullable;
import java.util.Set;

import static io.netty.util.ResourceLeakDetector.getLevel;

public class Util {

    public static boolean inWater(BlockPlaceContext context) {
        return context.getLevel().getFluidState(context.getClickedPos()).is(Fluids.WATER);
    }


    // List of minor words that should stay lowercase
    private static final Set<String> minorWords = Set.of(
            "a", "an", "the", "of", "in", "on", "at", "and", "but", "for", "or", "nor", "to", "with", "by"
    );

    public static String toText(Identifier id) {
        return toText(id.getPath());
    }

    public static String toText(@Nullable String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        var words = input.split("_");
        var result = new StringBuilder();
        var appended = false;

        for (int i = 0; i < words.length; i++) {
            var word = words[i];

            if (word.isEmpty()) continue;

            // If it's a minor word and NOT at the start or end, keep it lowercase
            if (minorWords.contains(word) && i != 0 && i != words.length - 1) {
                result.append(word).append(' ');
            } else {
                // Capitalize the first letter
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(' ');
            }

            appended = true;
        }

        if (appended) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}
