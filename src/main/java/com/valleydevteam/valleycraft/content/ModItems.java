package com.valleydevteam.valleycraft.content;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.content.item.RopeItem;
import com.valleydevteam.valleycraft.util.IdProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.valleydevteam.valleycraft.content.MoreItems.*;

public enum ModItems implements IdProvider, ItemLike {
    // Foods
    amethistle_salad(() -> food(4, 0.5f)),
    apple_juice(() -> food(2, 0.2f, Consumables.DEFAULT_DRINK)),
    apple_pie(() -> food(4, 0.5f)),
    atole(() -> food(4, 0.5f)),
    baked_apple(() -> food(4, 0.5f)),
    baked_beet(() -> food(4, 0.5f)),
    baked_carrot(() -> food(4, 0.5f)),
    baked_cave_root(() -> food(4, 0.5f)),
    baked_clam(() -> food(4, 0.5f)),
    baked_fire_pepper(() -> food(4, 0.5f)),
    baked_glow_berries(() -> food(4, 0.5f)),
    baked_maize(() -> food(4, 0.5f)),
    baked_onion(() -> food(4, 0.5f)),
    baked_pumpkin_slice(() -> food(4, 0.5f)),
    baked_sweet_berries(() -> food(4, 0.5f)),
    bat_wing(() -> food(4, 0.5f)),
    beef_stew(() -> food(4, 0.5f)),
    bread_slice(() -> food(4, 0.5f)),
    cake_slice(() -> food(4, 0.5f)),
    carrot_juice(() -> food(2, 0.2f, Consumables.DEFAULT_DRINK)),
    cave_root_stir_fry(() -> food(4, 0.5f)),
    cheese_wheel(() -> food(4, 0.5f)),
    cheese_wheel_slice(() -> food(4, 0.5f)),
    chicken_pot_pie(() -> food(4, 0.5f)),
    chicken_soup(() -> food(4, 0.5f)),
    chocolate(() -> food(4, 0.5f)),
    chocolate_cake(() -> food(4, 0.5f)),
    chocolate_cake_slice(() -> food(4, 0.5f)),
    clam_chowder(() -> food(4, 0.5f)),
    cooked_abysswatcher(() -> food(4, 0.5f)),
    cooked_drumstick(() -> food(4, 0.5f)),
    cooked_goldfin(() -> food(4, 0.5f)),
    cooked_heart(() -> food(4, 0.5f)),
    cooked_meat(() -> food(4, 0.5f)),
    cooked_monster_guts(() -> food(4, 0.5f)),
    cooked_perch(() -> food(4, 0.5f)),
    cooked_red_porgy(() -> food(4, 0.5f)),
    cooked_sardine(() -> food(4, 0.5f)),
    cooked_spider_stomach(() -> food(4, 0.5f)),
    cooked_stonetosser_minnow(() -> food(4, 0.5f)),
    cooked_tentacle(() -> food(4, 0.5f)),
    cooked_transparent_lionfish(() -> food(4, 0.5f)),
    cooked_tropical_fish(() -> food(4, 0.5f)),
    cured_fish(() -> food(4, 0.5f)),
    cured_flesh(() -> food(4, 0.5f)),
    dinner_rabbit(() -> food(4, 0.5f)),
    dog_biscuit(() -> food(4, 0.5f)),
    dragonblossom_soup(() -> food(4, 0.5f)),
    eggs_and_rice(() -> food(4, 0.5f)),
    egg_toast(() -> food(4, 0.5f)),
    fairy_bread(() -> food(4, 0.5f)),
    fire_pepper(() -> food(4, 0.5f)),
    fish_sandwich(() -> food(4, 0.5f)),
    fried_egg(() -> food(4, 0.5f)),
    fruit_mix(() -> food(4, 0.5f)),
    fungus_stir_fry(() -> food(4, 0.5f)),
    glistening_watermelon_juice(() -> food(2, 0.2f, Consumables.DEFAULT_DRINK)),
    glow_berry_egg_pudding(() -> food(4, 0.5f)),
    glow_berry_juice(() -> food(2, 0.2f, Consumables.DEFAULT_DRINK)),
    glow_berry_pie(() -> food(4, 0.5f)),
    glow_squid_soup(() -> food(4, 0.5f)),
    golden_beet(() -> food(4, 0.5f)),
    golden_cave_root(() -> food(4, 0.5f)),
    golden_chorus_fruit(() -> food(4, 0.5f)),
    golden_fire_pepper(() -> food(4, 0.5f)),
    golden_glow_berries(() -> food(4, 0.5f)),
    golden_maize(() -> food(4, 0.5f)),
    golden_onion(() -> food(4, 0.5f)),
    golden_potato(() -> food(4, 0.5f)),
    golden_pumpkin_slice(() -> food(4, 0.5f)),
    golden_sweet_berries(() -> food(4, 0.5f)),
    grilled_bat_wing(() -> food(4, 0.5f)),
    grilled_cheese_sandwich(() -> food(4, 0.5f)),
    grilled_frog_legs(() -> food(4, 0.5f)),
    grilled_silverfish(() -> food(4, 0.5f)),
    grilled_watermelon(() -> food(4, 0.5f)),
    hearty_beet_stew(() -> food(4, 0.5f)),
    hearty_breakfast(() -> food(4, 0.5f)),
    honeyed_apple(() -> food(4, 0.5f)),
    kelp_salad(() -> food(4, 0.5f)),
    milk(() -> food(4, 0.5f)),
    milk_chocolate(() -> food(4, 0.5f)),
    miners_lettuce(() -> food(4, 0.5f)),
    monster_stew(() -> food(4, 0.5f)),
    mushroom_fried_rice(() -> food(4, 0.5f)),
    omelette(() -> food(4, 0.5f)),
    onion(() -> food(4, 0.5f)),
    perch(() -> food(4, 0.5f)),
    puffball(() -> food(4, 0.5f)),
    pumpkin_slice(() -> food(4, 0.5f)),
    pumpkin_soup(() -> food(4, 0.5f)),
    raw_drumstick(() -> food(4, 0.5f)),
    raw_frog_legs(() -> food(4, 0.5f)),
    raw_heart(() -> food(4, 0.5f)),
    raw_meat(() -> food(4, 0.5f)),
    raw_sardine(() -> food(4, 0.5f)),
    raw_silverfish(() -> food(4, 0.5f)),
    raw_stonetosser_minnow(() -> food(4, 0.5f)),
    red_porgy(() -> food(4, 0.5f)),
    rice(() -> food(4, 0.5f)),
    salmon_pie(() -> food(4, 0.5f)),
    sandwich(() -> food(4, 0.5f)),
    sauteed_eyes_and_mushrooms(() -> food(4, 0.5f)),
    savory_breakfast(() -> food(4, 0.5f)),
    savory_shroom_skewer(() -> food(4, 0.5f)),
    slime_delight(() -> food(4, 0.5f)),
    slime_soup(() -> food(4, 0.5f)),
    spicy_calamari_skewer(() -> food(4, 0.5f)),
    spicy_fried_salmon(() -> food(4, 0.5f)),
    spicy_grilled_lamb(() -> food(4, 0.5f)),
    spicy_potatoes_and_bat(() -> food(4, 0.5f)),
    spicy_potatoes_and_carrots(() -> food(4, 0.5f)),
    spicy_rabbit_risotto(() -> food(4, 0.5f)),
    spider_stomach(() -> food(4, 0.5f)),
    squid_soup(() -> food(4, 0.5f)),
    steamed_rice(() -> food(4, 0.5f)),
    steamed_vegetables(() -> food(4, 0.5f)),
    stuffed_baked_potato(() -> food(4, 0.5f)),
    stuffed_onion(() -> food(4, 0.5f)),
    sugar_cookie(() -> food(4, 0.5f)),
    sweet_berry_juice(() -> food(2, 0.2f, Consumables.DEFAULT_DRINK)),
    sweet_berry_pie(() -> food(4, 0.5f)),
    sweet_chicken_risotto(() -> food(4, 0.5f)),
    tropical_salad(() -> food(4, 0.5f)),
    transparent_lionfish(() -> food(4, 0.5f)),
    tube_worms(() -> food(4, 0.5f)),
    vegetable_mix(() -> food(4, 0.5f)),

