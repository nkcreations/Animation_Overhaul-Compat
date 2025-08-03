package elocindev.animation_overhaul.compat;

import net.minecraft.client.player.AbstractClientPlayer;

//#if FABRIC==1
import io.github.kosmx.emotes.api.common.player.IEmotePlayer;
//#else
//$$ import io.github.kosmx.emotes.api.common.player.IEmotePlayer;
//$$ import vazkii.quark.content.experimental.emotes.EmoteHolder;
//#endif

public class EmoteCompat {
    public static boolean isPlayerEmoting(AbstractClientPlayer player) {
        if (CompatibilityLoader.EMOTECRAFT) {
            //#if FABRIC==1
            if (((IEmotePlayer) player).getEmote() != null && ((IEmotePlayer) player).getEmote().isPlaying()) {
                return true;
            }
            //#else
            //$$ if (((IEmotePlayer) player).getEmote() != null && ((IEmotePlayer) player).getEmote().isPlaying()) {
            //$$     return true;
            //$$ }
            //#endif
        }

        if (CompatibilityLoader.QUARK) {
            //#if FABRIC==1
            //#else
            //$$ if (EmoteHolder.getEmoteHolder(player).isEmoting()) {
            //$$     return true;
            //$$ }
            //#endif
        }

        return false;
    }
}
