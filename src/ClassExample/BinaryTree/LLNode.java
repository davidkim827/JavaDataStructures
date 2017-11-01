package ClassExample.BinaryTree;

/**
 * Created by dk on 10/26/2017.
 */
public class LLNode {
    private LLNode root;
    private int data;
    private LLNode left;
    private LLNode right;

    public void add(){

    }

    public int recSize(LLNode n){
        if (n == null) return 0;
        else return 1 + recSize(n.left) + recSize(n.right);
    }

    public int size(){
        return recSize(root);
    }

}