    // Items
    abysswatcher,
    agitator,
    amethistle,
    amethyst_talisman,
    amethyst_spear_tip,
    ancient_boots,
    ancient_coin,
    ancient_scroll,
    ancient_shoes,
    apple_pie_dough,
    azalea_flower_crown,
    baked_pumpkin_seeds,
    bamboo_staff(true),
    belt,
    bonefin,
    bone_withered,
    bow_leveled,
    bow_shortbow,
    bread_dough,
    breeze_powder,
    bucket_of_abysswatcher,
    bucket_of_bonefin,
    bucket_of_dye_remover,
    bucket_of_goldfin,
    bucket_of_perch,
    bucket_of_red_porgy,
    bucket_of_sardine,
    bucket_of_stonetosser_minnow,
    bunk_bed_ladder_frame,
    cake_dough,
    calibrated_clock_components,
    calibrated_compass_needle,
    cattails,
    cave_root,
    chainmail_segment,
    champions_cloak,
    champions_hood,
    chefs_apron,
    chefs_hat,
    chickadee_feather,
    chicken_pot_pie_dough,
    chocolate_cake_dough,
    clam_shell_breastplate,
    cloth_segment,
    conductive_stone_plate,
    cookie_dough,
    copper_knife,
    copper_sickle,
    coral_knife_blue,
    coral_knife_orange,
    cowpoke_hat,
    crafting_mat,
    crafting_tools,
    crow_feather,
    cutlass_enhanced,
    cutlass,
    cutlass_restored,
    daerdri_talisman,
    daub,
    diamond_coated_metal_plate,
    diamond_knife,
    diamond_sickle,
    disc_ancient_loop,
    dragonbloom,
    dragon_tooth,
    dripleaf_hat,
    duck_egg,
    duck_feather,
    elder_guardian_barb,
    emerald_talisman,
    empty_book,
    enderman_eye,
    endermite_carapace,
    etheric_dust,
    fairy_bottle,
    farmers_straw_hat,
    fiber,
    fiber_skirt,
    fiber_top,
    fire_pepper_seeds,
    fishing_hook,
    fishing_wheel,
    flaming_cauldron,
    flour,
    frost_talisman,
    glass_door,
    glow_ball,
    glow_berry_pie_dough,
    glowing_mushroom_lamp,
    glow_squid_tentacle,
    golden_glasses,
    golden_knife,
    golden_monocle_opposite,
    golden_monocle,
    golden_sickle,
    goldfin,
    guardian_barb,
    hanger_lantern,
    healers_cloak,
    healers_hood,
    horse_shoes,
    ice_tongs,
    infected_guts,
    infected_heart,
    ink,
    iron_knife,
    jungle_seeds,
    lapis_face_paint,
    leather_strap,
    lily_pad_hat,
    maize_bread_dough,
    maize_bread,
    maize_flour,
    maize,
    mask,
    nature_sickle,
    netherite_knife,
    netherite_sickle,
    net,
    oak_door_solid_item,
    oar,
    oil_purple_mushroom,
    onion_seeds,
    phantom_eye,
    piglin_kilt,
    piglin_tunic,
    pillager_boots,
    pillager_clothing,
    pillager_tunic,
    plant_fiber_canvas,
    plant_fiber_string,
    puff_ball_seeds,
    pumpkin_pie_dough,
    quill,
    resonating_dust,
    ribcage,
    ribcage_withered,
    rice_seeds,
    rope_bundle(false, RopeItem::new, item()),
    rough_diamond,
    rough_emerald,
    runecalling_tome,
    salmon_pie_dough,
    salt_crystals,
    saltpeter,
    seafarers_cap,
    seagull_feather,
    seed_ancient_bulbs,
    shroomleather_cloak,
    shroom_leather_cured,
    shroomleather_hood,
    shroom_leather,
    shroomleather_sandals,
    single_use_fire_starter,
    skull_fragment,
    skull_fragment_withered,
    slime_egg,
    small_bone,
    small_wither_bone,
    smithing_mask,
    smithing_tools,
    soul_flaming_cauldron,
    soul,
    spike_trap,
    squid_rolls,
    squid_tentacle,
    stone_knife,
    stone_sickle,
    sugar_cookie_dough,
    sweet_berry_pie_dough,
    thermal_core,
    totem_of_knowledge,
    totem_of_rain,
    totem_of_undying_talisman,
    trail_mix,
    trash,
    turtle_shell,
    undergarments_femme,
    undergarments_masc,
    undergarments_neutral,
    unique_painting,
    urn_pottery_sherd,
    vine_laurel,
    warm_boots,
    waxed_string,
    wood_dowel,
    wooden_knife,
    wooden_sickle,
    wooden_staff(true);

