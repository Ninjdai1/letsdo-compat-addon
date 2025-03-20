package dev.ninjdai.letsdocompat;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public final class RecipeJsonUtil {
    public static JsonObject generateFDCookingPotFromLDCookingPot(JsonObject jsonRecipe) {
        JsonObject FDCookingPotRecipe = new JsonObject();
        FDCookingPotRecipe.add("type", new JsonPrimitive("farmersdelight:cooking"));
        FDCookingPotRecipe.add("recipe_book_tab", new JsonPrimitive("meals"));
        FDCookingPotRecipe.add("ingredients", jsonRecipe.getAsJsonArray("ingredients"));
        try {
            JsonObject ldContainer = jsonRecipe.getAsJsonObject("container");
            if (!ldContainer.get("required").getAsBoolean()) {
                FDCookingPotRecipe.add("container", ldContainer.get("item"));
            }
        } catch(Exception e) {
            Compat.LOGGER.error("Error while reading recipe container");
        }
        FDCookingPotRecipe.add("result", jsonRecipe.get("result"));

        return FDCookingPotRecipe;
    }

    public static JsonObject generateLDCookingPotFromFDCookingPot(JsonObject jsonRecipe) {
        JsonObject letsDoCookingPotRecipe = new JsonObject();
        letsDoCookingPotRecipe.add("type", new JsonPrimitive("farm_and_charm:pot_cooking"));
        letsDoCookingPotRecipe.add("ingredients", jsonRecipe.getAsJsonArray("ingredients"));
        if (jsonRecipe.has("container")) {
            JsonObject containerObject = new JsonObject();
            containerObject.add("required", new JsonPrimitive(true));
            containerObject.add("item", jsonRecipe.get("container"));
            letsDoCookingPotRecipe.add("container", containerObject);
        }
        else {
            try {
                Item i = BuiltInRegistries.ITEM.get(new ResourceLocation(jsonRecipe.get("result").getAsJsonObject().get("item").getAsString()));
                if (i.getCraftingRemainingItem() != null) {
                    JsonObject container = new JsonObject();
                    container.add("required", new JsonPrimitive(true));
                    JsonObject itemObject = new JsonObject();
                    itemObject.add("item", new JsonPrimitive(i.getCraftingRemainingItem().arch$registryName().toString()));
                    container.add("item", itemObject);
                    letsDoCookingPotRecipe.add("container", container);
                } else return null;
            } catch (Exception e) {
                Compat.LOGGER.error("Error getting item from Item Registry: {}", e.getMessage());
                return null;
            }
        }
        letsDoCookingPotRecipe.add("result", jsonRecipe.get("result"));
        letsDoCookingPotRecipe.add("requiresLearning", new JsonPrimitive(false));

        return letsDoCookingPotRecipe;
    }

    public static JsonObject generateCreateMixerFromFDBowl(JsonObject jsonRecipe) {
        JsonObject createMixerRecipe = new JsonObject();
        createMixerRecipe.add("type", new JsonPrimitive("create:mixing"));
        createMixerRecipe.add("ingredients", jsonRecipe.getAsJsonArray("ingredients"));

        JsonArray resultsArray = new JsonArray();
        resultsArray.add(jsonRecipe.get("result"));
        createMixerRecipe.add("results", resultsArray);

        return createMixerRecipe;
    }
}