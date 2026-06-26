package menu;

import object.Group;
import object.KnockoutMatchesDivider;
import object.Match;
import object.Team;
import stage.GroupStage;
import stage.KnockoutStage;

import java.util.*;

public class Menu {

    /**
     * Indicator for left side of bracket
     */
    private static final String LEFT = "Left Bracket";
    /**
     * Indicator for right side of bracket
     */
    private static final String RIGHT = "Right Bracket";
    /**
     * Indicator for the final match of the bracket
     */
    private static final String FINAL = "Final";
    /**
     * Indicator for the third place play-off of the bracket
     */
    private static final String THIRD_PLACE_PLAYOFF = "Third-Place Play-off";

    /**
     * Main menu that will display the group stage
     * @param teams List of teams imported from the csv file
     */
    public static void mainMenu(List<Team> teams) {
        System.out.println("\n----------------------------Group Stage----------------------------\n");
        GroupStage groupStage = new GroupStage(teams, teams.size());
        Group[] groups = groupStage.sortGroups();
        //System.out.println(Arrays.toString(groups));
        displayGroup(groups, groupStage);
    }

    /**
     * This function helps to display each of the group and allow players to rank them. Each team would then be added
     * into a List associated with their ranking
     * @param group List of groups in the group stage
     * @param groupStage GroupStage object
     */
    private static void displayGroup(Group[] group, GroupStage groupStage) {
        for (int i = 0; i < group.length; i++) { // loops through all the groups
            String groupName = group[i].getTeams().get(0).getGroup(); // Gets the group latter from the first team of the group
            System.out.println("\n-----------------------" + groupName + "-----------------------");
            for (int j = 0; j < group[i].getSize(); j++) { // List through the teams in the group
                System.out.println(j + 1 + ". " + group[i].getTeams().get(j).getName());
            }
            int firstPlace;
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("\nFirst Place: ");
                    firstPlace = scanner.nextInt(); // get user input for the rankings of the teams
                    if (firstPlace > 0 && firstPlace < 5) {
                        groupStage.addToTop1(group[i].getTeams().get(firstPlace - 1)); // add the team the user chose as first place into the first place list
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
                    } else if (secPlace == firstPlace) { // makes sure the second place team is not the first place team
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
        chooseBestTop3s(groupStage); // let user choose the best top 3 teams
    }

    /**
     * This function helps to display all the top 3 teams for the user to choose 8 that can advance
     * @param groupStage GroupStage object
     */
    private static void chooseBestTop3s(GroupStage groupStage) {
        System.out.println("\n-----------------------Top 3s-----------------------");
        for (int i = 0; i < groupStage.getTop3s().size(); i++) { // displays all the teams
            System.out.println(i + 1 + ". " + groupStage.getTop3s().get(i));
        }
        for (int i = 0; i < 8; i++) { // have the user pick the top 8 teams
            chooseBestTop3sHelper(groupStage, i);
        }
        displayAllTopTeams(groupStage);
    }

    /**
     * Thus function helps to keep track of the best top 3 teams the user chose, and add them to the list
     * of top 3s that can advance
     * @param groupStage GroupStage object
     * @param index index of the team that was chosen
     */
    private static void chooseBestTop3sHelper(GroupStage groupStage, int index){
        while (true){
            try{
                System.out.print("Top " + (index + 1) + " Third Place Team: ");
                Scanner scanner = new Scanner(System.in);
                int option = scanner.nextInt();
                if (groupStage.top3sContains(groupStage.getTop3s().get(option - 1))){ // makes sure the team has not been selected
                    System.out.println("You have already chosen this team");
                }
                else if (option < 13 && option > 0) { // makes sure the option is within the range of teams available
                    groupStage.addBestTop3s(groupStage.getTop3s().get(option - 1));
                    break;
                }
                else{ // makes sure team exists
                    System.out.println("Please choose a valid team");
                }
            }catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
            }catch (IndexOutOfBoundsException e){
                System.out.println("Please choose a valid team");
            }
        }
    }

    /**
     * This function helps to display all the teams that will advance to the next round
     * @param groupStage GroupStage object
     */
    private static void displayAllTopTeams(GroupStage groupStage) {
        // Displays all the top 1, 2, 3 teams that will advance
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
        // allow user to decide if they want to continue to the next round
        while (isRunning) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nClick N to move to the next round... (X to exit): ");
            String option = scanner.nextLine();
            if (option.toUpperCase().equals("X")) {
                exitBracket();
            } else if (option.toUpperCase().equals("N")) {
                transitionRounds(groupStage);
                isRunning = false;
            }
        }
    }

