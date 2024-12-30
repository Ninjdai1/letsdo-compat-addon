package dev.ninjdai.letsdocompat.forge.compat;

import dev.ninjdai.letsdocompat.DoAddonExpectPlatform;
import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;
import sfiomn.legendarysurvivaloverhaul.config.json.JsonConfig;

public class LSOCompat {
    public static void init() {
        if (!DoAddonExpectPlatform.isModLoaded("legendarysurvivaloverhaul")) return;

        if (DoAddonExpectPlatform.isModLoaded("brewery")) initBrewery();
        if (DoAddonExpectPlatform.isModLoaded("candlelight")) initCandlelight();
        if (DoAddonExpectPlatform.isModLoaded("cornexpansion")) initCornExpansion();
        if (DoAddonExpectPlatform.isModLoaded("farm_and_charm")) initFarmAndCharm();
        if (DoAddonExpectPlatform.isModLoaded("herbalbrews")) initHerbalBrews();
        if (DoAddonExpectPlatform.isModLoaded("meadow")) initMeadow();
        if (DoAddonExpectPlatform.isModLoaded("vinery")) initVinery();
        if (DoAddonExpectPlatform.isModLoaded("wildernature")) initWilderNature();
    }

    private static void initBrewery() {
        JsonConfig.registerConsumableThirst("brewery:beer_wheat", 4, 2.0f);
        JsonConfig.registerConsumableThirst("brewery:beer_barley", 4, 2.0f);
        JsonConfig.registerConsumableThirst("brewery:beer_hops", 4, 2.0f);
        JsonConfig.registerConsumableThirst("brewery:beer_nettle", 4, 2.0f);
        JsonConfig.registerConsumableThirst("brewery:beer_oat", 4, 2.0f);
        JsonConfig.registerConsumableThirst("brewery:beer_haley", 4, 2.0f);

        JsonConfig.registerConsumableThirst("brewery:whiskey_jojannik", 3, 2.0f);
        JsonConfig.registerConsumableThirst("brewery:whiskey_lilitusinglemalt", 3, 2.0f);
        JsonConfig.registerConsumableThirst("brewery:whiskey_cristelwalker", 3, 2.0f);
        JsonConfig.registerConsumableThirst("brewery:whiskey_maggoallan", 3, 2.0f);
        JsonConfig.registerConsumableThirst("brewery:whiskey_carrasconlabel", 3, 2.0f);
        JsonConfig.registerConsumableThirst("brewery:whiskey_ak", 3, 2.0f);
        JsonConfig.registerConsumableThirst("brewery:whiskey_highland_hearth", 3, 2.0f);
        JsonConfig.registerConsumableThirst("brewery:whiskey_smokey_reverie", 3, 2.0f);
        JsonConfig.registerConsumableThirst("brewery:whiskey_jamesons_malt", 3, 2.0f);
    }

