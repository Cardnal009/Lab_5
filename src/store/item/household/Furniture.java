package store.item.household;

import store.item.HouseholdItem;

/**
 * Purpose: A class representation of furniture
 * @author Travis, Ricky, Brayden, Jasper
 * 10/23/25
 * section 331-001
 */
public class Furniture extends HouseholdItem {

    private String model;
    private String material;

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
     * @param model
     */
    public Furniture(String itemName, String itemDescription, double itemPrice, double taxRate, String brand, String color,
                     String returnPolicy, int quantity, String model, String material) {
        super(itemName, itemDescription, itemPrice, taxRate, brand, color, returnPolicy, quantity);
        this.model = model;
        this.material = material;
    }

    /**
     *
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     *
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     *
     * @return material
     */
    public String getMaterial() {
        return material;
    }

    /**
     *
     * @param material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

}
