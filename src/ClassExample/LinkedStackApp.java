package ClassExample;

/**
 * Created by dk on 9/14/2017.
 */
public class LinkedStackApp {
    public static void main(String[] args) {
        LinkedStack s = new LinkedStack();
        s.push(10);
        s.push(5);
        System.out.println(s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.size());
        System.out.println(s.top());
    }
}
