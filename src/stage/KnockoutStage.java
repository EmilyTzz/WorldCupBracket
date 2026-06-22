package stage;

import object.Team;

import java.util.ArrayList;

public class KnockoutStage {

    private ArrayList<Team> top1s;

    private ArrayList<Team> top2s;

    private ArrayList<Team> top3s;

    private ArrayList<Team> leftSide;

    private ArrayList<Team> rightSide;

    private ArrayList<Team> allTeams;

    public KnockoutStage(ArrayList<Team> top1s, ArrayList<Team> top2s, ArrayList<Team> top3s){
        this.top1s = new ArrayList<>(top1s);
        this.top2s = new ArrayList<>(top2s);
        this.top3s = new ArrayList<>(top3s);
        this.allTeams = new ArrayList<>();
        // Adds all the teams in the order of top 1 to top 3
        allTeams.addAll(top1s);
        allTeams.addAll(top2s);
        allTeams.addAll(top3s);
        this.leftSide = new ArrayList<>();
        this.rightSide = new ArrayList<>();
    }

    public ArrayList<Team> getAllTeams(){
        return allTeams;
    }

    public ArrayList<Team> getLeftSide() {
        return leftSide;
    }

    public ArrayList<Team> getRightSide() {
        return rightSide;
    }
}
