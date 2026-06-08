package object;

public class Team {

    private String name;

    private String group;


    public Team(String name, String group, int rank){
        this.name = name;
        this.group = group;
    }

    public String getName(){
        return name;
    }

    public String getGroup(){
        return group;
    }

}
