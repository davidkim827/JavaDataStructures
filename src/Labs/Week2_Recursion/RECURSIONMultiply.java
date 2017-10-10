package Labs.Week2_Recursion;

import java.util.Scanner;

/**
 * Created by dk on 8/31/2017.
 */
public class RECURSIONMultiply {
    public static void main(String[] args){
        Scanner keyBoard = new Scanner(System.in);

        int a;
        int b;
        System.out.println("Two numbers you want to multiply: ");
        a = keyBoard.nextInt();
        b = keyBoard.nextInt();

        if (a < 0 || b < 0)
            System.exit(1);
        else
            System.out.print(multiply(a, b));

    }

    public static int multiply(int a, int b){ //recursive method to multiply based only on addition

        if (b == 0)
            return 0;
        if (b == 1)
            return a;
        else
            return a + multiply(a,b - 1);
    }
}
