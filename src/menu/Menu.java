package menu;

import object.Group;
import object.Team;
import stage.GroupStage;

import java.util.Arrays;
import java.util.List;

public class Menu {

    public static void mainMenu(List<Team> teams){
        System.out.println("----------------------------Group Stage----------------------------\n");
        GroupStage groupStage = new GroupStage(teams, teams.size());
        Group[] groups = groupStage.sortGroups();
        //System.out.println(Arrays.toString(groups));
        displayGroup(groups);
    }

    private static void displayGroup(Group[] group){
        for (int i = 0; i < group.length; i++){
            String groupName = group[i].getTeams().get(0).getGroup();
            System.out.println("\n-----------------------"+groupName+"-----------------------");
            for (int j = 0; j < group[i].getSize(); j ++){
                System.out.println("- " + group[i].getTeams().get(j).getName());
            }
        }
    }

}
