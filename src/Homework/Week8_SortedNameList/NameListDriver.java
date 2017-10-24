package Homework.Week8_SortedNameList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NameListDriver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner output = new Scanner(new File("HW8data.txt"));

        int numberOfNames = Integer.parseInt(output.next());
        int count = 0;

        Name nameStartList = new Name();
        NameListSorted nls = new NameListSorted(nameStartList);

        while(output.hasNext()){
            String firstName = output.next();
            String lastName = output.next();
            Name name = new Name(firstName, lastName);
            nls.add(name);
            count++;
        }

        if (numberOfNames == count)
            System.out.println("Success! All " + numberOfNames + " names read!\n");
        else
            System.out.println("You're missing " + (numberOfNames - count));


        System.out.println(nls.size());

        nls.print(); //checks to see if all elements of the list are there and organized alphabetically

        System.out.println();

        Name firstOnList = new Name("David", "Aardvark"); //will be the first item on the list alphabetically
        nls.insert(firstOnList); //checks to see if adding to beginning of list works.
        nls.get(0); //it returns what is on the list at the given index argument. In this case, it is the first item, which should be David Aardvark
        System.out.println("\n");
        nls.search(firstOnList); //checks to see if search method works. In this instance looks for the alphabetically first item on the list. It should return the number 0.

        System.out.println();

        Name lastOnList = new Name("David", "Zulu"); //will be the last item on the list alphabetically
        nls.insert(new Name("David", "Zulu")); //checks to see if inserting at very end of list works
        nls.search(lastOnList); //checks to see if search method works. In this instance looks for the alphabetically last item on the list. It should return the last number on the list, number 436.
        nls.get(435); //it returns what is on the list at the given index argument. In this case, it is the last item, which should be David Zulu
        System.out.println("\n");

        nls.print("Zhang"); //searches through list with last name argument given and once it finds out the name, it prints out both first and last name
        System.out.println("\n");

        //removes all the items that were added to the list that were not from the data.txt file
        System.out.println(nls.size()); //checks the size of list before
        nls.remove(4);
        System.out.println("Removed index 4");
        nls.remove(firstOnList);
        System.out.println("Removed first item on list");
        nls.remove(436);
        System.out.println("Removed index 436");
        nls.remove(firstOnList);
        System.out.println("Removed last item on list");
        System.out.println(nls.size() + "\n"); //checks the size of list after deletions

        //removes all items from the list
        System.out.println("Now deleting list:");
        nls.removeAll();
        nls.print();
        System.out.println("Done!");
    }
}
