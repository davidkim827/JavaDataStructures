package Final;

import java.util.*;

public class StackEquals{

    //to do
    public static boolean equals(Stack<Integer> s1, Stack<Integer> s2){
        Stack<Integer> auxStorage = new Stack<>(); //auxiliary storage stack

        //pops off top items from both stacks, compares them. If the integers are equal, they are both pushed to the
        //auxiliary stack and keeps going. If the integers are not, the method returns a false boolean response.
        while(s1.size() > 1 && s2.size() > 1){
            int stack1Integer = s1.pop();
            int stack2Integer = s2.pop();
            if(stack1Integer == stack2Integer) {
                auxStorage.push(stack1Integer);
                auxStorage.push(stack2Integer);
            }
            else if(stack1Integer != stack2Integer)
                return false;
        }
        //the last items are compared and then all the items are pushed back to their original stacks
        int lastItemS1 = s1.peek();
        int lastItemS2 = s2.peek();
        if(lastItemS1 == lastItemS2){
            while(!auxStorage.isEmpty()) {
                int pushBackS1 = auxStorage.pop();
                int pushBackS2 = auxStorage.pop();
                s1.push(pushBackS1);
                s2.push(pushBackS2);
            }
            return true;
        }
        else {
            while(!auxStorage.isEmpty()) {
                int pushBackS1 = auxStorage.pop();
                int pushBackS2 = auxStorage.pop();
                s1.push(pushBackS1);
                s2.push(pushBackS2);
            }
            return false;
        }
    }
    public static void main(String[] args){
        Stack<Integer> s1=new Stack();
        Stack<Integer> s2=new Stack();
        s1.push(1);
        s1.push(2);
        s1.push(26);
        s1.push(56);
        s2.push(1);
        s2.push(2);
        s2.push(26);
        s2.push(56);
        System.out.println(equals(s1,s2));
        System.out.println(s2.size());
    }

}
