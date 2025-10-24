package store.item;

public abstract class FoodItem extends StoreItem {

    private String expirationDate;


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
    public FoodItem(String itemName, String itemDescription, double itemPrice, double taxRate, String brand, String color,
                    String returnPolicy, int quantity, String expirationDate) {
        super(itemName, itemDescription, itemPrice, taxRate, brand, color, returnPolicy, quantity);
        this.expirationDate = expirationDate;
    }

    /**
     *
     * @return expirationDate
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     *
     * @param expirationDate
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
