package Homework.Week4_LinkedListStack;
/**
 * Created by dk on 9/18/2017.
 */
public class LLNode {
    private LLNode next;
    private int coin;

    public LLNode(int coin, LLNode next){ //LLNode constructor to accept what coin and pointing to next element in stack
        this.next = next;
        setCoin(coin);
    }

    public void setCoin(int coin){
        this.coin = coin;
    }

    public int getCoin(){
        return coin;
    }

    public void setNext(LLNode next){
        this.next = next;
    }

    public LLNode getNext(){
        return next;
    }
}
