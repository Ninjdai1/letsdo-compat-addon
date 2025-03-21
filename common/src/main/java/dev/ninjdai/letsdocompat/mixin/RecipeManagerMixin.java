package dev.ninjdai.letsdocompat.mixin;

import com.google.gson.*;
import dev.ninjdai.letsdocompat.Compat;
import dev.ninjdai.letsdocompat.DoAddonExpectPlatform;
import dev.ninjdai.letsdocompat.RecipeJsonUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.Tuple;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.crafting.RecipeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.List;
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
                if (RecipeJsonUtil.RECIPE_CONVERSION_MAP.containsKey(recipeType)) {
                    List<Tuple<String, RecipeJsonUtil.RecipeConvertor>> modConvertorTupleList = RecipeJsonUtil.RECIPE_CONVERSION_MAP.get(recipeType);
                    for (Tuple<String, RecipeJsonUtil.RecipeConvertor> modConvertorTuple: modConvertorTupleList) {
                        if (DoAddonExpectPlatform.isModLoaded(modConvertorTuple.getA())) {
                            JsonObject recipe = modConvertorTuple.getB().generate(jsonRecipe);
                            if (recipe==null) continue;

                            tMap.put(
                                //Example generated ResourceLocation: "letsdocompat:create/crafting_bowl/butter"
                                new ResourceLocation(Compat.MOD_ID, modConvertorTuple.getA() + "/" + resourceLocation.getPath()),
                                recipe
                            );
                        }
                    }
                }
            } catch (Exception e) {
                Compat.LOGGER.error("Errored when converting recipes", e);
            }
        }
        map.putAll(tMap);
        Compat.LOGGER.info("Added {} compatibility recipes !", tMap.size());
    }
}
