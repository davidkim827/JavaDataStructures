package Labs.Week4_LinkedListStackADT;

public class LLNode { //class for creating the node to be pointed to
    private int randomNumber;
    private LLNode next;

    public LLNode(int randomNumber, LLNode n) { //constructor for Linked List Stack accepting a random number and the pointer for the next stack
        next = n;
        if (randomNumber <= 1000 && randomNumber > 0)
            setRandomNumber(randomNumber);
    }

    //getter and setter method for the random numbers associated with the Linked List Node
    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    //getter and setter methods for the pointers to the next Linked List Node
    public LLNode getNext() {
        return next;
    }

    public void setNext(LLNode next) {
        this.next = next;
    }

    public String toString() {
        return "" + randomNumber;
    }
}
