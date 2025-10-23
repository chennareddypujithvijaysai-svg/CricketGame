package main;

import java.util.*;

public class Team {
    private String name;
    private List<Player> players;
    private int totalRuns;
    private int wickets;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.totalRuns = 0;
        this.wickets = 0;
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addRuns(int runs) {
        totalRuns += runs;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getWickets() {
        return wickets;
    }

    public void loseWicket() {
        wickets++;
    }
}
