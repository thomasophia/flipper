package main;

import main.abstractFactory.BigMoneyFactory;
import main.abstractFactory.FontFactory;
import main.abstractFactory.PebblesFactory;
import main.commandPattern.GuessCommand;
import main.commandPattern.HitCommand;
import main.commandPattern.MacroCommand;
import main.commandPattern.ScoreCommand;
import main.flipperElements.*;
import main.statePattern.EndState;
import main.visitorPattern.PunkteVisitor;
import main.visitorPattern.ResetVisitor;
import java.util.List;
import java.util.Scanner;

public class Game {

    //Context
    private static Flipper flipper = Flipper.getInstance();

    public static void main(String[] args) {
        boolean playing = true;

        //Spiel-Vorbereitungen
        FlipperController flipperController = new FlipperController();
        List<FlipperElement> flipperElements = flipperController.getFlipperElements();
        ResetVisitor resetVisitor = new ResetVisitor();
        PunkteVisitor punkteVisitor = new PunkteVisitor();
        Ball ball = new Ball();

        //Font Auswahl
        FontFactory schriftFabrik = chooseFont();

        //Spiel
        while (playing) {
            startGame();
            schriftFabrik.produziertStart();
            pressPlay();
            //jedes Spiel hat 3 Runden
            for (int i = 1; i <= 3; i++) {
                schriftFabrik.produziertBall(i);
                for (FlipperElement f : flipperElements) {
                    ball.setCommand(new HitCommand(f));
                    ball.executeCommand();
                    if (f instanceof Hole) {
                        MacroCommand holeCommand = new MacroCommand();
                        holeCommand.add(new GuessCommand((Hole) f));
                        holeCommand.add(new ScoreCommand((Hole) f));
                        ball.setCommand(holeCommand);
                        ball.executeCommand();
                    }
                }

                for (FlipperElement f : flipperElements) {
                    f.welcomeVisitor(punkteVisitor);
                    f.welcomeVisitor(resetVisitor);
                }
                int score = punkteVisitor.getTotalPoints();
                System.out.println("Total Score: " + score);
                System.out.println("Reset completed!");
                startGame();
            }
            //ein Spiel ist vorbei
            schriftFabrik.produziertEnde();
            flipper.setState(EndState.getInstance());
            System.out.println("Start a new Game (1) or End Game (2)");
            Scanner scanner1 = new Scanner(System.in);
            int eingabe = scanner1.nextInt();
            if (eingabe == 1) {
                flipper.pressPlayButton();
            }
            if (eingabe == 2) {
                playing = false;
            }
        }
    }

    public static FontFactory chooseFont() {
        FontFactory schriftFabrik;
        System.out.println("Choose Font: Pebbles (1), BigMoney (2)");
        Scanner scanner2 = new Scanner(System.in);
        int font = scanner2.nextInt();

        schriftFabrik = switch (font) {
            case 1 -> new PebblesFactory();
            case 2 -> new BigMoneyFactory();
            default -> chooseFont();
        };
        return schriftFabrik;
    }

    public static void startGame() {
        while (flipper.getCredit() == 0) {
            System.out.println("Credit: 0  -->  Play (1) or Insert Coin (2)");
            Scanner scanner1 = new Scanner(System.in);
            int eingabe = scanner1.nextInt();
            if (eingabe == 1) {
                flipper.pressPlayButton();
            }
            if (eingabe == 2) {
                flipper.insertCoin();
            }
        }
        if (flipper.getCredit() >= 1) {
            System.out.println("Credit: " + flipper.getCredit() + " -->  Continue (1) or Insert Coin and Continue (2)");
            Scanner scanner2 = new Scanner(System.in);
            int eingabe2 = scanner2.nextInt();
            if (eingabe2 == 2) {
                flipper.insertCoin();
            }
        }
    }

    public static void pressPlay() {
        try {
            System.in.read();
            flipper.pressPlayButton();
        } catch (Exception e) {
        }
    }
}
