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


}
