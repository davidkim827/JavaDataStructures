package Labs.Week2_Recursion;

import java.util.Scanner;

/**
 * Created by dk on 8/31/2017.
 */
public class RECURSIONLetterPermutation {
    public static void main(String[] args) {
        Scanner keyBoard = new Scanner(System.in);

        int positiveInteger;
        System.out.print("Input a positive integer: ");
        positiveInteger = keyBoard.nextInt();


        Recursion("", positiveInteger);
    }

    public static void Recursion(String str, int len) {


        if (len == 1) {
            System.out.println(str + "L");
            System.out.println(str + "R");
        } else if (len > 1) {
            Recursion(str + "L", len - 1);
            Recursion(str + "R", len - 1);
        } else
            System.exit(0       );
    }
}
