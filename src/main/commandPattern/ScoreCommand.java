package main.commandPattern;

import main.flipperElements.Hole;

public class ScoreCommand implements Command {

    private Hole hole;

    public ScoreCommand(Hole hole) {
        this.hole = hole;
    }

    @Override
    public void execute() {
        hole.closeHole();
    }
}
