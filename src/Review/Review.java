package Review;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//sorted array vs linked list. which is faster for searching through a data file containing string of names?
public class Review {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(args[0]));

        //sorted array
        ArrayList<String> namesArray = new ArrayList<>();
        //LL
        LinkedList<String> linkedList = new LinkedList<>();
        while(reader.hasNextLine()){
            String name = reader.nextLine();
            namesArray.add(name);
            linkedList.add(name);
        }
        namesArray.toArray();
        String[] namesArr = (String[]) namesArray.toArray(new String[namesArray.size()]);
        Arrays.sort(namesArr);

        long startTime = System.nanoTime();

        for(int i = 0; i < namesArr.length; i++){
            if (namesArr[i].equalsIgnoreCase(args[1]))
                break;
        }
        long endTime = System.nanoTime();

        long totalTimeArray = endTime - startTime;
        System.out.println("Array: " + totalTimeArray);

        startTime = System.nanoTime();

        for(int i = 0; i < linkedList.size(); i++){
            if (linkedList.get(i).equals(args[1]))
                break;
        }
        endTime = System.nanoTime();

        long totalTimeLinkedList = endTime - startTime;
        System.out.println("Linked List:" + totalTimeLinkedList);

        if(totalTimeArray > totalTimeLinkedList)
            System.out.println("Sorted Array was slower than Linked List.");
        else
            System.out.println("Linked List was slower than sorted array.");

    }
}