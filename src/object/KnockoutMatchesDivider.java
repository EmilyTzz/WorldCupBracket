package object;

import stage.KnockoutStage;

import java.util.ArrayList;
import java.util.List;

public class KnockoutMatchesDivider {

    private ArrayList<Team> teams;

    private Match[] leftSideMatches;

    private Match[] rightSideMatches;

    public KnockoutMatchesDivider(ArrayList<Team> teams, int roundOfNumber){
        this.teams = new ArrayList<>(teams);
        this.leftSideMatches = new Match[roundOfNumber/4];
        this.rightSideMatches = new Match[roundOfNumber/4];
    }

    public List<Team> selectLeftSideTeams(){
        int j = 0;
        ArrayList<Team> leftSide = new ArrayList<>();
        for (int i = 0; i < (teams.size()/2)-1; i = i + 2){
            leftSide.add(teams.get(i));
            j ++;
        }
        return leftSide;
    }

    public List<Team> selectRightSideTeams(){
        int j = 0;
        ArrayList<Team> rightSide = new ArrayList<>();
        for (int i = 1; i < (teams.size()/2)-1; i = i + 2){
            rightSide.add(teams.get(i));
            j ++;
        }
        return rightSide;
    }
}
