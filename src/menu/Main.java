package menu;

import menu.Menu;

import java.io.File;

public class Main{
    public void main(String args[]){
        if (args.length > 1){
            System.out.println("Invalid Number of Arguments");
        }
        else if(args.length == 1){
            File file = new File(args[0]);
            if (!file.exists()){
                System.out.println("File Does Not Exist");
            }
            else{
                Reader.loadTeams(file);
            }
        }
    }
}
