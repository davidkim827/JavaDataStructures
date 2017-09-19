package Homework.Week4;

/**
 * Created by dk on 9/18/2017.
 */
public class CoinStack implements CoinStackInterface {
    private LLNode top;
    private int count;

    public CoinStack(){
        top = null;
    }

    public int top(){
        return top.getCoin();
    }

    public void push(int coin){
        LLNode n = new LLNode(coin, null);
        n.setNext(top);
        top = n;

        count++;
    }

    public void pop() {
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
