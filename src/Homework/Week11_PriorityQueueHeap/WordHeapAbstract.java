package Homework.Week11_PriorityQueueHeap;

/**
 * Created by dk on 11/14/2017.
 */
public abstract class WordHeapAbstract{
    Word[] list;
    int lastIndex=-1;
    int maxIndex;

    public WordHeapAbstract(int maxSize){
        lastIndex=-1;
        maxIndex=maxSize-1;
        list=new Word[maxSize];
    }
    public boolean isEmpty(){
        return lastIndex == -1;
    }
    public boolean isFull(){
        return lastIndex == maxIndex;
    }

    public abstract void enqueue(Word data);

    public abstract Word dequeue();

    public abstract void display(); //display heap structure: either complete or full tree

}

