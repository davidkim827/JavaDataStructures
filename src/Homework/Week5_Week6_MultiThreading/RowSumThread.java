package Homework.Week5_Week6_MultiThreading;

/**
 * Created by dk on 9/29/2017.
 */
public class RowSumThread implements Runnable {
    private Thread thread;
    private int[][] randomArray;
    private int index;

    public RowSumThread(int[][] randomArray, int index) { //constructor accepting the 20x20 array filled with random integers and index argument to sum up in rowsum() method.
        this.thread = new Thread(this);
        setRandomArray(randomArray);
        setIndex(index);
    }

    public void setRandomArray(int[][] randomArray) {
        this.randomArray = randomArray;
    }

    public int[][] getRandomArray() {
        return randomArray;
    }

    public void setIndex(int index){
        this.index = index;
    }

    public int getIndex(){
        return index;
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        rowSum();
    }

    public int rowSum() { //method that sums up the rows
        int rowSum = 0;

        for (int i = getIndex(); i < getIndex() + 1; i++)
            for (int j = 0; j < getRandomArray().length; j++)
                rowSum = rowSum + getRandomArray()[i][j];

        return rowSum;
    }
}
