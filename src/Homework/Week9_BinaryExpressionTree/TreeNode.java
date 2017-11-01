package Homework.Week9_BinaryExpressionTree;

/**
 Creates Nodes for the Tree ADT
 **/
public class TreeNode
{
    private Object value;
    private TreeNode left, right;

    //constructor for tree nodes
    public TreeNode(Object initValue)
    {
        value = initValue;
        left = null;
        right = null;
    }

    //overloaded constructor
    public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight)
    {
        value = initValue;
        left = initLeft;
        right = initRight;
    }

    //returns the value of the node
    public Object getValue()
    {
        return value;
    }

    //gets value of node to the left of parent node
    public TreeNode getLeft()
    {
        return left;
    }

    //gets value of node to the left of parent node
    public TreeNode getRight()
    {
        return right;
    }

    //sets value of node
    public void setValue(Object theNewValue)
    {
        value = theNewValue;
    }

    //sets value of node to the left of parent node
    public void setLeft(TreeNode theNewLeft)
    {
        left = theNewLeft;
    }

    //sets value of node to the right of parent node
    public void setRight(TreeNode theNewRight)
    {
        right = theNewRight;
    }
}

