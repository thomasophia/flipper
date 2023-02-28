package main.flipperElements;

import main.mediatorPattern.Mediator;
import main.visitorPattern.Visitor;

public class Kicker extends FlipperElement {

    public int hitCount;
    protected Mediator mediator;

    @Override
    public void hit() {

        int range = 6;
        int rand = (int) (Math.random() * range) + 1;
        if (rand <= 3) {
            hitCount += 1;
            System.out.println("You kick it!");
        } else {
            System.out.println("Your kick missed the ball :(");
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
