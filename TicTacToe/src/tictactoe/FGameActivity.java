package tictactoe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public abstract class FGameActivity{
    int counter = 1;
    char[][] matrix = new char[3][3];
    String text;
    String Name1, Name2;

    public void Create() {
    }

    /*public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void initButtons(){
        SharedPreferences sharedPref =  getSharedPreferences("NAMES", MODE_PRIVATE);
        int count = 1;
        for(int i = 0; i < 3; i++)for(int j = 0; j < 3; j++){
            if(sharedPref.contains(String.valueOf(i*3 + j)))matrix[i][j] = sharedPref.getString(String.valueOf(i*3 + j),"").charAt(0);
            butMatrix[i][j].setText(matrix[i][j]=='X'? "X" : matrix[i][j]=='O'? "O" : "");
            if(matrix[i][j]=='X' || matrix[i][j]=='O'){
                butMatrix[i][j].setEnabled(false);
                count++;
            }
            butMatrix[i][j].setTextSize(20);
        }
        counter = count;
        setTextView();
        checkIfWin();
        checkIfTie();
    }
    public void initButtonMatrix(){
        butMatrix[0][0] = (Button) findViewById(R.id.button);
        butMatrix[0][1] = (Button) findViewById(R.id.button2);
        butMatrix[0][2]= (Button) findViewById(R.id.button3);
        butMatrix[1][0] = (Button) findViewById(R.id.button4);
        butMatrix[1][1] = (Button) findViewById(R.id.button5);
        butMatrix[1][2] = (Button) findViewById(R.id.button6);
        butMatrix[2][0] = (Button) findViewById(R.id.button7);
        butMatrix[2][1] = (Button) findViewById(R.id.button8);
        butMatrix[2][2] = (Button) findViewById(R.id.button9);
        for(int i = 0; i < 3; i++)for(int j = 0; j < 3; j++)butMatrix[i][j].setTextColor(Color.BLACK);
    }
    public void defineAllViews(){
        stringColor1 = (String)getIntent().getSerializableExtra("Color1");
        stringColor2 = (String)getIntent().getSerializableExtra("Color2");
        Name1 = (String)getIntent().getSerializableExtra("Name1");
        Name2 = (String)getIntent().getSerializableExtra("Name2");
        initButtonMatrix();
        textView = (TextView) findViewById(R.id.textView);
    }
    public void setAllColors(){
        setColor(stringColor1, 1);
        setColor(stringColor2,2);
    }
    public void setColor(String color, int number){
        int createColor = Color.BLACK;
        switch (color){
            case "Червоний":
                createColor = Color.RED;
                break;
            case "Синій":
                createColor = Color.BLUE;
                break;
            case "Жовтий":
                createColor = Color.YELLOW;
                break;
            case "Зелений":
                createColor = Color.GREEN;
                break;
            case "Розовий":
                createColor = Color.parseColor("#FF69B4");
                break;
            default:
                break;
        }
        if(number==1)color1 = createColor;else color2 = createColor;
    }
    public int chooseColor(int color){
        return color==1? color1 : color2;
    }
    public void drawButtons(Button first, Button second, Button third, int color){
        first.setTextColor(chooseColor(color));
        second.setTextColor(chooseColor(color));
        third.setTextColor(chooseColor(color));
    }
    */
    public boolean isLine(char first, char second, char third){
        return first == second && first == third && (first == 'X' || first == 'O');
    }
    /*public void disableAllButtons(){
        for(int i = 0 ; i < 3; i++)for(int j = 0; j < 3; j++)butMatrix[i][j].setEnabled(false);
    }*/
    abstract boolean checkIfWin() throws IOException;
    /*public void changeButton(Button but){
        if(counter%2==1){
            but.setText("X");
        }else{
            but.setText("O");
        }
        counter++;
        setTextView();
        but.setTextSize(20);
        but.setEnabled(false);
    }*/
    abstract boolean checkIfTie() throws IOException;
    /*
    public void fillMatrix(Button but){
        for(int i = 0; i < 3; i++)for(int j = 0; j < 3; j++)if(butMatrix[i][j]==but)matrix[i][j]=counter%2==0?'X':'O';
    }*/
    void saveData() throws IOException{
        /*SharedPreferences.Editor editor = getSharedPreferences("NAMES", MODE_PRIVATE).edit();
        for(int i = 0; i < 3; i++)for(int j = 0; j < 3; j++)editor.putString(String.valueOf(i*3 + j),matrix[i][j]+"ABCD");
        editor.commit();
        */
    }
    /*public void onClick(View view){
        changeButton((Button)view);
        fillMatrix((Button) view);
        checkIfWin();
        saveData();
    }*/
    void Exit(){System.exit(0);}
    /*
    public void resetAllButtons(){
        for(int i = 0; i < 3; i++)for(int j = 0; j < 3; j++){Reset(butMatrix[i][j]);matrix[i][j]=' ';}
    }*/
    void reset() throws IOException{
        /*
        but.setText("");
        but.setEnabled(true);
        but.setTextColor(Color.BLACK);*/
    }
    abstract public String currentPlayerName(int choice);
    /*
    public void setTextView(){
        textView.setText("Хід " + currentPlayerName(counter));
        textView.setTextColor(chooseColor(counter%2));
    }
    public void Clear(View view){
        counter = 1;
        resetAllButtons();
        setTextView();
    }*/
}
