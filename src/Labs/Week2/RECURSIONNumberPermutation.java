package Labs.Week2;

import java.util.Scanner;

/**
 * Created by dk on 9/1/2017.
 */
public class RECURSIONNumberPermutation  {
    public static void main(String[] args) {
        Scanner keyBoard = new Scanner(System.in);
        int len;

        System.out.print("Length of odd digit permutations? ");
        len = keyBoard.nextInt();

        permutation("", len);
    }

    public static void permutation(String str, int len) {

        if (len == 0)
            System.exit(1);
        else if (len == 1) {
            System.out.println(str + "1");
            System.out.println(str + "3");
            System.out.println(str + "5");
            System.out.println(str + "7");
            System.out.println(str + "9");
        }
        else {
            permutation(str + "1", len - 1);
            permutation(str + "3", len - 1);
            permutation(str + "5", len - 1);
            permutation(str + "7", len - 1);
            permutation(str + "9", len - 1);
        }
    }
}
