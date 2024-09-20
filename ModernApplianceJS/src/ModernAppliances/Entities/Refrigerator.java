package ModernAppliances.Entities;

import ModernAppliances.Entities.Abstract.Appliance;

public class Refrigerator extends Appliance {
    // Fields
    private int numDoors;
    private double height;
    private double width;

    // Constructor
    public Refrigerator(long itemNumber, String brand, int quantity, double wattage, String color, double price, int numDoors, double height, double width) {
        super(brand, color, price, wattage, itemNumber, quantity); // Call the constructor of the parent class
        this.numDoors = numDoors;
        this.height = height;
        this.width = width;
    }

    // Getters and Setters
    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Overriding toString method
    @Override
    public String toString() {
        return super.toString() + "\nNumber of Doors: " + numDoors + "\nHeight: " + height + " inches\nWidth: " + width + " inches";
    }
}
