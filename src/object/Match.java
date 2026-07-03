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

    public double calculateWinProbability(){
        double ratingDiff = 0.0;
        // makes sure the point difference is not negative
        if (team1.getPoint()-team2.getPoint()>0){
            ratingDiff = team1.getPoint()-team2.getPoint();
        }
        else if (team2.getPoint()-team1.getPoint()>0){
            ratingDiff = team2.getPoint()-team1.getPoint();
        }
        return 1.0/(1.0+Math.pow(10, ratingDiff)/400.0); // Elo-style probability formula
    }



}
