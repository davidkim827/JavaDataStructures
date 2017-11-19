package Homework.Week11_PriorityQueueHeap;

/**
 * Created by dk on 11/12/2017.
 */
public class Word implements Comparable<Word>{

    private String word;
    private int frequency;
    public Word(String word){
        this.word=word;
        frequency=1;
    }
    public Word(String word, int frequency){
        this.word=word;
        this.frequency=frequency;
    }
    public String getWord(){
        return word;
    }
    public int getFrequency(){
        return frequency;
    }
    public void setWord(String word){
        this.word = word;
    }
    public void incrementFrequency(){
        frequency++;
    }
    public int compareTo(Word other){
        return frequency-other.getFrequency();
    }
    public String toString(){
        return String.format("["+word+ ":"+frequency+"]");
    }
}
