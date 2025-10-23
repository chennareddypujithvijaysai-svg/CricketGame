package main;

import java.util.Random;

public class Ball {
    private int runs;
    private boolean wicket;

    public Ball() {
        Random rand = new Random();
        int outcome = rand.nextInt(8); // 0–7
        if (outcome == 7) {
            wicket = true;
            runs = 0;
        } else {
            wicket = false;
            runs = outcome;
        }
    }

    public int getRuns() {
        return runs;
    }

    public boolean isWicket() {
        return wicket;
    }
}
