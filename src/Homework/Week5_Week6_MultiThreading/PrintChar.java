package Homework.Week5_Week6_MultiThreading;

/**
 * Created by dk on 9/29/2017.
 */
public class PrintChar implements Runnable {

    private Thread thread;
    private char ch;
    private int integer;

    public PrintChar(char ch, int integer){
        this.thread = new Thread(this);
        setCh(ch);
        setInteger(integer);
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public char getCh() {
        return ch;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public int getInteger() {
        return integer;
    }

    public void start(){
        thread.start();
    }

    @Override
    public void run() {

        for(int i = 0; i < getInteger(); i++)
            System.out.println(getCh() + " ");

    }
}
