package object;

public class Team {

    private String name;

    private String group;


    public Team(String name, String group){
        this.name = name;
        this.group = group;
    }

    public String getName(){
        return name;
    }

    public String getGroup(){
        return group;
    }

    @Override
    public String toString() {
        return name;
    }
}
