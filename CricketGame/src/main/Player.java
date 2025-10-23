package main;

public class Player {
    private String name;
    private int runs;
    private int balls;
    private boolean isOut;

    public Player(String name) {
        this.name = name;
        this.runs = 0;
        this.balls = 0;
        this.isOut = false;
    }

    public void addRuns(int r) {
        runs += r;
    }

    public void faceBall() {
        balls++;
    }

    public void setOut() {
        isOut = true;
    }

    public boolean isOut() {
        return isOut;
    }

    public String getName() {
        return name;
    }

    public int getRuns() {
        return runs;
    }

    public int getBalls() {
        return balls;
    }
}
