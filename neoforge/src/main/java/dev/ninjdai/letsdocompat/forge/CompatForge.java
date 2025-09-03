package dev.ninjdai.letsdocompat.forge;

import dev.ninjdai.letsdocompat.Compat;
import dev.architectury.platform.forge.EventBuses;
import dev.ninjdai.letsdocompat.ThirstCompatHelper;
import dev.ninjdai.letsdocompat.forge.compat.LSOCompat;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Compat.MOD_ID)
public final class CompatForge {
    public CompatForge() {
        EventBuses.registerModEventBus(Compat.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        Compat.init();

        LSOCompat.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(EventPriority.LOWEST, false, FMLCommonSetupEvent.class, event -> ThirstCompatHelper.init());
    }
}
