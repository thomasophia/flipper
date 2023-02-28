package main.commandPattern;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {

    private final List<Command> commands = new ArrayList<>();

    public void add(Command command) {
        this.commands.add(command);
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
