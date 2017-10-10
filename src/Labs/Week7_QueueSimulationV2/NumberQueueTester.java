package Labs.Week7_QueueSimulationV2;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by dk on 10/4/2017.
 */
public class NumberQueueTester {
    public static void main(String[] args) {
        Random r = new Random();


        NumberQueue nq = new NumberQueue(10);

        int customersServed = 0;
        int customerLeft = 0;
        int restaurantFull = 0;
        int maxSize = 0;

        int[] timeArray = new int[150];

        int[] timeArrivedArray = new int[150]; //counts at what time the customers arrive
        int[] timeLeftArray = new int[150]; //counts at what time the customers leave
        int countTimeArrived = 0;
        int countTimeLeft = 0;
        int customersNotServed = 0;

        for (int t = 1; t <= 480; t++) {//models an 8 hour restaurant time
            int avgMinutes = 1 + r.nextInt(5); //generates a random number between 1 - 5 to model when customers leave and come
            if (avgMinutes == 5 && nq.size() < 10) { //customers arrive on average of 5 min.
                nq.enqueue(r.nextInt(10));
                System.out.println((timeArrivedArray[countTimeArrived] = t) + " This is time Arrived"); //prints out array for what time they arrived
                countTimeArrived++;
                customersServed++;
                if (maxSize < nq.size())
                    maxSize = nq.size();
            }
            if (nq.size() == 10) { //restaurant is full when the queue is size 10 and customers leave if the queue is full
                restaurantFull++;
                if (avgMinutes == 5) {
                    customerLeft++;
                }
            }
            if (!nq.isEmpty() && t % 3 == 0) {
                nq.dequeue();
                System.out.println((timeLeftArray[countTimeLeft] = t) + " This is time Left"); //prints out array for what time they left
                countTimeLeft++;
            }
        }

        System.out.println("\n\n");


        // counts the waiting time for each customer that walked in
        int waitingTime = 0;
        for (int i = 0; i < timeArrivedArray.length; i++) {
            timeArray[i] = timeLeftArray[i] - timeArrivedArray[i]; //subtracts time arrived from time left array to create the waiting time array
            System.out.print(timeArray[i] + " ");
            if (timeArray[i] > waitingTime) {
                waitingTime = timeArray[i];
            }
            if (timeArray[i] < 0) {
                customersNotServed++;
            }
        }
        System.out.println("\n\n\n");

        //copied the waiting time array to account for any customers not served because customer entered after restaurant closed and for any unfilled spots in the array
        int sum = 0;
        int[] copyArr = Arrays.copyOf(timeArray, (customersServed - customersNotServed));
        for(int i = 0; i< copyArr.length; i++) {
            System.out.print(copyArr[i] + " ");
            sum = sum + copyArr[i];
        }
        float average = (float) sum / copyArr.length;

        System.out.println("\n\n\n");

        //prints out all gathered information
        System.out.println("Restaurant served " + (customersServed - customersNotServed) + ".");
        System.out.println("Customers NOT served after closing: " + customersNotServed);
        System.out.println("Customers Left because full: " + customerLeft);

        if (restaurantFull == 0)
            System.out.println("Restaurant had max queue size of " + maxSize + ".");
        else
            System.out.println("Restaurant was full " + restaurantFull + " times.");

        System.out.printf("\nAverage waiting time: %1.3f minutes", average);
        System.out.printf("\nLongest waiting time: %1d minutes\n", waitingTime);




    }
}

