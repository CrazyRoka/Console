package tictactoe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TicTacToe {
    static String Name1,Name2;
    public static void main(String[] args) throws IOException {
        printMenu();
    }    
    static void loadData() throws FileNotFoundException, IOException{
        try{
            File f = new File("Name1.txt");
            FileReader reader = new FileReader(f);
            char[] buffer = new char[(int)f.length()];
            reader.read(buffer);
            Name1 = String.valueOf(buffer);
        }catch(Exception e){
            Name1 = "";
        }
        try{
            File f = new File("Name2.txt");
            FileReader reader = new FileReader(f);
            char[] buffer = new char[(int)f.length()];
            reader.read(buffer);
            Name2 = String.valueOf(buffer);
        }catch(Exception e){
            Name2 = "";
        }
    }
    static void printMenu() throws IOException{
        String c;
        System.out.println("Виберіть один з варіантів:");
        System.out.println("1) Розпочати гру.");
        System.out.println("2) Налаштування.");
        System.out.println("3) Вийти.");
        Scanner sc = new Scanner(System.in);
        c = sc.next();
        char z = c.charAt(0);
        if(z=='1'){
            Start();
            printMenu();
        }else{
            if(c.charAt(0)=='2'){
                Settings();
                printMenu();
            }else{
                if(z=='3'){
                    System.exit(0);
                }else{
                    System.out.println("Неправильний вибір!");
                    System.out.println();
                    printMenu();
                }
            }
        }
    }
    static void startGame() throws IOException{
        GameActivity game = new GameActivity();
        game.Create(Name1, Name2);
    }
    static void Settings() throws IOException{
        SettingsActivity set = new SettingsActivity();
        set.printTab();
        loadData();
    }
    static void showDialog(String message){
        System.out.println();
        System.out.println(message);
        System.out.println();
    }
    static boolean isName(String a){
        boolean ans = false;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != ' ') ans = true;
        return ans;
    }
    static boolean validateNames(){return isName(Name1) && isName(Name2);}
    static void Start() throws IOException{
        loadData();
        if(validateNames()) {
            startGame();
        }else{
            showDialog("Введіть імена гравцям у налаштуваннях!");
        }
    }
}
