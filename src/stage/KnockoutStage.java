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

    private Team[] nextRoundLeftSideTeams;

    private Team[] nextRoundRightSideTeams;

    private Match[] finalTeams;

    public KnockoutStage(int roundOfNumber){
        if (roundOfNumber > 4){
            this.nextRoundLeftSideTeams = new Team[roundOfNumber/2];
            this.nextRoundRightSideTeams = new Team[roundOfNumber/2];
            this.nextRoundLeftSideMatches = new Match[roundOfNumber/8];
            this.nextRoundRightSideMatches = new Match[roundOfNumber/8];
            this.finalTeams = new Match[2];
        }
        else if (roundOfNumber == 4){
            this.nextRoundLeftSideTeams = new Team[1];
            this.nextRoundRightSideTeams = new Team[1];
            this.nextRoundLeftSideMatches = null;
            this.nextRoundRightSideMatches = null;
            this.finalTeams = new Match[1];
        }
    }

    public void addToLeftSide(Team winningTeam, int index){
        nextRoundLeftSideTeams[index] = winningTeam;
    }

    public void addToRightSide(Team winningTeam, int index){
        nextRoundRightSideTeams[index] = winningTeam;
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

    public Match[] getFinalTeams(){
        if (nextRoundLeftSideTeams.length == 1 && nextRoundRightSideTeams.length == 1){
            if (nextRoundLeftSideTeams[0] instanceof Team team && nextRoundRightSideTeams[0] instanceof Team team2){
                Match match = new Match(team, team2);
                finalTeams[0] = match;
                return finalTeams;
            }
        }
        return null;
    }

}
