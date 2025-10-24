package store.item;

public abstract class ElectronicItem extends StoreItem {

    private boolean requiresBatteries;


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
    public ElectronicItem(String itemName, String itemDescription, double itemPrice, double taxRate, String brand,
                          String color, String returnPolicy, int quantity, boolean requiresBatteries) {
        super(itemName, itemDescription, itemPrice, taxRate, brand, color, returnPolicy, quantity);
        this.requiresBatteries = requiresBatteries;
    }

    /**
     *
     * @return requiresBatteries
     */
    public boolean requiresBatteries() {
        return requiresBatteries;
    }

    /**
     *
     * @param requiresBatteries
     */
    public void setRequiresBatteries(boolean requiresBatteries) {
        this.requiresBatteries = requiresBatteries;
    }
}
