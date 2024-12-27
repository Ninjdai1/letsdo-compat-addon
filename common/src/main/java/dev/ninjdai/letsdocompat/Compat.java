package dev.ninjdai.letsdocompat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Compat {
    public static final String MOD_ID = "letsdocompat";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        LOGGER.info("You shall not Json my recipes !");
    }
}
