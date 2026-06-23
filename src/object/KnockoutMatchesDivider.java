package object;

import stage.KnockoutStage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
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
        this.leftSide = new ArrayList<>(teams.subList(0, teams.size()/2));
        this.rightSide = new ArrayList<>(teams.subList(teams.size()/2, teams.size()));
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

    public ArrayList<Team> getLeftSide(){
        return leftSide;
    }

    public ArrayList<Team> getRightSide() {
        return rightSide;
    }

    private ArrayList<Team> sortTeams(ArrayList<Team> teams){
        ArrayList<Team> sortedTeams = new ArrayList<>(teams); // List that stores the sorted teams that makes sure the teams with the same group would not meet again
        for (int i = 0; i < sortedTeams.size(); i ++){ // Loops through the weaker team list
            if (sortedTeams.get(i).getGroup().equals(sortedTeams.get(sortedTeams.size()-i-1).getGroup())){ // if the last strongest team is the same group as the best top 3 team
                Collections.swap(sortedTeams, sortedTeams.size()-i-1, sortedTeams.size()-i-2);
            }
        }
        System.out.println(sortedTeams);
        return sortedTeams;
    }

    public Match[] getMatches(ArrayList<Team> teams){
        teams = sortTeams(teams);
        Match[] matches = new Match[roundOfNumber/4];
        for (int i = 0; i < (teams.size()/2)-1; i ++){
            Match match = new Match(teams.get(i), teams.get(teams.size()-i-1));
            matches[i] = match;
        }
        return matches;
    }
}
