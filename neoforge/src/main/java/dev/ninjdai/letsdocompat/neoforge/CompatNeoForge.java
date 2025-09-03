package dev.ninjdai.letsdocompat.neoforge;

import dev.ninjdai.letsdocompat.Compat;
import dev.ninjdai.letsdocompat.neoforge.compat.LSOCompat;
import net.neoforged.fml.common.Mod;

@Mod(Compat.MOD_ID)
public final class CompatNeoForge {
    public CompatNeoForge() {
        Compat.init();

        LSOCompat.init();
    }
}
