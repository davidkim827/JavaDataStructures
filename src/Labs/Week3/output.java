package Labs.Week3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dk on 9/7/2017.
 */
public class output {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner output = new Scanner(new File("data.txt"));


        String[] arr = output.nextLine().replaceFirst("\\s+", " ").split(" ");

        ShoppingBag shoppingBag = new ShoppingBag(Float.parseFloat(arr[0]), Integer.parseInt(arr[1]));

        while (output.hasNextLine()) {
            String itemName;
            int quantity;
            float price;

            String[] array = output.nextLine().replace("  ", " ").split(" ");

            if (array.length == 4) {
                itemName = array[0] + " " + array[1];
                quantity = Integer.parseInt(array[2]);
                price = Float.parseFloat(array[3]);

                shoppingBag.push(new Item(itemName, quantity, price));
            } else if (array.length == 3) {
                itemName = array[0];
                quantity = Integer.parseInt(array[1]);
                price = Float.parseFloat(array[2]);

                shoppingBag.push(new Item(itemName, quantity, price));
            }
        }
        System.out.println(shoppingBag);

    }
}



