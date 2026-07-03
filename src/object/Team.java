package object;

public class Team {

    private String name;

    private String group;

    private double points;


    public Team(String name, String group, double points){
        this.name = name;
        this.group = group;
        this.points = points;
    }

    public String getName(){
        return name;
    }

    public String getGroup(){
        return group;
    }

    public double getPoint(){
        return points;
    }

    @Override
    public String toString() {
        return name;
    }

}
