package Homework.Week9_BinaryExpressionTree;

import java.util.Stack;
import java.util.StringTokenizer;

/*******************
 Represents a binary expression tree.
 The BXT can build itself from a postorder expression.  It can
 evaluate and print itself. It also prints an inorder string and a preorder string.
 **********************/
class BXT {
    private int count;
    private TreeNode root;

    public String print() {
        return root.getValue() + "abcd";
    }

    public boolean isEmpty() {
        return root == null;
    }

    //BXT Constructor
    public BXT() {
        count = 0;
        root = null;
    }

    //method that builds the tree out of text argument passed to it
    public void buildTree(String text) {

        StringTokenizer stringText = new StringTokenizer(text);
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (stringText.hasMoreElements()) {
            String nextToken = stringText.nextToken();
            if (nextToken.compareTo("-") == 0 || nextToken.compareTo("+") == 0 ||
                    nextToken.compareTo("*") == 0 || nextToken.compareTo("/") == 0) {
                TreeNode operator = new TreeNode(nextToken);
                operator.setRight(stack.pop());
                operator.setLeft(stack.pop());
                stack.push(operator);
            } else
                stack.push(new TreeNode(nextToken));
        }
        root = stack.pop();
    }

    //method that displays the BXT
    public String display() {
        return displayHelper(root, 0);
    }

    //helper method for display
    public static String displayHelper(TreeNode displayNode, int level) {
        String concat = "";
        if (displayNode == null)
            return "";
        concat += displayHelper(displayNode.getRight(), level + 1);
        for (int i = 0; i < level; i++)
            concat += "\t";
        concat += displayNode.getValue().toString() + "\n";
        concat += displayHelper(displayNode.getLeft(), level + 1);
        return concat;
    }


    //method that displays the postFix traversal
    public String postfix() {
        String post;
        post = postFixOrder(root);
        return post;
    }

    //helper method for displaying postfix order traversal
    public String postFixOrder(TreeNode postFixOrder) {
        if (postFixOrder == null)
            return "";
        else {
            return postFixOrder(postFixOrder.getLeft()) + postFixOrder(postFixOrder.getLeft()) + postFixOrder.getValue().toString() + " ";
        }
    }

    //method that displays the inFix traversal
    public String infix() {
        return inFixOrder(root);
    }

    //helper method for displaying infix order traversal
    public String inFixOrder(TreeNode inFixOrder) {
        if (inFixOrder == null)
            return "";
        else {
            return inFixOrder(inFixOrder.getLeft()) + inFixOrder.getValue().toString() + " " + inFixOrder(inFixOrder.getRight());
        }
    }

    //method that displays the prefix traversal
    public String prefix() {
        return preFixHelper(root);
    }

    //helper method for displaying prefix order traversal
    public String preFixHelper(TreeNode preFixHelper) {
        if (preFixHelper == null)
            return "";
        return (preFixHelper.getValue().toString() + " ") + preFixHelper(preFixHelper.getLeft()) + preFixHelper(preFixHelper.getRight());
    }

    //method that evaluates the built tree and returns the result
    public double evaluateTree() {
        return evaluateHelper(root);
    }

    //method that converts the treenode object into a double value to calculate result
    public double toDouble(Object value) {
        return new Double(value.toString());
    }

    public char toChar(String character) {
        return character.charAt(0);
    }

    //helper method for evaluating tree
    public double evaluateHelper(TreeNode evalTree) {
        if (evalTree.getLeft() == null && evalTree.getRight() == null) {
            return toDouble(evalTree.getValue());
        } else {
            double result = 0;
            double right = toDouble(evaluateHelper(evalTree.getRight()));
            double left = toDouble(evaluateHelper(evalTree.getLeft()));
            char operator = toChar(evalTree.getValue().toString());

            switch (operator) {
                case '+':
                    result = left + right;
                    break;
                case '-':
                    result = left - right;
                    break;
                case '*':
                    result = left * right;
                    break;
                case '/':
                    result = left / right;
                    break;
            }
            return result;
        }
    }
}
