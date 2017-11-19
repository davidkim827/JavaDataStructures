package Homework.Week11_PriorityQueueHeap;

public class WordHeap extends WordHeapAbstract{

    public WordHeap(int maxSize){
        super(maxSize);
    }

    @Override
    public void enqueue(Word data) {
        if(isFull()){
            System.out.print("Priority Queue is Full");
        }
        else{
            lastIndex++;
            list[lastIndex] = data;
            heapUp(data);
        }
    }

    public void heapUp(Word data){
        int hole = lastIndex;
        while((hole > 0) && (data.compareTo((list[(hole - 1) / 2])) > 0)){
            list[hole] = list[((hole - 1) / 2)];
            hole = ((hole - 1) / 2);
        }
        list[hole] = data;
    }

    @Override
    public Word dequeue(){
        Word topItem = null;
        Word moveLastWord;

        if(lastIndex == -1)
            System.out.print("Priority Queue is empty");
        else{
            topItem = list[0];
            moveLastWord = list[lastIndex];
            lastIndex--;
            if(lastIndex != -1)
                heapDown(moveLastWord);
        }
        return topItem;
    }

    public void heapDown(Word word){
        int hole = 0;
        int newHole;

        newHole = newHole(hole, word);
        while(newHole != hole){
            list[hole] = list[newHole];
            hole = newHole;
            newHole = newHole(hole, word);
        }
        list[hole] = word;
    }

    public int newHole(int hole, Word word){
        int left = (hole * 2) + 1;
        int right = (hole * 2) + 2;

        if (left > lastIndex)
            return hole;
        else if (left == lastIndex) {
            if (word.compareTo(list[left]) < 0)
                return left;
            else
                return hole;
        }
        else if (list[left].compareTo(list[right]) < 0){
            if(list[right].compareTo(word) <= 0)
                return hole;
            else
                return right;
        }
        else if (list[left].compareTo(word) < 0)
            return hole;
        else
            return left;
    }
    @Override
    public void display() {
        System.out.print(displayHelper(0, 0));
    }

    //helper method for display
    public String displayHelper(int index, int level) {
        if (index <= lastIndex) {
            int left = (index * 2) + 1;
            int right = (index * 2) + 2;

            String concat = "";
            if (list[index] == null)
                return "";
            concat += displayHelper(right, level + 1);
            for (int i = 0; i < level; i++)
                concat += "\t\t\t";
            concat += list[index] + "\n\n";
            concat += displayHelper(left, level + 1);
            return concat;
        }
        else
            return "";
    }
}
