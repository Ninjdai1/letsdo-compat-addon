import json
import os

HYDRATION_ITEMS = {
    "beachparty": {
        1: [
            "coconut_open",
            "honey_cocktail",
            "sweetberry_milkshake",
            "coconut_milkshake",
            "chocolate_milkshake",
            "sweetberry_icecream",
            "coconut_icecream",
            "chocolate_icecream",
            "icecream_coconut",
            "icecream_cactus",
            "icecream_chocolate",
            "icecream_sweetberries",
            "icecream_melon"
        ],
        2: [
            "coconut_cocktail",
            "sweetberries_cocktail",
            "cocoa_cocktail",
            "pumpkin_cocktail",
            "melon_cocktail"
        ],
        5: [
            "refreshing_drink"
        ]
    },
    "brewery": {
        2: [
            "whiskey",
            "whiskey_jojannik",
            "whiskey_lilitusinglemalt",
            "whiskey_cristelwalker",
            "whiskey_maggoallan",
            "whiskey_carrasconlabel",
            "whiskey_ak",
            "whiskey_highland_hearth",
            "whiskey_smokey_reverie",
            "whiskey_jamesons_malt"
        ],
        3: [
            "beer_wheat",
            "beer_barley",
            "beer_hops",
            "beer_nettle",
            "beer_oat",
            "beer_haley"
        ]
    },
    "candlelight": {
        1: [
            "beetroot_salad",
            "salad",
            "mozzarella",
            "fresh_garden_salad",
            "tomato_mozzarella_salad"
        ],
        3: [
            "tomato_soup",
            "mushroom_soup"
        ]
    },
    "cornexpansion": {
        1: [
            "corn_syrup"
        ]
    },
    "farm_and_charm": {
        1: [
            "tomato",
            "farmer_salad"
        ],
        2: [
            "strawberry_tea",
            "nettle_tea",
            "ribwort_tea",
            "strawberry_tea_cup",
            "nettle_tea_cup",
            "ribwort_tea_cup"
        ],
        3: [
            "simple_tomato_soup",
            "barley_soup",
            "onion_soup",
            "potato_soup"
        ]
    },
    "herbalbrews": {
        1: [
            "coffee",
            "milk_coffee"
        ],
        2: [
            "green_tea",
            "black_tea",
            "hibiscus_tea",
            "lavender_tea",
            "yerba_mate_tea",
            "rooibos_tea",
            "oolong_tea",
            "armor_flask",
            "armor_flask_big",
            "damage_flask",
            "damage_flask_big",
            "feral_flask",
            "feral_flask_big"
        ]
    },
    "meadow": {
        2: [
            "wooden_milk_bucket",
            "wooden_sheep_milk_bucket",
            "wooden_buffalo_milk_bucket",
            "wooden_goat_milk_bucket",
            "wooden_warped_milk_bucket",
            "wooden_grain_milk_bucket",
            "wooden_amethyst_milk_bucket"
        ]
    }
}
for mod in HYDRATION_ITEMS:
    for hydration_value in HYDRATION_ITEMS[mod]:
        for i in range(len(HYDRATION_ITEMS[mod][hydration_value])):
            HYDRATION_ITEMS[mod][hydration_value][i] = f"{mod}:{HYDRATION_ITEMS[mod][hydration_value][i]}"

class ThirstFile:
    name: str
    content: str

def generateThirstData() -> list[ThirstFile]:
    files: list[ThirstFile] = []
    # Tough As Nails
    hydration_concat: dict[int, list[str]] = {}
    for mod in HYDRATION_ITEMS:
        for hydration_value in HYDRATION_ITEMS[mod]:
            if hydration_value not in hydration_concat:
                hydration_concat[hydration_value] = []
            hydration_concat[hydration_value].extend(HYDRATION_ITEMS[mod][hydration_value])
    for hydration_value in hydration_concat:
        f = ThirstFile()
        f.name = f"data/toughasnails/tags/items/hydration/{hydration_value}0_hydration_drinks.json"
        items = []
        for item in hydration_concat[hydration_value]:
            items.append({
                "required": False,
                "id": item
            })
        f.content = json.dumps({
            "replace": False,
            "values": items
        }, indent=4)
        files.append(f)

    # Dehydration
    for mod in HYDRATION_ITEMS:
        f = ThirstFile()
        f.name = f"data/dehydration/hydration_items/{mod}_items.json"
        content = {}
        for hydration_value in HYDRATION_ITEMS[mod]:
            content[str(hydration_value)] = {
                "replace": False,
                "items": HYDRATION_ITEMS[mod][hydration_value]
            }
        f.content = json.dumps(content, indent=4)
        files.append(f)
    return files

OUTPUT_PATH: str = "./utils/output/"

file_list: list[ThirstFile] = generateThirstData()
for file in file_list:
    file_dir = file.name.split("/")
    file_dir.pop()
    file_dir = OUTPUT_PATH+'/'.join(file_dir)
    os.makedirs(file_dir, exist_ok=True)
    with open(f"{OUTPUT_PATH}{file.name}", "w") as f:
        print(file.content, file=f)
