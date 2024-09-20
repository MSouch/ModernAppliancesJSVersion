package ModernAppliances.Entities;

import ModernAppliances.Entities.Abstract.Appliance;

public class Vacuum extends Appliance {
    /* Vacuums have an Item Number, Brand, Quantity, Wattage, Color, Price, Grade, and Battery Voltage. */

    private String grade;
    private double voltage;

    // Constructor
    public Vacuum(long itemNumber, String brand, int quantity, double wattage, String color, double price, String grade, double voltage) {
        super(brand, color, price, wattage, itemNumber, quantity);
        this.grade = grade;
        this.voltage = voltage;
    }

    // Getter and Setter for Grade
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Getter and Setter for Voltage
    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    // Overriding toString method
    @Override
    public String toString() {
        return super.toString() + "\nGrade: " + grade + "\nVoltage: " + voltage + "V";
    }
}
