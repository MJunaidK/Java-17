package com.generics.example1;

interface Player{}

record BaseballPlayer(String name, String poistion) implements Player{};

record FootballPlayer(String name, String poistion) implements Player{};

public class Main {

    public static void main(String[] args) {

        BaseBallTeam phillies1 = new BaseBallTeam("Philadelphia phillies");
        BaseBallTeam astros1 = new BaseBallTeam("Houston Astros");
        scoreResult(phillies1, 3, astros1, 5);

        SportsTeam phillies = new SportsTeam("Philadelphia phillies");
        SportsTeam astros = new SportsTeam("Houston Astros");
        scoreResult(phillies, 3, astros, 5);

        var harper  = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh  = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.listTeamMembers();

        SportsTeam afc = new SportsTeam("Adelaide Crows");
        var tex = new FootballPlayer("Tex Walker", "Center half forward");
        afc.addTeamMember(tex);
        afc.listTeamMembers();

        // no type checking, afc has now one fotball player and one baseball player
        var guthrie = new BaseballPlayer("D Guthrie", "Center Fielder");
        afc.addTeamMember(guthrie);
        afc.listTeamMembers();
    }

    public static void scoreResult(BaseBallTeam team1, int t1_Score, BaseBallTeam team2, int t2_Score){
        String message = team1.setScore(t1_Score, t2_Score);
        team2.setScore(t2_Score, t1_Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(SportsTeam team1, int t1_Score, SportsTeam team2, int t2_Score){
        String message = team1.setScore(t1_Score, t2_Score);
        team2.setScore(t2_Score, t1_Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
