package menu;

import object.Group;
import object.Team;
import stage.GroupStage;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void mainMenu(List<Team> teams){
        System.out.println("\n----------------------------Group Stage----------------------------\n");
        GroupStage groupStage = new GroupStage(teams, teams.size());
        Group[] groups = groupStage.sortGroups();
        //System.out.println(Arrays.toString(groups));
        displayGroup(groups, groupStage);
    }

    private static void displayGroup(Group[] group, GroupStage groupStage){
        for (int i = 0; i < group.length; i++){
            String groupName = group[i].getTeams().get(0).getGroup();
            System.out.println("\n-----------------------"+groupName+"-----------------------");
            for (int j = 0; j < group[i].getSize(); j ++){
                System.out.println(j+1 + ". " + group[i].getTeams().get(j).getName());
            }
            int firstPlace;
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("\nFirst Place: ");
                    firstPlace = scanner.nextInt();
                    if (firstPlace > 0 && firstPlace < 5) {
                        for (int j = 0; j < group[i].getSize(); j++) {
                            groupStage.addToTop1(group[i].getTeams().get(firstPlace - 1));
                        }
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number");
                }
            }
            int secPlace;
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("\nSecond Place: ");
                    secPlace = scanner.nextInt();
                    if (secPlace > 0 && secPlace < 5 && secPlace != firstPlace) {
                        for (int j = 0; j < group[i].getSize(); j++) {
                            groupStage.addTop2s(group[i].getTeams().get(secPlace - 1));
                        }
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number");
                }
            }
            int thirdPlace;
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("\nThird Place: ");
                    thirdPlace = scanner.nextInt();
                    if (thirdPlace > 0 && thirdPlace < 5 && thirdPlace != firstPlace && thirdPlace != secPlace) {
                        for (int j = 0; j < group[i].getSize(); j++) {
                            groupStage.addTop3s(group[i].getTeams().get(thirdPlace - 1));
                        }
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number");
                }
            }
        }
    }
}
