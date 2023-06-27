package xyz.verifierbot.EventListeners;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import xyz.verifierbot.EventListeners.SlashCommands.Help.Help;
import xyz.verifierbot.AbstractClasses.SlashCommands.LeafCommand;
import xyz.verifierbot.AbstractClasses.SlashCommands.RootCommand;
import xyz.verifierbot.EventListeners.SlashCommands.Verification.Verification;

import java.util.HashMap;

public class Middleware extends ListenerAdapter {

    private final HashMap<String, RootCommand> allCommands = new HashMap<>();

    public Middleware() {
        addCommand(new Verification());
        addCommand(new Help());
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        RootCommand currentCommand = allCommands.get(event.getName());
        if (currentCommand == null) return;
        if (event.getSubcommandGroup() != null) {
            currentCommand
                    .leafCommandGroups.get(event.getSubcommandGroup())
                    .leafCommands.get(event.getSubcommandName())
                    .handle(event);
        } else if (event.getSubcommandName() != null) {
            currentCommand
                    .leafCommands.get(event.getSubcommandName())
                    .handle(event);
        } else {
            ((LeafCommand)currentCommand).handle(event);
        }

    }

    public void addCommand(RootCommand rootCommand) {
        allCommands.put(rootCommand.name, rootCommand);
    }
}
