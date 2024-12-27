package dev.ninjdai.letsdocompat.forge;

import dev.ninjdai.letsdocompat.Compat;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Compat.MOD_ID)
public final class CompatForge {
    public CompatForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(Compat.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        Compat.init();
    }
}
