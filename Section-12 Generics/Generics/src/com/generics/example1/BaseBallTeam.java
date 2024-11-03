package com.generics.example1;

import java.util.ArrayList;
import java.util.List;

public class BaseBallTeam {

    private String teamName;
    private List<com.generics.example1.BaseballPlayer> teamMembers = new ArrayList<>();
    private int totalWins= 0;
    private int totalloss = 0;
    private int totalTies = 0;

    public BaseBallTeam(String teamName) {
        this.teamName = teamName;
    }

    public void  addTeamMember(com.generics.example1.BaseballPlayer player){
        if(!teamMembers.contains(player)){
            teamMembers.add(player);
        }
    }

    public void listTeamMembers(){
        System.out.println(teamName + " Roster:");
        System.out.println(teamMembers);
    }

    public int ranking(){
        return (totalloss * 2) + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore){

        String message = "Lost to";
        if(ourScore > theirScore){
            totalWins++;
            message = "beat";
        } else if (ourScore == theirScore) {
             totalTies++;
             message = "tied";
        } else{
            totalloss++;
        }
        return  message;
    }

    @Override
    public String toString() {
        return teamName + "(Ranked " + ranking() + ")";
    }
}
