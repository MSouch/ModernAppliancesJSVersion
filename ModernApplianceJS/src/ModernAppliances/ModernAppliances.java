package ModernAppliances;

import ModernAppliances.Entities.*;
import ModernAppliances.Entities.Abstract.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public abstract class ModernAppliances {

	public static final String APPLIANCES_TEXT_FILE = "src/ModernAppliances/appliances.txt";

    public enum Options {
        None,
        Checkout,
        Find,
        DisplayType,
        RandomList,
        SaveExit
    }

    protected List<Appliance> appliances;

    // Getter for appliances list
    public List<Appliance> getAppliances() {
        return new ArrayList<>(appliances);
    }

    // Constructor
    public ModernAppliances() {
        this.appliances = this.readAppliances();
    }

    // Method to display menu
    public void displayMenu() {
        System.out.println("Welcome to Modern Appliances!");
        System.out.println("How May We Assist You?");
        System.out.println("1 – Check out appliance");
        System.out.println("2 – Find appliances by brand");
        System.out.println("3 – Display appliances by type");
        System.out.println("4 – Produce random appliance list");
        System.out.println("5 – Save & exit");
    }

    // Abstract methods
    public abstract void checkout();
    public abstract void find();
    public abstract void displayRefrigerators();
    public abstract void displayVacuums();
    public abstract void displayMicrowaves();
    public abstract void displayDishwashers();
    public abstract void randomList();

    // Method to display appliances by type
    public void displayType() {
        System.out.println("Appliance Types");
        System.out.println("1 – Refrigerators");
        System.out.println("2 – Vacuums");
        System.out.println("3 – Microwaves");
        System.out.println("4 – Dishwashers");

        System.out.print("Enter type of appliance: ");
        Scanner scanner = new Scanner(System.in);

        try {
            int applianceTypeNum = Integer.parseInt(scanner.nextLine());

            if (applianceTypeNum < 1 || applianceTypeNum > 4) {
                System.out.println("Invalid appliance type entered.");
                return;
            }

            switch (applianceTypeNum) {
                case 1:
                    this.displayRefrigerators();
                    break;
                case 2:
                    this.displayVacuums();
                    break;
                case 3:
                    this.displayMicrowaves();
                    break;
                case 4:
                    this.displayDishwashers();
                    break;
                default:
                    System.out.println("Invalid appliance type entered.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    // Method to save appliances to a file
    public void save() {
        System.out.print("Saving... ");

        try (BufferedWriter fileStream = new BufferedWriter(new FileWriter(APPLIANCES_TEXT_FILE))) {
            for (Appliance appliance : appliances) {
                fileStream.write(appliance.formatForFile());
                fileStream.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("DONE!");
    }

    // Method to read appliances from a file
    private List<Appliance> readAppliances() {
        List<Appliance> appliances = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(APPLIANCES_TEXT_FILE));

            for (String line : lines) {
                Appliance appliance = this.createApplianceFromLine(line);
                if (appliance != null) {
                    appliances.add(appliance);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return appliances;
    }

    // Method to create an appliance object from a line in the file
    private Appliance createApplianceFromLine(String line) {
        String[] parts = line.split(";");
        String firstDigitStr = line.substring(0, 1);
        short firstDigit = Short.parseShort(firstDigitStr);

        Appliance appliance = null;
        switch (firstDigit) {
            case 1:
                appliance = createRefrigeratorFromParts(parts);
                break;
            case 2:
                appliance = createVacuumFromParts(parts);
                break;
            case 3:
                appliance = createMicrowaveFromParts(parts);
                break;
            case 4:
            case 5:
                appliance = createDishwasherFromParts(parts);
                break;
        }

        return appliance;
    }

    // Methods to create specific appliance types from parts
    private Refrigerator createRefrigeratorFromParts(String[] parts) {
        if (parts.length != 9) return null;

        long itemNumber = Long.parseLong(parts[0]);
        String brand = parts[1];
        int quantity = Integer.parseInt(parts[2]);
        double wattage = Double.parseDouble(parts[3]);
        String color = parts[4];
        double price = Double.parseDouble(parts[5]);
        short doors = Short.parseShort(parts[6]);
        int width = Integer.parseInt(parts[7]);
        int height = Integer.parseInt(parts[8]);

        return new Refrigerator(itemNumber, brand, quantity, wattage, color, price, doors, width, height);
    }

    private Vacuum createVacuumFromParts(String[] parts) {
        if (parts.length != 8) return null;

        long itemNumber = Long.parseLong(parts[0]);
        String brand = parts[1];
        int quantity = Integer.parseInt(parts[2]);
        double wattage = Double.parseDouble(parts[3]);
        String color = parts[4];
        double price = Double.parseDouble(parts[5]);
        String grade = parts[6];
        short batteryVoltage = Short.parseShort(parts[7]);

        return new Vacuum(itemNumber, brand, quantity, wattage, color, price, grade, batteryVoltage);
    }

    private Microwave createMicrowaveFromParts(String[] parts) {
        if (parts.length != 8) return null;

        long itemNumber = Long.parseLong(parts[0]);
        String brand = parts[1];
        int quantity = Integer.parseInt(parts[2]);
        double wattage = Double.parseDouble(parts[3]);
        String color = parts[4];
        double price = Double.parseDouble(parts[5]);
        float capacity = Float.parseFloat(parts[6]);
        String roomType = parts[7];

        return new Microwave(itemNumber, brand, quantity, wattage, color, price, capacity, roomType);
    }

    private Dishwasher createDishwasherFromParts(String[] parts) {
        if (parts.length != 8) return null;

        long itemNumber = Long.parseLong(parts[0]);
        String brand = parts[1];
        int quantity = Integer.parseInt(parts[2]);
        double wattage = Double.parseDouble(parts[3]);
        String color = parts[4];
        double price = Double.parseDouble(parts[5]);
        String feature = parts[6];
        String soundRating = parts[7];

        return new Dishwasher(itemNumber, brand, quantity, wattage, color, price, feature, soundRating);
    }

    // Method to display a list of appliances
    public void displayAppliancesFromList(List<Appliance> appliances, int max) {
        if (appliances.size() > 0) {
            System.out.println("Found appliances:");
            System.out.println();

            for (int i = 0; i < appliances.size() && (max == 0 || i < max); i++) {
                Appliance appliance = appliances.get(i);
                System.out.println(appliance);
                System.out.println();
            }
        } else {
            System.out.println("No appliances found.");
        }

        System.out.println();
    }
}
