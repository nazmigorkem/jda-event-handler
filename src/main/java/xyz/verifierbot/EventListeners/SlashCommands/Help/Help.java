package xyz.verifierbot.EventListeners.SlashCommands.Help;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import xyz.verifierbot.AbstractClasses.SlashCommands.LeafCommand;

public class Help extends LeafCommand {
    public Help() {
        name = "help";
    }

    @Override
    public void handle(SlashCommandInteractionEvent event) {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setDescription("If you're looking for commands [click here](https://verifierbot.xyz/commands).")
                .setTitle("Welcome to Verifier's help section " + event.getUser().getName());
        event.replyEmbeds(embedBuilder.build()).queue();
    }
}
