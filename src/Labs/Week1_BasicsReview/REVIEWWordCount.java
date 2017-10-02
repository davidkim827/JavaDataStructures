package Labs.Week1_BasicsReview;


import java.util.Scanner;

/**
 * Created by dk on 8/29/2017.
 */



import java.io.File;
import java.io.FileNotFoundException;

public class REVIEWWordCount {
    public static void main(String[] args) throws FileNotFoundException {


        Scanner keyBoard = new Scanner(System.in);
        String wordSearch;

        System.out.print("What word are you looking for? "); //receives word to search for and makes it lowercase to disregard letter casing
        wordSearch = keyBoard.next().toLowerCase();

        File fileName = new File("wordCount.txt");
        Scanner input= new Scanner(fileName);  //Change argument index to reflect the file name in the argument list.

        //To do-file manipulation
        System.out.println();
        int count = 0;
        while (input.hasNext()) { //loops to constantly read in the next string
            String[] wordsArray = input.next().replaceAll("[^a-zA-Z-]", " ").replaceAll(" ", "").toLowerCase().split(" "); //reads in the text
            for(int i = 0; i < wordsArray.length; i++) {
               System.out.println(wordsArray[i]);
                if (wordsArray[i].equals(wordSearch))
                    count++;
            }
        }


        input.close();
        System.out.print("\n\nThe word \"" + wordSearch + "\" appears " + count + " times in the file.");


    }
}
