package Labs.Week3_ArrayStackADT;

/**
 * Created by dk on 9/7/2017.
 */
public class Item { //describes the items read from the data text file and passes along the information to the Shopping bag class
    private String itemName;
    private int quantity;
    private float retailPrice;

    public Item (String itemName, int quantity, float retailPrice){
        setItemName(itemName);
        setQuantity(quantity);
        setRetailPrice(retailPrice);
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setRetailPrice (float retailPrice){
        this.retailPrice = retailPrice;
    }

    public String getItemName (){
        return itemName;
    }
    public int getQuantity(){
        return quantity;
    }
    public float getRetailPrice (){
        return retailPrice;
    }

    @Override
    public String toString() { //returns
        return String.format("\n%-17s %16d %16s", this.getItemName(), this.getQuantity(), (this.getQuantity() * this.getRetailPrice()));
    }

}
