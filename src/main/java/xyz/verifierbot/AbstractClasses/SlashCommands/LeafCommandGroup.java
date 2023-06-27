package xyz.verifierbot.AbstractClasses.SlashCommands;

import java.util.HashMap;

public abstract class LeafCommandGroup extends RootCommand {
    public HashMap<String, LeafCommand> leafCommands = new HashMap<>();

    public void addLeafCommand(LeafCommand leafCommand) {
        leafCommands.put(leafCommand.name, leafCommand);
    }
}
