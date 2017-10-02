package Homework.Week5Week6_MultiThreading;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by dk on 9/29/2017.
 */
public class PrintCharTester {
    public static void main(String[] args) throws FileNotFoundException {
        PrintChar thread1 = new PrintChar('A', 100);
        PrintChar thread2 = new PrintChar('B', 100  );

        PrintStream out = new PrintStream(new FileOutputStream("printChar.txt"));
        System.setOut(out);

        thread1.start();
        thread2.start();

    }
}
