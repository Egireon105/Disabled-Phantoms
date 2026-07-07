package egireon.modid.mixin;

import net.minecraft.world.spawner.PhantomSpawner;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import egireon.modid.PhantomConfig;

import java.util.List;

@Mixin(PhantomSpawner.class)
public class PhantomSpawnerMixin {

    @Inject(method = "spawn", at = @At("HEAD"), cancellable = true)
    private void checkPlayersBeforeSpawning(ServerWorld world, boolean spawnMonsters, boolean spawnAnimals, CallbackInfoReturnable<Integer> cir) {
        if (!spawnMonsters) {
            return;
        }
        List<ServerPlayerEntity> players = world.getPlayers();
        if (players.isEmpty()) {
            cir.setReturnValue(0);
            return;
        }

        boolean anyEnabled = players.stream().anyMatch(PhantomConfig::isSpawnEnabled);
        if (!anyEnabled) {
            cir.setReturnValue(0);
        }
    }
}