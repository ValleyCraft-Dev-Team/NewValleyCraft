package com.valleydevteam.valleycraft;

import com.valleydevteam.valleycraft.datagen.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;

import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = ValleyCraft.MOD_ID)
public class ModDataGen {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        var generator = event.getGenerator();
        var output = generator.getPackOutput();
        var lookup = event.getReloadableLookupProvider();

        generator.addProvider(true, new ModLangProvider(output));
        generator.addProvider(true, new ModModelProvider(output));
        generator.addProvider(true, new ModBlockTagsProvider(output, lookup));
        generator.addProvider(true, new ModItemTagsProvider(output, lookup));
    }

    @SubscribeEvent
    public static void gatherLootTables(GatherDataRegistryEntriesEvent event) {
        event.add(Registries.LOOT_TABLE, new LootTableProvider(
                Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(ValleyCraftBlockLoot::new, LootContextParamSets.BLOCK))
        ));
    }
}
