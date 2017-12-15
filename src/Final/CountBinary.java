package Final;

/**
 * Created by dk on 12/14/2017.
 */
public class CountBinary{
    //to do
    public static void countBinary(int n){
        countBinaryHelper("", n);
    }

    //helper method to recursively print out combinations of 1 and 0 for a 5 digit number.
    public static void countBinaryHelper(String s, int n){
        if(n < 0){
            System.exit(0);
        }
        if(n == 0){
            System.out.println(s);
            return;
        }
        countBinaryHelper(s + "0", n-1);
        countBinaryHelper(s + "1", n-1);
    }

    public static void main(String[] args){
        countBinary(5);
    }
}