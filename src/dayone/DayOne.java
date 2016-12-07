/**
 * Created by Simon on 05.12.2016.
 */
import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class DayOne {


    public enum State {NORTH, EAST, SOUTH, WEST};
    // positiv/negativ x and y values for tracking the way and for better understanding of the method
    int x;
    int y;

    int xDestination;
    int yDestination;

    DayOneWay way = new DayOneWay();
    ArrayList<Point> points = new ArrayList<>();
    String input;
    String[] allMoves;
    State curr  = State.NORTH;
    public DayOne(){



        //assigning values to variables
        x = 0;
        y = 0;


        //Reading the input-file
        Scanner sc = null;
        try {
            URL url = getClass().getResource("InputTaskOne.txt");
            sc = new Scanner(new File(url.toURI()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        while(sc.hasNext()) {
            //reading the line and splitting it afterwards
            input = sc.nextLine();

            allMoves = input.split(", ");
        }


        // for each String in the allMoves array -> do move(String s); once
        for(int i = 0; i<allMoves.length;i++){
            if(!move(allMoves[i])){
                break;
            }
        }

        //Location the position of the missing point P(x,y) -> P(xDestination, yDestination)
        xDestination = x;
        yDestination = y;

        //Some informations

        System.out.println("Steps to Destinationpoint: "+ (Math.abs(xDestination)+Math.abs(yDestination)));
    }

    public boolean move(String task){
        boolean cross = true;
        char rotation = task.startsWith("L") ? 'L':'R';
        String number = task.substring(1);
        //  S.o.p : The direction and the number of steps we handle in this round
      //  System.out.println(rotation +":"+number);
        int steps = Integer.parseInt(number);

        //rotation : 'R' -> 90° rotation to the right --- 'L' -> 90° rotation to the left
        //curr : current direction we are facing 
        switch (rotation){
            case 'R':
             //   System.out.print("turned right; ");
                switch (curr) {
                    case NORTH:
                        curr = State.EAST;
                        cross =addToX(steps);
                        break;
                    case EAST:
                        curr = State.SOUTH;
                        cross =subToY(steps);
                        break;
                    case SOUTH:
                        curr = State.WEST;
                        cross =subToX(steps);
                        break;
                    case WEST:
                        curr = State.NORTH;
                        cross =addToY(steps);
                        break;
                }
                break;
            case 'L':
           //     System.out.print("turned right; ");
                switch (curr){
                    case NORTH:
                        curr = State.WEST;
                        cross=subToX(steps);
                        break;
                    case WEST:
                        curr = State.SOUTH;
                        cross=subToY(steps);
                        break;
                    case SOUTH:
                        curr = State.EAST;
                        cross=addToX(steps);
                        break;
                    case EAST:
                        curr = State.NORTH;
                        cross=addToY(steps);
                        break;
                }
                break;
        }
        //System.out.println("now facing "+ curr+"; moving "+steps+" foward; Now stading on: ("+x+","+y+")");
        return cross;
    }
    public boolean addToX(int steps){
        boolean res = true;
        for (int i = 0; i<steps; i++){
            x += 1;
            res =way.addWayPoint(x,y);
            if (!res)break;
        }
        return res;
    }
    public boolean addToY(int steps){
        boolean res = true;
        for (int i = 0; i<steps; i++){
            y += 1;
            res =way.addWayPoint(x,y);
            if (!res)break;
        }
        return res;
    }
    public boolean subToX(int steps){
        boolean res=true;
        for (int i = 0; i<steps; i++){
            x -= 1;
            res =way.addWayPoint(x,y);
            if (!res)break;
        }
        return res;
    }
    public boolean subToY(int steps){
        boolean res= true;
        for (int i = 0; i<steps; i++){
            y -= 1;
            res = way.addWayPoint(x,y);
            if (!res)break;
        }
        return res;
    }
}
