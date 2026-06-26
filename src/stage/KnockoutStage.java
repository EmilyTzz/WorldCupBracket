package stage;

import object.Match;
import object.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnockoutStage {


    //private Match[] leftSideMatches;

    //private Match[] rightSideMatches;

    private Match[] nextRoundLeftSideMatches;

    private Match[] nextRoundRightSideMatches;

    private final Team[] nextRoundLeftSideTeams;

    private final Team[] nextRoundRightSideTeams;

    private Match[] finalTeams;

    private Match[] thirdPlaceTeams;

    private int roundOfNumber;

    public KnockoutStage(int roundOfNumber){
        this.roundOfNumber = roundOfNumber;
        this.nextRoundLeftSideTeams = new Team[roundOfNumber/2];
        this.nextRoundRightSideTeams = new Team[roundOfNumber/2];
        if (roundOfNumber > 4){
            this.nextRoundLeftSideMatches = new Match[roundOfNumber/8];
            this.nextRoundRightSideMatches = new Match[roundOfNumber/8];
            this.finalTeams = null;
            this.thirdPlaceTeams = null;
        }
        else if (roundOfNumber == 4){
            this.nextRoundLeftSideMatches = null;
            this.nextRoundRightSideMatches = null;
            this.finalTeams = new Match[1];
            this.thirdPlaceTeams = new Match[1];
        }
    }

    public int getRoundOfNumber(){
        return roundOfNumber;
    }

    public void addToLeftSide(Team team, int index){
        nextRoundLeftSideTeams[index] = team;
    }

    public void addToRightSide(Team team, int index){
        nextRoundRightSideTeams[index] = team;
    }

    public Match[] getNextRoundLeftSide() {
        int j = 0;
        for (int i = 0; i < nextRoundLeftSideTeams.length/2; i = i + 2){
            if (nextRoundLeftSideTeams[i] instanceof Team team && nextRoundLeftSideTeams[i+1] instanceof Team team2) {
                Match match = new Match(team, team2);
                nextRoundLeftSideMatches[j] = match;
                j ++;
            }
        }
        //System.out.println(Arrays.toString(nextRoundLeftSideMatches));
        return nextRoundLeftSideMatches;
    }

    public Match[] getNextRoundRightSide() {
        int j = 0;
        for (int i = 0; i < nextRoundRightSideTeams.length/2; i = i + 2){
            if (nextRoundRightSideTeams[i] instanceof Team team && nextRoundRightSideTeams[i+1] instanceof Team team2) {
                Match match = new Match(team, team2);
                nextRoundRightSideMatches[j] = match;
                j ++;
            }
        }
        return nextRoundRightSideMatches;}

    public Match[] getThirdPlaceTeams(){
        if (nextRoundLeftSideTeams[1] instanceof Team team && nextRoundRightSideTeams[1] instanceof Team team2 && roundOfNumber == 4){
            Match match = new Match(team, team2);
            thirdPlaceTeams[0] = match;
            return thirdPlaceTeams;
        }
        return null;
    }

    public Match[] getFinalTeams(){
        if (nextRoundLeftSideTeams[0] instanceof Team team && nextRoundRightSideTeams[0] instanceof Team team2 && roundOfNumber == 4){
            Match match = new Match(team, team2);
            finalTeams[0] = match;
            return finalTeams;
        }
        return null;
    }

}
