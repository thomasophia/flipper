package main.commandPattern;

import main.flipperElements.Hole;

public class GuessCommand implements Command {

    private Hole hole;

    public GuessCommand(Hole hole) {
        this.hole = hole;
    }

    @Override
    public void execute() {
        hole.guess();
    }
}
