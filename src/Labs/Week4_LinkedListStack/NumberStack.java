package Labs.Week4_LinkedListStack;

/**
 * Created by dk on 9/14/2017.
 */
public class NumberStack {
    private LLNode top;
    private int count;

    public NumberStack() {
        top = null;
    }

    public boolean isEmpty() { //type in an even number or odd number for argument
        return top == null;
    }

    public boolean isFull() {
        return false;
    }

    public int top() {
        return top.getRandomNumber();
    }

    public void push(int randomNumber) {
        LLNode n = new LLNode(randomNumber, null);
        n.setNext(top);
        top = n;

        this.count++;
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

    public void print(){
        System.out.print("Stack: \n");
        LLNode stack = top;
        int count = 0;
        while (stack != null){
            if (count % 10 == 0)
                System.out.println();
            System.out.print(stack.getRandomNumber() + " ");
            stack = stack.getNext();
            count++;
        }
        System.out.println();
    }
}



