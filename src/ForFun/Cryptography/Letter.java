package ForFun.Cryptography;

/**
 * Created by dk on 11/22/2017.
 */
public class Letter implements Comparable<Letter> {
    private char letter;
    private int frequency;

    public Letter(char letter){
        this.letter = letter;
        frequency = 0;
    }

    public int compareTo(Letter letter) {
        if (frequency != letter.frequency)
            return frequency - letter.frequency;
        else
            return (int) this.letter - (int) letter.letter;
    }

    public char getChar() {
        return letter;
    }

    public int getFrequency() {
        return frequency;
    }

    //added setter method to provide an easy access to manipulate frequencies for decoding method
    public void setFrequency(int frequency){
        this.frequency = frequency;
    }

    public void incrementFrequency() {
        frequency++;
    }
}
