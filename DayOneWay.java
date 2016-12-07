

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Simon on 06.12.2016.
 */
public class DayOneWay {
    HashSet<Point> set = new HashSet<>();


    public boolean addWayPoint(int x , int y){
        boolean res = true;
        res = set.add(new Point(x,y));


        return res;
    }

}
