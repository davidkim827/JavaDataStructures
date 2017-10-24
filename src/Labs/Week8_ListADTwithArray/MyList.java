package Labs.Week8_ListADTwithArray;

/**
 * Created by dk on 10/12/2017.
 */

//List Methods with Array Implementation
public class MyList{
    String[] arr;
    int loc=0;
    int capacity;

    public MyList(int size){ //List constructor accepting array size argument
        arr=new String[size];
        capacity=size;
    }
    public boolean isFull(){ //checks to see if array is full
        return loc==capacity;
    }
    public boolean isEmpty(){//checks to see if array is empty
        return loc==0;
    }
    public int size(){ //returns the size of the array so far
        return loc;
    }
    public String get(int index){ //returns the String data at the specified index of array
        return arr[index];
    }
    public void print(){ //print method to return the array so far
        for(int i=0; i<loc; i++){
            System.out.println(arr[i]);
        }
    }
    public void add(String data){ //adding method to add items to the list
        if(!isFull()){
            arr[loc]=data;
            loc++;
        }
    }
    public void remove(int index){ //remove method to remove items from the method
        if(!isEmpty() && index>=0 && index<loc){
            for(int i=index; i<=loc-1; i++){
                arr[i]=arr[i+1];
            }
            loc--;
        }
        else if (!isEmpty() && index == loc)
            loc--;
    }
    public void remove(String data){ //overloaded remove method to accept a string to remove from the list

        int index = 0;
        if (!isEmpty()) {
            for (int i = 0; i <= loc; i++) {
                if (arr[i].equals(data))
                    index = i;
            }
        }

        for (int i = index; i <= loc - 1; i++)
            arr[i]=arr[i+1];

        loc--;
    }
}

