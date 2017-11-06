package Homework.Week9_BinaryExpressionTree;

/**
 * Created by dk on 10/28/2017.
 */

import java.util.ArrayList;

/*******************
 Driver for a binary expression tree class.
 Input: a postfix string, each token separated by a space.
 **********************/
public class BXTDriver
{
    public static void main(String[] args)
    {
        ArrayList<String> postExp = new ArrayList<String>();
        postExp.add("14 -5 / ");
        postExp.add("20 3 -4 + * ");
        postExp.add("2 3 + 5 / 4 5 - *");

        for( String postfix : postExp )
        {
            System.out.println("Postfix Exp: "  + postfix);
            BXT tree = new BXT();
            tree.buildTree( postfix ); System.out.println();tree.print();
            System.out.println("BXT: ");
            System.out.print(tree.display());
            System.out.print("Infix order:  ");
            System.out.print(tree.infix());
            System.out.print("\nPrefix order:  ");
            System.out.print(tree.prefix());
            System.out.print("\nPostFix order:  ");
            System.out.print(tree.postfix());
            System.out.print("\nEvaluates to " + tree.evaluateTree());
            System.out.println( "\n------------------------");
        }
    }
}
