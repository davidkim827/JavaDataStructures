package Homework.Week11_PriorityQueueHeap;

/**
 * Created by dk on 11/14/2017.
 */
import java.io.*;

public abstract class KeyWordListAbstract{

    public abstract Word[] wordsList(File fileForKeyWords, File fileForWordsToIgnore) throws FileNotFoundException; //also exclude single letter, numbers, and punctuations (,.?!)

    public abstract Word[] keyWordsList(File inputFile1, int N, File inputFile2) throws FileNotFoundException;

}
