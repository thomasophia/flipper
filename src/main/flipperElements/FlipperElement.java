package main.flipperElements;

import main.mediatorPattern.Mediator;
import main.visitorPattern.Visitor;

public abstract class FlipperElement {

    public abstract void hit();

    public abstract void resetElement();

    public abstract void welcomeVisitor(Visitor visitor);

    public abstract void setMediator(Mediator mediator);

    public abstract int getHitCount();

}
