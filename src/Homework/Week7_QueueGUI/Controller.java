package Homework.Week7_QueueGUI;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Controller implements Runnable {

    private ImageView customer0View;
    private ImageView customer1View;
    private ImageView customer2View;
    private ImageView customer3View;
    private ImageView customer4View;
    private ImageView customer5View;
    private ImageView customer6View;
    private ImageView customer7View;
    private ImageView customer8View;
    private ImageView customer9View;
    private ImageView customer10View;

    private int status;
    private Thread thread;

    private TextArea resultsTextArea;
    private Button startButton;
    private Button stopButton;

    private int position;
    private int count;

    //constructor for the GUI logic
    public Controller(TextArea resultsTextArea, Button startButton, Button stopButton, ImageView customer0View,
                      ImageView customer1View, ImageView customer2View, ImageView customer3View,
                      ImageView customer4View, ImageView customer5View, ImageView customer6View,
                      ImageView customer7View, ImageView customer8View, ImageView customer9View,
                      ImageView customer10View) {
        thread = new Thread(this);
        status = 0;
        count = 0;

        setResultsTextArea(resultsTextArea);
        setStartButton(startButton);
        setStopButton(stopButton);

        setCustomer0View(customer0View);
        setCustomer1View(customer1View);
        setCustomer2View(customer2View);
        setCustomer3View(customer3View);
        setCustomer4View(customer4View);
        setCustomer5View(customer5View);
        setCustomer6View(customer6View);
        setCustomer7View(customer7View);
        setCustomer8View(customer8View);
        setCustomer9View(customer9View);
        setCustomer10View(customer10View);
    }

    //getters and setter methods for the fields
    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setResultsTextArea(TextArea resultsTextArea) {
        this.resultsTextArea = resultsTextArea;
    }

    public void setStartButton(Button startButton) {
        this.startButton = startButton;
    }

    public void setStopButton(Button stopButton) {
        this.stopButton = stopButton;
    }

    public void setCustomer0View(ImageView customer0View) {
        this.customer0View = customer0View;
    }

    public ImageView getCustomer0View() {
        return customer0View;
    }

    public void setCustomer1View(ImageView customer1View) {
        this.customer1View = customer1View;
    }

    public ImageView getCustomer1View() {
        return customer1View;
    }

    public void setCustomer2View(ImageView customer2View) {
        this.customer2View = customer2View;
    }

    public ImageView getCustomer2View() {
        return customer2View;
    }

    public void setCustomer3View(ImageView customer3View) {
        this.customer3View = customer3View;
    }

    public ImageView getCustomer3View() {
        return customer3View;
    }

    public void setCustomer4View(ImageView customer4View) {
        this.customer4View = customer4View;
    }

    public ImageView getCustomer4View() {
        return customer4View;
    }

    public void setCustomer5View(ImageView customer5View) {
        this.customer5View = customer5View;
    }

    public ImageView getCustomer5View() {
        return customer5View;
    }

    public void setCustomer6View(ImageView customer6View) {
        this.customer6View = customer6View;
    }

    public ImageView getCustomer6View() {
        return customer6View;
    }

    public void setCustomer7View(ImageView customer7View) {
        this.customer7View = customer7View;
    }

    public ImageView getCustomer7View() {
        return customer7View;
    }

    public void setCustomer8View(ImageView customer8View) {
        this.customer8View = customer8View;
    }

    public ImageView getCustomer8View() {
        return customer8View;
    }

    public void setCustomer9View(ImageView customer9View) {
        this.customer9View = customer9View;
    }

    public ImageView getCustomer9View() {
        return customer9View;
    }

    public void setCustomer10View(ImageView customer10View) {
        this.customer10View = customer10View;
    }

    public ImageView getCustomer10View() {
        return customer10View;
    }

    //starting method for thread
    public void start() {
        thread.start();
    }

    @Override
    // Run method that consists of three different states: beginning state, counting state, and stopping state. The
    // beginning state will disable the stop button, so that the stop logic will not run, and the counting state will
    // implement a counter so that it will count (minutes) until the user inputs the stop button action, or if the user
    // does not input a stop button action, then the entirety of the "8 hours" will run. The end user has 5 seconds to
    // determine when he/she will stop. Then the result method will take into consider how many counts (minutes) to
    // implement in the stop state or full state.
    public void run() {
        while (true) {
            switch (getStatus()) {
                case 0: {
                    startButton.setDisable(false);
                    stopButton.setDisable(true);
                    break;
                }
                case 1: {
                    if (getCount() == 480) {
                        stopButton.setDisable(true);
                        resultsTextArea.setText("Results");
                        results(getCount());
                        setStatus(0);
                        run();
                    }
                    this.count++;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    resultsTextArea.setText("Press stop now otherwise it will run \nuntil the end. You have 5 seconds.");
                    break;
                }
                case 2: {
                    setStatus(0);
                    results(count);
                    run();
                    break;
                }
            }
        }
    }

    // Over the course of "8 hours" for the full term (for loop with counts dependent on the run method), will generate
    // random numbers between 1 and 5 to simulate a restaurant queue. On average, a customer will enqueue every 5
    // minutes and leave on average in 3 minutes. An array collects the data for when the customers enqueue and dequeue,
    // and calculates the average time it takes to serve a customer. It outputs all the data into the textbox on the GUI.
    public void results(int counter) {

        Random r = new Random();
        Random c = new Random();

        NumberQueue nq = new NumberQueue(10);

        int customersServed = 0;
        int customerLeft = 0;
        int maxSize = 0;

        int[] timeArray = new int[150];

        int[] timeArrivedArray = new int[150];
        int[] timeLeftArray = new int[150];
        int countTimeArrived = 0;
        int countTimeLeft = 0;
        int customersNotServed = 0;

        int queuePositionRear = 0;

        for (int t = 1; t <= counter; t++) {
            int avgMinutes = 1 + r.nextInt(5);
            if (avgMinutes == 5 && nq.size() < 10) {
                nq.enqueue(r.nextInt(10));
                timeArrivedArray[countTimeArrived] = t;
                countTimeArrived++;
                customersServed++;
                setPosition(++queuePositionRear);
                customerEnqueue(randomImage());
                System.out.print("minute: " + t + " | " + queuePositionRear + " enqueue | ");
                if (maxSize < nq.size())
                    maxSize = nq.size();
            }
            if (nq.size() == 10) {
                if (avgMinutes == 5) {
                    customerLeft++;
                }
            }
            if (!nq.isEmpty() && t % 3 == 0) {
                nq.dequeue();
                timeLeftArray[countTimeLeft] = t;
                countTimeLeft++;
                setPosition(--queuePositionRear);
                customerDequeue();
                System.out.println("minute: " + t + " | " + queuePositionRear + " dequeue");
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
        DecimalFormat df = new DecimalFormat("#0.000");
        String averageWaitingTime = df.format(average);

        resultsTextArea.setText("Average waiting time: " + averageWaitingTime + " minutes\nLongest waiting time: " +
                waitingTime + "\nTotal Customers: " + (customersServed - customersNotServed) + "\nCustomers left: "
                + customerLeft);
    }

    // method to visually simulate an enqueue
    public void customerEnqueue(Image randomImage) {

        if (getPosition() == 1)
            getCustomer0View().setImage(randomImage);
        else if (getPosition() == 2)
            getCustomer1View().setImage(randomImage);
        else if (getPosition() == 3)
            getCustomer2View().setImage(randomImage);
        else if (getPosition() == 4)
            getCustomer3View().setImage(randomImage);
        else if (getPosition() == 5)
            getCustomer4View().setImage(randomImage);
        else if (getPosition() == 6)
            getCustomer5View().setImage(randomImage);
        else if (getPosition() == 7)
            getCustomer6View().setImage(randomImage);
        else if (getPosition() == 8)
            getCustomer7View().setImage(randomImage);
        else if (getPosition() == 9)
            getCustomer8View().setImage(randomImage);
        else if (getPosition() == 10)
            getCustomer9View().setImage(randomImage);
        else
            getCustomer10View().setImage(randomImage);
    }

    //method to visually simulate a dequeue as well as shifting customers down the line
    public void customerDequeue() {

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (getPosition() == 0)
            getCustomer0View().setImage(null);

        else if (getPosition() == 1) {
            Image customerShift1 = getCustomer1View().getImage();
            customerEnqueue(customerShift1);
            getCustomer1View().setImage(null);

        } else if (getPosition() == 2) {
            Image customerShift1 = getCustomer1View().getImage();
            setPosition(--position);
            customerEnqueue(customerShift1);
            getCustomer1View().setImage(null);
            setPosition(++position);

            Image customerShift2 = getCustomer2View().getImage();
            customerEnqueue(customerShift2);
            getCustomer2View().setImage(null);

        } else if (getPosition() == 3) {
            Image customerShift1 = getCustomer1View().getImage();
            setPosition(position - 2);
            customerEnqueue(customerShift1);
            getCustomer1View().setImage(null);
            setPosition(position + 2);

            Image customerShift2 = getCustomer2View().getImage();
            setPosition(position - 1);
            customerEnqueue(customerShift2);
            getCustomer2View().setImage(null);
            setPosition(position + 1);

            Image customerShift3 = getCustomer3View().getImage();
            customerEnqueue(customerShift3);
            getCustomer3View().setImage(null);

        } else if (getPosition() == 4) {
            Image customerShift1 = getCustomer1View().getImage();
            setPosition(position - 3);
            customerEnqueue(customerShift1);
            getCustomer1View().setImage(null);
            setPosition(position + 3);

            Image customerShift2 = getCustomer2View().getImage();
            setPosition(position - 2);
            customerEnqueue(customerShift2);
            getCustomer2View().setImage(null);
            setPosition(position + 2);

            Image customerShift3 = getCustomer3View().getImage();
            setPosition(position - 1);
            customerEnqueue(customerShift3);
            getCustomer3View().setImage(null);
            setPosition(position + 1);

            Image customerShift4 = getCustomer4View().getImage();
            customerEnqueue(customerShift4);
            getCustomer4View().setImage(null);


        } else if (getPosition() == 5) {
            Image customerShift1 = getCustomer1View().getImage();
            setPosition(position - 4);
            customerEnqueue(customerShift1);
            getCustomer1View().setImage(null);
            setPosition(position + 4);

            Image customerShift2 = getCustomer2View().getImage();
            setPosition(position - 3);
            customerEnqueue(customerShift2);
            getCustomer2View().setImage(null);
            setPosition(position + 3);

            Image customerShift3 = getCustomer3View().getImage();
            setPosition(position - 2);
            customerEnqueue(customerShift3);
            getCustomer3View().setImage(null);
            setPosition(position + 2);

            Image customerShift4 = getCustomer4View().getImage();
            setPosition(position - 1);
            customerEnqueue(customerShift4);
            getCustomer4View().setImage(null);
            setPosition(position + 1);

            Image customerShift5 = getCustomer5View().getImage();
            customerEnqueue(customerShift5);
            getCustomer5View().setImage(null);
        } else if (getPosition() == 6) {
            Image customerShift1 = getCustomer1View().getImage();
            setPosition(position - 5);
            customerEnqueue(customerShift1);
            getCustomer1View().setImage(null);
            setPosition(position + 5);

            Image customerShift2 = getCustomer2View().getImage();
            setPosition(position - 4);
            customerEnqueue(customerShift2);
            getCustomer2View().setImage(null);
            setPosition(position + 4);

            Image customerShift3 = getCustomer3View().getImage();
            setPosition(position - 3);
            customerEnqueue(customerShift3);
            getCustomer3View().setImage(null);
            setPosition(position + 3);

            Image customerShift4 = getCustomer4View().getImage();
            setPosition(position - 2);
            customerEnqueue(customerShift4);
            getCustomer4View().setImage(null);
            setPosition(position + 2);

            Image customerShift5 = getCustomer5View().getImage();
            setPosition(position - 1);
            customerEnqueue(customerShift5);
            getCustomer5View().setImage(null);
            setPosition(position + 1);

            Image customerShift6 = getCustomer6View().getImage();
            customerEnqueue(customerShift6);
            getCustomer6View().setImage(null);
        } else if (getPosition() == 7) {
            Image customerShift1 = getCustomer1View().getImage();
            setPosition(position - 6);
            customerEnqueue(customerShift1);
            getCustomer1View().setImage(null);
            setPosition(position + 6);

            Image customerShift2 = getCustomer2View().getImage();
            setPosition(position - 5);
            customerEnqueue(customerShift2);
            getCustomer2View().setImage(null);
            setPosition(position + 5);

            Image customerShift3 = getCustomer3View().getImage();
            setPosition(position - 4);
            customerEnqueue(customerShift3);
            getCustomer3View().setImage(null);
            setPosition(position + 4);

            Image customerShift4 = getCustomer4View().getImage();
            setPosition(position - 3);
            customerEnqueue(customerShift4);
            getCustomer4View().setImage(null);
            setPosition(position + 3);

            Image customerShift5 = getCustomer5View().getImage();
            setPosition(position - 2);
            customerEnqueue(customerShift5);
            getCustomer5View().setImage(null);
            setPosition(position + 2);

            Image customerShift6 = getCustomer6View().getImage();
            setPosition(position - 1);
            customerEnqueue(customerShift6);
            getCustomer6View().setImage(null);
            setPosition(position + 1);

            Image customerShift7 = getCustomer7View().getImage();
            customerEnqueue(customerShift7);
            getCustomer7View().setImage(null);
        } else if (getPosition() == 8) {
            Image customerShift1 = getCustomer1View().getImage();
            setPosition(position - 7);
            customerEnqueue(customerShift1);
            getCustomer1View().setImage(null);
            setPosition(position + 7);

            Image customerShift2 = getCustomer2View().getImage();
            setPosition(position - 6);
            customerEnqueue(customerShift2);
            getCustomer2View().setImage(null);
            setPosition(position + 6);

            Image customerShift3 = getCustomer3View().getImage();
            setPosition(position - 5);
            customerEnqueue(customerShift3);
            getCustomer3View().setImage(null);
            setPosition(position + 5);

            Image customerShift4 = getCustomer4View().getImage();
            setPosition(position - 4);
            customerEnqueue(customerShift4);
            getCustomer4View().setImage(null);
            setPosition(position + 4);

            Image customerShift5 = getCustomer5View().getImage();
            setPosition(position - 3);
            customerEnqueue(customerShift5);
            getCustomer5View().setImage(null);
            setPosition(position + 3);

            Image customerShift6 = getCustomer6View().getImage();
            setPosition(position - 2);
            customerEnqueue(customerShift6);
            getCustomer6View().setImage(null);
            setPosition(position + 2);

            Image customerShift7 = getCustomer7View().getImage();
            setPosition(position - 1);
            customerEnqueue(customerShift7);
            getCustomer7View().setImage(null);
            setPosition(position + 1);

            Image customerShift8 = getCustomer8View().getImage();
            customerEnqueue(customerShift8);
            getCustomer8View().setImage(null);

        } else if (getPosition() == 9) {
            Image customerShift1 = getCustomer1View().getImage();
            setPosition(position - 8);
            customerEnqueue(customerShift1);
            getCustomer1View().setImage(null);
            setPosition(position + 8);

            Image customerShift2 = getCustomer2View().getImage();
            setPosition(position - 7);
            customerEnqueue(customerShift2);
            getCustomer2View().setImage(null);
            setPosition(position + 7);

            Image customerShift3 = getCustomer3View().getImage();
            setPosition(position - 6);
            customerEnqueue(customerShift3);
            getCustomer3View().setImage(null);
            setPosition(position + 6);

            Image customerShift4 = getCustomer4View().getImage();
            setPosition(position - 5);
            customerEnqueue(customerShift4);
            getCustomer4View().setImage(null);
            setPosition(position + 5);

            Image customerShift5 = getCustomer5View().getImage();
            setPosition(position - 4);
            customerEnqueue(customerShift5);
            getCustomer5View().setImage(null);
            setPosition(position + 4);

            Image customerShift6 = getCustomer6View().getImage();
            setPosition(position - 3);
            customerEnqueue(customerShift6);
            getCustomer6View().setImage(null);
            setPosition(position + 3);

            Image customerShift7 = getCustomer7View().getImage();
            setPosition(position - 2);
            customerEnqueue(customerShift7);
            getCustomer7View().setImage(null);
            setPosition(position + 2);

            Image customerShift8 = getCustomer8View().getImage();
            setPosition(position - 1);
            customerEnqueue(customerShift8);
            getCustomer8View().setImage(null);
            setPosition(position + 1);

            Image customerShift9 = getCustomer9View().getImage();
            customerEnqueue(customerShift9);
            getCustomer9View().setImage(null);
        } else if (getPosition() == 10){
            Image customerShift1 = getCustomer1View().getImage();
            setPosition(position - 9);
            customerEnqueue(customerShift1);
            getCustomer1View().setImage(null);
            setPosition(position + 9);

            Image customerShift2 = getCustomer2View().getImage();
            setPosition(position - 8);
            customerEnqueue(customerShift2);
            getCustomer2View().setImage(null);
            setPosition(position + 8);

            Image customerShift3 = getCustomer3View().getImage();
            setPosition(position - 7);
            customerEnqueue(customerShift3);
            getCustomer3View().setImage(null);
            setPosition(position + 7);

            Image customerShift4 = getCustomer4View().getImage();
            setPosition(position - 6);
            customerEnqueue(customerShift4);
            getCustomer4View().setImage(null);
            setPosition(position + 6);

            Image customerShift5 = getCustomer5View().getImage();
            setPosition(position - 5);
            customerEnqueue(customerShift5);
            getCustomer5View().setImage(null);
            setPosition(position + 5);

            Image customerShift6 = getCustomer6View().getImage();
            setPosition(position - 4);
            customerEnqueue(customerShift6);
            getCustomer6View().setImage(null);
            setPosition(position + 4);

            Image customerShift7 = getCustomer7View().getImage();
            setPosition(position - 3);
            customerEnqueue(customerShift7);
            getCustomer7View().setImage(null);
            setPosition(position + 3);

            Image customerShift8 = getCustomer8View().getImage();
            setPosition(position - 2);
            customerEnqueue(customerShift8);
            getCustomer8View().setImage(null);
            setPosition(position + 2);

            Image customerShift9 = getCustomer9View().getImage();
            setPosition(position - 1);
            customerEnqueue(customerShift9);
            getCustomer9View().setImage(null);
            setPosition(position + 1);

            Image customerShift10 = getCustomer10View().getImage();
            customerEnqueue(customerShift10);
            getCustomer10View().setImage(null);
        }
    }

    //method to generate random customers to enqueue
    public Image randomImage() {
        Image customer0 = new Image("File:0.png", 50.0, 100.0, true, true);
        Image customer1 = new Image("File:1.png", 50.0, 100.0, true, true);
        Image customer2 = new Image("File:2.png", 50.0, 100.0, true, true);
        Image customer3 = new Image("File:3.png", 50.0, 100.0, true, true);
        Image customer4 = new Image("File:4.png", 50.0, 100.0, true, true);
        Image customer5 = new Image("File:5.png", 50.0, 100.0, true, true);
        Image customer6 = new Image("File:6.png", 50.0, 100.0, true, true);
        Image customer7 = new Image("File:7.png", 50.0, 100.0, true, true);
        Image customer8 = new Image("File:8.png", 50.0, 100.0, true, true);
        Image customer9 = new Image("File:9.png", 50.0, 100.0, true, true);
        Image customer10 = new Image("File:10.png", 50.0, 100.0, true, true);

        Random r = new Random();
        int randomImage = r.nextInt(10);

        if (randomImage == 0)
            return customer0;
        else if (randomImage == 1)
            return customer1;
        else if (randomImage == 2)
            return customer2;
        else if (randomImage == 3)
            return customer3;
        else if (randomImage == 4)
            return customer4;
        else if (randomImage == 5)
            return customer5;
        else if (randomImage == 6)
            return customer6;
        else if (randomImage == 7)
            return customer7;
        else if (randomImage == 8)
            return customer8;
        else if (randomImage == 9)
            return customer9;
        else
            return customer10;
    }

}
