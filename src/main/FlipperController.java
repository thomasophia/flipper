package main;

import main.flipperElements.*;
import main.mediatorPattern.ConcreteMediator;

import java.util.ArrayList;
import java.util.List;

public class FlipperController {

    public List<FlipperElement> flipperElements = new ArrayList<>();

    public FlipperController() {
        Hole hole = new Hole();
        Target target1 = new Target();
        Target target2 = new Target();
        Bumper bumper = new Bumper();
        Ramp ramp = new Ramp();
        SlingShot slingShot = new SlingShot();
        Kicker kicker1 = new Kicker();
        Kicker kicker2 = new Kicker();

        flipperElements.add(target1);
        flipperElements.add(bumper);
        flipperElements.add(kicker1);
        flipperElements.add(target2);
        flipperElements.add(kicker2);
        flipperElements.add(slingShot);
        flipperElements.add(ramp);
        flipperElements.add(hole);

        ConcreteMediator concreteMediator = new ConcreteMediator();
        concreteMediator.addColleague(target1);
        concreteMediator.addColleague(target2);
        concreteMediator.addColleague(ramp);
    }

    public List<FlipperElement> getFlipperElements() {
        return flipperElements;
    }
}
