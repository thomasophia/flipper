package main.flipperElements;

import main.mediatorPattern.Mediator;
import main.visitorPattern.Visitor;

public class SlingShot extends FlipperElement {

    public int hitCount;
    protected Mediator mediator;

    @Override
    public void hit() {
        int range = 20;
        int rand = (int) (Math.random() * range) + 1;
        if (rand <= 5) {
            hitCount += 1;
            System.out.println("SlingShot Champ!");
        } else {
            System.out.println("Oh no. No SlingShot today..");
        }
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
