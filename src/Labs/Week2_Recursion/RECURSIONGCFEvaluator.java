package Labs.Week2_Recursion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RECURSIONGCFEvaluator {
    public static void main(String[] args) throws FileNotFoundException, InputMismatchException {

        Scanner keyBoard = new Scanner(System.in);
        System.out.print("Choose x pairs of numbers: ");


        int[][] arr = new int[3][2];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < 2; j++)
                arr[i][j] = keyBoard.nextInt();

        //outputting to a text file
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);

        System.out.println("\n-----------------------------------------------------");
        System.out.println(" | a, b |     gcf1     |     gcf2      |     gcf3    | ");
        System.out.println("-----------------------------------------------------");
        for(int j = 0; j < arr.length; j++) {
            System.out.printf(" | " + arr[j][0] + ", " + arr[j][1] + " |    %1d    |    %1d    |    %1d    " +
                    "|\n", timeTaken1(arr[j][0], arr[j][1]), timeTaken2(arr[j][0], arr[j][1]),
                    timeTaken3(arr[j][0], arr[j][1]));
        }
        System.out.print("-----------------------------------------------------");
    }

    public static int timeTaken1(int a, int b){ //measures and returns time taken for GCF1 in nano seconds
        int startTime = (int) System.nanoTime();
        for(int i = 0; i < 100; i++)
            GCFAlgorithm.gcf1(a, b);
        int stopTime = (int) System.nanoTime();
        int timeTaken = stopTime - startTime;
        return timeTaken;
    }

    public static int timeTaken2(int a, int b){ //measures and returns time taken for GCF2 in nano seconds
        int startTime = (int) System.nanoTime();
        for(int i = 0; i < 100; i++)
            GCFAlgorithm.gcf2(a, b);
        int stopTime = (int) System.nanoTime();
        int timeTaken = stopTime - startTime;
        return timeTaken;
    }
    public static int timeTaken3(int a, int b){ //measures and returns time taken for GCF3 in nano seconds
        int startTime = (int) System.nanoTime();
        for(int i = 0; i < 100; i++)
            GCFAlgorithm.gcf3(a, b);
        int stopTime = (int) System.nanoTime();
        int timeTaken = stopTime - startTime;
        return timeTaken;
    }
}