package main;

import java.util.*;

public class GameEngine {

    private Team teamA, teamB;
    private Match match;
    private Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("🏏 Welcome to the Professional Cricket Game! 🏏");
        System.out.print("Enter Team A name: ");
        String teamAName = sc.nextLine();
        System.out.print("Enter Team B name: ");
        String teamBName = sc.nextLine();

        teamA = new Team(teamAName);
        teamB = new Team(teamBName);

        System.out.println("\nEnter players for " + teamAName + ":");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Player " + i + ": ");
            teamA.addPlayer(new Player(sc.nextLine()));
        }

        System.out.println("\nEnter players for " + teamBName + ":");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Player " + i + ": ");
            teamB.addPlayer(new Player(sc.nextLine()));
        }

        System.out.print("\nEnter number of overs: ");
        int overs = sc.nextInt();

        match = new Match(teamA, teamB, overs);
        match.playMatch();
    }
}
