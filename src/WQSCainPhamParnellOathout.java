import store.item.*;
import store.item.clothing.Outerwear;
import store.item.clothing.Shirt;
import store.item.clothing.Shoe;
import store.item.electronics.Laptop;
import store.item.electronics.Phone;
import store.item.electronics.TV;
import store.item.food.Fruit;
import store.item.food.ShelfStable;
import store.item.food.Vegetable;
import store.item.household.CleaningSupply;
import store.item.household.Furniture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class WQSCainPhamParnellOathout {

    private static final double FOOD_TAX_RATE = 1.0675; // food tax rate
    private static final double TAX_RATE = 1.07; // any item besides food tax rate
    private static ArrayList<StoreItem> itemList = new ArrayList<>(); // array list of all items in inventory
    private static HashMap<StoreItem, Integer> cart = new HashMap<>(); // hashmap of items in cart (specifically used to help with quantity)
    private static Scanner input = new Scanner(System.in); // initialize scanner for input

    public static void main(String[] args) {

        initializeInventory(); // initialize inventory items

        boolean isRunning = true; // checks if program should exit

        while (isRunning) {
            String response = getResponse("Would you like to add an item or sell an item in inventory? (Type add, sell, or exit)",
                    new String[]{ "add", "sell", "exit"}); // get user input and check response against string array
            switch (response) {
                case "add":
                    addItemMenu(); // add new item to inventory
                    break;
                case "sell":
                    sellItemMenu(); // sell item from inventory / add item to cart
                    break;
                case "exit":
                    isRunning = false; // exits program
            }
        }
    }

    /**
     * Prompts user for input to add a new {@link StoreItem} into {@link WQSCainPhamParnellOathout#itemList}.
     */
    private static void addItemMenu() {
        boolean isDone = false; // checks if program is done
        while (!isDone) { // loops until isDone is true
            String category = getResponse("What type of item (Food, Electronics, Clothing, or Household)",
                    new String[] {"Food", "Electronics", "Clothing", "Household"}); // get user input and check response against string array
            displayItems(category); // displays items by category
            String response = getResponse("Would you like to add more of an existing item or add a new item? (type existing, new, or end)",
                    new String[] {"existing", "new", "end"}); // get user input and check response against string array
            switch (response) { // add existing item, new item, or end adding item
                case "existing":
                    System.out.println("What item would you like to add more of? (type the name exactly as you see it)");
                    response = input.nextLine(); // get user input
                    updateItemAmount(response, input, category); // update quantity of an existing item
                    displayItems(category); // displays items in the chosen category with updated quantity
                    break;
                case "new":
                    String itemType = "";
                    switch (category.toLowerCase()) {
                        case "food":
                            itemType = getResponse("What item would you like to add? (Fruit, ShelfStable, Vegetable)",
                                    new String[] {"Fruit", "ShelfStable", "Vegetable"}); // get user input and check response against string array
                            break;
                        case "electronics":
                            itemType = getResponse("What item would you like to add? (Laptop, Phone, TV)",
                                    new String[] {"Laptop", "Phone", "TV"}); // get user input and check response against string array
                            break;
                        case "clothing":
                            itemType = getResponse("What item would you like to add? (Outerwear, Shirt, Shoe)",
                                    new String[] {"Outerwear", "Shirt", "Shoe"}); // get user input and check response against string array
                            break;
                        case "household":
                            itemType = getResponse("What item would you like to add? (CleaningSupply, Furniture)",
                                    new String[]{"CleaningSupply", "Furniture"}); // get user input and check response against string array
                            break;
                    }
                    addNewItem(category, itemType); // add new item given the category and specific item type in that category
                    displayItems(category); // displays the items in the category chosen
                    break;
                case "end":
                    isDone = true; // ends add portion of the program
                    break;
            }
        }
    }

    /**
     * Adds a new {@link StoreItem} object
     * Prompts user for the item's information (will change based on category and item type)
     * @param category (Food, Electronics, Clothing, Household)
     * @param itemType Specific items within the category
     */
    private static void addNewItem(String category, String itemType) {
        System.out.println("Enter item name: ");
        String itemName = input.nextLine();
        System.out.println("Enter item description: ");
        String itemDescription = input.nextLine();
        System.out.println("Enter item price: ");
        double itemPrice = input.nextDouble();
        input.nextLine();
        System.out.println("Enter item brand (can be null): ");
        String itemBrand = input.nextLine();
        System.out.println("Enter item color (can be null): ");
        String itemColor = input.nextLine();
        System.out.println("Enter item return policy: ");
        String itemReturnPolicy = input.nextLine();
        System.out.println("Enter quantity of the item: ");
        int itemQuantity = input.nextInt();
        input.nextLine(); // clear buffer
        if (category.equalsIgnoreCase("clothing")) {
            System.out.println("Enter item size: ");
            String itemSize = input.nextLine();
            System.out.println("Enter item material: ");
            String itemMaterial = input.nextLine();
            String shoeType = null; // initialize shoeType
            if (itemType.equalsIgnoreCase("shoe")) {
                System.out.println("Enter type of shoe: ");
                shoeType = input.nextLine();
            }
            ClothingItem newClothingItem = null; // initialize a new clothing item
            switch (itemType.toLowerCase()) {
                case "outerwear":
                    newClothingItem = new Outerwear(itemName, itemDescription, itemPrice, TAX_RATE, itemBrand, itemColor,
                            itemReturnPolicy, itemQuantity, itemSize, itemMaterial);
                    break;
                case "shirt":
                    newClothingItem = new Shirt(itemName, itemDescription, itemPrice, TAX_RATE, itemBrand, itemColor,
                            itemReturnPolicy, itemQuantity, itemSize, itemMaterial);
                    break;
                case "shoe":
                    newClothingItem = new Shoe(itemName, itemDescription, itemPrice, TAX_RATE, itemBrand, itemColor,
                            itemReturnPolicy, itemQuantity, itemSize, itemMaterial, shoeType);
                    break;
            }
            itemList.add(newClothingItem); // add new clothing item to itemList
        }
        if (category.equalsIgnoreCase("electronics")) { // if category is electronics
            System.out.println("Enter batteries required (true/false): ");
            boolean batteriesRequired = input.nextBoolean(); // check if batteries are required
            input.nextLine(); // clear buffer
            ElectronicItem newElectronicItem = null; // initialize new electronic item object
            switch (itemType.toLowerCase()) {
                case "laptop":
                    newElectronicItem = new Laptop(itemName, itemDescription, itemPrice, TAX_RATE, itemBrand, itemColor,
                            itemReturnPolicy, itemQuantity, batteriesRequired);
                    break;
                case "phone":
                    newElectronicItem = new Phone(itemName, itemDescription, itemPrice, TAX_RATE, itemBrand, itemColor,
                            itemReturnPolicy, itemQuantity, batteriesRequired);
                    break;
                case "tv":
                    newElectronicItem = new TV(itemName, itemDescription, itemPrice, TAX_RATE, itemBrand, itemColor,
                            itemReturnPolicy, itemQuantity, batteriesRequired);
                    break;
            }
            itemList.add(newElectronicItem); // add new electronic item to itemList
        }
        if (category.equalsIgnoreCase("food")) { // if category is food
            System.out.println("Enter item expiration date: ");
            String itemExpirationDate = input.nextLine();
            FoodItem newFoodItem = null; // initialize new food item object
            switch (itemType.toLowerCase()) {
                case "fruit":
                    newFoodItem = new Fruit(itemName, itemDescription, itemPrice, FOOD_TAX_RATE, itemBrand, itemColor,
                            itemReturnPolicy, itemQuantity, itemExpirationDate);
                    break;
                case "shelfstable":
                    newFoodItem = new ShelfStable(itemName, itemDescription, itemPrice, FOOD_TAX_RATE, itemBrand, itemColor,
                            itemReturnPolicy, itemQuantity, itemExpirationDate);
                    break;
                case "vegetable":
                    newFoodItem = new Vegetable(itemName, itemDescription, itemPrice, FOOD_TAX_RATE, itemBrand, itemColor,
                            itemReturnPolicy, itemQuantity, itemExpirationDate);
                    break;
            }
            itemList.add(newFoodItem); // add new food item to itemList
        }
        if (category.equalsIgnoreCase("household")) { // if category is household
            String itemModel = null; // initialize itemModel
            String itemMaterial = null; // initialize itemMaterial
            if (itemType.equalsIgnoreCase("furniture")) { // if itemType is furniture, get extra information
                System.out.println("Enter furniture model: ");
                itemModel = input.nextLine();
                System.out.println("Enter furniture material: ");
                itemMaterial = input.nextLine();
            }
            HouseholdItem newHouseholdItem = null; // initialize new household item object
            switch (itemType.toLowerCase()) {
                case "cleaningsupply":
                    newHouseholdItem = new CleaningSupply(itemName, itemDescription, itemPrice, TAX_RATE, itemBrand, itemColor,
                            itemReturnPolicy, itemQuantity);
                    break;
                case "furniture":
                    newHouseholdItem = new Furniture(itemName, itemDescription, itemPrice, TAX_RATE, itemBrand, itemColor,
                            itemReturnPolicy, itemQuantity, itemModel, itemMaterial);
                    break;
            }
            itemList.add(newHouseholdItem);// add new household item to itemList
        }
    }

    /**
     * Prompts user for input to sell a {@link StoreItem} and place it into the {@link WQSCainPhamParnellOathout#cart} HashMap.
     */
    private static void sellItemMenu() {
        boolean isDone = false; // method runs until isDone changes to true
        while (!isDone) { // continue running
            String category = getResponse("What type of item category do you want to shop for (Food, Electronics, Clothing, or Household) or Checkout",
                    new String[]{"Food", "Electronics", "Clothing", "Household", "Checkout"}); // get user input and check response against string array
            if (!category.equalsIgnoreCase("checkout")) { // if the user did not type checkout
                displayDetailedItems(category); // display a detailed list of the items in inventory for the specified category
                System.out.print("What would you like to add to your cart (type item name)? ");
                String item = input.nextLine();
                addToCart(item, category); // adds an item chosen from the detailed list to add to the user's cart
            } else {
                displayOrderSummary(); // once checked out, display items chosen for checkout with total and tax
                String response = getResponse("Do you want to confirm checkout? (yes or no)", new String[] {"Yes", "No"}); // get user input and check response against string array
                switch (response.toLowerCase()) {
                    case "yes": // checking out
                        isDone = true; // end method
                        displayUpdatedInventoryOfItemsSold(); // display only the items sold showing category, item name, and quantity of the item remaining in stock
                        cart.clear(); // clears user cart
                        break;
                    case "no": // not checking out (loop back to top of method)
                        break;
                }
            }

        }
    }

    /**
     * Displays each item the user added to their cart, categorized showing name and price.
     * Shows subtotal before tax then final total with tax at the end.
     */
    private static void displayOrderSummary() {
        double foodPrice = 0; // keeps track of price of food items
        double otherPrice = 0; // keeps track of non food item prices

        /*
            prints food and shows which food items were purchased
         */
        System.out.println("Food:"); // table category
        System.out.printf("%-20s%-15s%-10s%n", "Name", "Quantity", "Price"); // table header
        for (HashMap.Entry<StoreItem, Integer> entry : cart.entrySet()) { // loops through the hashmap 'cart' to display only the items that were purchased by the user (entry.getKey() is the storeItem entry.getValue() is the amount)
            if (entry.getKey() instanceof FoodItem) { // if the storeItem is an instance of food (specifically a food item)
                foodPrice += entry.getValue() * entry.getKey().getItemPrice(); // add the total price of the food that was purchased to the variable foodPrice
                System.out.printf("%-20s%-15d%-10.2f%n", entry.getKey().getItemName(), entry.getValue(), entry.getKey().getItemPrice() * entry.getValue()); //print table data
            }
        }

        /*
            prints electronics and shows which electronic items were purchased
         */
        System.out.println("\n\nElectronics:"); // table category
        System.out.printf("%-20s%-15s%-10s%n", "Name", "Quantity", "Price"); // table header
        for (HashMap.Entry<StoreItem, Integer> entry : cart.entrySet()) { // loops through the hashmap 'cart' to display only the items that were purchased by the user (entry.getKey() is the storeItem entry.getValue() is the amount)
            if (entry.getKey() instanceof ElectronicItem) { // if the storeItem is an instance of ElectronicItem (specifically an electronic item)
                otherPrice += entry.getValue() * entry.getKey().getItemPrice(); // add the total price of the non-food items that were purchased to the variable otherPrice
                System.out.printf("%-20s%-15s%-10s%n", entry.getKey().getItemName(), entry.getValue(), entry.getKey().getItemPrice() * entry.getValue()); //print table data
            }
        }

        System.out.println("\n\nHousehold:"); // table category
        System.out.printf("%-20s%-15s%-10s%n", "Name", "Quantity", "Price"); // table header
        for (HashMap.Entry<StoreItem, Integer> entry : cart.entrySet()) { // loops through the hashmap 'cart' to display only the items that were purchased by the user (entry.getKey() is the storeItem entry.getValue() is the amount)
            if (entry.getKey() instanceof HouseholdItem) { // if the storeItem is an instance of HouseholdItem (specifically a household item)
                otherPrice += entry.getValue() * entry.getKey().getItemPrice(); // add the total price of the non-food items that were purchased to the variable otherPrice
                System.out.printf("%-20s%-15s%-10s%n", entry.getKey().getItemName(), entry.getValue(), entry.getKey().getItemPrice() * entry.getValue()); //print table data
            }
        }

        System.out.println("\n\nClothing:"); // table category
        System.out.printf("%-20s%-15s%-10s%n", "Name", "Quantity", "Price"); // table header
        for (HashMap.Entry<StoreItem, Integer> entry : cart.entrySet()) { // loops through the hashmap 'cart' to display only the items that were purchased by the user (entry.getKey() is the storeItem entry.getValue() is the amount)
            if (entry.getKey() instanceof ClothingItem) { // if the storeItem is an instance of ClothingItem (specifically a clothing item)
                otherPrice += entry.getValue() * entry.getKey().getItemPrice(); // add the total price of the non-food items that were purchased to the variable otherPrice
                System.out.printf("%-20s%-15s%-10s%n", entry.getKey().getItemName(), entry.getValue(), entry.getKey().getItemPrice() * entry.getValue()); //print table data
            }
        }

        double foodPriceTaxed = foodPrice * FOOD_TAX_RATE; // calculate food price after tax
        double otherPriceTaxed = otherPrice * TAX_RATE; // calculate non food price after tax

        double subtotal = foodPrice + otherPrice; // calculate total price without tax
        double totalPrice = foodPriceTaxed + otherPriceTaxed; // calculate total price with tax

        System.out.println("\nFood Tax: " + FOOD_TAX_RATE);
        System.out.println("Other Item Tax: " + TAX_RATE);
        System.out.printf("%n%s%.2f", "Your order subtotal is: $", subtotal);
        System.out.printf("%n%s%.2f%n%n", "Your total price is: $", totalPrice);
    }

    /**
     * Adds a {@link StoreItem} to {@link WQSCainPhamParnellOathout#cart} from the inventory and removes the quantity added from the inventory.
     * The user cannot add an item to the cart if it doesn't exist within the category the user has chosen to display.
     * @param itemName the name of the item the user wishes to add to the cart
     * @param category the category of the store item
     */
    private static void addToCart(String itemName, String category) {
        StoreItem itemFound = getItemFromCategory(itemName, category); // try to find store item

        if (itemFound == null) {
            System.out.println("Could not find the store item: " + itemName + " in the " + category + " category. Please make sure it's spelled exactly as you see it."); // item could not be found
            return;
        }
        System.out.println("Type the number of " + itemFound.getItemName() + " you would like to sell: ");
        int quantity = input.nextInt(); // get input of quantity to sell to shopper
        input.nextLine(); // clear buffer
        if (itemFound.getQuantity() >= quantity) { // checks if the user is trying to buy more than the shop has in stock
            itemFound.setQuantity(itemFound.getQuantity() - quantity); // subtracts quantity from inventory
            if (!cart.containsKey(itemFound)) { // if does not already exist in cart HashMap
                cart.put(itemFound, quantity); // add the item and amount of item to cart
            } else {
                cart.put(itemFound, cart.get(itemFound) + quantity); // re-store the item with the additional quantity in the cart Hashmap
            }
        } else {
            System.out.println("There isn't enough of " + itemFound.getItemName() + " in stock to sell " + quantity + ". There are " + itemFound.getQuantity() + " in stock."); // failed the quantity check, can't be added to cart
        }

    }

    /**
     * Updates the quantity of a specified item.
     * @param itemName the item name
     * @param input the scanner instance used to read user input
     * @param category the category the item belongs to
     */
    private static void updateItemAmount(String itemName, Scanner input, String category) {
        StoreItem itemFound = getItemFromCategory(itemName, category); // try to find store item

        if (itemFound == null) {
            System.out.println("Could not find the store item: " + itemName + " in the " + category + " category. Please make sure it's spelled exactly as you see it."); // item could not be found
            return;
        }
        System.out.println("Type the number you would like to add to the inventory amount of " + itemFound.getItemName());
        int quantity = input.nextInt();
        input.nextLine(); // clear buffer
        itemFound.setQuantity(itemFound.getQuantity() + quantity);
    }

    /**
     * Looks for an item with the specified item name in the specified category
     * @param itemName the name of the store item
     * @param category the category of the store item
     * @return the {@link StoreItem} item, otherwise null
     */
    private static StoreItem getItemFromCategory(String itemName, String category) {
        for (StoreItem storeItem : itemList) { // loop through entire inventory
            if (storeItem.getItemName().equalsIgnoreCase(itemName) && (category.equalsIgnoreCase("food"))) { // checks specific category, so you can't edit items outside specified category
                if (storeItem instanceof FoodItem) { // checks if instance of FoodItem
                    return storeItem; // item found, return item
                }
            }
            if (storeItem.getItemName().equalsIgnoreCase(itemName) && (category.equalsIgnoreCase("electronics"))) { // checks specific category, so you can't edit items outside specified category
                if (storeItem instanceof ElectronicItem) { // checks if instance of FoodItem
                    return storeItem; // item found, return item
                }
            }
            if (storeItem.getItemName().equalsIgnoreCase(itemName) && (category.equalsIgnoreCase("clothing"))) { // checks specific category, so you can't edit items outside specified category
                if (storeItem instanceof ClothingItem) { // checks if instance of FoodItem
                    return storeItem; // item found, return item
                }
            }
            if (storeItem.getItemName().equalsIgnoreCase(itemName) && (category.equalsIgnoreCase("household"))) { // checks specific category, so you can't edit items outside specified category
                if (storeItem instanceof HouseholdItem) { // checks if instance of FoodItem
                    return storeItem; // item found, return item
                }
            }
        }
        return null; // could not find store item
    }

    private static void displayUpdatedInventoryOfItemsSold() {
        System.out.println("\nInventory of items sold:");
        System.out.printf("%-15s%-25s%-15s%n", "Category", "Item", "Quantity"); // table header
        for (Map.Entry<StoreItem, Integer> entry : cart.entrySet()) { // loop through items in cart HashMap
            if (entry.getKey() instanceof FoodItem) {
                System.out.printf("%-15s%-25s%-15d%n", "Food: ", entry.getKey().getItemName(), entry.getKey().getQuantity()); // displays food items sold
            }
            if (entry.getKey() instanceof ElectronicItem) {
                System.out.printf("%-15s%-25s%-15d%n", "Electronics: ", entry.getKey().getItemName(), entry.getKey().getQuantity()); // displays electronic items sold
            }
            if (entry.getKey() instanceof ClothingItem) {
                System.out.printf("%-15s%-25s%-15d%n", "Clothing: ", entry.getKey().getItemName(), entry.getKey().getQuantity()); // displays clothing items sold
            }
            if (entry.getKey() instanceof HouseholdItem) {
                System.out.printf("%-15s%-25s%-15d%n", "Household: ", entry.getKey().getItemName(), entry.getKey().getQuantity()); // displays household items sold
            }
            displayReturnPolicy(); // prints return policy
        }
    }

    /**
     * Prints out the return policy for each category of items.
     */
    private static void displayReturnPolicy() {
        System.out.println("\nFood items may not be returned");
        System.out.println("Clothing items may be returned with tag up to 30 days");
        System.out.println("Household items may be returned up to 30 days");
        System.out.println("Electronics items may be returned up to 30 days\n");
    }

    /**
     * Displays items within the itemCategory, showing the item name and quantity
     * @param itemCategory the category of the store item (Food, Electronics, Clothing, Household)
     */
    private static void displayItems(String itemCategory) {
        for (StoreItem storeItem : itemList) { // loops through itemList (inventory)
            switch (itemCategory.toLowerCase()) {
                case "food":
                    if (storeItem instanceof FoodItem)
                        System.out.printf("%-50s%d%n", storeItem.getItemName(), storeItem.getQuantity());
                    break;
                case "electronics":
                    if (storeItem instanceof ElectronicItem)
                        System.out.printf("%-50s%d%n", storeItem.getItemName(), storeItem.getQuantity());
                    break;
                case "clothing":
                    if (storeItem instanceof ClothingItem)
                        System.out.printf("%-50s%d%n", storeItem.getItemName(), storeItem.getQuantity());
                    break;
                case "household":
                    if (storeItem instanceof HouseholdItem)
                        System.out.printf("%-50s%d%n", storeItem.getItemName(), storeItem.getQuantity());
                    break;
            }
        }
    }

    /**
     * Displays items within the itemCategory, showing all applicable parameters of {@link StoreItem} with extras as needed based on item type.
     * @param itemCategory the category of the store item (Food, Electronics, Clothing, Household)
     */
    private static void displayDetailedItems(String itemCategory) {
        /*
         headers for each category
         */
        if (itemCategory.equalsIgnoreCase("food")) {
            System.out.printf("%-30s%-50s%-10s%-10s%-25s%-12s%-30s%n", "Item Name", "Description", "Quantity", "Price", "Brand", "Exp. Date", "Return Policy");
        }
        if (itemCategory.equalsIgnoreCase("electronics")) {
            System.out.printf("%-30s%-50s%-10s%-10s%-20s%-7s%-20s%-30s%n", "Item Name", "Description", "Quantity", "Price", "Brand", "Color", "Requires Batteries", "Return Policy");
        }
        if (itemCategory.equalsIgnoreCase("clothing")) {
            System.out.printf("%-30s%-50s%-10s%-10s%-15s%-10s%-7s%-7s%-20s%-30s%n", "Item Name", "Description", "Quantity", "Price", "Brand", "Material", "Color", "Size", "Shoe Type", "Return Policy");
        }
        if (itemCategory.equalsIgnoreCase("household")) {
            System.out.printf("%-30s%-50s%-10s%-10s%-15s%-10s%-15s%-20s%-30s%n", "Item Name", "Description", "Quantity", "Price", "Brand", "Model", "Material", "Color", "Return Policy");
        }

        /*
            tables for each category
         */
        for (StoreItem storeItem : itemList) {
            switch (itemCategory.toLowerCase()) {
                case "food":
                    if (storeItem instanceof FoodItem) {
                        if (storeItem.getBrand() != null)
                            System.out.printf("%-30s%-50s%-10d%-10.2f%-25s%-12s%-30s%n", storeItem.getItemName(), storeItem.getItemDescription(), storeItem.getQuantity(), storeItem.getItemPrice(), storeItem.getBrand(), ((FoodItem) storeItem).getExpirationDate(), storeItem.getReturnPolicy());
                        else
                            System.out.printf("%-30s%-50s%-10d%-10.2f%-25s%-12s%-30s%n", storeItem.getItemName(), storeItem.getItemDescription(), storeItem.getQuantity(), storeItem.getItemPrice(), "not applicable", ((FoodItem) storeItem).getExpirationDate(), storeItem.getReturnPolicy());
                    }
                    break;
                case "electronics":
                    if (storeItem instanceof ElectronicItem) {
                        if (((ElectronicItem) storeItem).requiresBatteries()) {
                            System.out.printf("%-30s%-50s%-10d%-10.2f%-20s%-7s%-20s%-30s%n", storeItem.getItemName(), storeItem.getItemDescription(), storeItem.getQuantity(), storeItem.getItemPrice(), storeItem.getBrand(), storeItem.getColor(), "yes", storeItem.getReturnPolicy());
                        } else {
                            System.out.printf("%-30s%-50s%-10d%-10.2f%-20s%-7s%-20s%-30s%n", storeItem.getItemName(), storeItem.getItemDescription(), storeItem.getQuantity(), storeItem.getItemPrice(), storeItem.getBrand(), storeItem.getColor(), "no", storeItem.getReturnPolicy());
                        }
                    }
                    break;
                case "clothing":
                    if (storeItem instanceof ClothingItem) {
                        if (storeItem instanceof Shoe) {
                            System.out.printf("%-30s%-50s%-10s%-10s%-15s%-10s%-7s%-7s%-20s%-30s%n", storeItem.getItemName(), storeItem.getItemDescription(), storeItem.getQuantity(), storeItem.getItemPrice(), storeItem.getBrand(), ((ClothingItem) storeItem).getMaterial(), storeItem.getColor(), ((ClothingItem) storeItem).getSize(), ((Shoe) storeItem).getShoeType(), storeItem.getReturnPolicy());
                        } else {
                            System.out.printf("%-30s%-50s%-10s%-10s%-15s%-10s%-7s%-7s%-20s%-30s%n", storeItem.getItemName(), storeItem.getItemDescription(), storeItem.getQuantity(), storeItem.getItemPrice(), storeItem.getBrand(), ((ClothingItem) storeItem).getMaterial(), storeItem.getColor(), ((ClothingItem) storeItem).getSize(), "not applicable", storeItem.getReturnPolicy());
                        }

                    }
                    break;
                case "household":
                    if (storeItem instanceof HouseholdItem) {
                        if (storeItem instanceof Furniture) {
                            System.out.printf("%-30s%-50s%-10d%-10.2f%-15s%-10s%-15s%-20s%-30s%n", storeItem.getItemName(), storeItem.getItemDescription(), storeItem.getQuantity(), storeItem.getItemPrice(), storeItem.getBrand(), ((Furniture) storeItem).getModel(), ((Furniture) storeItem).getMaterial(), storeItem.getColor(), storeItem.getReturnPolicy());
                        } else {
                            System.out.printf("%-30s%-50s%-10d%-10.2f%-15s%-10s%-15s%-20s%-30s%n", storeItem.getItemName(), storeItem.getItemDescription(), storeItem.getQuantity(), storeItem.getItemPrice(), storeItem.getBrand(), "", "", storeItem.getColor(), storeItem.getReturnPolicy());
                        }
                    }
                    break;
            }
        }
    }

    /**
     * Prompts the user for input and returns a valid response. If an invalid option is entered
     * this method will recursively call itself until a valid response is provided.
     *
     * @param prompt the message displayed to the user
     * @param validOptions the list of valid responses
     * @return the validated user response
     */
    private static String getResponse(String prompt, String[] validOptions) {
        System.out.println(prompt);
        String response = input.nextLine();
        for (String s : validOptions) {
            if (response.equalsIgnoreCase(s))
                return s;
        }
        return getResponse(prompt, validOptions);
    }


    /**
     * initialize inventory data of type {@link StoreItem} to be added to {@link WQSCainPhamParnellOathout#itemList}
     */
    private static void initializeInventory() {
        Vegetable bakingPotato = new Vegetable("Russet Potato", "Russet potato from Idaho.", .89, FOOD_TAX_RATE, "Idaho Potatoes", null, "Can't accept returns because it's a food item.", 32, null);

        itemList.add(bakingPotato); // inventory test data

        Vegetable bagOFPotatoes = new Vegetable("Russet Potato 5 lb. bag", "5 lb. bag of Russet potatoes from Idaho.", 6.75, FOOD_TAX_RATE, "Idaho Potatoes", null, "Can't accept returns because it's a food item.", 23, null);

        itemList.add(bagOFPotatoes);

        Fruit bunchOfBananas = new Fruit("Bunch of bananas", "5 Organic bananas.", 2.99, FOOD_TAX_RATE, "Chiquita", null, "Can't accept returns because it's a food item.", 16, null);


        itemList.add(bunchOfBananas);

        Furniture chair = new Furniture("Office Chair", "Ergonomic mesh chair", 129.99, TAX_RATE, "ErgoPlus", "Black", "90-day return", 5, "X120", "Mesh");


        itemList.add(chair);

        Shoe runningShoes = new Shoe("Running Shoes", "Lightweight breathable running shoes", 79.99, TAX_RATE, "FleetFeet", "Blue", "30-day return", 20, "10.5", "Mesh", "Running");

        itemList.add(runningShoes);

        Shirt tshirt = new Shirt("Graphic Tee", "Cotton T-shirt with print", 19.99, TAX_RATE, "ComfyWear", "White", "30-day return", 50, "L", "Cotton");

        itemList.add(tshirt);

        Outerwear jacket = new Outerwear("Winter Jacket", "Insulated waterproof jacket", 89.99, TAX_RATE, "NorthWind", "Navy", "60-day return", 15, "M", "Polyester");

        itemList.add(jacket);

        TV smartTV = new TV("Smart TV", "55-inch 4K UHD Smart TV", 499.99, TAX_RATE, "ViewPro", "Black", "30-day return", 8, false);

        itemList.add(smartTV);

        Phone smartphone = new Phone("Smartphone", "5G Android phone with OLED display", 699.99, TAX_RATE, "TechOne", "Silver", "14-day return", 25, true);

        itemList.add(smartphone);

        Laptop gamingLaptop = new Laptop("Gaming Laptop", "High-performance gaming laptop with RTX GPU", 1499.99, TAX_RATE, "MegaByte", "Black", "30-day return", 10, true);

        itemList.add(gamingLaptop);

        ShelfStable pasta = new ShelfStable("Spaghetti", "Dry pasta, 16 oz box", 1.99, FOOD_TAX_RATE, "PastaPerfect", "Yellow", "No returns", 100, "2026-05-15");

        itemList.add(pasta);

        CleaningSupply cleaner = new CleaningSupply("All-Purpose Cleaner", "Multipurpose surface cleaner", 3.49, TAX_RATE, "CleanCo", null, "30-day return", 40);

        itemList.add(cleaner);
    }
}
