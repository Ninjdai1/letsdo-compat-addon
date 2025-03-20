package dev.ninjdai.letsdocompat.mixin;

import com.google.gson.*;
import dev.ninjdai.letsdocompat.Compat;
import dev.ninjdai.letsdocompat.DoAddonExpectPlatform;
import dev.ninjdai.letsdocompat.RecipeJsonUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
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
            String recipeType = jsonRecipe.get("type").getAsString();
            if (recipeType.equals("farm_and_charm:pot_cooking")) {
                if (DoAddonExpectPlatform.isModLoaded("farmersdelight")) {
                    ResourceLocation id = new ResourceLocation(Compat.MOD_ID, "farm_and_charm/" + resourceLocation.getPath());
                    tMap.put(id, RecipeJsonUtil.generateFDCookingPotFromLDCookingPot(jsonRecipe));
                }
            } else if (recipeType.equals("farmersdelight:cooking")) {
                if (DoAddonExpectPlatform.isModLoaded("farm_and_charm")) {
                    ResourceLocation id = new ResourceLocation(Compat.MOD_ID, "farmersdelight/" + resourceLocation.getPath());
                    tMap.put(id, RecipeJsonUtil.generateLDCookingPotFromFDCookingPot(jsonRecipe));
                }
            }
        }
        map.putAll(tMap);
        Compat.LOGGER.info("Added {} compatibility recipes !", tMap.size());
    }
}
