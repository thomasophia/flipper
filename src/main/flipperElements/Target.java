package main.flipperElements;

import main.mediatorPattern.Mediator;
import main.visitorPattern.Visitor;

public class Target extends FlipperElement {

    public int hitCount;
    protected Mediator mediator;

    @Override
    public void hit() {
        int range = 10;
        int rand = (int) (Math.random() * range) + 1;
        if (rand <= 5) {
            hitCount += 1;
            System.out.println("Score! Hit Target!");
            mediator.communicate(this);
        } else {
            System.out.println("Oh no. Missed Target.");
        }
    }

    @Override
    public void resetElement() {
        hitCount = 0;
    }

    @Override
    public void welcomeVisitor(Visitor visitor) {             //Visitor
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
