package main.flipperElements;

import main.mediatorPattern.Mediator;
import main.visitorPattern.Visitor;

public class Bumper extends FlipperElement {

    public int hitCount;
    protected Mediator mediator;

    @Override
    public void hit() {
        hitCount += 1;
        System.out.println("It's getting bumpy...");
    }

    @Override
    public void resetElement() {
        hitCount = 0;
    }

    @Override
    public void welcomeVisitor(Visitor visitor) {
        visitor.visitElement(this);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public int getHitCount() {
        return 0;
    }
}
