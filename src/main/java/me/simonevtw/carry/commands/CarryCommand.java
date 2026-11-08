package me.simonevtw.carry.commands;

import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import io.papermc.paper.command.brigadier.argument.resolvers.selector.PlayerSelectorArgumentResolver;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CarryCommand {
    public static LiteralCommandNode<CommandSourceStack> create() {
        return Commands.literal("carry")
                .then(Commands.argument("target", ArgumentTypes.player())
                        .executes(context -> {
                            var source = context.getSource();

                            if (!(source.getSender() instanceof Player player)) {
                                source.getSender().sendMessage("Solo i giocatori possono usare questo comando!");
                                return 0;
                            }

                            PlayerSelectorArgumentResolver resolver = context.getArgument("target", PlayerSelectorArgumentResolver.class);
                            var resolvedPlayers = resolver.resolve(source);
                            Player target = resolvedPlayers.iterator().next();

                            if (target.getLocation().distanceSquared(player.getLocation()) > 3) {
                                player.sendRichMessage("<red>Questo giocatore è troppo lontano");
                                return 0;
                            }

                            if (target == player) {
                                player.sendRichMessage("<red>Non puoi usare il carry su tè stesso");
                                return 0;
                            }


                            player.addPassenger(target);

                            return 1;
                        }))
                .build();
    }
}