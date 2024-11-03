package com.generics.example;

record BaseballPlayer(String name, String poistion){};

public class Main {

    public static void main(String[] args) {

        BaseBallTeam phillies = new BaseBallTeam("Philadelphia phillies");
        BaseBallTeam astros = new BaseBallTeam("Houston Astros");
        scoreResult(phillies, 3, astros, 5);

        var harper  = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh  = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.listTeamMembers();
    }

    public static void scoreResult(BaseBallTeam team1, int t1_Score, BaseBallTeam team2, int t2_Score){
        String message = team1.setScore(t1_Score, t2_Score);
        team2.setScore(t2_Score, t1_Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
