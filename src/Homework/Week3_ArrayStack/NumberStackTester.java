package Homework.Week3_ArrayStack;

import java.util.Random;

/**
 * Created by dk on 9/10/2017.
 */
public class NumberStackTester {
    public static void main(String[] args) {
        Random r = new Random();

        NumberStack ns = new NumberStack();

        for (int i = 0; i < 500; i++)
            ns.push(r.nextInt(5000));

        ns.print();
    }
}

