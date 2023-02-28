package main;

import main.statePattern.NoCreditState;
import main.statePattern.State;

public class Flipper {

    private State state;
    private int level = 1;
    private int credit;

    public int getCredit() {
        return credit;
    }

    public void addCredit() {
        credit += 1;
    }

    public void reduceCredit() {
        credit -= 1;
    }

    private static final Flipper flipperInstance = new Flipper();

    private Flipper() {
        this.state = NoCreditState.getInstance();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void insertCoin() {
        state.insertCoin(this);
    }

    public void pressPlayButton() {
        state.pressPlayButton(this);
    }

    public void nextLevel() {
        level += 1;
    }

    public static Flipper getInstance() {
        return flipperInstance;
    }

    public int getLevel() {
        return level;
    }

}
