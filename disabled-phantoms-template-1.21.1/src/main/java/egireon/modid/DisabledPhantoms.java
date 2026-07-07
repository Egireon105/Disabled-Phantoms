package egireon.modid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class DisabledPhantoms implements ModInitializer {
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            PhantomCommand.register(dispatcher);
        });
        System.out.println("[DisabledPhantoms] Мод загружен!");
    }
}