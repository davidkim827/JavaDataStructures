package Labs.Week1_BasicsReview;

import java.util.*;
import java.util.Random;

public class REVIEWArray2DPrint {

    public static void main(String[] args){
        Scanner keyBoard = new Scanner(System.in);

        System.out.print("Size of array N x N? ");
        int nByN = keyBoard.nextInt();
        int[][] arr = new int[nByN][nByN];
        print(arr);
    }
    public static void print(int[][] arr){
        Random r1 = new Random();

        for (int i = 0; i < arr.length; i++){
            for (int z = 0; z < arr.length; z++) //Prints out the borders between lines inclusive of top and bottom borders
                System.out.print("-------");
            System.out.println();
            for (int j = 0; j < arr.length; j++) { //generation of random numbers 0-3 inclusive and places X for value 1 and O for value 0
                System.out.print(" | ");
                arr[i][j] = r1.nextInt(3);
                if (arr[i][j] == 0)
                    System.out.print(" O ");
                else if (arr[i][j] == 1)
                    System.out.print(" X ");
                else
                    System.out.print("   ");
            }
            System.out.println(" |");
        }
        for (int z = 0; z < arr.length; z++)
            System.out.print("-------");
    }

}
