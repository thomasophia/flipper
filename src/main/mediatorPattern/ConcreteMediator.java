package main.mediatorPattern;

import main.flipperElements.FlipperElement;
import main.flipperElements.Ramp;
import main.flipperElements.Target;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {

    private final List<FlipperElement> flipperElements;

    public ConcreteMediator() {
        this.flipperElements = new ArrayList<>();
    }

    private int gotHit = 0;

    @Override
    public void communicate(FlipperElement flipperElement) {
        for (FlipperElement t : flipperElements) {
            if (t instanceof Target) {
                gotHit += t.getHitCount();
            }
        }
        if (gotHit == 2) {
            System.out.println("Congrats, You hit all targets! ---> Ramp opens >>>>>>>>>");
            for (FlipperElement f : flipperElements) {
                if (f instanceof Ramp) {
                    ((Ramp) f).openRamp();
                }
                gotHit = 0;
            }
        } else {
            gotHit = 0;
        }
    }

    public void addColleague(FlipperElement flipperElement) {
        flipperElements.add(flipperElement);
        flipperElement.setMediator(this);
    }
}
