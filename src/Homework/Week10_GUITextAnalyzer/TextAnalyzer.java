package Homework.Week10_GUITextAnalyzer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dk on 11/5/2017.
 */

public class TextAnalyzer extends TextAnalyzerAbstract {

    public TextAnalyzer(String text) {
        super(text);
    }

    @Override
    public int length() {
        char[] ch = super.getText().toCharArray();
        int length = 0;
        for (int i = 0; i < super.getText().length(); i++) {
            if (Character.isLetter(ch[i]))
                length++;
            else
                length++;
        }
        return length;
    }

    @Override
    public int numberOfVowels() {
        char[] ch = super.getText().toCharArray();
        int numberVowels = 0;
        for (int i = 0; i < super.getText().length(); i++) {
            if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u' || ch[i] == 'A' ||
                    ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U')
                numberVowels++;
        }
        return numberVowels;
    }

    @Override
    public int numberOfUppercase() {
        char[] ch = super.getText().toCharArray();
        int upperCase = 0;
        for (int i = 0; i < super.getText().length(); i++) {
            if (Character.isUpperCase(ch[i]))
                upperCase++;
        }
        return upperCase;
    }

    @Override
    public int numberOfLatinAlphabetic() {
        char[] ch = super.getText().toCharArray();
        int alphabetCount = 0;
        for (int i = 0; i < super.getText().length(); i++) {
            if (Character.isLetter(ch[i]))
                alphabetCount++;
        }
        return alphabetCount;
    }

    @Override
    public String mode() {
        String stringWithoutSpaces = super.getText().replaceAll(" ", ""); //makes sure that the string is without spaces
        char[] ch = stringWithoutSpaces.toCharArray(); //converts string to a character array to analyze
        ArrayList<Character> multipleModes = new ArrayList<>(); //an arraylist to store multiple modes if there are any

        char mode = 0;
        int count = 0;

        for (int i = 0; i < ch.length; i++) {
            char tempMode = ch[i];
            int tempCount = 0;
            for (int j = 0; j < ch.length; j++) {
                //makes sure to count all lowercase and uppercase characters equally
                if (Character.toUpperCase(ch[j]) == Character.toUpperCase(ch[i]))
                    tempCount++;
            }
            //adds to the arraylist in the beginning and makes sure if there is a higher frequency count, it clears
            // the array list to introduce the new letter
            if (tempCount > count) {
                count = tempCount;
                mode = tempMode;
                multipleModes.clear();
                multipleModes.add(mode);
            }
            //adds to the array list if there are equal frequency instances of a certain letter
            if(tempCount == count && !multipleModes.contains(Character.toUpperCase(tempMode)) &&
                    !multipleModes.contains(Character.toLowerCase(tempMode)))
                multipleModes.add(tempMode);
        }

        //returns the arraylist without the brackets as a string
        return Arrays.toString(multipleModes.toArray()).replace("[", "")
                .replace("]", "");

    }
}
