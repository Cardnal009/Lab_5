package store.item;

/**
 * Purpose: An abstract class defining the structure of household items
 * @author Travis, Ricky, Brayden, Jasper
 * 10/23/25
 * section 331-001
 */
public abstract class HouseholdItem extends StoreItem {

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
    public HouseholdItem(String itemName, String itemDescription, double itemPrice, double taxRate, String brand, String color, String returnPolicy, int quantity) {
        super(itemName, itemDescription, itemPrice, taxRate, brand, color, returnPolicy, quantity);
    }
}
