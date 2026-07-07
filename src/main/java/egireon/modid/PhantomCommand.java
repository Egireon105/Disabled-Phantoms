package egireon.modid;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.*;

public class PhantomCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("phantoms")
            .then(literal("spawn")
                .then(literal("true")
                    .executes(context -> {
                        var player = context.getSource().getPlayer();
                        if (player == null) {
                            context.getSource().sendError(Text.translatable("command.phantoms.error.not_player"));
                            return 0;
                        }
                        PhantomConfig.setSpawnEnabled(player, true);
                        context.getSource().sendFeedback(() -> Text.translatable("command.phantoms.spawn.enabled"), false);
                        return 1;
                    })
                )
                .then(literal("false")
                    .executes(context -> {
                        var player = context.getSource().getPlayer();
                        if (player == null) {
                            context.getSource().sendError(Text.translatable("command.phantoms.error.not_player"));
                            return 0;
                        }
                        PhantomConfig.setSpawnEnabled(player, false);
                        context.getSource().sendFeedback(() -> Text.translatable("command.phantoms.spawn.disabled"), false);
                        return 1;
                    })
                )
            )
        );
    }
}