package object;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private ArrayList<Team> teams;

    public Group() {
        teams = new ArrayList<Team>();
    }

    public void addTeam(Team team){
        teams.add(team);
    }

    @Override
    public String toString() {
        return teams.toString();
    }

    public int getSize(){
        return teams.size();
    }

    public ArrayList<Team> getTeams(){
        return teams;
    }

}
