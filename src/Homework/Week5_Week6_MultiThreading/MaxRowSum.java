package Homework.Week5_Week6_MultiThreading;

import java.util.Random;

/**
 * Created by dk on 9/29/2017.
 */
public class MaxRowSum {
    public static void main(String[] args) {
        Random r = new Random();
        int[][] randomArray = new int[20][20];

        //fills in the 20x20 array with random numbers
        for (int i = 0; i < randomArray.length; i++) {
            for (int j = 0; j < randomArray.length; j++) {
                randomArray[i][j] = 1 + r.nextInt(100);
                System.out.print(randomArray[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        //instantiates 20 different threads to sum up all the values per row
        RowSumThread rst0 = new RowSumThread(randomArray, 0);
        RowSumThread rst1 = new RowSumThread(randomArray, 1);
        RowSumThread rst2 = new RowSumThread(randomArray, 2);
        RowSumThread rst3 = new RowSumThread(randomArray, 3);
        RowSumThread rst4 = new RowSumThread(randomArray, 4);
        RowSumThread rst5 = new RowSumThread(randomArray, 5);
        RowSumThread rst6 = new RowSumThread(randomArray, 6);
        RowSumThread rst7 = new RowSumThread(randomArray, 7);
        RowSumThread rst8 = new RowSumThread(randomArray, 8);
        RowSumThread rst9 = new RowSumThread(randomArray, 9);
        RowSumThread rst10 = new RowSumThread(randomArray, 10);
        RowSumThread rst11 = new RowSumThread(randomArray, 11);
        RowSumThread rst12 = new RowSumThread(randomArray, 12);
        RowSumThread rst13 = new RowSumThread(randomArray, 13);
        RowSumThread rst14 = new RowSumThread(randomArray, 14);
        RowSumThread rst15 = new RowSumThread(randomArray, 15);
        RowSumThread rst16 = new RowSumThread(randomArray, 16);
        RowSumThread rst17 = new RowSumThread(randomArray, 17);
        RowSumThread rst18 = new RowSumThread(randomArray, 18);
        RowSumThread rst19 = new RowSumThread(randomArray, 19);

        rst0.start();
        rst1.start();
        rst2.start();
        rst3.start();
        rst4.start();
        rst5.start();
        rst6.start();
        rst7.start();
        rst8.start();
        rst9.start();
        rst10.start();
        rst11.start();
        rst12.start();
        rst13.start();
        rst14.start();
        rst15.start();
        rst16.start();
        rst17.start();
        rst18.start();
        rst19.start();

        //instantiates a new array to fill up with the row sums
        int[] arr = new int[20];

        arr[0] = rst0.rowSum();
        arr[1] = rst1.rowSum();
        arr[2] = rst2.rowSum();
        arr[3] = rst3.rowSum();
        arr[4] = rst4.rowSum();
        arr[5] = rst5.rowSum();
        arr[6] = rst6.rowSum();
        arr[7] = rst7.rowSum();
        arr[8] = rst8.rowSum();
        arr[9] = rst9.rowSum();
        arr[10] = rst10.rowSum();
        arr[11] = rst11.rowSum();
        arr[12] = rst12.rowSum();
        arr[13] = rst13.rowSum();
        arr[14] = rst14.rowSum();
        arr[15] = rst15.rowSum();
        arr[16] = rst16.rowSum();
        arr[17] = rst17.rowSum();
        arr[18] = rst18.rowSum();
        arr[19] = rst19.rowSum();

        System.out.println("\nArray of Summed Rows: \n");

        int indexOfHighestSum = 0;
        int highestSum = 0;

        //loops through the entire row summed array to see at which index and what number is the highest sum and prints out those two data points
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (arr[i] > highestSum) {
                highestSum = arr[i];
                indexOfHighestSum = i;
            }
        }
        System.out.println("\n\nHighest Sum = " + highestSum + "\nIndex of Highest Sum = " + indexOfHighestSum);

    }
}
