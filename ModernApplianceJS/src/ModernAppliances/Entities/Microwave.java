package ModernAppliances.Entities;


import ModernAppliances.Entities.Abstract.Appliance;

public class Microwave extends Appliance {
    // Fields
    private double capacity;
    private char roomType;

    // Constructor
    public Microwave(long itemNumber, String brand, int quantity, double wattage, String color, double price, double capacity, String roomType) {
        super(brand, color, price, wattage, itemNumber, quantity);
        this.capacity = capacity;
        this.roomType = roomType.charAt(0); // Convert the first character of the String to char
    }

    // Getters and Setters
    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public char getRoomType() {
        return roomType;
    }

    public void setRoomType(char roomType) {
        this.roomType = roomType;
    }

    // Overriding toString method
    @Override
    public String toString() {
        String roomTypeDescription = null;

        if (roomType == 'K') {
            roomTypeDescription = "Kitchen";
        } else if (roomType == 'W') {
            roomTypeDescription = "Work Space";
        }

        return super.toString() + "\nCapacity: " + capacity + "\nRoom type: " + roomTypeDescription;
    }
}
