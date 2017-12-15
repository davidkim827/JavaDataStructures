package Labs.Week4_LinkedListStackADT;

import java.util.Random;

/**
 * Created by dk on 9/14/2017.
 */
public class NumberStackTester {
    public static void main(String[] args) {
        Random r = new Random();

        NumberStack nsOdd = new NumberStack(); // instantiates the odd stack
        NumberStack nsEven = new NumberStack(); // instantiates the even stack

        for (int i = 0; i < 500; i++) { //generates 500 random numbers, placing each into either the odd or even stack, only if the number is between 1 and 1000
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

        System.out.print("Odd ");        //prints out the Odd Stack
        nsOdd.print();
        System.out.println("\nNumber in Odd Stack: " + nsOdd.size());

        System.out.print("\nEven ");         //prints out the Even Stack
        nsEven.print();
        System.out.println("\nNumber in Even Stack: " + nsEven.size());
    }
}
