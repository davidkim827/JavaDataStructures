package ClassExample.StackLinkedList;

/**
 * Created by dk on 9/14/2017.
 */
public class LinkedStack {
    private LNumber top;

    public LinkedStack(){
        top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public boolean isFull(){
        return false;
    }

    public LNumber top(){
        return top;
    }

    public void push(int data){
        LNumber n = new LNumber(data);
        n.setNext(top);
        top = n;

    }

    public void pop(){
        if (!isEmpty())
            top = top.getNext();
    }

    public int size(){
        LNumber tmp = top;
        int count = 0;
        while(tmp != null){
            count++;
            tmp = tmp.getNext();
        }
        return count;
    }
}
