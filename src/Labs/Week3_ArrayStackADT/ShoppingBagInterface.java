package Labs.Week3_ArrayStackADT;

/**
 * Created by dk on 9/7/2017.
 */
public interface ShoppingBagInterface { //Interface for the shopping bag
    void push (Item item); //pushes an item on to the stack
    void pop(); //pops an item from the stack
    Item top(); //returns the last in item on the stack
    boolean isFull(); //returns true if stack is full
    boolean isEmpty(); //returns true if stack is empty
}
