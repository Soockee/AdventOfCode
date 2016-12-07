package DayTwo;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Simon on 07.12.2016.
 */
public class DayTwo {
    final int[] keypad = {1,2,3,4,5,6,7,8,9};
    int start ;
    int curr;

    public DayTwo(){
        start = 4;
        curr = start;
    }

    public  void up (){
        if (curr>2){
            curr -= 3;
        }
    }
    public void down(){
        //System.out.println("Move Down from::"+curr);
        if (curr<6) {
            curr += 3;
        }
        //System.out.println(" To::"+curr);
    }

    public void right(){
        if (curr != 2 && curr != 5 && curr != 8){
            curr +=1;
        }
    }
    public void left(){
        if (curr != 0 && curr != 3 && curr != 6 ) {
            curr -= 1;
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

    public void newStart(){
        curr = start;
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
            System.out.println(keypad[curr]);
        }
    }
}
