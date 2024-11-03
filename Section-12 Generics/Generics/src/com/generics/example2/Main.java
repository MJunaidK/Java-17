package com.generics.example2;

interface Player{
    public abstract String name();
}

record BaseballPlayer(String name, String poistion) implements Player{};

record FootballPlayer(String name, String poistion) implements Player{};

record VolleyballPlayer(String name, String poistion) implements Player{};

public class Main {

    public static void main(String[] args) {

        var philly = new Affiliation("city", "Philadelphia, PA", "US");

        BaseBallTeam phillies1 = new BaseBallTeam("Philadelphia phillies");
        BaseBallTeam astros1 = new BaseBallTeam("Houston Astros");
        scoreResult(phillies1, 3, astros1, 5);

        SportsTeam phillies2 = new SportsTeam("Philadelphia phillies");
        SportsTeam astros2 = new SportsTeam("Houston Astros");
        scoreResult(phillies2, 3, astros2, 5);

        Team<BaseballPlayer, Affiliation> phillies = new Team<>("Philadelphia phillies", philly);
        Team<BaseballPlayer, Affiliation> astros = new Team<>("Houston Astros");
        scoreResult(phillies, 3, astros, 5);


        var harper  = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh  = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        var guthrie = new BaseballPlayer("D Guthrie", "Center Fielder");
        phillies.addTeamMember(guthrie);
        phillies.listTeamMembers();

        SportsTeam afc1 = new SportsTeam("Adelaide Crows");
        Team<FootballPlayer, String> afc = new Team<>("Adelaide Crows", "City of Adelaide, South Australia, in AU");
        var tex = new FootballPlayer("Tex Walker", "Center half forward");
        afc.addTeamMember(tex);
        afc.listTeamMembers();
        var rory = new FootballPlayer("Rory Liard", "Midfield");
        afc.addTeamMember(rory);
        afc.listTeamMembers();

        Team<VolleyballPlayer, Affiliation> adelaide = new Team<>("Adelaide Storm");
        adelaide.addTeamMember(new VolleyballPlayer("N Roberts", "Setter"));
        adelaide.listTeamMembers();

        var canberra = new Team<VolleyballPlayer, Affiliation>("Canberaa Heat");
        canberra.addTeamMember(new VolleyballPlayer("B Black", "Opposite"));
        canberra.listTeamMembers();
        scoreResult(canberra, 0,adelaide, 1);

        // Can't use generic class with primitive data type instead we have to use Wrapper class
        //Team<int> melbourneVB = new Team<>("Melboune Vipers");

        //Team<Integer> melbourneVB = new Team<>("Melboune Vipers");
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

    public static void scoreResult(Team team1, int t1_Score, Team team2, int t2_Score){
        String message = team1.setScore(t1_Score, t2_Score);
        team2.setScore(t2_Score, t1_Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
