package main;

import java.util.*;

public class Match {

    private Team teamA, teamB;
    private int overs;
    private Scoreboard scoreboard;
    private Scanner sc = new Scanner(System.in);

    public Match(Team teamA, Team teamB, int overs) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.overs = overs;
        this.scoreboard = new Scoreboard();
    }

    public void playMatch() {
        System.out.println("\nTossing the coin...");
        Team tossWinner = (Math.random() < 0.5) ? teamA : teamB;
        System.out.println(tossWinner.getName() + " won the toss!");
        System.out.print("Choose to bat or bowl (bat/bowl): ");
        String choice = sc.next();

        Team battingFirst = choice.equalsIgnoreCase("bat") ? tossWinner :
                (tossWinner == teamA ? teamB : teamA);
        Team bowlingFirst = (battingFirst == teamA) ? teamB : teamA;

        playInnings(battingFirst, bowlingFirst);
        playInnings(bowlingFirst, battingFirst);

        scoreboard.displayResult(teamA, teamB);
    }

    private void playInnings(Team batting, Team bowling) {
        System.out.println("\n===== " + batting.getName() + " Innings =====");
        List<Player> players = batting.getPlayers();

        int totalBalls = overs * 6;
        int currentPlayer = 0;

        for (int ball = 1; ball <= totalBalls; ball++) {
            if (currentPlayer >= players.size()) break;

            Player striker = players.get(currentPlayer);
            Ball b = new Ball();
            striker.faceBall();

            if (b.isWicket()) {
                striker.setOut();
                batting.loseWicket();
                System.out.println("Ball " + ball + ": " + striker.getName() + " is OUT!");
                currentPlayer++;
            } else {
                striker.addRuns(b.getRuns());
                batting.addRuns(b.getRuns());
                System.out.println("Ball " + ball + ": " + striker.getName() + " scored " + b.getRuns() + " runs.");
            }

            if (batting.getWickets() >= 5) break;
        }

        scoreboard.displayInnings(batting);
    }
}
