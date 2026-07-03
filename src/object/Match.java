package object;

public class Match {

    private Team team1;

    private Team team2;

    public Match(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
    }

    @Override
    public String toString() {
        return team1.getName() + " vs " + team2.getName();
    }

    public Team getTeam1(){
        return team1;
    }

    public Team getTeam2(){
        return team2;
    }

    private double calculateWinProbability(Team team1, Team team2){
        double ratingDiff = team2.getPoint()-team1.getPoint();
        return 1.0/(1.0+Math.pow(10, ratingDiff/400.0)); // Elo-style probability formula
    }

    public StringBuilder getProbabilityDisplay(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n--------Match Predictions--------\n");
        sb.append(team1.getName() + ": " + Math.round(calculateWinProbability(team1, team2)*100) + "%\n");
        sb.append(team2.getName() + ": " + Math.round(calculateWinProbability(team2, team1)*100) + "%\n");
        return sb;
    }

}
