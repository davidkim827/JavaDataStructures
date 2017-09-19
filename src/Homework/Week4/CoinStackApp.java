package Homework.Week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dk on 9/18/2017.
 */
public class CoinStackApp {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("coins.txt");
        Scanner read = new Scanner(file);

        CoinStack penny = new CoinStack();
        CoinStack nickel = new CoinStack();
        CoinStack dime = new CoinStack();
        CoinStack quarter = new CoinStack();

        while (read.hasNextLine()) {
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
