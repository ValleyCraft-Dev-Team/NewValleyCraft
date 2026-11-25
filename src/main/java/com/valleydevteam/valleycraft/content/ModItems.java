package com.valleydevteam.valleycraft.content;

import com.valleydevteam.valleycraft.ValleyCraft;
import com.valleydevteam.valleycraft.content.item.RopeItem;
import com.valleydevteam.valleycraft.util.IdProvider;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public enum ModItems implements IdProvider, ItemLike {
    // Foods
    amethistle_salad(p -> food(p, 4, 0.5f)),
    apple_juice(p -> food(p, 2, 0.2f, Consumables.DEFAULT_DRINK)),
    apple_pie(p -> food(p, 4, 0.5f)),
    atole(p -> food(p, 4, 0.5f)),
    baked_apple(p -> food(p, 4, 0.5f)),
    baked_beet(p -> food(p, 4, 0.5f)),
    baked_carrot(p -> food(p, 4, 0.5f)),
    baked_cave_root(p -> food(p, 4, 0.5f)),
    baked_clam(p -> food(p, 4, 0.5f)),
    baked_fire_pepper(p -> food(p, 4, 0.5f)),
    baked_glow_berries(p -> food(p, 4, 0.5f)),
    baked_maize(p -> food(p, 4, 0.5f)),
    baked_onion(p -> food(p, 4, 0.5f)),
    baked_pumpkin_slice(p -> food(p, 4, 0.5f)),
    baked_sweet_berries(p -> food(p, 4, 0.5f)),
    bat_wing(p -> food(p, 4, 0.5f)),
    beef_stew(p -> food(p, 4, 0.5f)),
    bread_slice(p -> food(p, 4, 0.5f)),
    cake_slice(p -> food(p, 4, 0.5f)),
    carrot_juice(p -> food(p, 2, 0.2f, Consumables.DEFAULT_DRINK)),
    cave_root_stir_fry(p -> food(p, 4, 0.5f)),
    cheese_wheel(p -> food(p, 4, 0.5f)),
    cheese_wheel_slice(p -> food(p, 4, 0.5f)),
    chicken_pot_pie(p -> food(p, 4, 0.5f)),
    chicken_soup(p -> food(p, 4, 0.5f)),
    chocolate(p -> food(p, 4, 0.5f)),
    chocolate_cake(p -> food(p, 4, 0.5f)),
    chocolate_cake_slice(p -> food(p, 4, 0.5f)),
    clam_chowder(p -> food(p, 4, 0.5f)),
    cooked_abysswatcher(p -> food(p, 4, 0.5f)),
    cooked_drumstick(p -> food(p, 4, 0.5f)),
    cooked_goldfin(p -> food(p, 4, 0.5f)),
    cooked_heart(p -> food(p, 4, 0.5f)),
    cooked_meat(p -> food(p, 4, 0.5f)),
    cooked_monster_guts(p -> food(p, 4, 0.5f)),
    cooked_perch(p -> food(p, 4, 0.5f)),
    cooked_red_porgy(p -> food(p, 4, 0.5f)),
    cooked_sardine(p -> food(p, 4, 0.5f)),
    cooked_spider_stomach(p -> food(p, 4, 0.5f)),
    cooked_stonetosser_minnow(p -> food(p, 4, 0.5f)),
    cooked_tentacle(p -> food(p, 4, 0.5f)),
    cooked_transparent_lionfish(p -> food(p, 4, 0.5f)),
    cooked_tropical_fish(p -> food(p, 4, 0.5f)),
    cured_fish(p -> food(p, 4, 0.5f)),
    cured_flesh(p -> food(p, 4, 0.5f)),
    dinner_rabbit(p -> food(p, 4, 0.5f)),
    dog_biscuit(p -> food(p, 4, 0.5f)),
    dragonblossom_soup(p -> food(p, 4, 0.5f)),
    eggs_and_rice(p -> food(p, 4, 0.5f)),
    egg_toast(p -> food(p, 4, 0.5f)),
    fairy_bread(p -> food(p, 4, 0.5f)),
    fire_pepper(p -> food(p, 4, 0.5f)),
    fish_sandwich(p -> food(p, 4, 0.5f)),
    fried_egg(p -> food(p, 4, 0.5f)),
    fruit_mix(p -> food(p, 4, 0.5f)),
    fungus_stir_fry(p -> food(p, 4, 0.5f)),
    glistening_watermelon_juice(p -> food(p, 2, 0.2f, Consumables.DEFAULT_DRINK)),
    glow_berry_egg_pudding(p -> food(p, 4, 0.5f)),
    glow_berry_juice(p -> food(p, 2, 0.2f, Consumables.DEFAULT_DRINK)),
    glow_berry_pie(p -> food(p, 4, 0.5f)),
    glow_squid_soup(p -> food(p, 4, 0.5f)),
    golden_beet(p -> food(p, 4, 0.5f)),
    golden_cave_root(p -> food(p, 4, 0.5f)),
    golden_chorus_fruit(p -> food(p, 4, 0.5f)),
    golden_fire_pepper(p -> food(p, 4, 0.5f)),
    golden_glow_berries(p -> food(p, 4, 0.5f)),
    golden_maize(p -> food(p, 4, 0.5f)),
    golden_onion(p -> food(p, 4, 0.5f)),
    golden_potato(p -> food(p, 4, 0.5f)),
    golden_pumpkin_slice(p -> food(p, 4, 0.5f)),
    golden_sweet_berries(p -> food(p, 4, 0.5f)),
    grilled_bat_wing(p -> food(p, 4, 0.5f)),
    grilled_cheese_sandwich(p -> food(p, 4, 0.5f)),
    grilled_frog_legs(p -> food(p, 4, 0.5f)),
    grilled_silverfish(p -> food(p, 4, 0.5f)),
    grilled_watermelon(p -> food(p, 4, 0.5f)),
    hearty_beet_stew(p -> food(p, 4, 0.5f)),
    hearty_breakfast(p -> food(p, 4, 0.5f)),
    honeyed_apple(p -> food(p, 4, 0.5f)),
    kelp_salad(p -> food(p, 4, 0.5f)),
    milk(p -> food(p, 4, 0.5f)),
    milk_chocolate(p -> food(p, 4, 0.5f)),
    miners_lettuce(p -> food(p, 4, 0.5f)),
    monster_stew(p -> food(p, 4, 0.5f)),
    mushroom_fried_rice(p -> food(p, 4, 0.5f)),
    omelette(p -> food(p, 4, 0.5f)),
    onion(p -> food(p, 4, 0.5f)),
    perch(p -> food(p, 4, 0.5f)),
    puffball(p -> food(p, 4, 0.5f)),
    pumpkin_slice(p -> food(p, 4, 0.5f)),
    pumpkin_soup(p -> food(p, 4, 0.5f)),
    raw_drumstick(p -> food(p, 4, 0.5f)),
    raw_frog_legs(p -> food(p, 4, 0.5f)),
    raw_heart(p -> food(p, 4, 0.5f)),
    raw_meat(p -> food(p, 4, 0.5f)),
    raw_sardine(p -> food(p, 4, 0.5f)),
    raw_silverfish(p -> food(p, 4, 0.5f)),
    raw_stonetosser_minnow(p -> food(p, 4, 0.5f)),
    red_porgy(p -> food(p, 4, 0.5f)),
    rice(p -> food(p, 4, 0.5f)),
    salmon_pie(p -> food(p, 4, 0.5f)),
    sandwich(p -> food(p, 4, 0.5f)),
    sauteed_eyes_and_mushrooms(p -> food(p, 4, 0.5f)),
    savory_breakfast(p -> food(p, 4, 0.5f)),
    savory_shroom_skewer(p -> food(p, 4, 0.5f)),
    slime_delight(p -> food(p, 4, 0.5f)),
    slime_soup(p -> food(p, 4, 0.5f)),
    spicy_calamari_skewer(p -> food(p, 4, 0.5f)),
    spicy_fried_salmon(p -> food(p, 4, 0.5f)),
    spicy_grilled_lamb(p -> food(p, 4, 0.5f)),
    spicy_potatoes_and_bat(p -> food(p, 4, 0.5f)),
    spicy_potatoes_and_carrots(p -> food(p, 4, 0.5f)),
    spicy_rabbit_risotto(p -> food(p, 4, 0.5f)),
    spider_stomach(p -> food(p, 4, 0.5f)),
    squid_soup(p -> food(p, 4, 0.5f)),
    steamed_rice(p -> food(p, 4, 0.5f)),
    steamed_vegetables(p -> food(p, 4, 0.5f)),
    stuffed_baked_potato(p -> food(p, 4, 0.5f)),
    stuffed_onion(p -> food(p, 4, 0.5f)),
    sugar_cookie(p -> food(p, 4, 0.5f)),
    sweet_berry_juice(p -> food(p, 2, 0.2f, Consumables.DEFAULT_DRINK)),
    sweet_berry_pie(p -> food(p, 4, 0.5f)),
    sweet_chicken_risotto(p -> food(p, 4, 0.5f)),
    tropical_salad(p -> food(p, 4, 0.5f)),
    transparent_lionfish(p -> food(p, 4, 0.5f)),
    tube_worms(p -> food(p, 4, 0.5f)),
    vegetable_mix(p -> food(p, 4, 0.5f)),

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
    applewood_door,
    applewood_sign,
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
    cobblestone_rock,
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
    deepslate_rock,
    diamond_coated_metal_plate,
    diamond_knife,
    diamond_sickle,
    disc_ancient_loop,
    dragonbloom,
    dragon_tooth,
    dripleaf_hat,
    dripstone_rock,
    duck_egg,
    duck_feather,
    elder_guardian_barb,
    emerald_talisman,
    empty_book,
    enderman_eye,
    endermite_carapace,
    endstone_rock,
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
    glowberry_lantern,
    glow_berry_pie_dough,
    glowing_mushroom_lamp,
    glowsquid_lantern,
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
    netherack_rock,
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
    redstone_lantern,
    resonating_dust,
    ribcage,
    ribcage_withered,
    rice_seeds,
    rock,
    rope_bundle(false, RopeItem::new, p -> p),
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
        this(false, p -> p);
    }

    ModItems(UnaryOperator<Item.Properties> propsFun) {
        this(false, Item::new, propsFun);
    }

    ModItems(Function<Item.Properties, ? extends Item> itemFun, UnaryOperator<Item.Properties> itemPropsFun) {
        this(false, itemFun, itemPropsFun);
    }

    ModItems(boolean useCustomModel) {
        this(useCustomModel, p -> p);
    }

    ModItems(boolean useCustomModel, UnaryOperator<Item.Properties> propsFun) {
        this(useCustomModel, Item::new, propsFun);
    }

    ModItems(boolean useCustomModel, Function<Item.Properties, ? extends Item> itemFun, UnaryOperator<Item.Properties> itemPropsFun) {
        this.useDataGen = !useCustomModel;
        this.id = ValleyCraft.makeId(name());
        this.itemFun = itemFun;
        this.itemPropsFun = itemPropsFun;
    }

    public static void init(DeferredRegister.Items items) {
        for (var item : values()) {
            item.load(items);
            itemMap.put(item.name(), item.getItem());
        }
    }

    private void load(DeferredRegister.Items items) {
        item = items.registerItem(name(), itemFun, itemPropsFun);
    }

    private static Item.Properties food(Item.Properties p, int nut, float sat) {
        return p.food(new FoodProperties(nut, sat, true));
    }

    private static Item.Properties food(Item.Properties p, int nut, float sat, Consumable c) {
        return p.food(new FoodProperties(nut, sat, true), c);
    }

    public static DeferredItem<Item> get(String name) {
        return itemMap.get(name);
    }

    private DeferredItem<Item> item;
    private final Identifier id;
    private final boolean useDataGen;
    private final Function<Item.Properties, ? extends Item> itemFun;
    private final UnaryOperator<Item.Properties> itemPropsFun;

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
