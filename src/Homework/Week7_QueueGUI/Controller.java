package Homework.Week7_QueueGUI;

import javafx.scene.control.*;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Controller implements Runnable {
    private int status;
    private Thread thread;
    private TextArea resultsTextArea;

    public Controller(TextArea resultsTextArea) {
        thread = new Thread(this);
        setResultsTextArea(resultsTextArea);
        status = 0;

    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void start() {
        thread.start();
    }

    public void setResultsTextArea(TextArea resultsTextArea) {
        this.resultsTextArea = resultsTextArea;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            switch (getStatus()) {
                case 0: {

                    break;
                }
                case 1: {
                    results();
                    break;
                }

            }
        }
    }



    public void results() {
        Random r = new Random();


        NumberQueue nq = new NumberQueue(10);

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
                timeArrivedArray[countTimeArrived] = t;
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
                timeLeftArray[countTimeLeft] = t;
                countTimeLeft++;
            }
        }

        int waitingTime = 0;
        for (int i = 0; i < timeArrivedArray.length; i++) {
            timeArray[i] = timeLeftArray[i] - timeArrivedArray[i];
            if (timeArray[i] > waitingTime) {
                waitingTime = timeArray[i];
            }
            if (timeArray[i] < 0) {
                customersNotServed++;
            }
        }

        int sum = 0;
        int[] copyArr = Arrays.copyOf(timeArray, (customersServed - customersNotServed));
        for (int i = 0; i < copyArr.length; i++) {
            sum = sum + copyArr[i];
        }
        float average = (float) sum / copyArr.length;
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String averageString = Float.valueOf(decimalFormat.format(average)).toString();

        System.out.printf("Average waiting time: %1.3f minutes\n", average);
        System.out.println("Longest waiting time: " + waitingTime + " minutes");
        System.out.println("Total Customers: " + (customersServed - customersNotServed));
        System.out.println("Customers not served after closing: " + customersNotServed);
        System.out.println("Customers left: " + customerLeft);

        resultsTextArea.setText("Average waiting time: " + averageString + " minutes\nLongest waiting time: " +
                waitingTime + "\nTotal Customers: " + (customersServed - customersNotServed) + "\nCustomers left: "
                + customerLeft);

    }

}
