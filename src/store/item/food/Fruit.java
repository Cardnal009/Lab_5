package store.item.food;

import store.item.FoodItem;

/**
 * Purpose: A class representation of fruit
 * @author Travis, Ricky, Brayden, Jasper
 * 10/23/25
 * section 331-001
 */
public class Fruit extends FoodItem {


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
     * @param expirationDate
     */
    public Fruit(String itemName, String itemDescription, double itemPrice, double taxRate, String brand, String color,
                 String returnPolicy, int quantity, String expirationDate) {
        super(itemName, itemDescription, itemPrice, taxRate, brand, color, returnPolicy, quantity, expirationDate);
    }
}
