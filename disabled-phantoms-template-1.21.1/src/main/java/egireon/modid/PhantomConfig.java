package egireon.modid;

import net.minecraft.server.network.ServerPlayerEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PhantomConfig {
    // Храним настройки в оперативной памяти (сбрасываются при перезапуске сервера)
    private static final Map<UUID, Boolean> settings = new HashMap<>();

    public static boolean isSpawnEnabled(ServerPlayerEntity player) {
        // По умолчанию true (фантомы спавнятся)
        return settings.getOrDefault(player.getUuid(), true);
    }

    public static void setSpawnEnabled(ServerPlayerEntity player, boolean enabled) {
        settings.put(player.getUuid(), enabled);
    }
}