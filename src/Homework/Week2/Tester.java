package Homework.Week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by dk on 9/4/2017.
 */
public class Tester {
    public static void main(String[] args) throws FileNotFoundException, NoSuchElementException {
        Scanner keyBoard = new Scanner(System.in);
        char[][] arr = null;

        String fileName;
        System.out.print("Filename: ");
        fileName = keyBoard.next();

        arr = arrReader(fileName);
        arrReaderOutput(arr);

        System.out.print("Enter ROW , COL: ");
        int row = keyBoard.nextInt();
        int col = keyBoard.nextInt();

        char original = arr[row][col];
        arrFiller(arr, row, col, original, '*');
        arrReaderOutput(arr);

    }

    public static char[][] arrReader(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner output = new Scanner(file);

        int rowOutput = Integer.parseInt(output.next());
        int columnOutput = Integer.parseInt(output.next());

        char[][] arr = new char[rowOutput][columnOutput];
        for (int r = 0; r < rowOutput; r++) {
            String nextline = output.next();
            for (int c = 0; c < columnOutput; c++)
                arr[r][c] = nextline.charAt(c);
        }
        output.close();

        return arr;
    }

    public static void arrReaderOutput(char[][] arr){
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public static void arrFiller(char[][] arr, int row, int col, char original, char star){

        if (arr[row][col] == original)
            arr[row][col] = star;
        if (col < (arr[0].length - 1) && arr[row][col + 1] == original)
            arrFiller(arr, row, col+1, original, star);
        if (col > 0 && arr[row][col - 1] == original)
            arrFiller(arr, row, col-1, original, star);
        if (row < (arr.length - 1) && arr[row + 1][col] == original)
            arrFiller(arr, row + 1, col, original, star);
        if (row > 0 && arr[row - 1][col] == original)
            arrFiller(arr, row - 1, col, original, star);
    }
}