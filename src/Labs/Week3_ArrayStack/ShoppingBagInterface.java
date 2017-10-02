package Labs.Week3_ArrayStack;

/**
 * Created by dk on 9/7/2017.
 */
public interface ShoppingBagInterface {
    void push (Item item);
    void pop();
    Item top();
    boolean isFull();
    boolean isEmpty();
}
