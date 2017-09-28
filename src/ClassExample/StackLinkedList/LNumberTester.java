package ClassExample.StackLinkedList;

/**
 * Created by dk on 9/14/2017.
 */
public class LNumberTester {
    public static void main(String[] args) {
        LNumber n1 = new LNumber(10);
        LNumber n2 = new LNumber (5);
        n1.setNext(n2);
        System.out.println(n1.getNext());
        System.out.println(n1.getNext()==n2);
        n2.setNext(n1);
    }
}
