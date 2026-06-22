package stage;

import object.Group;
import object.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupStage {

    private List<Team> teams;

    private Group[] groups;

    private List<Team> top1s;

    private List<Team> top2s;

    private List<Team> top3s;

    private List<Team> bestTop3s;

    private int numberOfTeams;

    public GroupStage(List<Team> teams, int numberOfTeams){
        this.teams = new ArrayList<>(teams); // copy of the list of teams
        this.numberOfTeams = numberOfTeams;
        this.groups = new Group[numberOfTeams/4];
        this.top1s = new ArrayList<>();
        this.top2s = new ArrayList<>();
        this.top3s = new ArrayList<>();
        this.bestTop3s = new ArrayList<>();
    }

    public List<Team> getTeams() {
        return teams;
    }

    public Group[] getGroups() {
        return groups;
    }

    public List<Team> getTop1s() {
        return top1s;
    }

    public List<Team> getTop2s() {
        return top2s;
    }

    public List<Team> getTop3s() {
        return top3s;
    }

    public List<Team> getBestTop3s() {
        return bestTop3s;
    }

    public void addToTop1(Team team){
        top1s.add(team);
    }

    public void addTop2s(Team team){
        top2s.add(team);
    }

    public void addTop3s(Team team){
        top3s.add(team);

    }

    public void addBestTop3s(Team team){
        bestTop3s.add(team);

    }

    public boolean top3sContains(Team team){
        for (int i = 0; i < top3s.size(); i++){
            if (team.getName().equals(top3s.get(i).getName())){
                return false;
            }
        }
        return true;
    }

    public Group[] sortGroups() {
        for (int i = 0; i < numberOfTeams / 4; i++) { // List through all the groups
            Group group = new Group(); // Create a new group object for every group
            group.addTeam(teams.get(0));
            for (int k = 1; k < teams.size(); k++) { // List through all the teams in the list
                if (teams.get(0).getGroup().equals(teams.get(k).getGroup())) { // Add all 4 teams with the same group to a group
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
