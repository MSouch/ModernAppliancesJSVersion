package ModernAppliances.Entities;

import ModernAppliances.Entities.Abstract.Appliance;

public class Dishwasher extends Appliance {
    // Fields
    private String soundRatings;
    private String feature;

    // Constructor
    public Dishwasher(long itemNumber, String brand, int quantity, double wattage, String color, double price, String feature, String soundRating) {
        super(brand, color, price, wattage, itemNumber, quantity);
        this.soundRatings = soundRating;
        this.feature = feature;
    }

    // Getters and Setters
    public String getSoundRatings() {
        return soundRatings;
    }

    public void setSoundRatings(String soundRatings) {
        this.soundRatings = soundRatings;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    // Overriding toString method
    @Override
    public String toString() {
        // Replace soundRatings string values with their descriptions
        switch (soundRatings) {
            case "Qt":
                soundRatings = "Quietest";
                break;
            case "Qr":
                soundRatings = "Quieter";
                break;
            case "Qu":
                soundRatings = "Quiet";
                break;
            case "M":
                soundRatings = "Moderate";
                break;
        }

        return super.toString() + "\nSound Rating: " + soundRatings + "\nFeature: " + feature;
    }
}
