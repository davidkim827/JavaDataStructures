package Labs.Week6;

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

    public StopWatchGUI() {
        super("StopWatchGUI");
        layout = new FlowLayout(0);
        setLayout(layout);
        btn0 = new JButton("Start");
        btn1 = new JButton("Reset");
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
        //See sample code below
        if (event.getActionCommand().equals("Start")) {
            stopwatch.setStatus(1);
            btn0.setText("Pause");
        }
        else if (event.getActionCommand().equals("Pause")) {
            stopwatch.setStatus(2);
            btn0.setText("Resume");
        }
        else if (event.getActionCommand().equals("Resume")){
            stopwatch.setStatus(1);
            btn0.setText("Pause");
        }
        if (event.getActionCommand().equals("Reset")) {
            stopwatch.setStatus(0);
            btn0.setText("Start");
        }
    }

    public static void main(String[] args) {
        StopWatchGUI stopWatchGUI = new StopWatchGUI();
        stopWatchGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stopWatchGUI.setSize(450, 350);
        stopWatchGUI.setVisible(true);
    }

}
