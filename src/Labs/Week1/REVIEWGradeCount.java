package Labs.Week1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dk on 8/30/2017.
 */
public class REVIEWGradeCount {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyBoard = new Scanner(System.in);

        System.out.print("File Name: ");
        String fileName = keyBoard.next();

        File fileOutput = new File(fileName);
        Scanner file = new Scanner(fileOutput);

        int grades;
        int countNtoH = 0; //number of 90 to 100s
        int countEtoEN = 0; //number of 80 to 89s
        int countStoSN = 0; //number of 70 to 79s
        int countSxtoSxN = 0; //number of 60 to 69s
        int countBelowSx = 0; //number below 60s

        while (file.hasNextLine()){
            String[] split = file.next().replaceAll("[^0-9]", "").split(" "); //puts each string in the text into an array and gets rid of all non-numerical integers
            for (int j = 0; j < split.length; j++){
                grades = Integer.parseInt(split[j]); //parses each element in array to be read as an integer
                if (grades < 60)                    // logic to control the categorization of grades
                    countBelowSx++;
                else if (grades < 69)
                    countSxtoSxN++;
                else if (grades < 79)
                    countStoSN++;
                else if (grades < 90 && grades >= 80)
                    countEtoEN++;
                else
                    countNtoH++;

            }

        }
        System.out.println("Category \t No. of Students");
        System.out.printf("[90-100] \t %7d\n", countNtoH);
        System.out.printf("[80-89] \t %7d\n", countEtoEN);
        System.out.printf("[70-79] \t %7d\n", countStoSN);
        System.out.printf("[60-69] \t %7d\n", countSxtoSxN);
        System.out.printf("[ <60 ] \t %7d\n", countBelowSx);

        System.out.print("\nAll students above 100 are automatically labeled as 100");



    }
}
