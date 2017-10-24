package Homework.Week8_SortedNameList;

/**
 * Created by dk on 10/15/2017.
 */
public class LLNode{

    private Name name;
    private LLNode next;

    public LLNode(){
        name=null;
        next=null;
    }


    public LLNode(Name name, LLNode next){
        setName(name);
        setNext(next);
    }

    public Name getName(){
        return name;
    }
    public LLNode getNext(){
        return next;
    }
    public void setName(Name name){
        this.name = name;
    }
    public void setNext(LLNode next){
        this.next = next;
    }
}

