package ClassExample.StackLinkedList;

/**
 * Created by dk on 9/14/2017.
 */
public class LNumber{
    private int data;
    private LNumber next;

    public LNumber(int data){
        this.data = getData();
        next = null;
    }

    public int getData(){
        return data;
    }

    public void setData(int d){
        data = d;
    }

    public LNumber getNext(){
        return next;
    }

    public void setNext(LNumber next){
        this.next = next;
    }

    public String toString(){
        return ""+data;
    }
}
