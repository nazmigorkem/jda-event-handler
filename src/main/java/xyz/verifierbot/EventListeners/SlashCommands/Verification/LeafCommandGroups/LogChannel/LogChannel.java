package xyz.verifierbot.EventListeners.SlashCommands.Verification.LeafCommandGroups.LogChannel;

import xyz.verifierbot.AbstractClasses.SlashCommands.LeafCommandGroup;
import xyz.verifierbot.EventListeners.SlashCommands.Verification.LeafCommandGroups.LogChannel.LeafCommands.Delete;
import xyz.verifierbot.EventListeners.SlashCommands.Verification.LeafCommandGroups.LogChannel.LeafCommands.Set;

public class LogChannel extends LeafCommandGroup {
    public LogChannel() {
        name = "log-channel";
        addLeafCommand(new Set());
        addLeafCommand(new Delete());
    }
}
