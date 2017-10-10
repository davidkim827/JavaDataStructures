package Labs.Week6_MultiThreading;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by dk on 9/28/2017.
 */
public class StopWatchGUI extends JFrame implements ActionListener {
    private final LayoutManager layout;
    private StopWatchLogic stopwatch;
    private JButton btn0;
    private JButton btn1;
    private JLabel lbl0;

    public StopWatchGUI() { //constructor for GUI
        super("StopWatchGUI");
        layout = new FlowLayout(0);
        setLayout(layout);
        btn0 = new JButton("Start"); //start button. changes when pressed.
        btn1 = new JButton("Reset"); //restart button. restarts stopwatch.
        lbl0 = new JLabel("00:00:00");

        add(lbl0);
        add(btn0);
        add(btn1);

        btn0.addActionListener(this);
        btn1.addActionListener(this);
        this.stopwatch = new StopWatchLogic(lbl0);
        stopwatch.start();
    }

    public void actionPerformed(ActionEvent event) {
        //event.getActionCommand() returns the lable on the button
        //event.getSource() returns the button object
        if (event.getActionCommand().equals("Start")) { //sets the status for 1 after start button is pressed
            stopwatch.setStatus(1);
            btn0.setText("Pause");
        }
        else if (event.getActionCommand().equals("Pause")) { //changes the start button to a "pause button" so that you can pause when needed. Status is set to 2 when "paused".
            stopwatch.setStatus(2);
            btn0.setText("Resume");
        }
        else if (event.getActionCommand().equals("Resume")){ //changes "pause button" to "resume button" so that you can resume when needed. Status is set to 1 when "resumed".
            stopwatch.setStatus(1);
            btn0.setText("Pause");
        }
        if (event.getActionCommand().equals("Reset")) { //changes the pause or resume button to "start button" so that you can restart the stopwatch. Status is set to 0 when "reset".
            stopwatch.setStatus(0);
            btn0.setText("Start");
        }
    }

    public static void main(String[] args) { //runs the GUI
        StopWatchGUI stopWatchGUI = new StopWatchGUI();
        stopWatchGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stopWatchGUI.setSize(450, 350);
        stopWatchGUI.setVisible(true);
    }

}
