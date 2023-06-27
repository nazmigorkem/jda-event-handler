package xyz.verifierbot.EventListeners.SlashCommands.Verification.LeafCommandGroups.LogChannel.LeafCommands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import xyz.verifierbot.AbstractClasses.SlashCommands.LeafCommand;

public class Set extends LeafCommand {

    public Set() {
        name = "set";
    }

    @Override
    public void handle(SlashCommandInteractionEvent event) {
        event.reply("b").queue();
    }
}
