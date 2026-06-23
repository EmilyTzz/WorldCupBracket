package object;

import stage.KnockoutStage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class KnockoutMatchesDivider {

    private ArrayList<Team> teams;

    private ArrayList<Team> leftSide;

    private ArrayList<Team> rightSide;

    private Match[] leftSideMatches;

    private Match[] rightSideMatches;

    private int roundOfNumber;

    public KnockoutMatchesDivider(ArrayList<Team> teams, int roundOfNumber){
        this.teams = new ArrayList<>(teams);
        this.leftSide = new ArrayList<>();
        this.rightSide = new ArrayList<>();
        this.leftSideMatches = new Match[roundOfNumber/4];
        this.rightSideMatches = new Match[roundOfNumber/4];
        this.roundOfNumber = roundOfNumber;
    }

    public void selectLeftSideTeams(){
        int j = 0;
        for (int i = 0; i < leftSide.size()-1; i = i + 2){
            leftSide.add(teams.get(i));
            j ++;
        }
    }

    public void selectRightSideTeams(){
        int j = 0;
        for (int i = 1; i < rightSide.size()-1; i = i + 2){
            rightSide.add(teams.get(i));
            j ++;
        }
    }

    private ArrayList<Team> sortTeams(ArrayList<Team> teams){
        ArrayList<Team> strongerTeams = new ArrayList<>(teams.subList(0,teams.size()/2)); // Stronger teams is the first half of the list
        ArrayList<Team> weakerTeams = new ArrayList<>(teams.subList(teams.size()/2, teams.size())); // Weaker teams is the last half
        ArrayList<Team> sortedTeams = new ArrayList<>(strongerTeams); // List that stores the sorted teams that makes sure the teams with the same group would not meet again
        for (int i = 0; i < weakerTeams.size(); i ++){ // Loops through the weaker team list
            if (i == weakerTeams.size()-1){ // if i is at the last index
                if (strongerTeams.get(i).getGroup().equals(weakerTeams.get(weakerTeams.size()-i).getGroup())){ // if the last strongest team is the same group as the best top 3 team
                    sortedTeams.remove(i+2); // remove the second-weakest team
                    sortedTeams.add(i+2, weakerTeams.get(weakerTeams.size()-i)); // replace the second-weakest team's place with the best weakest tea,
                    sortedTeams.add(i+1, weakerTeams.get(weakerTeams.size()-i+1));
                }
            }
            else if(strongerTeams.get(i).getGroup().equals(weakerTeams.get(weakerTeams.size()-i).getGroup())){
                sortedTeams.add(weakerTeams.get(weakerTeams.size()-(i-1)));
            }
            else{
                sortedTeams.add(weakerTeams.get(weakerTeams.size()-i));
            }
        }
        return sortedTeams;
    }


    public Match[] getMatches(ArrayList<Team> teams){

        Match[] matches = new Match[roundOfNumber/4];
        for (int i = 0; i < (teams.size()/2)-1; i ++){
            if (!(teams.get(i).getGroup().equals(teams.get(teams.size()).getGroup()))){
                Match match = new Match(teams.get(i), teams.get(teams.size()));
                matches[i] = match;
                teams.remove(i);
                teams.remove(teams.size());
            }else{

            }
        }

        return matches;
    }
}
