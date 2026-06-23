package object;

import stage.KnockoutStage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
        this.leftSide = new ArrayList<>();
        this.rightSide = new ArrayList<>();
        this.leftSideMatches = new Match[roundOfNumber/4];
        this.rightSideMatches = new Match[roundOfNumber/4];
        this.roundOfNumber = roundOfNumber;
    }

    public ArrayList<Team> selectLeftSideTeams(){
        for (int i = 0; i < teams.size(); i = i + 2){
            leftSide.add(teams.get(i));
        }
        return leftSide;
    }

    public ArrayList<Team> selectRightSideTeams(){
        for (int i = 1; i < teams.size(); i = i + 2){
            rightSide.add(teams.get(i));
        }
        return rightSide;
    }

    public ArrayList<Team> getLeftSide(){
        return leftSide;
    }

    public ArrayList<Team> getRightSide() {
        return rightSide;
    }

    private ArrayList<Team> sortTeams(ArrayList<Team> allTeams){
        ArrayList<Team> sortedTeams = new ArrayList<>(allTeams); // List that stores the sorted teams that makes sure the teams with the same group would not meet again
        for (int i = 0; i < sortedTeams.size(); i ++){ // Loops through the weaker team list
            if (sortedTeams.get(i).getGroup().equals(sortedTeams.get(sortedTeams.size()-i-1).getGroup())){ // if the last strongest team is the same group as the best top 3 team
                Collections.swap(sortedTeams, sortedTeams.size()-i-1, sortedTeams.size()-i-2);
            }
        }
        //System.out.println(sortedTeams);
        //System.out.println(sortedTeams.size());
        return sortedTeams;
    }

    public Match[] getMatches(ArrayList<Team> allTeams){
        allTeams = sortTeams(allTeams);
        Match[] matches = new Match[roundOfNumber/4];
        //System.out.println(allTeams);
        int j = 0;
        for (int i = 0; i < (allTeams.size()); i ++){
            Match match = new Match(allTeams.get(i), allTeams.get(allTeams.size()-i-1));
            matches[i] = match;
            //System.out.println(Arrays.toString(matches));
            j++;
            if (j == roundOfNumber/4){
                break;
            }
        }
        return matches;
    }
}
