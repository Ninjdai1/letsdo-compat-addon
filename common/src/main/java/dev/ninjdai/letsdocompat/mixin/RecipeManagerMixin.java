package dev.ninjdai.letsdocompat.mixin;

import com.google.gson.*;
import dev.ninjdai.letsdocompat.Compat;
import dev.ninjdai.letsdocompat.DoAddonExpectPlatform;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin {
    @Inject(method = "apply*", at = @At(value = "HEAD"))
    public void interceptApply(Map<ResourceLocation, JsonElement> map, ResourceManager resourceManager, ProfilerFiller profilerFiller, CallbackInfo info) {
        HashMap<ResourceLocation, JsonElement> tMap = new HashMap<>();
        for (Map.Entry<ResourceLocation, JsonElement> entry : map.entrySet()) {
            ResourceLocation resourceLocation = entry.getKey();
            JsonObject jsonRecipe = entry.getValue().getAsJsonObject();
            String recipeType = jsonRecipe.get("type").getAsString();
            if (recipeType.equals("farm_and_charm:pot_cooking")) {
                Compat.LOGGER.info("Located F&C Pot cooking recipe {}: {}", resourceLocation, jsonRecipe);

                if (DoAddonExpectPlatform.isModLoaded("farmersdelight")) {
                    JsonObject FDCookingPotRecipe = new JsonObject();
                    FDCookingPotRecipe.add("type", new JsonPrimitive("farmersdelight:cooking"));
                    FDCookingPotRecipe.add("recipe_book_tab", new JsonPrimitive("meals"));
                    FDCookingPotRecipe.add("ingredients", jsonRecipe.getAsJsonArray("ingredients"));
                    FDCookingPotRecipe.add("container", jsonRecipe.get("container"));
                    FDCookingPotRecipe.add("result", jsonRecipe.get("result"));
                    ResourceLocation id = new ResourceLocation(Compat.MOD_ID, "farm_and_charm/" + resourceLocation.getPath());
                    Compat.LOGGER.info("FD recipe: {} {}", id, FDCookingPotRecipe);
                    tMap.put(id, FDCookingPotRecipe);
                }
            } else if (recipeType.equals("farmersdelight:cooking")) {
                Compat.LOGGER.info("Located FD Pot cooking recipe {}: {}", resourceLocation, jsonRecipe);

                if (DoAddonExpectPlatform.isModLoaded("farm_and_charm")) {
                    JsonObject letsDoCookingPotRecipe = new JsonObject();
                    letsDoCookingPotRecipe.add("type", new JsonPrimitive("farm_and_charm:pot_cooking"));
                    letsDoCookingPotRecipe.add("ingredients", jsonRecipe.getAsJsonArray("ingredients"));
                    if (jsonRecipe.has("container")) letsDoCookingPotRecipe.add("container", jsonRecipe.get("container"));
                    else {
                        try {
                            Item i = BuiltInRegistries.ITEM.get(new ResourceLocation(jsonRecipe.get("result").getAsJsonObject().get("item").getAsString()));
                            if (i.hasCraftingRemainingItem()) {
                                JsonObject container = new JsonObject();
                                container.add("item", new JsonPrimitive(i.getCraftingRemainingItem().arch$registryName().toString()));
                                letsDoCookingPotRecipe.add("container", container);
                            } else continue;
                        } catch (Exception e) {
                            Compat.LOGGER.error("Error getting item from Item Registry: {}", e.getMessage());
                            continue;
                        }
                    }
                    letsDoCookingPotRecipe.add("result", jsonRecipe.get("result"));
                    ResourceLocation id = new ResourceLocation(Compat.MOD_ID, "farmersdelight/" + resourceLocation.getPath());
                    Compat.LOGGER.info("Let's Do recipe: {} {}", id, letsDoCookingPotRecipe);
                    tMap.put(id, letsDoCookingPotRecipe);
                }
            }
        }
        map.putAll(tMap);
    }
}