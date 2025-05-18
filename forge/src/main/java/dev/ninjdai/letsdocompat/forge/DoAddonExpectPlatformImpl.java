package dev.ninjdai.letsdocompat.forge;

import dev.ghen.thirst.api.ThirstHelper;
import dev.ninjdai.letsdocompat.Compat;
import dev.ninjdai.letsdocompat.ThirstCompatHelper;
import dev.ninjdai.letsdocompat.DoAddonExpectPlatform;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.LoadingModList;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class DoAddonExpectPlatformImpl {
    public static boolean isModLoaded(String modId) {
        ModList modList = ModList.get();
        if (modList != null) {
            return modList.isLoaded(modId);
        }
        return isModPreLoaded(modId);
    }

    public static boolean isModPreLoaded(String modId) {
        return getPreLoadedModInfo(modId) != null;
    }

    public static @Nullable ModInfo getPreLoadedModInfo(String modId){
        for(ModInfo info : LoadingModList.get().getMods()){
            if(info.getModId().equals(modId)) {
                return info;
            }
        }
        return null;
    }

    public static void addItemCompat(String itemName, Number[] values, ThirstCompatHelper.ItemType itemType) {
        if (DoAddonExpectPlatform.isModLoaded("thirst")) {
            ForgeRegistries.ITEMS.getDelegate(new ResourceLocation(itemName)).ifPresentOrElse( itemReference -> {
                Item i = itemReference.get();
                if (itemType == ThirstCompatHelper.ItemType.DRINK) ThirstHelper.VALID_DRINKS.put(i, values);
                else if (itemType == ThirstCompatHelper.ItemType.FOOD) ThirstHelper.VALID_FOODS.put(i, values);
            }, () -> Compat.LOGGER.error("Couldn't find {} in registries. This might be caused by {} having changed its ids.", itemName, itemName.split(":")[0]));
        }
    }
}