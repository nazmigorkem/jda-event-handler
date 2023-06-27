package xyz.verifierbot.EventListeners.SlashCommands.Verification.LeafCommands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import xyz.verifierbot.AbstractClasses.SlashCommands.LeafCommand;

public class Create extends LeafCommand {
    public Create() {
        name = "create";
    }

    @Override
    public void handle(SlashCommandInteractionEvent event) {
        event.reply("a").queue();
    }
}
