package menu;

import object.Group;
import object.Team;
import stage.GroupStage;

import java.io.*;
import java.util.ArrayList;

public class Reader {
    public static void loadTeams(File file){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<Team> teams = new ArrayList<>();
            String line;
            reader.readLine();
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if (data.length == 2){
                    String groupName = data[0];
                    String teamName = data[1];
                    Team team = new Team(teamName, groupName);
                    teams.add(team);
                }
            }
            Menu.mainMenu(teams);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
