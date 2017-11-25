package Cryptography;

import Homework.Week11_PriorityQueueHeap.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by dk on 11/22/2017.
 */
public class CryptGram {

    private Letter[] orderedFrequency;
    private int[] key;
    private int counter;

    public CryptGram() {
        counter = 0;
    }

    public void createLetterFrequency(String text) {
        char[] charText = text.replaceAll(" ", "").replaceAll("[^a-zA-Z]", "").toUpperCase().toCharArray();

        ArrayList<Letter> frequency = new ArrayList<>(26);
        frequency.add(new Letter('A'));
        frequency.add(new Letter('B'));
        frequency.add(new Letter('C'));
        frequency.add(new Letter('D'));
        frequency.add(new Letter('E'));
        frequency.add(new Letter('F'));
        frequency.add(new Letter('G'));
        frequency.add(new Letter('H'));
        frequency.add(new Letter('I'));
        frequency.add(new Letter('J'));
        frequency.add(new Letter('K'));
        frequency.add(new Letter('L'));
        frequency.add(new Letter('M'));
        frequency.add(new Letter('N'));
        frequency.add(new Letter('O'));
        frequency.add(new Letter('P'));
        frequency.add(new Letter('Q'));
        frequency.add(new Letter('R'));
        frequency.add(new Letter('S'));
        frequency.add(new Letter('T'));
        frequency.add(new Letter('U'));
        frequency.add(new Letter('V'));
        frequency.add(new Letter('W'));
        frequency.add(new Letter('X'));
        frequency.add(new Letter('Y'));
        frequency.add(new Letter('Z'));

        ArrayList<Character> tmp = new ArrayList<>();

        for (int i = 0; i < charText.length; i++) {
            Character nextLetter = charText[i];
            tmp.add(nextLetter);
            if (tmp.contains(nextLetter)) {
                for (int j = 0; j < frequency.size(); j++) {
                    if (nextLetter.compareTo(frequency.get(j).getChar()) == 0) {
                        frequency.get(j).incrementFrequency();
                    }
                }
            }
        }
        Collections.sort(frequency);
        orderedFrequency = frequency.toArray(new Letter[frequency.size()]);
    }

    public int getFrequencyByChar(char letter) {
        char analyze = Character.toUpperCase(letter);
        for (int i = 0; i < orderedFrequency.length; i++) {
            if (analyze == orderedFrequency[i].getChar())
                return (orderedFrequency[i].getFrequency());
        }
        return 1000;
    }

    public String encode(String textToBeEncoded) {
        key = new int[textToBeEncoded.length()];
        String result = "";

        String replace = textToBeEncoded.toUpperCase();
        for (int i = 0; i < replace.length(); i++) {
            char letter = replace.charAt(i);
            int number = letter - 'A';
            if (letter >= 'A' && letter <= 'Z') {
                letter = orderedFrequency[number].getChar();
            }
            setKey(number);
            result += letter;
        }
        return regularCase(result);
    }

    public String decode(String textToBeDecoded) {

        for (int i = 0; i < orderedFrequency.length; i++)
            orderedFrequency[i].setFrequency(0);

        ArrayList<Letter> backToOriginal = new ArrayList<>(Arrays.asList(orderedFrequency));
        Collections.sort(backToOriginal);
        System.out.println();
        orderedFrequency = backToOriginal.toArray(new Letter[backToOriginal.size()]);

        String stringReturn = "";

        String replace = textToBeDecoded.toUpperCase();
        for (int i = 0; i < textToBeDecoded.length(); i++) {
            char replaceChar = replace.charAt(i);
            if (replaceChar >= 'A' && replaceChar <= 'Z') {
                replaceChar = orderedFrequency[getKey()[i]].getChar();
                stringReturn += replaceChar;
            } else
                stringReturn += replaceChar;
        }

        return regularCase(stringReturn);
    }

    public void setKey(int key) {
        this.key[counter] = key;
        counter++;
    }

    public int[] getKey() {
        return this.key;
    }

    public String regularCase(String text) {
        String textReplace = "";
        for (int i = 0; i < text.length(); i++) {
            char replace = text.charAt(i);
            if (i == 0 || text.charAt(i) == '.' || text.charAt(i) == '?' || text.charAt(i) == '!') {
                textReplace += replace;
            } else {
                replace = Character.toLowerCase(replace);
                textReplace += replace;
            }
        }
        return textReplace;
    }
}
