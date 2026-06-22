package stage;

import object.Team;

import java.util.ArrayList;
import java.util.List;

public class KnockoutStage {

    private Team[] leftSide;

    private Team[] rightSide;

    private List<Team> allTeams;

    public KnockoutStage(int roundOfNumber, ArrayList<Team> allTeams){
        this.allTeams = new ArrayList<>(allTeams);
        this.leftSide = new Team[roundOfNumber/2];
        this.rightSide = new Team[roundOfNumber/2];
    }

    public List<Team> getAllTeams(){
        return allTeams;
    }

    public Team[] getLeftSide() {
        return leftSide;
    }

    public Team[] getRightSide() {
        return rightSide;
    }

    public void selectLeftSideTeams(){
        int j = 0;
        for (int i = 0; i < leftSide.length-1; i = i + 2){
            leftSide[j] = allTeams.get(i);
            j ++;
        }
    }

    public void setRightSide(){
        int j = 0;
        for (int i = 1; i < rightSide.length-1; i = i + 2){
            rightSide[j] = allTeams.get(i);
            j ++;
        }
    }



}
