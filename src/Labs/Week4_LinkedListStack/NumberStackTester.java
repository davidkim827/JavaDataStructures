package Labs.Week4_LinkedListStack;

import java.util.Random;

/**
 * Created by dk on 9/14/2017.
 */
public class NumberStackTester {
    public static void main(String[] args) {
        Random r = new Random();

        NumberStack nsOdd = new NumberStack();
        NumberStack nsEven = new NumberStack();

        for (int i = 0; i < 500; i++) {
            int randomNumber = r.nextInt(5000);
            if (randomNumber % 2 == 0) {
                if (((nsEven.size() + nsOdd.size()) < 200) && randomNumber > 0 && randomNumber <= 1000) {
                    nsEven.push(randomNumber);
                }
            }
            else {
                if (((nsEven.size() + nsOdd.size()) < 200) && randomNumber > 0 && randomNumber <= 1000) {
                    nsOdd.push(randomNumber);
                }
            }
        }

        System.out.print("Odd ");
        nsOdd.print();
        System.out.println("\nNumber in Odd Stack: " + nsOdd.size());

        System.out.print("\nEven ");
        nsEven.print();
        System.out.println("\nNumber in Even Stack: " + nsEven.size());
    }
}
