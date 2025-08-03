package elocindev.animation_overhaul.compat;

import elocindev.animation_overhaul.util.PlatformUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompatibilityLoader {

    public static final Logger LOGGER = LoggerFactory.getLogger("Animation Overhaul");

    public static boolean BETTER_COMBAT = false;
    public static boolean SPELL_ENGINE = false;
    public static boolean EMOTECRAFT = false;

    public static void refresh() {
        LOGGER.info("Animation Overhaul checking for mod compatibilities..");

        if (PlatformUtility.isModLoaded("bettercombat")) {
            BETTER_COMBAT = true;
            LOGGER.info("Better Combat compatibility loaded.");
        }

        if (PlatformUtility.isModLoaded("spell_engine")) {
            SPELL_ENGINE = true;
            LOGGER.info("Spell Engine compatibility loaded.");
        }

        if (PlatformUtility.isModLoaded("emotecraft")) {
            EMOTECRAFT = true;
            LOGGER.info("Emotecraft compatibility loaded.");
        }
    }
}
