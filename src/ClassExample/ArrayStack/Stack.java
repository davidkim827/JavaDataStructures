package ClassExample.ArrayStack;

/**
 * Created by dk on 9/7/2017.
 */
class stackDish {
    stackDish[] arr;
    int index = -1;
    
    public stackDish (int cap){ //Constructor
        arr = new stackDish[cap];

    }

    public void push(stackDish dish){ //push method
        if (!isFull())
            arr[++index] = dish;
    }

    public stackDish pop(){ //push method
        if (!isEmpty())
            return arr[index--];
        else
            return null;
    }

    public boolean isEmpty(){
        //return arr.length==0; // as opposed to if (arrlength ==0) return true; else return false;

        return index == -1;
    }

    public boolean isFull(){
        return arr.length -1 == index;
    }


}

