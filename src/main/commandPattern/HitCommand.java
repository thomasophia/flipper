package main.commandPattern;

import main.flipperElements.FlipperElement;

public class HitCommand implements Command {

    private FlipperElement flipperElement;


    public HitCommand(FlipperElement flipperElement) {
        this.flipperElement = flipperElement;
    }

    @Override
    public void execute() {
        flipperElement.hit();
    }
}