    /**
     * This function helps to transition to the rounds after the group stage
     * @param groupStage GroupStage object
     */
    private static void transitionRounds(GroupStage groupStage){
        // Add all the top teams into an array list for the round of 32
        ArrayList<Team> bestOf32teams = new ArrayList<>();
        bestOf32teams.addAll(groupStage.getTop1s());
        bestOf32teams.addAll(groupStage.getTop2s());
        bestOf32teams.addAll(groupStage.getBestTop3s());
        // Create the matches in the round of 32
        KnockoutMatchesDivider knockoutMatchesDivider = new KnockoutMatchesDivider(bestOf32teams, 32);
        // Get the matches on each side of the bracket
        Match[] leftSideMatches = roundOf32MatchDivider(knockoutMatchesDivider, LEFT);
        Match[] rightSideMatches = roundOf32MatchDivider(knockoutMatchesDivider, RIGHT);
        // Create a knockout stage object for the rest of the rounds until the semi-finals
        KnockoutStage roundOf32 = knockoutRoundDisplay(32, leftSideMatches, rightSideMatches);
        KnockoutStage roundOf16 = knockoutRoundDisplay(16, roundOf32.getNextRoundLeftSide(), roundOf32.getNextRoundRightSide());
        KnockoutStage quarterFinals = knockoutRoundDisplay(8, roundOf16.getNextRoundLeftSide(), roundOf16.getNextRoundRightSide());
        KnockoutStage semiFinals = knockoutRoundDisplay(4, quarterFinals.getNextRoundLeftSide(), quarterFinals.getNextRoundRightSide());
        KnockoutRoundSelectionBracket(THIRD_PLACE_PLAYOFF, semiFinals.getThirdPlaceTeams(), semiFinals);
        KnockoutRoundSelectionBracket(FINAL, semiFinals.getFinalTeams(), semiFinals);
    }

    private static Match[] roundOf32MatchDivider(KnockoutMatchesDivider knockoutMatchesDivider, String side){
        if (side.equals(LEFT)){
            return knockoutMatchesDivider.getMatches(new ArrayList<>(knockoutMatchesDivider.selectLeftSideTeams()));
        }
        else if (side.equals(RIGHT)){
            return knockoutMatchesDivider.getMatches(new ArrayList<>(knockoutMatchesDivider.selectRightSideTeams()));
        }
        return null;
    }

    /**
     * This function helps to display the left and right side of the bracket during the knockoffs
     * @param roundNumber the current total number of teams
     * @param leftSideMatches the left side matches
     * @param rightSideMatches the right side matches
     * @return KnockoutStage object
     */
    private static KnockoutStage knockoutRoundDisplay(int roundNumber, Match[] leftSideMatches, Match[] rightSideMatches) {
        System.out.println("\n----------------------------Best of " + roundNumber + "----------------------------\n");
        System.out.println("\n-----------------------Left Bracket-----------------------");
        for (int i = 0; i < leftSideMatches.length; i++){
            System.out.println(i+1 + ". " + leftSideMatches[i].toString());
        }
        System.out.println("\n-----------------------Right Bracket-----------------------");
        for (int i = 0; i < rightSideMatches.length; i++){
            System.out.println(i+1 + ". " + rightSideMatches[i].toString());
        }
        // Create a new knockout stage object and create the left and right side matches in it
        KnockoutStage knockoutStage = new KnockoutStage(roundNumber);
        KnockoutRoundSelectionBracket(LEFT, leftSideMatches, knockoutStage);
        KnockoutRoundSelectionBracket(RIGHT, rightSideMatches, knockoutStage);
        return knockoutStage;
    }

