package Homework.Week7_QueueGUI;

/**
 * Created by dk on 10/3/2017.
 */
public class NumberQueue {

    private int[] data;
    private int front, rear, numberOfItems, capacity;

    public NumberQueue(int capacity){
        front = rear = numberOfItems = 0;
        data = new int[capacity];
        this.capacity = capacity;
    }

    public boolean isEmpty(){
        return numberOfItems == 0;
    }

    public boolean isFull(){
        return numberOfItems == capacity;
    }

    public int size(){
        return numberOfItems;
    }

    public void enqueue(int val){
        if (!isFull()) {
            data[rear] = val;
            rear = ++rear % capacity;
            numberOfItems++;
        }
        else
            System.out.println("This restaurant is full.");
    }

    public int dequeue(){
        if (!isEmpty()) {
            int val = data[front];
            front = ++front % capacity;
            numberOfItems--;
            return val;
        }
        else
            return -1000;
    }
    public void print(){
        System.out.println(front + " " + rear);
    }

}
