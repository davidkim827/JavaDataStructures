package Homework.Week7_QueueGUI;

import Labs.Week7_QueueSimulationV2.NumberQueue;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by dk on 10/4/2017.
 */
public class NumberQueueTester {
    public static void main(String[] args) {
        Random r = new Random();


        Labs.Week7_QueueSimulationV2.NumberQueue nq = new NumberQueue(10);

        int customersServed = 0;
        int customerLeft = 0;
        int restaurantFull = 0;
        int maxSize = 0;

        int[] timeArray = new int[150];

        int[] timeArrivedArray = new int[150];
        int[] timeLeftArray = new int[150];
        int countTimeArrived = 0;
        int countTimeLeft = 0;
        int customersNotServed = 0;

        for (int t = 1; t <= 480; t++) {
            int avgMinutes = 1 + r.nextInt(5);
            if (avgMinutes == 5 && nq.size() < 10) {
                nq.enqueue(r.nextInt(10));
                System.out.println((timeArrivedArray[countTimeArrived] = t) + " This is time Arrived");
                countTimeArrived++;
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
            if (!nq.isEmpty() && t % 3 == 0) {
                nq.dequeue();
                System.out.println((timeLeftArray[countTimeLeft] = t) + " This is time Left");
                countTimeLeft++;
            }
        }

        System.out.println("\n\n");

        int waitingTime = 0;
        for (int i = 0; i < timeArrivedArray.length; i++) {
            timeArray[i] = timeLeftArray[i] - timeArrivedArray[i];
            System.out.print(timeArray[i] + " ");
            if (timeArray[i] > waitingTime) {
                waitingTime = timeArray[i];
            }
            if (timeArray[i] < 0) {
                customersNotServed++;
            }
        }
        System.out.println("\n\n\n");

        int sum = 0;
        int[] copyArr = Arrays.copyOf(timeArray, (customersServed - customersNotServed));
        for(int i = 0; i< copyArr.length; i++) {
            System.out.print(copyArr[i] + " ");
            sum = sum + copyArr[i];
        }
        float average = (float) sum / copyArr.length;

        System.out.println("\n\n\n");

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

