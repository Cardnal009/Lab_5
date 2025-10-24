package store.item;

/**
 * Purpose: An abstract class defining the structure of clothing objects
 * @author Travis, Ricky, Brayden, Jasper
 * 10/23/25
 * section 331-001
 */
public abstract class ClothingItem extends StoreItem {

    private String size;
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
     * @param size
     * @param material
     */
    public ClothingItem(String itemName, String itemDescription, double itemPrice, double taxRate, String brand, String color,
                        String returnPolicy, int quantity, String size, String material) {
        super(itemName, itemDescription, itemPrice, taxRate, brand, color, returnPolicy, quantity);
        this.size = size;
        this.material = material;
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

    /**
     *
     * @return size
     */
    public String getSize() {
        return size;
    }

    /**
     *
     * @param size
     */
    public void setSize(String size) {
        this.size = size;
    }
}
