package store.item;

public abstract class StoreItem {

    private String itemName;
    private String itemDescription;
    private double itemPrice;
    private double taxRate;
    private String brand = null;
    private String color;
    private String returnPolicy;
    private int quantity;


    /**
     * Constructor including all attributes
     * @param itemName
     * @param itemDescription
     * @param itemPrice
     * @param taxRate
     * @param brand
     * @param color
     * @param returnPolicy
     * @param quantity
     */
    public StoreItem(String itemName, String itemDescription, double itemPrice, double taxRate, String brand, String color,
                     String returnPolicy, int quantity) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.taxRate = taxRate;
        this.brand = brand;
        this.color = color;
        this.returnPolicy = returnPolicy;
        this.quantity = quantity;
    }

    /**
     *
     * @return itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     *
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     *
     * @return itemDescription
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     *
     * @param itemDescription
     */
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    /**
     *
     * @return itemPrice
     */
    public double getItemPrice() {
        return itemPrice;
    }

    /**
     *
     * @param itemPrice
     */
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     *
     * @return taxRate
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     *
     * @param taxRate
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     *
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     *
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     *
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     *
     * @return returnPolicy
     */
    public String getReturnPolicy() {
        return returnPolicy;
    }

    /**
     *
     * @param returnPolicy
     */
    public void setReturnPolicy(String returnPolicy) {
        this.returnPolicy = returnPolicy;
    }

    /**
     *
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
