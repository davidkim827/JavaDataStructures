package Labs.Week5;

public class NumberQueue{

    private int[] data;
    private int front, rear, numberOfItems, capacity;
    public NumberQueue(int cap){
        front=rear=numberOfItems=0;
        data=new int[cap];
        capacity=cap;
    }
    public boolean isEmpty(){
        return numberOfItems==0;
    }
    public boolean isFull(){
        return numberOfItems==capacity;
    }

    public int size(){
        return numberOfItems;
    }
    public void enqueue(int val){
        if(!isFull()){
            data[rear]=val;
            rear= ++rear % capacity;
            numberOfItems++;
        }else{
            System.out.println("it is full, find another restaurant!");
        }
    }
    public int dequeue(){
        if(!isEmpty()){
            int val=data[front];
            front = ++front % capacity;
            numberOfItems--;
            return val;
        }else{
            return -1000;
        }
    }
}
