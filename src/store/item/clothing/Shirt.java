package store.item.clothing;

import store.item.ClothingItem;

/**
 * Purpose: A class representation of a shirt
 * @author Travis, Ricky, Brayden, Jasper
 * 10/23/25
 * section 331-001
 */

public class Shirt extends ClothingItem {

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
     */
    public Shirt(String itemName, String itemDescription, double itemPrice, double taxRate, String brand, String color, String returnPolicy, int quantity, String size, String material) {
        super(itemName, itemDescription, itemPrice, taxRate, brand, color, returnPolicy, quantity, size, material);
    }
}
