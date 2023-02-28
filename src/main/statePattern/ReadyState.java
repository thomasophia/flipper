package main.statePattern;

import main.Flipper;

public class ReadyState extends State {

    private static final ReadyState readyStateInstance = new ReadyState();

    private ReadyState() {
    }

    @Override
    public void insertCoin(Flipper flipper) {
        flipper.addCredit();
        System.out.println("Münze eingeworfen! Credit: " + flipper.getCredit());
    }

    @Override
    public void pressPlayButton(Flipper flipper) {
        System.out.println("**NEW ROUND**");
        flipper.setState(PlayingState.getInstance());
        flipper.reduceCredit();
    }

    public static ReadyState getInstance() {
        return readyStateInstance;
    }
}
