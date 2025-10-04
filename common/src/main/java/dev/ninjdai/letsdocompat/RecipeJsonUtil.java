package dev.ninjdai.letsdocompat;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class RecipeJsonUtil {
    public static final Map<String, List<Tuple<String, RecipeConvertor>>> RECIPE_CONVERSION_MAP = new HashMap<>();

    public static final RecipeConvertor generateFDCookingPotFromLDCookingPot = (ldRecipe) -> {
        JsonObject FDCookingPotRecipe = new JsonObject();
        FDCookingPotRecipe.add("type", new JsonPrimitive("farmersdelight:cooking"));
        FDCookingPotRecipe.add("recipe_book_tab", new JsonPrimitive("meals"));
        FDCookingPotRecipe.add("ingredients", ldRecipe.getAsJsonArray("ingredients"));
        if (ldRecipe.has("container") && ldRecipe.getAsJsonPrimitive("requireContainer").getAsBoolean()) {
            FDCookingPotRecipe.add("container", ldRecipe.get("container"));
        }
        FDCookingPotRecipe.add("result", ldRecipe.get("result"));

        return FDCookingPotRecipe;
    };

    @Nullable
    public static final RecipeConvertor generateLDCookingPotFromFDCookingPot = (fdRecipe) -> {
        JsonObject letsDoCookingPotRecipe = new JsonObject();
        letsDoCookingPotRecipe.add("type", new JsonPrimitive("farm_and_charm:pot_cooking"));
        letsDoCookingPotRecipe.add("ingredients", fdRecipe.getAsJsonArray("ingredients"));
        if (fdRecipe.has("container")) {
            letsDoCookingPotRecipe.add("requireContainer", new JsonPrimitive(true));
            letsDoCookingPotRecipe.add("container", fdRecipe.get("container"));
        } else {
            ResourceLocation resultLocation = ResourceLocation.parse(fdRecipe.getAsJsonObject("result").get("id").getAsString());
            if (BuiltInRegistries.ITEM.containsKey(resultLocation)) {
                Item i = BuiltInRegistries.ITEM.get(resultLocation);
                if (i.hasCraftingRemainingItem()) {
                    letsDoCookingPotRecipe.add("requireContainer", new JsonPrimitive(true));
                    JsonObject container = new JsonObject();
                    container.add("count", new JsonPrimitive(1));
                    container.add("id", new JsonPrimitive(i.getCraftingRemainingItem().toString()));
                    letsDoCookingPotRecipe.add("container", container);
                } else {
                    return null;
                }
            } else {
                Compat.LOGGER.info("FD Pot recipe for {} missing container", fdRecipe.get("result"));
                return null;
            }
        }
        letsDoCookingPotRecipe.add("result", fdRecipe.get("result"));
        letsDoCookingPotRecipe.add("requiresLearning", new JsonPrimitive(false));

        return letsDoCookingPotRecipe;
    };

    public static final RecipeConvertor generateCreateMixerFromFCBowl = (jsonRecipe) -> {
        JsonObject createMixerRecipe = new JsonObject();
        createMixerRecipe.add("type", new JsonPrimitive("create:mixing"));
        createMixerRecipe.add("ingredients", jsonRecipe.getAsJsonArray("ingredients"));

        JsonArray resultsArray = new JsonArray();
        resultsArray.add(jsonRecipe.get("result"));
        createMixerRecipe.add("results", resultsArray);

        return createMixerRecipe;
    };

    public static final RecipeConvertor generateCreateMillingFromFDMincer = (jsonRecipe) -> {
        JsonObject createMillingRecipe = new JsonObject();
        createMillingRecipe.add("type", new JsonPrimitive("create:milling"));
        createMillingRecipe.add("processingTime", new JsonPrimitive(90));

        JsonArray ingredientsArray = new JsonArray();
        ingredientsArray.add(jsonRecipe.get("ingredient"));
        createMillingRecipe.add("ingredients", ingredientsArray);

        JsonArray resultsArray = new JsonArray();
        resultsArray.add(jsonRecipe.get("result"));
        createMillingRecipe.add("results", resultsArray);

        return createMillingRecipe;
    };

    static {
        RECIPE_CONVERSION_MAP.put("farm_and_charm:pot_cooking", List.of(
                new Tuple<>("farmersdelight", RecipeJsonUtil.generateFDCookingPotFromLDCookingPot)
        ));
        RECIPE_CONVERSION_MAP.put("farmersdelight:cooking", List.of(
                new Tuple<>("farm_and_charm", RecipeJsonUtil.generateLDCookingPotFromFDCookingPot)
        ));
        RECIPE_CONVERSION_MAP.put("farm_and_charm:crafting_bowl", List.of(
                new Tuple<>("create", RecipeJsonUtil.generateCreateMixerFromFCBowl)
        ));
    }

    public interface RecipeConvertor {
        JsonObject generate(JsonObject jsonRecipe);
    }
}