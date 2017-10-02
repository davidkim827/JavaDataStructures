package Labs.Week6_MultiThreading;

import javax.swing.*;

/**
 * Created by dk on 9/28/2017.
 */
public class StopWatchLogic implements Runnable {
    private Thread thread;
    private int status;
    private JLabel label;
    private int m, s, ss;

    public StopWatchLogic(JLabel label) {
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
                case 0: {
                    this.s = this.m = this.ss = 0;
                    label.setText("00:00:00");
                    break;
                }
                case 1: {
                    add();
                    break;
                }
                case 2:
                    break;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void add() {
        this.ss++;
        if (this.s == 60) {
            this.m++;
            this.s = 0;
        }
        if (this.ss == 99) {
            this.s++;
            this.ss = -1;
        }
        String timerUpdate;
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

        label.setText(timerUpdate);

    }
}
