package dev.ninjdai.letsdocompat.fabric;

import dev.ninjdai.letsdocompat.ThirstCompatHelper;
import net.fabricmc.loader.api.FabricLoader;

public class DoAddonExpectPlatformImpl {
    public static boolean isModLoaded(String modid) {
        return FabricLoader.getInstance().isModLoaded(modid);
    }

    public static void addItemCompat(String itemName, Number[] values, ThirstCompatHelper.ItemType itemType) {

    }
}