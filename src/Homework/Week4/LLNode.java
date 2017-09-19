package Homework.Week4;
/**
 * Created by dk on 9/18/2017.
 */
public class LLNode {
    private LLNode next;
    private int coin;

    public LLNode(int coin, LLNode next){
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
