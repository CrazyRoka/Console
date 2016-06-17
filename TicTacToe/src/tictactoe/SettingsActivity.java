package tictactoe;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SettingsActivity {
    boolean isName(String a){
        boolean ans = false;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != ' ') ans = true;
        return ans;
    }
    void printTab() throws IOException{
        String Name1="",Name2 = "";
        Scanner sc = new Scanner(System.in);
        while(!isName(Name1)){
            System.out.println("Введіть ім'я першому гравцню.");
            Name1 = sc.next();
        }
        while(!isName(Name2)){
            System.out.println("Введіть ім'я другому гравцню.");
            Name2 = sc.next();
        }        
        FileWriter file = new FileWriter("Name1.txt");
        file.write(Name1);
        file.flush();
        file.close();
        file = new FileWriter("Name2.txt");
        file.write(Name2);
        file.flush();
        file.close();
    }
}
