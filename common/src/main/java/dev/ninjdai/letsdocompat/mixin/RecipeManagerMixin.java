package dev.ninjdai.letsdocompat.mixin;

import com.google.gson.*;
import dev.ninjdai.letsdocompat.Compat;
import dev.ninjdai.letsdocompat.DoAddonExpectPlatform;
import dev.ninjdai.letsdocompat.RecipeJsonUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
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
            if (!jsonRecipe.has("type")) continue;
            try {
                String recipeType = jsonRecipe.get("type").getAsString();
                switch (recipeType) {
                    case "farm_and_charm:pot_cooking":
                        if (DoAddonExpectPlatform.isModLoaded("farmersdelight")) {
                            ResourceLocation id = new ResourceLocation(Compat.MOD_ID, "farm_and_charm/" + resourceLocation.getPath());
                            tMap.put(id, RecipeJsonUtil.generateFDCookingPotFromLDCookingPot(jsonRecipe));
                        }
                        break;
                    case "farmersdelight:cooking":
                        if (DoAddonExpectPlatform.isModLoaded("farm_and_charm")) {
                            ResourceLocation id = new ResourceLocation(Compat.MOD_ID, "farmersdelight/" + resourceLocation.getPath());
                            JsonObject newRecipe = RecipeJsonUtil.generateLDCookingPotFromFDCookingPot(jsonRecipe);
                            if (newRecipe!=null) tMap.put(id, newRecipe);
                        }
                        break;
                    case "farm_and_charm:crafting_bowl":
                        if (DoAddonExpectPlatform.isModLoaded("create")) {
                            ResourceLocation id = new ResourceLocation(Compat.MOD_ID, "create/" + resourceLocation.getPath());
                            tMap.put(id, RecipeJsonUtil.generateCreateMixerFromFDBowl(jsonRecipe));
                        }
                        break;
                }
            } catch (Exception e) {
                Compat.LOGGER.error("Errored when converting recipes", e);
            }
        }
        map.putAll(tMap);
        Compat.LOGGER.info("Added {} compatibility recipes !", tMap.size());
    }
}
