package Homework.Week11_PriorityQueueHeap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dk on 11/12/2017.
 */
public class KeyWordList extends KeyWordListAbstract {

    @Override
    public Word[] wordsList(File fileForKeyWords, File fileForWordsToIgnore) throws FileNotFoundException {
        Scanner ignore = new Scanner(fileForWordsToIgnore);
        Scanner important = new Scanner(fileForKeyWords);

        ArrayList<String> ignoreArray = new ArrayList<>();

        while (ignore.hasNext()) {
            String ignoreWord = ignore.next();
            ignoreArray.add(ignoreWord);
        }

        ArrayList<Word> importantWords = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();

        while (important.hasNext()) {
            String wordToWord = important.next().replaceAll("[^a-zA-Z]", "").toLowerCase();
            Word word = new Word(wordToWord);
            if (ignoreArray.contains(wordToWord) || wordToWord.equals(" "))
                continue;
            else {
                if (tmp.contains(wordToWord)) {
                    for(int i = 0; i < importantWords.size(); i++)
                        if(wordToWord.equals(importantWords.get(i).getWord()))
                            importantWords.get(i).incrementFrequency();
                }
                else {
                    tmp.add(wordToWord);
                    importantWords.add(word);
                }
            }
        }

        for(int i = 0; i < importantWords.size(); i++){
            if(importantWords.get(i).getFrequency() < 3) {
                importantWords.remove(i);
                i--;
            }
        }
        return importantWords.toArray(new Word[importantWords.size()]);
    }


    public Word[] keyWordsList(File inputFile1, int N, File inputFile2) throws FileNotFoundException {
        Word[] wordsList = wordsList(inputFile1, inputFile2);
        WordHeap heap = new WordHeap(wordsList.length);
        Word[] keyWordsList = new Word[N];

        for (int i = 0; i < wordsList.length; i++){
            heap.enqueue(wordsList[i]);
        }

        System.out.println("Heap structure before constructing key word list:\n" +
                "=================================================\n");
        heap.display();

        for (int i = 0; i < N; i++){
            keyWordsList[i] = heap.dequeue();
        }
        System.out.println("Heap structure after constructing " + N + " key words list:\n" +
                "===================================================\n");
        heap.display();

        System.out.print("And output file containing key words list:\n" +
                "==================================================\n");
        for (int i = 0; i < N; i++)
            System.out.println(keyWordsList[i]);

        return keyWordsList;
    }

    public static void main(String[] args) throws FileNotFoundException {
        KeyWordList kwl = new KeyWordList();

        //File file1 = new File(args[0]);
        //File file2 = new File(args[2]);
        //int n = args[1];
        File file1 = new File("Week11data1.txt");
        File file2 = new File("Week11data2.txt");
        int n = 10;

        Word[] keyWordsList = kwl.keyWordsList(file1, n, file2);

        PrintWriter writer = new PrintWriter("KeyWordOutputFile.txt");
        for(int i = 0; i < keyWordsList.length; i++)
            writer.println(keyWordsList[i]);

        writer.close();
    }
}
