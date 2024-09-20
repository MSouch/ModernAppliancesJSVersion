package ModernAppliances.Entities.Abstract;

import java.util.List;

public abstract class Appliance {
    // Fields
    private long itemNumber;
    private String brand;
    private int quantity;
    private double wattage;
    private String color;
    private double price;

    // Constructor
    public Appliance(String brand, String color, double price, double wattage, long itemNumber, int quantity) {
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.wattage = wattage;
        this.itemNumber = itemNumber;
        this.quantity = quantity;
    }

    // Getters and Setters
    public long getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(long itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // IsAvailable property equivalent
    public boolean isAvailable() {
        return quantity > 0;
    }

    // ToString method override
    @Override
    public String toString() {
        return String.format("Item Number: %d%nBrand: %s%nQuantity: %d%nWattage: %.2f%nColor: %s%nPrice: %.2f", 
                              itemNumber, brand, quantity, wattage, color, price);
    }

    // Method to print appliances list
    public void printApplianceList(List<Appliance> applianceList) {
        for (Appliance appliance : applianceList) {
            System.out.println("Brand: " + appliance.getBrand());
            System.out.println("Color: " + appliance.getColor());
            System.out.println("Price: " + appliance.getPrice());
            System.out.println("Wattage: " + appliance.getWattage());
            System.out.println("ItemNumber: " + appliance.getItemNumber());
            System.out.println("Quantity: " + appliance.getQuantity());
        }
    }

    // Enum for ApplianceTypes
    public enum ApplianceTypes {
        UNKNOWN,
        REFRIGERATOR,
        VACUUM,
        MICROWAVE,
        DISHWASHER
    }

    // Method to determine appliance type based on item number
    public ApplianceTypes getType() {
        return determineApplianceTypeFromItemNumber(this.itemNumber);
    }

    public static ApplianceTypes determineApplianceTypeFromItemNumber(long itemNumber) {
        String firstDigitStr = Long.toString(itemNumber).substring(0, 1);
        int firstDigit = Integer.parseInt(firstDigitStr);

        switch (firstDigit) {
            case 1: return ApplianceTypes.REFRIGERATOR;
            case 2: return ApplianceTypes.VACUUM;
            case 3: return ApplianceTypes.MICROWAVE;
            case 4:
            case 5: return ApplianceTypes.DISHWASHER;
            default: return ApplianceTypes.UNKNOWN;
        }
    }

    // Method to format appliance details for a file
    public String formatForFile() {
        return String.join(";", Long.toString(itemNumber), brand, Integer.toString(quantity), Double.toString(wattage), color, Double.toString(price));
    }

    // Checkout method
    public void checkout() {
        this.quantity--;
    }
}
