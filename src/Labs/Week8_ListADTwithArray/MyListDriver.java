package Labs.Week8_ListADTwithArray;

import java.util.Scanner;

/**
 * Created by dk on 10/12/2017.
 */
public class MyListDriver {
    public static void main(String[] args){
        Scanner keyBoard = new Scanner(System.in);
        String stringData;
        int count = 0;

        MyList myList = new MyList(10);

        System.out.println("What do you want to put in to your list? Type \"Done\" when finished");
        while(true) {
            stringData = keyBoard.next();
            if(stringData.equals("Done"))
                break;
            myList.add(stringData);
            count++;
        }

        System.out.println();
        System.out.println("Print Method Test: ");
        myList.print();
        System.out.println();

        System.out.println("Size Test:");
        System.out.print(myList.size());
        System.out.println();
        System.out.println();

        System.out.println("Remove (Last Index) Test:");
        myList.remove(count);
        myList.print();
        System.out.println();

        System.out.println("Remove (Index 1) Test:");
        myList.remove(1);
        myList.print();
        System.out.println();

        System.out.println("Remove (Index 0) Test:");
        myList.remove(0);
        myList.print();
        System.out.println();

        System.out.println("Get test (Index 2): ");
        System.out.print(myList.get(2));
        System.out.println();
        System.out.println();

        System.out.println("What we have so far: ");
        myList.print();
        System.out.println();

        String removeWord;
        System.out.println("Word to remove from index 0 of array? ");
        removeWord = keyBoard.next();
        System.out.println();

        System.out.println("Overloaded String Removal Method Test (Removing " + removeWord + "):");
        myList.remove(removeWord);
        myList.print();
        System.out.println();

        System.out.println("Word to remove from the middle of array?");
        removeWord = keyBoard.next();
        System.out.println();

        System.out.println("Overloaded String Removal Method Test (Removing " + removeWord + "):");
        myList.remove(removeWord);
        myList.print();
        System.out.println();

        System.out.println("Word to remove from last index of array?");
        removeWord = keyBoard.next();
        System.out.println();

        System.out.println("Overloaded String Removal Method Test (Removing " + removeWord + "):");
        myList.remove(removeWord);
        myList.print();
    }
}
