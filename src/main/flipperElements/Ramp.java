package main.flipperElements;

import main.mediatorPattern.Mediator;
import main.visitorPattern.Visitor;

public class Ramp extends FlipperElement {

    private boolean open = false;
    private int hitCount = 0;
    protected Mediator mediator;


    @Override
    public void hit() {
        if (open) {
            hitCount += 4;
            System.out.println("Ramp activated! Awesome Mode On! +4");
        }
    }

    @Override
    public void resetElement() {
        hitCount = 0;
        open = false;
    }

    public void openRamp() {
        open = true;
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
        return hitCount;
    }
}
