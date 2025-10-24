package store.item.electronics;

import store.item.ElectronicItem;

/**
 * Purpose: A class representation of a TV
 * @author Travis, Ricky, Brayden, Jasper
 * 10/23/25
 * section 331-001
 */

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
