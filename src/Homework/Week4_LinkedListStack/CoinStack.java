package Homework.Week4_LinkedListStack;

/**
 * Created by dk on 9/18/2017.
 */
public class CoinStack implements CoinStackInterface { //Linked List Implementation of Stack ADT
    private LLNode top;
    private int count;

    public CoinStack(){
        top = null;
    }

    public int top(){ //returns top element
        return top.getCoin();
    }

    public void push(int coin){ //pushes/points to a new node for stack
        LLNode n = new LLNode(coin, null);
        n.setNext(top);
        top = n;

        count++;
    }

    public void pop() { //removes top element from stack
        if (!isEmpty()) {
            LLNode nn = top;
            top = nn.getNext();
        }
        this.count--;
    }

    public int size() {
        return this.count;
    }

    public boolean isFull(){
        return false;
    }

    public boolean isEmpty(){
        return top == null;
    }

}
