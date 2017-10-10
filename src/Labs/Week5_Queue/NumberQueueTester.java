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

        for (int t = 1; t <= 480; t++) { //given a timeline of 8 hours, modeled a restaurant queue so that on average, customers would come every 5 min. and served in 3 min. (on average).
            int avgMinutes = 1 + r.nextInt(5); // 1 - 5 minutes average
            if (avgMinutes == 5 && nq.size() < 10) { // every time a random 5 is generated, it enqueues a customer
                nq.enqueue(r.nextInt(10));
                customersServed++;
                if (maxSize < nq.size())
                    maxSize = nq.size();
            }
            if (nq.size() == 10) { //every time the queue gets full (at size 10) then the customer leaves
                restaurantFull++;
                if (avgMinutes == 5) {
                    customerLeft++;
                }
            }
            if (!nq.isEmpty() && t % 3 == 0) //a customer is dequeued everytime they are served if and only if the restaurant is not empty
                nq.dequeue();
        }

        //print out of the data
        System.out.println("Restaurant served " + customersServed + ".");
        System.out.println("Customers Left: " + customerLeft);
        if (restaurantFull == 0)
            System.out.println("Restaurant had max queue size of " + maxSize + ".");
        else
            System.out.println("Restaurant was full " + restaurantFull + " times.");
    }
}

