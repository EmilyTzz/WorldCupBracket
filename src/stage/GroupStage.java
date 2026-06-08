package stage;

import object.Group;
import object.Team;

import java.util.ArrayList;
import java.util.List;

public class GroupStage {

    private Team[] teams;

    private Group[][] groups;

    private List<Group> top1s;

    private List<Group> top2s;

    private List<Group> top3s;

    public GroupStage(Team teams, Group groups, int numberOfTeams){
        this.teams = new Team[numberOfTeams];
        this.groups = new Group[numberOfTeams/4][4];
        this.top1s = new ArrayList<>();
        this.top2s = new ArrayList<>();
        this.top3s = new ArrayList<>();
    }

}
