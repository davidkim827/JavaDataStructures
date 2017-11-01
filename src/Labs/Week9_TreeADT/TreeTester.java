package Labs.Week9_TreeADT;

/**
 * Created by dk on 10/26/2017.
 */
public class TreeTester {
    public static void main(String[] args){
        MyTree tree = new MyTree();

        tree.add(40);
        tree.add(25);
        tree.add(78);
        tree.add(50);
        tree.add(93);
        tree.add(10);
        tree.add(32);
        tree.add(3);
        tree.add(17);
        tree.add(30);
        tree.add(38);


        tree.printInorder();
        System.out.println();
        tree.printReverse();

        tree.remove(19);
        System.out.println();
        tree.printInorder();

        System.out.println();
        System.out.println();
        tree.display();

    }
}
