package store.item.household;

import store.item.HouseholdItem;

public class CleaningSupply extends HouseholdItem {


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
     */
    public CleaningSupply(String itemName, String itemDescription, double itemPrice, double taxRate, String brand, String color, String returnPolicy, int quantity) {
        super(itemName, itemDescription, itemPrice, taxRate, brand, color, returnPolicy, quantity);
    }
}
