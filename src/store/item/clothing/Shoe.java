package store.item.clothing;

import store.item.ClothingItem;

public class Shoe extends ClothingItem {

    private String shoeType;

    /**
     * Constructor including all attributes
     *
     * @param itemName
     * @param itemDescription
     * @param itemPrice
     * @param taxRate
     * @param brand
     * @param color
     * @param returnPolicy
     * @param quantity
     * @param size
     * @param material
     * @param shoeType
     */
    public Shoe(String itemName, String itemDescription, double itemPrice, double taxRate, String brand, String color,
                String returnPolicy, int quantity, String size, String material, String shoeType) {
        super(itemName, itemDescription, itemPrice, taxRate, brand, color, returnPolicy, quantity, size, material);
        this.shoeType = shoeType;
    }

    /**
     *
     * @return shoeType
     */
    public String getShoeType() {
        return shoeType;
    }

    /**
     *
     * @param shoeType
     */
    public void setShoeType(String shoeType) {
        this.shoeType = shoeType;
    }
}
