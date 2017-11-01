package Homework.Week9_BinaryExpressionTree;

/**
 Stack to hold the tree nodes for traversal and evaluating the results
 **/
public class StackNode {
    private TreeNode treeNode;
    StackNode next;

    //constructor
    public StackNode(TreeNode treeNode, StackNode next){
        setTreeNode(treeNode);
        this.next = next;
    }

    //setter and getter methods for the tree nodes on the stack
    public void setTreeNode(TreeNode treeNode){
        this.treeNode = treeNode;
    }

    public TreeNode getTreeNode(){
        return treeNode;
    }

    //settger and getter methods for the next item on the stack
    public void setNext(StackNode next){
        this.next = next;
    }

    public StackNode getNext(){
        return next;
    }
}
