package Homework.Week10_GUITextAnalyzer;

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
        for (int i = 0; i < super.getText().length(); i++){
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
        for (int i = 0; i < super.getText().length(); i++){
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
        for (int i = 0; i < super.getText().length(); i++){
            if (Character.isUpperCase(ch[i]))
                upperCase++;
        }
        return upperCase;
    }

    @Override
    public int numberOfLatinAlphabetic() {
        char[] ch = super.getText().toCharArray();
        int alphabetCount = 0;
        for (int i = 0; i < super.getText().length(); i++){
            if (Character.isLetter(ch[i]))
                alphabetCount++;
        }
        return alphabetCount;
    }
}
