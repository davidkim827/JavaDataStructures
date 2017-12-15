package Labs.Week3_ArrayStackADT;

/**
 * Created by dk on 9/7/2017.
 */
public class ShoppingBag implements ShoppingBagInterface {

    Item[] bag;
    int capacity;
    float taxRate;
    int index;

    public ShoppingBag (float taxRate, int capacity){
        this.taxRate = taxRate;
        this.capacity = capacity;
        this.bag = new Item[capacity];
        this.index = 0;
    }

    @Override
    public void push(Item item) {
        if (!isFull()) {
            this.bag[index] = item;
            index++;
        }
    }

    @Override
    public void pop() {
        if (!isEmpty()) {
            this.bag[this.index] = null;
            this.index--;
        }
    }

    @Override
    public Item top() {
        if (!isEmpty())
            return this.bag[this.index];
        else
            return null;
    }

    @Override
    public boolean isFull() {
        return -1 == index;
    }

    @Override
    public boolean isEmpty() {
        return index == -1;
    }

    public float totalRetailCost() { //returns the total retail cost
        float sum = 0;
        for (int i = 0 ; i < index; i++) {
            sum = sum + (this.bag[i].getQuantity() * this.bag[i].getRetailPrice());
        }

        return sum;
    }
    public float getTaxRate(float totalRetail){ // returns the tax rate based upon the total retail cost
        return (totalRetail * this.taxRate);
    }

    public String toString() {

        if(index != -1) {
            System.out.println("The bag contains: ");
            System.out.print("--------------------------------------------------------");
            System.out.printf("\n%-17s %16s %16s", "Name of the Items", "Quantity", "Subtotal");

            for (int i = 0 ; i < index ; i++) {
                System.out.println(this.bag[i].toString());
            }
            System.out.print("--------------------------------------------------------");

            System.out.printf("\n%35s %15.2f", "Total", totalRetailCost());
            System.out.printf("\n%35s %15.2f", "Tax(" + this.taxRate + "%)", getTaxRate(totalRetailCost()));

            System.out.print("\n--------------------------------------------------------");

            System.out.printf("\n%35s %15.2f", "Grand Total", (totalRetailCost()+ getTaxRate(totalRetailCost())));
        }
        return "";
    }
}
