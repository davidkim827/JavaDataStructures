package Labs.Week9_TreeADT;

public class MyTree {

    private TreeNode root;

    public MyTree() {
        root = null;
    }

    public void remove(int data) {
        root = recRemove(root, data);
    }

    public TreeNode recRemove(TreeNode node, int data) {
        if (node == null)
            return null;
        else if (node.getData() < data)
            node.setRight(recRemove(node.getRight(), data));
        else if (node.getData() > data)
            node.setLeft(recRemove(node.getLeft(), data));
        else
            node = removeNode(node);
        return node;
    }

    public TreeNode removeNode(TreeNode node) {

        if (node.getLeft() == null)
            return node.getRight();
        else if (node.getRight() == null)
            return node.getLeft();
        else {
            int nodeData = getPredecessor(node.getLeft());
            node.setData(nodeData);
            node.setLeft(recRemove(node.getLeft(), nodeData));
            return node;
        }
    }

    public int getPredecessor(TreeNode node) {
        while (node.getRight() != null)
            node = node.getRight();
        return node.getData();
    }

    public void printReverse() {
        printReverseHelper(root);
    }

    private void printReverseHelper(TreeNode node) {
        if (node != null) {
            printReverseHelper(node.getRight());
            System.out.println(node.getData());
            printReverseHelper(node.getLeft());
        }
    }


    public void display() {
        displayHelper(root);
        System.out.println();
    }

    public void displayHelper(TreeNode node) {

        for (int i = 1; i <= height(root); i++) {
            printLevel(node, i);
            System.out.println();
            System.out.println();
        }
    }

    public void printLevel(TreeNode node, int level) {
        if (node == null)
            return;
        if (level == 1) {
            System.out.print(node.getData() + "\t");
            System.out.print("");
        } else if (level > 1) {
            printLevel(node.getLeft(), level - 1);
            printLevel(node.getRight(), level - 1);
        }
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(height(node.getRight()),
                    height(node.getLeft()));
        }
    }


    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return sizeHelper(root);
    }

    private int sizeHelper(TreeNode node) {
        if (node == null) return 0;
        else return 1 + sizeHelper(node.getLeft()) + sizeHelper(node.getRight());
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(TreeNode node, int data) {
        if (node == null) return false;
        if (node.getData() == data) return true;
        else if (node.getData() < data)
            return searchHelper(node.getRight(), data);
        else
            return searchHelper(node.getLeft(), data);
    }

    public void add(int data) {
        root = addHelper(root, data);
    }

    private TreeNode addHelper(TreeNode node, int data) {
        if (node == null)
            node = new TreeNode(data);
        else if (data <= node.getData())
            node.setLeft(addHelper(node.getLeft(), data));
        else
            node.setRight(addHelper(node.getRight(), data));
        return node;
    }

    public void printInorder() {
        printHelper(root);
    }

    private void printHelper(TreeNode node) {
        if (node != null) {
            printHelper(node.getLeft());
            System.out.println(node.getData());
            printHelper(node.getRight());
        }
    }
}
