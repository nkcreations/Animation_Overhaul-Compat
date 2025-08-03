package elocindev.animation_overhaul.compat;

import net.minecraft.world.entity.player.Player;

import java.lang.reflect.Method;

public class EmotecraftCompat {
    private static Method getPlayingEmoteMethod;
    private static boolean initialized = false;

    private static void initialize() {
        if (initialized) return;
        try {
            Class<?> emotePlayerClass = Class.forName("dev.kosmx.emotecraft.api.EmotePlayerAnimationAccess");
            getPlayingEmoteMethod = emotePlayerClass.getMethod("getPlayingEmote", Player.class);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            // Emotecraft not found or version mismatch
        }
        initialized = true;
    }

    public static boolean isEmotePlaying(Player player) {
        if (!CompatibilityLoader.EMOTECRAFT) return false;
        initialize();
        if (getPlayingEmoteMethod != null) {
            try {
                Object emote = getPlayingEmoteMethod.invoke(null, player);
                return emote != null;
            } catch (Exception e) {
                // Invocation failed
                return false;
            }
        }
        return false;
    }
}
