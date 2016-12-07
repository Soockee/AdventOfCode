/**
 * Created by Simon on 05.12.2016.
 */
public class DayOneTest {
    public static void main(String[]args){
        final long startTime = System.currentTimeMillis();
        DayOne d = new DayOne();
        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time in milliSec: " + (endTime - startTime) );
        System.out.println("Total execution time in Sec: " + ((double)endTime - (double)startTime)/1000 );
    }
}
