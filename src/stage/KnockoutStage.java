package stage;

import object.Match;
import object.Team;

import java.util.ArrayList;
import java.util.List;

public class KnockoutStage {


    private Match[] leftSideMatches;

    private Match[] rightSideMatches;

    public KnockoutStage(int roundOfNumber, Match[] leftSideMatches, Match[] rightSideMatches){
        this.leftSideMatches = leftSideMatches;
        this.rightSideMatches = rightSideMatches;
    }

    public Match[] getLeftSide() {
        return leftSideMatches;
    }

    public Match[] getRightSide() {
        return rightSideMatches;
    }



}
