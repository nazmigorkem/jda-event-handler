package xyz.verifierbot.AbstractClasses.SlashCommands;

import java.util.HashMap;

public abstract class RootCommand extends SlashCommand {

    public HashMap<String, LeafCommand> leafCommands = new HashMap<>();

    public HashMap<String, LeafCommandGroup> leafCommandGroups = new HashMap<>();

    public void addLeafCommand(LeafCommand leafCommand) {
        leafCommands.put(leafCommand.name, leafCommand);
    }

    public void addLeafCommandGroup(LeafCommandGroup leafCommandGroup) {
        leafCommandGroups.put(leafCommandGroup.name, leafCommandGroup);
    }
}
