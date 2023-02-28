package main.visitorPattern;

import main.flipperElements.FlipperElement;

public class ResetVisitor extends Visitor {

    @Override
    public void visitElement(FlipperElement flipperElement) {

        flipperElement.resetElement();
    }
}
