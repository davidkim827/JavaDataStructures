package Labs.Week6_MultiThreading;

import javax.swing.*;

/**
 * Created by dk on 9/28/2017.
 */
public class StopWatchLogic implements Runnable { //implements runnable to create threads
    private Thread thread;
    private int status; //status for the thread to keep checking whether it is on four different states: start, pause, resume, and stop
    private JLabel label; //connects data output as label on GUI
    private int m, s, ss;

    public StopWatchLogic(JLabel label) { //constructor for stopwatch logic
        thread = new Thread(this);
        setLabel(label);
        status = 0;
        m = s = ss = 0;
    }

    public void start() {
        thread.start();
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public void run() {
        while (true) {
            switch (getStatus()) {
                case 0: { //restarts the stopwatch
                    this.s = this.m = this.ss = 0;
                    label.setText("00:00:00");
                    break;
                }
                case 1: { //updates the stopwatch with the adding method (adds time to the clock)
                    add();
                    break;
                }
                case 2: //pauses the stopwatch
                    break;
            }
            try { //updates for the status every 10 milliseconds
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void add() {
        this.ss++; //adds a decisecond everytime this method is called
        if (this.s == 60) { // counts for every minute and returns to a zero state for seconds
            this.m++;
            this.s = 0;
        }
        if (this.ss == 99) { //counts for every second and returns to a zero state for deciseconds
            this.s++;
            this.ss = -1;
        }
        String timerUpdate; //print out for the stopwatch
        if (this.ss < 10)
            timerUpdate = ":0" + this.ss;
        else
            timerUpdate = ":" + this.ss;
        if (this.s < 10)
            timerUpdate = ":0" + this.s + timerUpdate;
        else
            timerUpdate = ":" + this.s + timerUpdate;
        if (this.m < 10)
            timerUpdate = "0" + this.m + timerUpdate;
        else
            timerUpdate = this.m + ":" + this.s + ":" + this.ss;

        label.setText(timerUpdate); //updating the stopwatch label on GUI every time the method is called

    }
}
