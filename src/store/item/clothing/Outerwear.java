package store.item.clothing;

import store.item.ClothingItem;

/**
 * Purpose: A class represenation of outerwear
 * @author Travis, Ricky, Brayden, Jasper
 * 10/23/25
 * section 331-001
 */

public class Outerwear extends ClothingItem {


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
    public Outerwear(String itemName, String itemDescription, double itemPrice, double taxRate, String brand, String color, String returnPolicy, int quantity, String size, String material) {
        super(itemName, itemDescription, itemPrice, taxRate, brand, color, returnPolicy, quantity, size, material);
    }
}