    /**
     * This function helps to allow the user to choose which team will win in each matchup, and add that team to the
     * list of teams advancing in that side of the bracket
     * @param side Side of the bracket, or the final or third-place playoff round
     * @param matches Matches associated with the side of the bracket
     * @param knockoutStage KnockoutStage object
     */
    private static void KnockoutRoundSelectionBracket(String side, Match[] matches, KnockoutStage knockoutStage) {
        System.out.println("\n-----------------------" + side + "-----------------------");
        // Displays each of the match
        for (int i = 0; i < matches.length; i++) {
            System.out.println(i + 1 + ". " + matches[i].toString());
            System.out.println("    1. " + matches[i].getTeam1());
            System.out.println("    2. " + matches[i].getTeam2());
            while (true){
                try{
                    System.out.print("Winner: ");
                    Scanner scanner = new Scanner(System.in);
                    int option = scanner.nextInt();
                    if (option == 1){ // if the first team is selected
                        if (side.equals(LEFT)){ // adds the winning team a list that advances to the next round
                            knockoutStage.addToLeftSide(matches[i].getTeam1(), i);
                            if (knockoutStage.getRoundOfNumber() == 4){ // if the round number is 4 (semi-finals), then add the losing team to the list as well
                                knockoutStage.addToLeftSide(matches[i].getTeam2(), i+1);
                            }
                        }
                        else if (side.equals(RIGHT)){
                            knockoutStage.addToRightSide(matches[i].getTeam1(), i);
                            if (knockoutStage.getRoundOfNumber() == 4){
                                knockoutStage.addToRightSide(matches[i].getTeam2(), i+1);
                            }
                        }
                        else if (side.equals(FINAL)){ // if the side is a final match then display the team that is chosen
                            winnerDisplay(matches[i].getTeam1());
                        }
                        else if (side.equals(THIRD_PLACE_PLAYOFF)){
                            thirdPlaceDisplay(matches[i].getTeam1());
                        }
                        break;
                    }
                    else if (option == 2){ // if the second team is selected
                        if (side.equals(LEFT)){
                            knockoutStage.addToLeftSide(matches[i].getTeam2(), i);
                            if (knockoutStage.getRoundOfNumber() == 4){
                                knockoutStage.addToLeftSide(matches[i].getTeam1(), i+1);
                            }
                        }
                        else if (side.equals(RIGHT)){
                            knockoutStage.addToRightSide(matches[i].getTeam2(), i);
                            if (knockoutStage.getRoundOfNumber() == 4){
                                knockoutStage.addToRightSide(matches[i].getTeam1(), i+1);
                            }
                        }
                        else if (side.equals(FINAL)){
                            winnerDisplay(matches[i].getTeam2());
                        }
                        else if (side.equals(THIRD_PLACE_PLAYOFF)){
                            thirdPlaceDisplay(matches[i].getTeam2());
                        }
                        break;
                    }
                    else{
                        System.out.println("Please select a valid Team");
                    }
                }catch (IllegalArgumentException e){
                    System.out.println("Please select a valid Team");
                }
            }
        }
    }

    private static void thirdPlaceDisplay(Team team){
        System.out.println("\nThird Place of The World Cup: " + team.getName());
    }

    private static void winnerDisplay(Team team){
        System.out.println("\nWinner of the World Cup: " + team.getName());
    }

    private static void exitBracket(){
        System.exit(0);
    }
}
