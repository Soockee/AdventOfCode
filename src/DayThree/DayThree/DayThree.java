package DayThree;


import java.net.URL;
import java.util.Scanner;

/**
 * Created by Simon on 08.12.2016.
 */
public class DayThree {
    int x,y,z;
    int[] values;
    String input;
    String[] row;
    String t1 ="";
    String t2 ="";
    String t3 ="";

    int correct;
    public  DayThree(){
        values = new int[3];
        correct = 0;
    }

    public void run(){
        Scanner sc = null;
        int counter = 0;
        try {
            URL url = getClass().getResource("Input.txt");
            sc = new Scanner(new File(url.toURI()));
        } catch (Exception e) {
            e.printStackTrace();
        }

            while (sc.hasNext()) {
                //reading the line
                input = sc.nextLine();
                input = input.replaceAll("[\\D]+", ";");
                input = input.substring(1);
                row = input.split(";");
                //System.out.println(input);
                x = Integer.parseInt(row[0]);
                y = Integer.parseInt(row[1]);
                z = Integer.parseInt(row[2]);

                t1 += x +";";
                t2 += y +";";
                t3 += z + ";";
                counter++;
                System.out.println(t1);
                if (counter==3){
                    String[] inputs = {t1,t2,t3};
                    t1="";
                    t2="";
                    t3="";
                  //  String[] valuesTemp = inputs;
                    for (int i = 0;i<3;i++) {
                        valuesTemp = inputs[i].split(";");
                    }
                    for (int i = 0; i<3;i++){
                       values[i] = Integer.parseInt(valuesTemp[i]);
                        if (compareValues(values)) {
                            correct++;
                        }
                    }

                    counter = 0;
                }
            }
        System.out.println(correct);
    }


    public boolean compareValues(int[] values){
        for(int i = 0; i<values.length; i++){
            if (values[0] < values[1]+values[2]){
                int temp1;
                temp1 = values[0];
                values[0] = values[1];
                values[1] = values[2];
                values[2] = temp1;
            }
            else{
                return false;
            }
        }
        return true;
    }

}
