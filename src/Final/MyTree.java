package Final;

public class MyTree {

    private TreeNode root;

    public MyTree() {
        root = null;
    }

    public void add(int data) {
        root = addHelper(root, data);
    }

    //to do
    public void doublePositives(){
        doublePositivesHelper(root);
    }

    //helper method to traverse the tree and double the positive integers
    public void doublePositivesHelper(TreeNode node){
        if(node == null)
            System.out.print("");
        else if(node.getData() > 0){
            node.setData(node.getData()*2);
            doublePositivesHelper(node.getLeft());
            doublePositivesHelper(node.getRight());
        }
    }

    public static void main(String[] args){
        MyTree test = new MyTree();
        int[] arr={19,15,6,25,-9,0,-78,17};
        for(int i=0; i<arr.length; i++){
            test.add(arr[i]);
        }
        test.printInorder();
        test.doublePositives();
        test.printInorder();
    }

    private TreeNode addHelper(TreeNode node, int data) {
        if (node == null) node = new TreeNode(data);
        else if (data <= node.getData())
            node.setLeft(addHelper(node.getLeft(), data));
        else
            node.setRight(addHelper(node.getRight(), data));
        return node;
    }

    public void printInorder() {
        printHelper(root);
        System.out.println(" ");
    }
    private void printHelper(TreeNode node) {
        if (node != null) {
            printHelper(node.getLeft());
            System.out.print(node.getData()+", ");
            printHelper(node.getRight());
        }
    }

}
