package Homework.Week4_LinkedListStack;

/**
 * Created by dk on 9/18/2017.
 */
public class PrintCoinStacks { //print class to accept interface arguments
    public static void print(CoinStackInterface penny, CoinStackInterface nickel, CoinStackInterface dime,
                             CoinStackInterface quarter) {

        //string output that bases the width of the stacks upon the size of the actual coins (pennies are larger than dimes, but smaller than quarters.. etc.)
        String pennyLine = "|-----|";
        String nickelLine = "|------|";
        String dimeLine = "|----|";
        String quarterLine = "|--------|";

        int pennyCount = penny.size();
        int nickelCount = nickel.size();
        int dimeCount = dime.size();
        int quarterCount = quarter.size();

        for (int i = 50; i > 0; i--) { //creates a visual for how many items in each stack with 50 coins being able to fit in pennies and dimes, and 40 in nickels and quarters
            if (i == pennyCount) {
                System.out.printf("%10s", pennyLine);
                pennyCount--;
            } else if (i != pennyCount) {
                System.out.printf("%10s", "|     |");
            }

            if (i == nickelCount) {
                System.out.printf("%22s", nickelLine);
                nickelCount--;
            } else if (i != nickelCount && i < 40)
                System.out.printf("%22s", "|      |");
            else if (i != nickelCount && i >= 40)
                System.out.printf("%22s", "      ");

            if (i == dimeCount) {
                System.out.printf("%20s", dimeLine);
                dimeCount--;
            } else if (i != pennyCount)
                System.out.printf("%20s", "|    |");

            if (i == quarterCount) {
                System.out.printf("%24s\n", quarterLine);
                quarterCount--;
            } else if (i != quarterCount && i < 40)
                System.out.printf("%24s\n", "|        |");
            else if (i != quarterCount && i >= 40)
                System.out.printf("%10s\n", "        ");
        }

        System.out.printf("%12s%22s%20s%24s", "Penny Stack", "Nickel Stack", "Dime Stack", "Quarter Stack");
        System.out.printf("\n%4d %6s%13d %2s%14d %2s%15d %2s", penny.size(), "Pennies", nickel.size(), "Nickels",
                dime.size(), "Dimes", quarter.size(), "Quarters");
    }
}