    private static final HashMap<String, DeferredItem<Item>> itemMap = new HashMap<>();


    ModItems() {
        this(false, item());
    }

    ModItems(Supplier<Item.Properties> propsSub) {
        this(false, Item::new, propsSub);
    }

    ModItems(Function<Item.Properties, Item> itemFun, Supplier<Item.Properties> propsSub) {
        this(false, itemFun, propsSub);
    }

    ModItems(boolean useCustomModel) {
        this(useCustomModel, item());
    }

    ModItems(boolean useCustomModel, Supplier<Item.Properties> propsSub) {
        this(useCustomModel, Item::new, propsSub);
    }

    ModItems(boolean useCustomModel, Function<Item.Properties, Item> itemFun, Supplier<Item.Properties> propsSub) {
        this.useDataGen = !useCustomModel;
        this.id = ValleyCraft.makeId(name());
        this.itemFun = itemFun;
        this.itemPropsSub = propsSub;
    }

    public static void init(DeferredRegister.Items items) {
        for (var item : values()) {
            item.load(items);
        }
    }

    private void load(DeferredRegister.Items items) {
        item = items.registerItem(name(), itemFun, itemPropsSub);
        itemMap.put(name(), item);
    }

    public static DeferredItem<Item> get(String name) {
        return itemMap.get(name);
    }

    private DeferredItem<Item> item;
    private final Identifier id;
    private final boolean useDataGen;
    private final Function<Item.Properties, Item> itemFun;
    private final Supplier<Item.Properties> itemPropsSub;

    public Item get() {
        return item.get();
    }

    public DeferredItem<Item> getItem() {
        return item;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public Item asItem() {
        return item.get();
    }

    public ItemStack getStack() {
        return get().getDefaultInstance();
    }

    public boolean useDataGen() {
        return useDataGen;
    }

    public ResourceKey<Item> getItemRK() {
        return item.key();
    }
}
