package dev.ninjdai.letsdocompat.fabric;

import dev.ninjdai.letsdocompat.Compat;
import dev.ninjdai.letsdocompat.ThirstCompatHelper;
import net.fabricmc.api.ModInitializer;

public final class CompatFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Compat.init();

        ThirstCompatHelper.init();
    }
}
