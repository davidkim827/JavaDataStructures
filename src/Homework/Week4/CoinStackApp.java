package Homework.Week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dk on 9/18/2017.
 */
public class CoinStackApp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyBoard = new Scanner(System.in);
        String file;

        System.out.print("Name of file to analyze? ");
        file = keyBoard.next();

        Scanner read = new Scanner(new File(file));

        CoinStack penny = new CoinStack();
        CoinStack nickel = new CoinStack();
        CoinStack dime = new CoinStack();
        CoinStack quarter = new CoinStack();

        while (read.hasNext()) {
            int nextCoin = Integer.parseInt(read.next());
            if (nextCoin == 1)
                penny.push(nextCoin);
            else if (nextCoin == 5)
                nickel.push(nextCoin);
            else if (nextCoin == 10)
                dime.push(nextCoin);
            else
                quarter.push(nextCoin);
        }

        PrintCoinStacks print = new PrintCoinStacks();
        print.print(penny, nickel, dime, quarter);

    }
}
