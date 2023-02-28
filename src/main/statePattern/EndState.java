package main.statePattern;

import main.Flipper;

import java.util.Scanner;

public class EndState extends State {

    private static final EndState endStateInstance = new EndState();

    private EndState() {
    }

    @Override
    public void insertCoin(Flipper flipper) {
        flipper.addCredit();
        System.out.println("Münze eingeworfen! Credit: " + flipper.getCredit());
    }

    @Override
    public void pressPlayButton(Flipper flipper) {
        System.out.println("Try to win a game! choose (1) or (2) __ooo°> ");
        Scanner scanner = new Scanner(System.in);
        int eingabe = scanner.nextInt();
        if (eingabe == 1) {
            flipper.addCredit();
            System.out.println("Congrats! +1 Credit! Total Credit: " + flipper.getCredit());
        }
        if (eingabe == 2) {
            System.out.println("Not the right choice.");
        }
        if (flipper.getCredit() != 0) {
            flipper.setState(ReadyState.getInstance());
            flipper.nextLevel();
            System.out.println("Next Level! Credit: " + flipper.getCredit());
        } else {
            System.out.println("To continue insert coin.");
            flipper.setState(NoCreditState.getInstance());
        }
    }

    public static EndState getInstance() {
        return endStateInstance;
    }
}
