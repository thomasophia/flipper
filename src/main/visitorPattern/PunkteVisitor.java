package main.visitorPattern;

import main.Flipper;
import main.flipperElements.FlipperElement;

public class PunkteVisitor extends Visitor {

    private int totalPoints;
    private Flipper flipper = Flipper.getInstance();

    @Override
    public void visitElement(FlipperElement flipperElement) {
        int elementPoints = flipperElement.getHitCount();
        totalPoints += elementPoints;
    }

    public int getTotalPoints() {
        int level = flipper.getLevel();
        totalPoints *= level;
        return totalPoints;
    }
}
