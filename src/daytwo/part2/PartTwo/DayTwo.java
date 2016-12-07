package DayTwo.PartTwo;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Simon on 07.12.2016.
 */
public class DayTwo {
    final char[][] keypad = {
                {'1'}, //row 1
              {'2','3','4'}, // row 2
             {'5','6','7','8','9'}, // row 3
              {'A','B','C'}, // row 4
                {'D'}// row 5
    };

    int currX;
    int currY;



    public DayTwo(){
        currX = 0;
        currY = 2;
    }

    public  void up (){
        //X = 0 y = 3
        if (currY == 0) return;
        int maxX;
        int minX;
        if (currY<4){
            maxX = (currY-1)*2;
        }
        else{
            maxX = ((currY-1)%2)*2;
        }
        minX = 0;

        if (currY < 3) {
            if (currX-1 <= maxX && currX-1 >= minX) {
                currY -= 1;
                currX -= 1;
            }
        }
        else{
            if (currX+1 <= maxX && currX+1>= minX) {
                currY -= 1;
                currX += 1;
            }
        }

    }

    public void down(){
        //currX = 2
        //currY = 2
        if (currY == 4)return;

        int maxX;
        int minX;
        if (currY<2){
            maxX = (currY+1)*2;
        }
        else{
            maxX = ((currY+1)%2)*2;
        }
        minX = 0;

        if (currY < 2) {
            if (currX+1 <= maxX && currX+1 >= minX) {
                currY += 1;
                currX += 1;
            }
        }
        else{
            if (currX-1 <= maxX && currX-1 >= minX) {
                currY += 1;
                currX -= 1;
            }
        }
    }

    public void right(){
        if (currX == 4) return;
        int maxX;
        if (currY<3){
            maxX = currY*2;
        }
        else{
            maxX = (currY%2)*2;
        }

        if (currX < maxX){
            currX +=1;
        }
    }
    public void left(){
        if (currX == 0)return;
            if(currX > 0){
                currX -= 1;
            }

    }

    public void move(char command){
        switch (command){
            case 'U' : up();break;
            case 'D' : down();break;
            case 'L' : left();break;
            case 'R' : right();break;
        }
    }
    public void run(){
        String inputLine;
        String[] moves;

        Scanner sc = null;
        try {
            URL url = getClass().getResource("Input.txt");
            sc = new Scanner(new File(url.toURI()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        while(sc.hasNext()) {
            //reading the line
            inputLine = sc.nextLine();
            moves = inputLine.split("");

            for (int i = 0; i<moves.length;i++){
                //System.out.print("Moves from:" + keypad[curr]);
                move(moves[i].charAt(0));
               // System.out.println("to : " + keypad[curr]);


            }
            //  System.out.println(currY +" "+ currX);
            System.out.println(keypad[currY][currX] );
        }
    }
}
