package main.flipperElements;

import main.mediatorPattern.Mediator;
import main.visitorPattern.Visitor;

import java.util.Scanner;

public class Hole extends FlipperElement {


    public int hitCount;
    private boolean open = true;
    protected Mediator mediator;


    @Override
    public void hit() {
        hitCount += 1;
        System.out.println("Ball holed!!!");
    }

    @Override
    public void resetElement() {
        open = true;
        hitCount = 0;
    }

    @Override
    public void welcomeVisitor(Visitor visitor) {             //Visitor
        visitor.visitElement(this);
    }

    public void closeHole() {
        open = false;
        System.out.println("Hole got closed!");
    }

    public void guess() {
        System.out.println("Guess the right number: (1), (2) or (3) ?");
        Scanner scanner = new Scanner(System.in);
        int guess = scanner.nextInt();
        int range = 3;
        int rand = (int) (Math.random() * range) + 1;
        System.out.println("Right number was: " + rand);
        if (guess == rand) {
            hitCount += 2;
            System.out.println("Score! 2 Points!");
        } else {
            System.out.println("Not the right guess...");
        }
    }

    @Override
    public void setMediator(Mediator mediator) {            //evtl besser: Element hat command, command hat referenz auf mediator
        this.mediator = mediator;
    }

    @Override
    public int getHitCount() {
        return hitCount;
    }

}
