package xyz.verifierbot.AbstractClasses.SlashCommands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public abstract class LeafCommand extends RootCommand {
    public abstract void handle(SlashCommandInteractionEvent event);
}
