/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author rokar
 */
public class GameActivity extends FGameActivity {
    int counter = 1;
    char[][] matrix = new char[3][3];
    String text;
    String Name1, Name2;
    Scanner sc;
    void Create(String name1, String name2) throws IOException {
        sc = new Scanner(System.in);
        Name1 = name1;
        Name2 = name2;
        setText();
        Game();
    }
    void Game() throws IOException{
        loadMatrix();
        boolean tie = checkIfTie();
        boolean win = checkIfWin();
        printMatrix();
        System.out.println(text);
        if(win){
            Win();
            return;
        }
        if(!tie){
            Tie();
            return;
        }
        System.out.println("Введіть число від 1 до 9 щоб зробити свій вибір.");
        System.out.println("Введіть q щоб вийти, або введіть r щоб почати заново.");
        String input = sc.next();
        char z = input.charAt(0);
        if(z>='1' && z<='9'){
            int t = z-'1';
            if(matrix[t/3][t%3]=='X' || matrix[t/3][t%3]=='O'){
                System.out.println("Ця клітинка вже заповнена! Введіть інше число.");
                Game();
                return;
            }
            changeButton(t);
            saveData();
            tie = checkIfTie();
            if(!tie){
                Tie();
                return;
            }
            Game();
        }else{
            if(z=='q')Exit();
            else if(z=='r')reset(); 
            else{
                System.out.println("Неправильний ввід! Введіть ще раз");
                Game();
                return;
            }
        }
    }
    void Win() throws IOException{
        Tie();
    }
    @Override
    boolean checkIfWin() throws IOException{
        int winner = 0;
        for(int i = 0 ; i < 3; i++){
            if(isLine(matrix[i][0],matrix[i][1],matrix[i][2])){
                winner = matrix[i][0]=='X'? 1 : 2;
                break;
            }
            if(isLine(matrix[0][i],matrix[1][i],matrix[2][i])){
                winner = matrix[0][i]=='X'? 1 : 2;
                break;
            }
        }
        if(winner == 0 && isLine(matrix[0][0],matrix[1][1],matrix[2][2])){
            winner = matrix[0][0]=='X'? 1 : 2;
        }
        if(winner == 0 && isLine(matrix[2][0],matrix[1][1],matrix[0][2])){
            winner = matrix[2][0]=='X'? 1 : 2;
        }
        if(winner>0){
            text="Переміг " + currentPlayerName(winner);
            return true;
        }
        return false;
    }
    @Override
    boolean checkIfTie() throws IOException{
        boolean ans = false;
        for(int i = 0 ; i < 3; i++)for(int j = 0; j < 3; j++)if(matrix[i][j]!='X' && matrix[i][j]!='O')ans=true;
        if(ans==false){
            text="НІчия! Перемогла дружба!";
        }
        return ans;
    }
    void Tie() throws IOException{
        System.out.println("Введіть q, або введіть r щоб почати заново.");
        String input = sc.next();
        char z = input.charAt(0);
        if(z!='q' && z!='r'){
            System.out.println("Неправильний ввід! Введіть ще раз");
            Tie();
            return;
        }else{
            if(z=='q')Exit(); else reset();
        }
    }
    @Override
    void reset() throws IOException{
        for(int i = 0; i < 3; i++)for(int j = 0; j < 3; j++)matrix[i][j]='.';
        counter = 1;
        saveData();
        setText();
        Game();
    }
    @Override
    void saveData() throws IOException{
        FileWriter file = new FileWriter("matrix.txt",false);
        for(int i = 0; i<3; i++)for(int j = 0; j<3; j++)file.write(matrix[i][j]);
        file.flush();
        file.close();
    }
    void changeButton(int but){
        matrix[but/3][but%3]=counter%2==0?'O':'X';
        counter++;
        setText();
    }
    void loadMatrix(){
        try{
            FileReader file = new FileReader("matrix.txt");
            int count = 1;
            for(int i = 0; i < 3; i++)for(int j = 0; j < 3; j++){
                int c;
                c = file.read();
                char z = (char) c;
                if(c==-1)z = '.';
                matrix[i][j] = z;
                if(z=='X' || z=='O'){
                    count++;
                }
            }
            file.close();
            counter = count;
        }catch(Exception e){
            for(int i = 0; i < 3; i++)for(int j = 0; j < 3; j++)matrix[i][j]='.';
        }
        setText();
    }
    void printMatrix(){
        for(int i = 2; i>=0; i--){
            for(int j = 0; j<3; j++)System.out.print(matrix[i][j]);
            System.out.println();
        }
    }
    void setText(){
        text = "Хід " + currentPlayerName(counter);
    }
    @Override
    public String currentPlayerName(int choice){
        return (choice%2==1?Name1:Name2);
    }
}
