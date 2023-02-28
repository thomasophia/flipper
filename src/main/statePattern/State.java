package main.statePattern;

import main.Flipper;

public abstract class State {

    public abstract void insertCoin(Flipper flipper);

    public abstract void pressPlayButton(Flipper flipper);
}