    private static void initCandlelight() {
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "candlelight:tomato_soup", 1, 3000);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "candlelight:mushroom_soup", 1, 3000);
        JsonConfig.registerConsumableThirst("candlelight:tomato_soup", 4, 2.0f);
        JsonConfig.registerConsumableThirst("candlelight:mushroom_soup", 4, 2.0f);

        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "candlelight:mozzarella", -1, 600);
        JsonConfig.registerConsumableThirst("candlelight:mozzarella", 1, 0.5f);
    }

    private static void initCornExpansion() {
        JsonConfig.registerConsumableThirst("cornexpansion:corn_syrup", 1, 0f);
    }

    private static void initFarmAndCharm() {
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "farm_and_charm:simple_tomato_soup", 1, 3000);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "farm_and_charm:barley_soup", 1, 3000);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "farm_and_charm:onion_soup", 1, 3000);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "farm_and_charm:potato_soup", 1, 3000);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "farm_and_charm:goulash", 1, 3000);
        JsonConfig.registerConsumableThirst("farm_and_charm:simple_tomato_soup", 4, 2.0f);
        JsonConfig.registerConsumableThirst("farm_and_charm:barley_soup", 4, 2.0f);
        JsonConfig.registerConsumableThirst("farm_and_charm:onion_soup", 4, 2.0f);
        JsonConfig.registerConsumableThirst("farm_and_charm:potato_soup", 4, 2.0f);
        JsonConfig.registerConsumableThirst("farm_and_charm:goulash", 4, 2.0f);

        JsonConfig.registerConsumableThirst("farm_and_charm:strawberry_tea", 3, 1.0f);
        JsonConfig.registerConsumableThirst("farm_and_charm:nettle_tea", 3, 1.0f);
        JsonConfig.registerConsumableThirst("farm_and_charm:ribwort_tea", 3, 1.0f);
        JsonConfig.registerConsumableThirst("farm_and_charm:strawberry_tea_cup", 3, 1.0f);
        JsonConfig.registerConsumableThirst("farm_and_charm:nettle_tea_cup", 3, 1.0f);
        JsonConfig.registerConsumableThirst("farm_and_charm:ribwort_tea_cup", 3, 1.0f);
    }

    private static void initHerbalBrews() {
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "herbalbrews:green_tea", 1, 1800);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "herbalbrews:black_tea", 1, 1800);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "herbalbrews:hibiscus_tea", 1, 1800);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "herbalbrews:lavender_tea", 1, 1800);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "herbalbrews:yerba_mate_tea", 1, 1800);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "herbalbrews:rooibos_tea", 1, 1800);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "herbalbrews:oolong_tea", 1, 1800);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "herbalbrews:coffee", 1, 1800);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "herbalbrews:milk_coffee", 1, 1800);
        JsonConfig.registerConsumableThirst("herbalbrews:green_tea", 5, 3.0f);
        JsonConfig.registerConsumableThirst("herbalbrews:black_tea", 5, 3.0f);
        JsonConfig.registerConsumableThirst("herbalbrews:hibiscus_tea", 5, 3.0f);
        JsonConfig.registerConsumableThirst("herbalbrews:lavender_tea", 5, 3.0f);
        JsonConfig.registerConsumableThirst("herbalbrews:yerba_mate_tea", 5, 3.0f);
        JsonConfig.registerConsumableThirst("herbalbrews:rooibos_tea", 5, 3.0f);
        JsonConfig.registerConsumableThirst("herbalbrews:oolong_tea", 5, 3.0f);
        JsonConfig.registerConsumableThirst("herbalbrews:coffee", 4, 2.0f);
        JsonConfig.registerConsumableThirst("herbalbrews:milk_coffee", 4, 2.0f);

        JsonConfig.registerConsumableThirst("herbalbrews:armor_flask", 4, 2.0f);
        JsonConfig.registerConsumableThirst("herbalbrews:armor_flask_big", 5, 3.0f);
        JsonConfig.registerConsumableThirst("herbalbrews:damage_flask", 4, 2.0f);
        JsonConfig.registerConsumableThirst("herbalbrews:famage_flask_big", 5, 3.0f);
        JsonConfig.registerConsumableThirst("herbalbrews:feral_flask", 4, 2.0f);
        JsonConfig.registerConsumableThirst("herbalbrews:feral_flask_big", 5, 3.0f);
    }

    private static void initMeadow() {
        JsonConfig.registerConsumableThirst("meadow:wooden_milk_bucket", 3, 1.0f);
        JsonConfig.registerConsumableThirst("meadow:wooden_sheep_milk_bucket", 3, 1.0f);
        JsonConfig.registerConsumableThirst("meadow:wooden_buffalo_milk_bucket", 3, 1.0f);
        JsonConfig.registerConsumableThirst("meadow:wooden_goat_milk_bucket", 3, 1.0f);
        JsonConfig.registerConsumableThirst("meadow:wooden_warped_milk_bucket", 3, 1.0f);
        JsonConfig.registerConsumableThirst("meadow:wooden_grain_milk_bucket", 3, 1.0f);
        JsonConfig.registerConsumableThirst("meadow:wooden_amethyst_milk_bucket", 3, 1.0f);

        JsonConfig.registerItemTemperature("meadow:fur_boots", 0, 0f, 0.5f, 0f);
        JsonConfig.registerItemTemperature("meadow:fur_chestplate", 0, 0f, 3f, 0f);
        JsonConfig.registerItemTemperature("meadow:fur_helmet", 0, 0f, 1.5f, 0f);
        JsonConfig.registerItemTemperature("meadow:fur_leggings", 0, 0f, 2.5f, 0f);
    }

    private static void initWilderNature() {
        JsonConfig.registerItemTemperature("wildernature:fur_cloak", 0, 0f,3f, 0f);
    }

    private static void initVinery() {
        JsonConfig.registerConsumableThirst("vinery:red_grapejuice", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:white_grapejuice", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:red_taiga_grapejuice", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:white_taiga_grapejuice", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:red_jungle_grapejuice", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:white_jungle_grapejuice", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:red_savanna_grapejuice", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:white_savanna_grapejuice", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:apple_juice", 3, 2.0f);

        JsonConfig.registerConsumableThirst("vinery:mead", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:apple_cider", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:apple_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:mellohi_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:glowing_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:solaris_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:noir_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:red_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:strad_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:cherry_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:cristel_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:creepers_crush", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:kelp_cider", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:lilitu_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:jo_special_mixture", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:eiswein", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:aegis_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:bolvar_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:chorus_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:villagers_fright", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:clark_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:magnetic_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:stal_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:chenet_wine", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:bottle_mojang_noir", 3, 2.0f);
        JsonConfig.registerConsumableThirst("vinery:jellie_wine", 3, 2.0f);
    }
}
