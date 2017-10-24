package ExtraCredit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dk on 10/12/2017.
 */

public class CharDistribution {

    private int[] charCountingArr;
    private int countA;
    private int countB;
    private int countC;
    private int countD;
    private int countE;
    private int countF;
    private int countG;
    private int countH;
    private int countI;
    private int countJ;
    private int countK;
    private int countL;
    private int countM;
    private int countN;
    private int countO;
    private int countP;
    private int countQ;
    private int countR;
    private int countS;
    private int countT;
    private int countU;
    private int countV;
    private int countW;
    private int countX;
    private int countY;
    private int countZ;

    public int[] charCounting(String str) {
        charCountingArr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'A' || str.charAt(i) == 'a')
                countA++;
            else if (str.charAt(i) == 'B' || str.charAt(i) == 'b')
                countB++;
            else if (str.charAt(i) == 'C' || str.charAt(i) == 'c')
                countC++;
            else if (str.charAt(i) == 'D' || str.charAt(i) == 'd')
                countD++;
            else if (str.charAt(i) == 'E' || str.charAt(i) == 'e')
                countE++;
            else if (str.charAt(i) == 'F' || str.charAt(i) == 'f')
                countF++;
            else if (str.charAt(i) == 'G' || str.charAt(i) == 'g')
                countG++;
            else if (str.charAt(i) == 'H' || str.charAt(i) == 'h')
                countH++;
            else if (str.charAt(i) == 'I' || str.charAt(i) == 'i')
                countI++;
            else if (str.charAt(i) == 'J' || str.charAt(i) == 'j')
                countJ++;
            else if (str.charAt(i) == 'K' || str.charAt(i) == 'k')
                countK++;
            else if (str.charAt(i) == 'L' || str.charAt(i) == 'l')
                countL++;
            else if (str.charAt(i) == 'M' || str.charAt(i) == 'm')
                countM++;
            else if (str.charAt(i) == 'N' || str.charAt(i) == 'n')
                countN++;
            else if (str.charAt(i) == 'O' || str.charAt(i) == 'o')
                countO++;
            else if (str.charAt(i) == 'P' || str.charAt(i) == 'p')
                countP++;
            else if (str.charAt(i) == 'Q' || str.charAt(i) == 'q')
                countQ++;
            else if (str.charAt(i) == 'R' || str.charAt(i) == 'r')
                countR++;
            else if (str.charAt(i) == 'S' || str.charAt(i) == 's')
                countS++;
            else if (str.charAt(i) == 'T' || str.charAt(i) == 't')
                countT++;
            else if (str.charAt(i) == 'U' || str.charAt(i) == 'u')
                countU++;
            else if (str.charAt(i) == 'V' || str.charAt(i) == 'v')
                countV++;
            else if (str.charAt(i) == 'W' || str.charAt(i) == 'w')
                countW++;
            else if (str.charAt(i) == 'X' || str.charAt(i) == 'x')
                countX++;
            else if (str.charAt(i) == 'Y' || str.charAt(i) == 'y')
                countY++;
            else if (str.charAt(i) == 'Z' || str.charAt(i) == 'z')
                countZ++;
        }
        charCountingArr[0] = countA;
        charCountingArr[1] = countB;
        charCountingArr[2] = countC;
        charCountingArr[3] = countD;
        charCountingArr[4] = countE;
        charCountingArr[5] = countF;
        charCountingArr[6] = countG;
        charCountingArr[7] = countH;
        charCountingArr[8] = countI;
        charCountingArr[9] = countJ;
        charCountingArr[10] = countK;
        charCountingArr[11] = countL;
        charCountingArr[12] = countM;
        charCountingArr[13] = countN;
        charCountingArr[14] = countO;
        charCountingArr[15] = countP;
        charCountingArr[16] = countQ;
        charCountingArr[17] = countR;
        charCountingArr[18] = countS;
        charCountingArr[19] = countT;
        charCountingArr[20] = countU;
        charCountingArr[21] = countV;
        charCountingArr[22] = countW;
        charCountingArr[23] = countX;
        charCountingArr[24] = countY;
        charCountingArr[25] = countZ;

        return charCountingArr;
    }

    public int[] charCounting(File file) throws FileNotFoundException {
        charCountingArr = new int[26];
        Scanner output = new Scanner(file);

        while (output.hasNextLine()) {
            String line = output.nextLine();
            if (line != null)
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == 'a' || line.charAt(i) == 'A')
                        countA++;
                    else if (line.charAt(i) == 'b' || line.charAt(i) == 'B')
                        countB++;
                    else if (line.charAt(i) == 'c' || line.charAt(i) == 'C')
                        countC++;
                    else if (line.charAt(i) == 'd' || line.charAt(i) == 'D')
                        countD++;
                    else if (line.charAt(i) == 'e' || line.charAt(i) == 'E')
                        countE++;
                    else if (line.charAt(i) == 'f' || line.charAt(i) == 'F')
                        countF++;
                    else if (line.charAt(i) == 'g' || line.charAt(i) == 'G')
                        countG++;
                    else if (line.charAt(i) == 'h' || line.charAt(i) == 'H')
                        countH++;
                    else if (line.charAt(i) == 'i' || line.charAt(i) == 'I')
                        countI++;
                    else if (line.charAt(i) == 'j' || line.charAt(i) == 'J')
                        countJ++;
                    else if (line.charAt(i) == 'k' || line.charAt(i) == 'K')
                        countK++;
                    else if (line.charAt(i) == 'l' || line.charAt(i) == 'L')
                        countL++;
                    else if (line.charAt(i) == 'm' || line.charAt(i) == 'M')
                        countM++;
                    else if (line.charAt(i) == 'n' || line.charAt(i) == 'N')
                        countN++;
                    else if (line.charAt(i) == 'o' || line.charAt(i) == 'O')
                        countO++;
                    else if (line.charAt(i) == 'p' || line.charAt(i) == 'P')
                        countP++;
                    else if (line.charAt(i) == 'q' || line.charAt(i) == 'Q')
                        countQ++;
                    else if (line.charAt(i) == 'r' || line.charAt(i) == 'R')
                        countR++;
                    else if (line.charAt(i) == 's' || line.charAt(i) == 'S')
                        countS++;
                    else if (line.charAt(i) == 't' || line.charAt(i) == 'T')
                        countT++;
                    else if (line.charAt(i) == 'u' || line.charAt(i) == 'U')
                        countU++;
                    else if (line.charAt(i) == 'v' || line.charAt(i) == 'V')
                        countV++;
                    else if (line.charAt(i) == 'w' || line.charAt(i) == 'W')
                        countW++;
                    else if (line.charAt(i) == 'x' || line.charAt(i) == 'X')
                        countX++;
                    else if (line.charAt(i) == 'y' || line.charAt(i) == 'Y')
                        countY++;
                    else if (line.charAt(i) == 'z' || line.charAt(i) == 'Z')
                        countZ++;
                    else
                        ;
                }
        }

        charCountingArr[0] = countA;
        charCountingArr[1] = countB;
        charCountingArr[2] = countC;
        charCountingArr[3] = countD;
        charCountingArr[4] = countE;
        charCountingArr[5] = countF;
        charCountingArr[6] = countG;
        charCountingArr[7] = countH;
        charCountingArr[8] = countI;
        charCountingArr[9] = countJ;
        charCountingArr[10] = countK;
        charCountingArr[11] = countL;
        charCountingArr[12] = countM;
        charCountingArr[13] = countN;
        charCountingArr[14] = countO;
        charCountingArr[15] = countP;
        charCountingArr[16] = countQ;
        charCountingArr[17] = countR;
        charCountingArr[18] = countS;
        charCountingArr[19] = countT;
        charCountingArr[20] = countU;
        charCountingArr[21] = countV;
        charCountingArr[22] = countW;
        charCountingArr[23] = countX;
        charCountingArr[24] = countY;
        charCountingArr[25] = countZ;

        return charCountingArr;
    }

    public void print(int[] c) {

        char star = '*';

        int max = 0;
        for (int i = 0; i < charCountingArr.length; i++) {
            System.out.print(charCountingArr[i] + " ");
            if (charCountingArr[i] > max) {
                max = charCountingArr[i];
            }
        }


        System.out.println("\n\n");
        for (int i = max; i > 0; i--) {
            for (int j = 0; j < charCountingArr.length; j++) {
                if (charCountingArr[j] < max)
                    System.out.print("  ");
                else
                    System.out.print(star + " ");
            }
            System.out.println();
            max--;
        }

        System.out.print("---------------------------------------------------- \n" +
                "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z \n");
    }
}

