package main.statePattern;

import main.Flipper;

public class NoCreditState extends State {

    private static final NoCreditState noCreditStateInstance = new NoCreditState();

    private NoCreditState() {
    }

    @Override
    public void insertCoin(Flipper flipper) {
        flipper.setState(ReadyState.getInstance());
        flipper.addCredit();
        System.out.println("°°Münze eingeworfen!°° Credit: " + flipper.getCredit());
    }

    @Override
    public void pressPlayButton(Flipper flipper) {
        System.out.println("°°kein Kredit vorhanden!°°");
    }


    public static NoCreditState getInstance() {
        return noCreditStateInstance;
    }
}
