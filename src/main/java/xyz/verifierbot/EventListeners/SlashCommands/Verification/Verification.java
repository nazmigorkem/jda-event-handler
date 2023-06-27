package xyz.verifierbot.EventListeners.SlashCommands.Verification;

import xyz.verifierbot.AbstractClasses.SlashCommands.RootCommand;
import xyz.verifierbot.EventListeners.SlashCommands.Verification.LeafCommandGroups.LogChannel.LogChannel;
import xyz.verifierbot.EventListeners.SlashCommands.Verification.LeafCommands.Create;

public class Verification extends RootCommand {
    public Verification() {
        name = "verification";
        addLeafCommand(new Create());
        addLeafCommandGroup(new LogChannel());
    }
}
