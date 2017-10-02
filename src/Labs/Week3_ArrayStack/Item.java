package Labs.Week3_ArrayStack;

/**
 * Created by dk on 9/7/2017.
 */
public class Item {
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
    public String toString() {;
        return String.format("\n%-17s %16d %16s", this.getItemName(), this.getQuantity(), (this.getQuantity() * this.getRetailPrice()));
    }

}
