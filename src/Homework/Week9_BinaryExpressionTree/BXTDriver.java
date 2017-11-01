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
            tree.buildTree( postfix );
            System.out.println("BXT: ");
            tree.display();
            System.out.print("Infix order:  ");
            tree.inorderTraverse();
            System.out.print("\nPrefix order:  ");
            tree.preorderTraverse();
            System.out.print("\nEvaluates to " + tree.evaluateTree());
            System.out.println( "\n------------------------");
        }
    }
}

/***************************************
 Postfix Exp: 14 -5 /
 BXT:
 -5
 /
 14
 Infix order:  14 / -5
 Prefix order:  / 14 -5
 Evaluates to -2.8
 ------------------------
 Postfix Exp: 20 3 -4 + *
 BXT:
 -4
 +
 3
 *
 20
 Infix order:  20 * 3 + -4
 Prefix order:  * 20 + 3 -4
 Evaluates to -20.0
 ------------------------
 Postfix Exp: 2 3 + 5 / 4 5 - *
 BXT:
 5
 -
 4
 *
 5
 /
 3
 +
 2
 Infix order:  2 + 3 / 5 * 4 - 5
 Prefix order:  * / + 2 3 5 - 4 5
 Evaluates to -1.0
 ------------------------
 */
