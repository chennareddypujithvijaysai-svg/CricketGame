package main;

import java.io.*;

public class Scoreboard {

    public void displayInnings(Team team) {
        System.out.println("\n" + team.getName() + " Innings Over!");
        System.out.println("Score: " + team.getTotalRuns() + "/" + team.getWickets());
        System.out.println("----------------------------------");
    }

    public void displayResult(Team teamA, Team teamB) {
        System.out.println("\n🏁 MATCH RESULT 🏁");
        System.out.println(teamA.getName() + ": " + teamA.getTotalRuns() + "/" + teamA.getWickets());
        System.out.println(teamB.getName() + ": " + teamB.getTotalRuns() + "/" + teamB.getWickets());

        String result;
        if (teamA.getTotalRuns() > teamB.getTotalRuns()) {
            result = teamA.getName() + " won by " + (teamA.getTotalRuns() - teamB.getTotalRuns()) + " runs!";
        } else if (teamB.getTotalRuns() > teamA.getTotalRuns()) {
            result = teamB.getName() + " won by " + (5 - teamB.getWickets()) + " wickets!";
        } else {
            result = "The match is tied!";
        }

        System.out.println(result);
        saveResult(teamA, teamB, result);
    }

    private void saveResult(Team teamA, Team teamB, String result) {
        try {
            File file = new File("data/match_results.txt");
            file.getParentFile().mkdirs();
            FileWriter writer = new FileWriter(file, true);
            writer.write(teamA.getName() + " vs " + teamB.getName() + " → " + result + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving match result: " + e.getMessage());
        }
    }
}
