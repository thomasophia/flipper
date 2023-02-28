package main.statePattern;

import main.Flipper;

public class PlayingState extends State {

    private static final PlayingState playingStateInstance = new PlayingState();

    private PlayingState() {
    }

    @Override
    public void insertCoin(Flipper flipper) {
        flipper.addCredit();
        System.out.println("Münze eingeworfen! Credit: " + flipper.getCredit());
    }

    @Override
    public void pressPlayButton(Flipper flipper) {
        System.out.println("Autorinnen: Isabel Matky & Sophia Thoma");
    }


    public static PlayingState getInstance() {
        return playingStateInstance;
    }
}
