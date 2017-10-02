package Labs.Week5_Queue;

import java.util.Random;

/**
 * Created by dk on 9/21/2017.
 */
public class NumberQueueTester {
    public static void main(String[] args) {
        Random r = new Random();


        NumberQueue nq = new NumberQueue(10);

        int customersServed = 0;
        int customerLeft = 0;
        int restaurantFull = 0;
        int maxSize = 0;

        for (int t = 1; t <= 480; t++) {
            int avgMinutes = 1 + r.nextInt(5);
            if (avgMinutes == 5 && nq.size() < 10) {
                nq.enqueue(r.nextInt(10));
                customersServed++;
                if (maxSize < nq.size())
                    maxSize = nq.size();
            }
            if (nq.size() == 10) {
                restaurantFull++;
                if (avgMinutes == 5) {
                    customerLeft++;
                }
            }
            if (!nq.isEmpty() && t % 3 == 0)
                nq.dequeue();
        }

        System.out.println("Restaurant served " + customersServed + ".");
        System.out.println("Customers Left: " + customerLeft);
        if (restaurantFull == 0)
            System.out.println("Restaurant had max queue size of " + maxSize + ".");
        else
            System.out.println("Restaurant was full " + restaurantFull + " times.");
    }
}

