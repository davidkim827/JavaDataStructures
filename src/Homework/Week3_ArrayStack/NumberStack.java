package Homework.Week3_ArrayStack;

/**
 * Created by dk on 9/10/2017.
 */
public class NumberStack {

    private int[] oddArray;
    private int[] evenArray;
    private int index1;
    private int index2;

    public NumberStack(){ //array based stack implementation constructor
        this.index1 = 0;
        this.index2 = 0;
        this.oddArray = new int[200];
        this.evenArray = new int[200];
    }

    public void push(int randomNumber){ //pushes an item on to an even stack or an odd stack depending on the random number generated.
        if (!isFull() && randomNumber % 2 == 1 && randomNumber > 0 && randomNumber <= 1000) {
            this.oddArray[this.index1] = randomNumber;
            this.index1++;
        }
        else if (!isFull() && randomNumber % 2 == 0 && randomNumber > 0 && randomNumber <= 1000) {
            this.evenArray[this.index2] = randomNumber;
            this.index2++;
        }
    }

    public void pop(int index){ //removes top item from stack
        if (!isEmpty() && index == 1)
            this.index1--;
        else if (!isEmpty() && index == 2)
            this.index2--;
    }

    public int top(int index){ //looks at the top item on stack
        if (!isEmpty() && index == 1)
            return this.oddArray[this.index1];
        else
            return this.evenArray[this.index2];
    }

    public boolean isEmpty() {
        return this.index1 == 0 || this.index2 == 0;
    }

    public boolean isFull(){
        return (this.index1 + this.index2) > 200;
    }

    public String print(){ //print method for printing out both the stacks and determining how many are in each stack
        if (index1 != 0 || index2 != 0 && !isFull()){
            System.out.println("Odd Stack: ");
            for (int i = 0; i < oddArray.length; i++) {
                if (oddArray[i] != 0) {
                    if (i % 10 == 0)
                        System.out.println();
                    System.out.print(oddArray[i] + " ");
                }
            }
            System.out.println("\n\nEven Stack: ");
            for (int j = 0; j < oddArray.length; j++)
                if (evenArray[j] != 0) {
                    if (j % 10 == 0)
                        System.out.println();
                    System.out.print(evenArray[j] + " ");
                }
            System.out.printf("\n\nNumber in Odd Stack: %1d \nNumber in Even Stack: %1d\n", index1, index2);
        }
        return "";
    }
}
