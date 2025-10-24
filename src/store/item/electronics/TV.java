package store.item.electronics;

import store.item.ElectronicItem;

public class TV extends ElectronicItem {

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
     * @param requiresBatteries
     */
    public TV(String itemName, String itemDescription, double itemPrice, double taxRate, String brand, String color, String returnPolicy, int quantity, boolean requiresBatteries) {
        super(itemName, itemDescription, itemPrice, taxRate, brand, color, returnPolicy, quantity, requiresBatteries);
    }
}
