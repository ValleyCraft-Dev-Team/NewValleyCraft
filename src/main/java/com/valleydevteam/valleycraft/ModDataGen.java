package com.valleydevteam.valleycraft;

import com.valleydevteam.valleycraft.datagen.ModLangProvider;
import com.valleydevteam.valleycraft.datagen.ModModelProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = ValleyCraft.MOD_ID)
public class ModDataGen {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        var generator = event.getGenerator();
        var output = generator.getPackOutput();

        generator.addProvider(true, new ModLangProvider(output));
        generator.addProvider(true, new ModModelProvider(output));
    }
}
