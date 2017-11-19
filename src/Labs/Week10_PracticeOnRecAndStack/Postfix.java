package Labs.Week10_PracticeOnRecAndStack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by dk on 11/9/2017.
 */

public class Postfix {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner reader = new Scanner(new File(args[0]));

        Scanner reader = new Scanner(new File("prefix.txt"));
        while (reader.hasNextLine()){
            String equations = reader.nextLine();
            System.out.println(eval(equations));
        }
    }

    public static int eval(String str){
        Stack<Integer> operand = new Stack<>();

        for (int i = 0; i < str.length(); i++){
            if (isOperator(str.charAt(i))) {
                operand.push(eval(operand.pop(), operand.pop(), str.charAt(i)));
            }
            else if (Character.isDigit(str.charAt(i)))
                operand.push(Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        return operand.peek();
    }

    private static int eval(int a, int b, char ch){
        if (ch == '*')
            return b * a;
        else if (ch == '/')
            return b / a;
        else if (ch == '-')
            return b - a;
        else
            return b + a;
    }

    public static boolean isOperator(char ch){
        return ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }

}
