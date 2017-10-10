package Homework.Week5_Week6_MultiThreading;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by dk on 9/29/2017.
 */
public class PrintCharTester { //purpose is to test how multithreading behaves when two threads are available to run
    public static void main(String[] args) throws FileNotFoundException {
        PrintChar thread1 = new PrintChar('A', 100); //instantiates a thread to print out the character A
        PrintChar thread2 = new PrintChar('B', 100); //instnatiates a thread to print out the character B

        PrintStream out = new PrintStream(new FileOutputStream("printChar.txt")); //prints out the test runs to a text file
        System.setOut(out);

        thread1.start(); //starts 1st thread consisting of the A character
        thread2.start(); //starts 2nd thread consisting of the B character

    }
}
