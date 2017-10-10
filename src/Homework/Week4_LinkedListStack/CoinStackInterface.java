package Homework.Week4_LinkedListStack;

/**
 * Created by dk on 9/18/2017.
 */
public interface CoinStackInterface {
    public int top(); //returns top element from stack
    public void push(int coin); //adds a coin to stack
    public void pop(); //removes a coin from stack
    public int size(); //returns how many coins in stack
    public boolean isFull(); //returns whether stack is full or not (should not be full because it's a linked list implementation)
    public boolean isEmpty(); //returns whether stack is empty or not
}
