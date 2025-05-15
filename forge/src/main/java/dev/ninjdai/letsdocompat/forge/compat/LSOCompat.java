package dev.ninjdai.letsdocompat.forge.compat;

import dev.ninjdai.letsdocompat.DoAddonExpectPlatform;
import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;
import sfiomn.legendarysurvivaloverhaul.config.json.JsonConfig;

public class LSOCompat {
    public static void init() {
        return;
        if (!DoAddonExpectPlatform.isModLoaded("legendarysurvivaloverhaul")) return;

        if (DoAddonExpectPlatform.isModLoaded("candlelight")) initCandlelight();
        if (DoAddonExpectPlatform.isModLoaded("farm_and_charm")) initFarmAndCharm();
        if (DoAddonExpectPlatform.isModLoaded("herbalbrews")) initHerbalBrews();
        if (DoAddonExpectPlatform.isModLoaded("meadow")) initMeadow();
        if (DoAddonExpectPlatform.isModLoaded("wildernature")) initWilderNature();
    }

    private static void initCandlelight() {
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "candlelight:tomato_soup", 1, 3000);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "candlelight:mushroom_soup", 1, 3000);

        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "candlelight:mozzarella", -1, 600);
    }

    private static void initFarmAndCharm() {
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "farm_and_charm:simple_tomato_soup", 1, 3000);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "farm_and_charm:barley_soup", 1, 3000);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "farm_and_charm:onion_soup", 1, 3000);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "farm_and_charm:potato_soup", 1, 3000);
        JsonConfig.registerConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "farm_and_charm:goulash", 1, 3000);
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
    }

    private static void initMeadow() {
        JsonConfig.registerItemTemperature("meadow:fur_boots", 0, 0f, 0.5f, 0f);
        JsonConfig.registerItemTemperature("meadow:fur_chestplate", 0, 0f, 3f, 0f);
        JsonConfig.registerItemTemperature("meadow:fur_helmet", 0, 0f, 1.5f, 0f);
        JsonConfig.registerItemTemperature("meadow:fur_leggings", 0, 0f, 2.5f, 0f);
    }

    private static void initWilderNature() {
        JsonConfig.registerItemTemperature("wildernature:fur_cloak", 0, 0f,3f, 0f);
    }
}
