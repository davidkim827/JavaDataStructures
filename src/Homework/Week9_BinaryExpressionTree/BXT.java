package Homework.Week9_BinaryExpressionTree;

/*******************
 Represents a binary expression tree.
 The BXT can build itself from a postorder expression.  It can
 evaluate and print itself. It also prints an inorder string and a preorder string.
 **********************/
class BXT {
    private int count;
    private StackNode top;

    //BXT Constructor
    public BXT() {
        count = 0;
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    //adds node to stack
    public void pushNodeToStack(TreeNode treeNode) {
        StackNode n = new StackNode(treeNode, null);
        n.setNext(top);
        top = n;
        count++;
    }

    //removes node from top of the stack
    public TreeNode pop() {
        if (!isEmpty()) {
            TreeNode n = top.getTreeNode();
            top = top.getNext();
            count--;
            return n;
        } else
            return null;
    }

    //returns the node at top of the stack
    public TreeNode top() {
        return top.getTreeNode();
    }

    //method to insert operator into tree
    public void insertNodeOperator(char ch) {
        TreeNode operator = new TreeNode(ch);
        operator.setLeft(pop());
        operator.setRight(pop());
        pushNodeToStack(operator);
    }

    //method to insert decimal value operands
    public void insertNodeOperand(double decimal) {
        TreeNode operand = new TreeNode(decimal);
        pushNodeToStack(operand);
    }

    //method to insert integer value operands
    public void insertNodeOperand(int integer){
        TreeNode operand = new TreeNode(integer);
        pushNodeToStack(operand);
    }

    //helper method for displaying postfix order traversal
    public void postFixOrder(TreeNode postFixOrder){
        if (postFixOrder != null){
            postFixOrder(postFixOrder.getLeft());
            System.out.println(postFixOrder.getValue());
            postFixOrder(postFixOrder.getRight());
        }
    }

    //helper method for displaying infix order traversal
    public void inFixOrder(TreeNode inFixOrder){
        if (inFixOrder != null){
            inFixOrder(inFixOrder.getRight());
            System.out.print(inFixOrder.getValue() + " ");
            inFixOrder(inFixOrder.getLeft());
        }
    }

    //helper method for displaying prefix order traversal
    public void preFixOrder(TreeNode preFixOrder){
        if (preFixOrder != null){
            System.out.print(preFixOrder.getValue() + " ");
            preFixOrder(preFixOrder.getRight());
            preFixOrder(preFixOrder.getLeft());
        }
    }

    //method that builds the tree out of text argument passed to it
    public void buildTree(String text) {
        String[] stringArray = text.split(" ");

        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].matches("^[+-]?[0-9]{1,6}(/.[0-9]{1,3})"))
                insertNodeOperand(Double.parseDouble(stringArray[i]));
            else if (stringArray[i].matches("-?[0-9]+"))
                insertNodeOperand(Integer.parseInt(stringArray[i]));
            else if (stringArray[i].compareTo("-") == 0 || stringArray[i].compareTo("+") == 0 ||
                    stringArray[i].compareTo("*") == 0 || stringArray[i].compareTo("/") == 0) {
                char c = stringArray[i].charAt(0);
                insertNodeOperator(c);
            }
        }
    }

    //method that displays the postFix traversal
    public void display(){
        postFixOrder(top());
    }

    //method that displays the inFix traversal
    public void inorderTraverse(){
        inFixOrder(top());
    }

    //method that displays the preFix traversal
    public void preorderTraverse(){
        preFixOrder(top());
    }

    //method that evaluates the built tree and returns the result
    public double evaluateTree(){
        return evaluateHelper(top());
    }

    //method that converts the treenode object into a double value to calculate result
    public double toDouble(Object value){
        return new Double(value.toString());
    }

    //helper method for evaluating tree
    public double evaluateHelper(TreeNode evalTree){
        if (evalTree.getLeft() == null && evalTree.getRight() == null){
            return toDouble(evalTree.getValue());
        }
        else{
            double result = 0;
            double left = toDouble(evaluateHelper(evalTree.getLeft()));
            double right = toDouble(evaluateHelper(evalTree.getRight()));
            Character operator = (Character) evalTree.getValue();

            switch (operator){
                case '+' : result = right + left; break;
                case '-' : result = right - left; break;
                case '*' : result = right * left; break;
                case '/' : result = right / left; break;
            }
            return result;
        }
    }
}
