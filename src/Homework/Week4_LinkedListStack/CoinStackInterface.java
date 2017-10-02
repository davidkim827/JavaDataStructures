package Homework.Week4_LinkedListStack;

/**
 * Created by dk on 9/18/2017.
 */
public interface CoinStackInterface {
    public int top();
    public void push(int coin);
    public void pop();
    public int size();
    public boolean isFull();
    public boolean isEmpty();
}
