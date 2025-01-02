package dev.ninjdai.letsdocompat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThirstCompatHelper {
    private static final Map<String, Number[]> DRINKS = new HashMap<>();
    private static final Map<String, Number[]> FOODS = new HashMap<>();

    public static void init() {
        for (String itemName: DRINKS.keySet()) {
            DoAddonExpectPlatform.addItemCompat(itemName, DRINKS.get(itemName), ItemType.DRINK);
        }
        for (String itemName: FOODS.keySet()) {
            DoAddonExpectPlatform.addItemCompat(itemName, FOODS.get(itemName), ItemType.DRINK);
        }
    }

    public static void registerDrinkThirst(String itemName, int thirst, float quench) {
        DRINKS.put(itemName, List.of(thirst, quench).toArray(new Number[0]));
    }

    public static void registerFoodThirst(String itemName, int thirst, float quench) {
        FOODS.put(itemName, List.of(thirst, quench).toArray(new Number[0]));
    }

    static {
        if (DoAddonExpectPlatform.isModLoaded("brewery")) {
            registerDrinkThirst("brewery:beer_wheat", 4, 2.0f);
            registerDrinkThirst("brewery:beer_barley", 4, 2.0f);
            registerDrinkThirst("brewery:beer_hops", 4, 2.0f);
            registerDrinkThirst("brewery:beer_nettle", 4, 2.0f);
            registerDrinkThirst("brewery:beer_oat", 4, 2.0f);
            registerDrinkThirst("brewery:beer_haley", 4, 2.0f);

            registerDrinkThirst("brewery:whiskey_jojannik", 3, 2.0f);
            registerDrinkThirst("brewery:whiskey_lilitusinglemalt", 3, 2.0f);
            registerDrinkThirst("brewery:whiskey_cristelwalker", 3, 2.0f);
            registerDrinkThirst("brewery:whiskey_maggoallan", 3, 2.0f);
            registerDrinkThirst("brewery:whiskey_carrasconlabel", 3, 2.0f);
            registerDrinkThirst("brewery:whiskey_ak", 3, 2.0f);
            registerDrinkThirst("brewery:whiskey_highland_hearth", 3, 2.0f);
            registerDrinkThirst("brewery:whiskey_smokey_reverie", 3, 2.0f);
            registerDrinkThirst("brewery:whiskey_jamesons_malt", 3, 2.0f);
        }

        if (DoAddonExpectPlatform.isModLoaded("beachparty")) {
            registerDrinkThirst("beachparty:coconut_open", 2, 1.0f);
        }

        if (DoAddonExpectPlatform.isModLoaded("candlelight")) {
            registerFoodThirst("candlelight:tomato_soup", 4, 2.0f);
            registerFoodThirst("candlelight:mushroom_soup", 4, 2.0f);

            registerFoodThirst("candlelight:mozzarella", 1, 0.5f);
        }

        if (DoAddonExpectPlatform.isModLoaded("cornexpansion")) {
            registerDrinkThirst("cornexpansion:corn_syrup", 1, 0f);
        }

        if (DoAddonExpectPlatform.isModLoaded("farm_and_charm")) {
            registerFoodThirst("farm_and_charm:simple_tomato_soup", 4, 2.0f);
            registerFoodThirst("farm_and_charm:barley_soup", 4, 2.0f);
            registerFoodThirst("farm_and_charm:onion_soup", 4, 2.0f);
            registerFoodThirst("farm_and_charm:potato_soup", 4, 2.0f);
            registerFoodThirst("farm_and_charm:goulash", 4, 2.0f);

            registerDrinkThirst("farm_and_charm:strawberry_tea", 3, 1.0f);
            registerDrinkThirst("farm_and_charm:nettle_tea", 3, 1.0f);
            registerDrinkThirst("farm_and_charm:ribwort_tea", 3, 1.0f);
            registerDrinkThirst("farm_and_charm:strawberry_tea_cup", 3, 1.0f);
            registerDrinkThirst("farm_and_charm:nettle_tea_cup", 3, 1.0f);
            registerDrinkThirst("farm_and_charm:ribwort_tea_cup", 3, 1.0f);
        }

        if (DoAddonExpectPlatform.isModLoaded("herbalbrews")) {
            registerDrinkThirst("herbalbrews:green_tea", 5, 3.0f);
            registerDrinkThirst("herbalbrews:black_tea", 5, 3.0f);
            registerDrinkThirst("herbalbrews:hibiscus_tea", 5, 3.0f);
            registerDrinkThirst("herbalbrews:lavender_tea", 5, 3.0f);
            registerDrinkThirst("herbalbrews:yerba_mate_tea", 5, 3.0f);
            registerDrinkThirst("herbalbrews:rooibos_tea", 5, 3.0f);
            registerDrinkThirst("herbalbrews:oolong_tea", 5, 3.0f);
            registerDrinkThirst("herbalbrews:coffee", 4, 2.0f);
            registerDrinkThirst("herbalbrews:milk_coffee", 4, 2.0f);

            registerDrinkThirst("herbalbrews:armor_flask", 4, 2.0f);
            registerDrinkThirst("herbalbrews:armor_flask_big", 5, 3.0f);
            registerDrinkThirst("herbalbrews:damage_flask", 4, 2.0f);
            registerDrinkThirst("herbalbrews:damage_flask_big", 5, 3.0f);
            registerDrinkThirst("herbalbrews:feral_flask", 4, 2.0f);
            registerDrinkThirst("herbalbrews:feral_flask_big", 5, 3.0f);
        }

        if (DoAddonExpectPlatform.isModLoaded("meadow")) {
            registerDrinkThirst("meadow:wooden_milk_bucket", 3, 1.0f);
            registerDrinkThirst("meadow:wooden_sheep_milk_bucket", 3, 1.0f);
            registerDrinkThirst("meadow:wooden_buffalo_milk_bucket", 3, 1.0f);
            registerDrinkThirst("meadow:wooden_goat_milk_bucket", 3, 1.0f);
            registerDrinkThirst("meadow:wooden_warped_milk_bucket", 3, 1.0f);
            registerDrinkThirst("meadow:wooden_grain_milk_bucket", 3, 1.0f);
            registerDrinkThirst("meadow:wooden_amethyst_milk_bucket", 3, 1.0f);
        }

        if (DoAddonExpectPlatform.isModLoaded("vinery")) {
            registerDrinkThirst("vinery:red_grapejuice", 3, 2.0f);
            registerDrinkThirst("vinery:white_grapejuice", 3, 2.0f);
            registerDrinkThirst("vinery:red_taiga_grapejuice", 3, 2.0f);
            registerDrinkThirst("vinery:white_taiga_grapejuice", 3, 2.0f);
            registerDrinkThirst("vinery:red_jungle_grapejuice", 3, 2.0f);
            registerDrinkThirst("vinery:white_jungle_grapejuice", 3, 2.0f);
            registerDrinkThirst("vinery:red_savanna_grapejuice", 3, 2.0f);
            registerDrinkThirst("vinery:white_savanna_grapejuice", 3, 2.0f);
            registerDrinkThirst("vinery:apple_juice", 3, 2.0f);

            registerDrinkThirst("vinery:mead", 3, 2.0f);
            registerDrinkThirst("vinery:apple_cider", 3, 2.0f);
            registerDrinkThirst("vinery:apple_wine", 3, 2.0f);
            registerDrinkThirst("vinery:mellohi_wine", 3, 2.0f);
            registerDrinkThirst("vinery:glowing_wine", 3, 2.0f);
            registerDrinkThirst("vinery:solaris_wine", 3, 2.0f);
            registerDrinkThirst("vinery:noir_wine", 3, 2.0f);
            registerDrinkThirst("vinery:red_wine", 3, 2.0f);
            registerDrinkThirst("vinery:strad_wine", 3, 2.0f);
            registerDrinkThirst("vinery:cherry_wine", 3, 2.0f);
            registerDrinkThirst("vinery:cristel_wine", 3, 2.0f);
            registerDrinkThirst("vinery:creepers_crush", 3, 2.0f);
            registerDrinkThirst("vinery:kelp_cider", 3, 2.0f);
            registerDrinkThirst("vinery:lilitu_wine", 3, 2.0f);
            registerDrinkThirst("vinery:jo_special_mixture", 3, 2.0f);
            registerDrinkThirst("vinery:eiswein", 3, 2.0f);
            registerDrinkThirst("vinery:aegis_wine", 3, 2.0f);
            registerDrinkThirst("vinery:bolvar_wine", 3, 2.0f);
            registerDrinkThirst("vinery:chorus_wine", 3, 2.0f);
            registerDrinkThirst("vinery:villagers_fright", 3, 2.0f);
            registerDrinkThirst("vinery:clark_wine", 3, 2.0f);
            registerDrinkThirst("vinery:magnetic_wine", 3, 2.0f);
            registerDrinkThirst("vinery:stal_wine", 3, 2.0f);
            registerDrinkThirst("vinery:chenet_wine", 3, 2.0f);
            registerDrinkThirst("vinery:bottle_mojang_noir", 3, 2.0f);
            registerDrinkThirst("vinery:jellie_wine", 3, 2.0f);
        }
    }

    public enum ItemType {
        DRINK,
        FOOD
    }
}
