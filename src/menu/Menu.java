package menu;

import object.Group;
import object.KnockoutMatchesDivider;
import object.Match;
import object.Team;
import stage.GroupStage;
import stage.KnockoutStage;

import java.util.*;

public class Menu {

    public static void mainMenu(List<Team> teams) {
        System.out.println("\n----------------------------Group Stage----------------------------\n");
        GroupStage groupStage = new GroupStage(teams, teams.size());
        Group[] groups = groupStage.sortGroups();
        //System.out.println(Arrays.toString(groups));
        displayGroup(groups, groupStage);
    }

    private static void displayGroup(Group[] group, GroupStage groupStage) {
        for (int i = 0; i < group.length; i++) {
            String groupName = group[i].getTeams().get(0).getGroup();
            System.out.println("\n-----------------------" + groupName + "-----------------------");
            for (int j = 0; j < group[i].getSize(); j++) {
                System.out.println(j + 1 + ". " + group[i].getTeams().get(j).getName());
            }
            int firstPlace;
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("\nFirst Place: ");
                    firstPlace = scanner.nextInt();
                    if (firstPlace > 0 && firstPlace < 5) {
                        groupStage.addToTop1(group[i].getTeams().get(firstPlace - 1));
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
                        groupStage.addTop2s(group[i].getTeams().get(secPlace - 1));
                        break;
                    } else if (secPlace == firstPlace) {
                        System.out.println("The team is already selected");
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
                        groupStage.addTop3s(group[i].getTeams().get(thirdPlace - 1));
                        break;
                    } else if (thirdPlace == firstPlace || thirdPlace == secPlace) {
                        System.out.println("The team is already selected");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number");
                }
            }
        }
        chooseBestTop3s(groupStage);
    }

    private static void chooseBestTop3s(GroupStage groupStage) {
        System.out.println("\n-----------------------Top 3s-----------------------");
        for (int i = 0; i < groupStage.getTop3s().size(); i++) {
            System.out.println(i + 1 + ". " + groupStage.getTop3s().get(i));
        }
        while (true) {
            try {
                for (int i = 0; i < 8; i++) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Top " + (i + 1) + " Third Place Team: ");
                    int option = scanner.nextInt();
                    if (option < 13 && option > 0 && groupStage.top3sContains(groupStage.getTop3s().get(option - 1)) == false) {
                        groupStage.addBestTop3s(groupStage.getTop3s().get(option - 1));
                    }
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
            }
        }
        displayAllTopTeams(groupStage);
    }

    private static void displayAllTopTeams(GroupStage groupStage) {
        System.out.println("\n-----------------------Top 1s-----------------------");
        for (int i = 0; i < groupStage.getTop1s().size(); i++) {
            System.out.println(i + 1 + ". " + groupStage.getTop1s().get(i));
        }
        System.out.println("\n-----------------------Top 2s-----------------------");
        for (int i = 0; i < groupStage.getTop2s().size(); i++) {
            System.out.println(i + 1 + ". " + groupStage.getTop2s().get(i));
        }
        System.out.println("\n-----------------------Top 3s-----------------------");
        for (int i = 0; i < groupStage.getBestTop3s().size(); i++) {
            System.out.println(i + 1 + ". " + groupStage.getBestTop3s().get(i));
        }
        boolean isRunning = true;
        while (isRunning) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nClick N to move to the next round... (X to exit): ");
            String option = scanner.nextLine();
            if (option.toUpperCase().equals("X")) {
                exitBracket();
            } else if (option.toUpperCase().equals("N")) {
                bestOf32Display(groupStage);
                isRunning = false;
            }
        }
    }

    private static void bestOf32Display(GroupStage groupStage) {
        System.out.println("\n----------------------------Best of 32----------------------------\n");
        ArrayList<Team> bestOf32teams = new ArrayList<>();
        bestOf32teams.addAll(groupStage.getTop1s());
        bestOf32teams.addAll(groupStage.getTop2s());
        bestOf32teams.addAll(groupStage.getBestTop3s());
        KnockoutMatchesDivider knockoutMatchesDivider = new KnockoutMatchesDivider(bestOf32teams, 32);
        Match[] leftSideMatches = knockoutMatchesDivider.getMatches(new ArrayList<>(knockoutMatchesDivider.selectLeftSideTeams()));
        Match[] rightSideMatches = knockoutMatchesDivider.getMatches(new ArrayList<>(knockoutMatchesDivider.selectRightSideTeams()));
        //System.out.println(Arrays.toString(leftSideMatches));
        //System.out.println(Arrays.toString(rightSideMatches));
        System.out.println("\n-----------------------Left Bracket-----------------------");
        for (int i = 0; i < leftSideMatches.length; i++){
            System.out.println(i+1 + ". " + leftSideMatches[i].toString());
        }
        System.out.println("\n-----------------------Right Bracket-----------------------");
        for (int i = 0; i < rightSideMatches.length; i++){
            System.out.println(i+1 + ". " + rightSideMatches[i].toString());
        }
        KnockoutStage knockoutStage = new KnockoutStage(32);
        bestOf16SelectionLeftBracket(groupStage, leftSideMatches, knockoutStage);
    }

    private static void bestOf16SelectionLeftBracket(GroupStage groupStage, Match[] leftSideMatches, KnockoutStage knockoutStage) {
        System.out.println("\n-----------------------Left Bracket-----------------------");
        for (int i = 0; i < leftSideMatches.length; i++) {
            System.out.println(i + 1 + ". " + leftSideMatches[i].toString());
            System.out.println("    1. " + leftSideMatches[i].getTeam1());
            System.out.println("    2. " + leftSideMatches[i].getTeam2());
            while (true){
                try{
                    System.out.println("Winner: ");
                    Scanner scanner = new Scanner(System.in);
                    int option = scanner.nextInt();
                    if (option == 1){
                        knockoutStage.addToLeftSide(leftSideMatches[i].getTeam1(), i);
                        break;
                    }
                    else if (option == 2){
                        knockoutStage.addToLeftSide(leftSideMatches[i].getTeam2(), i);
                        break;
                    }
                }catch (IllegalArgumentException e){
                    System.out.println("Please select a valid Team");
                }
            }

        }
    }

    private static void exitBracket(){
        System.exit(0);
    }
}
