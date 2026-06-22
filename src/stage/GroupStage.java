package stage;

import object.Group;
import object.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupStage {

    private List<Team> teams;

    private Group[] groups;

    private List<Group> top1s;

    private List<Group> top2s;

    private List<Group> top3s;

    private int numberOfTeams;

    public GroupStage(List<Team> teams, int numberOfTeams){
        this.teams = teams;
        this.numberOfTeams = numberOfTeams;
        this.groups = new Group[numberOfTeams/4];
        this.top1s = new ArrayList<>();
        this.top2s = new ArrayList<>();
        this.top3s = new ArrayList<>();
    }

    public List<Team> getTeams() {
        return teams;
    }

    public Group[] getGroups() {
        return groups;
    }

    public List<Group> getTop1s() {
        return top1s;
    }

    public List<Group> getTop2s() {
        return top2s;
    }

    public List<Group> getTop3s() {
        return top3s;
    }

    public Group[] sortGroups() {
        for (int i = 0; i < numberOfTeams / 4; i++) {
            Group group = new Group();
            group.addTeam(teams.get(0));
            for (int k = 1; k < teams.size(); k++) {
                if (teams.get(0).getGroup().equals(teams.get(k).getGroup())) {
                    group.addTeam(teams.get(k));
                }
                if (group.getSize() == 4) {
                    for (Team team : group.getTeams()){
                        teams.remove(team);
                    }
                    break;
                }
            }
            groups[i] = group;
        }
        return groups;
    }

}
