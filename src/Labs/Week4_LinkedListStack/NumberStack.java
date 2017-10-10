package Labs.Week4_LinkedListStack;

/**
 * Created by dk on 9/14/2017.
 */
public class NumberStack {
    private LLNode top;
    private int count;

    public NumberStack() {
        top = null;
    } //constructor for LL Stack

    public boolean isEmpty() { //type in an even number or odd number for argument
        return top == null;
    } //checks to see if stack is empty or not

    public boolean isFull() {//checks to see if stack is full (but really can't be full because it's not a fixed size like arrays
        return false;
    }

    public int top() {
        return top.getRandomNumber();
    } //checks for top item on the LL Stack

    public void push(int randomNumber) { //pushes next random number to LL Stack
        LLNode n = new LLNode(randomNumber, null);
        n.setNext(top);
        top = n;

        this.count++;
    }

    public void pop() { //pops or removes top element from stack
        if (!isEmpty()) {
            LLNode nn = top;
            top = nn.getNext();
        }
        this.count--;
    }

    public int size() {
        return this.count;
    } //returns the size of the stack

    public void print(){ //print method for the entire stack
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



