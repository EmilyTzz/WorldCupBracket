package object;

public class Team {

    private String name;

    private String group;

    private float points;


    public Team(String name, String group, float points){
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

    public float getPoint(){
        return points;
    }

    @Override
    public String toString() {
        return name;
    }
}
