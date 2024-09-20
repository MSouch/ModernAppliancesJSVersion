package ModernAppliances;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import ModernAppliances.Entities.Dishwasher;
import ModernAppliances.Entities.Microwave;
import ModernAppliances.Entities.Refrigerator;
import ModernAppliances.Entities.Vacuum;
import ModernAppliances.Entities.Abstract.Appliance;

public class MyModernAppliance extends ModernAppliances {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void checkout() {
        // Prompt the user to enter the item number
        System.out.println("Enter the item number of an appliance: ");
        long itemNumber;
        String itemNumberInput = scanner.nextLine();
        // Parse the input string to a long
        try {
            itemNumber = Long.parseLong(itemNumberInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        Appliance foundAppliance = null;
        // Search through the list of appliances
        for (Appliance a : appliances) {
            if (a.getItemNumber() == itemNumber) {
                foundAppliance = a;
                break;
            }
        }

        // Check if the appliance was found and is available
        if (foundAppliance == null) {
            System.out.println("No appliances found with that item number.\n");
        } else if (foundAppliance.isAvailable()) {
            foundAppliance.checkout();
            System.out.println("Appliance has been checked out.\n");
        } else {
            System.out.println("The appliance is not available to be checked out.\n");
        }
    }

    @Override
    public void find() {
        // Prompt the user to enter a brand
        System.out.println("Enter brand to search for:");
        String brand = scanner.nextLine();

        List<Appliance> foundAppliances = new ArrayList<>();
        // Search for appliances by brand
        for (Appliance a : appliances) {
            if (a.getBrand().equalsIgnoreCase(brand)) {
                foundAppliances.add(a);
            }
        }

        displayAppliancesFromList(foundAppliances, 0);
    }

    @Override
    public void displayRefrigerators() {
        System.out.println("Possible options:");
        System.out.println("0 - Any");
        System.out.println("2 - Double doors");
        System.out.println("3 - Three doors");
        System.out.println("4 - Four doors");

        System.out.print("Enter number of doors: ");
        int nDoors;
        try {
            nDoors = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        List<Appliance> foundAppliances = new ArrayList<>();
        // Filter appliances by refrigerator and number of doors
        for (Appliance a : appliances) {
            if (a instanceof Refrigerator) {
                Refrigerator refrigerator = (Refrigerator) a;
                if (nDoors == 0 || refrigerator.getNumDoors() == nDoors) {
                    foundAppliances.add(refrigerator);
                }
            }
        }

        displayAppliancesFromList(foundAppliances, 0);
    }

    @Override
    public void displayVacuums() {
        System.out.println("Possible options:");
        System.out.println("0 - Any");
        System.out.println("1 - Residential");
        System.out.println("2 - Commercial");

        System.out.print("Enter grade: ");
        String gradeInput = scanner.nextLine();
        String grade;
        switch (gradeInput) {
            case "0":
                grade = "Any";
                break;
            case "1":
                grade = "Residential";
                break;
            case "2":
                grade = "Commercial";
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }

        System.out.println("Possible options:");
        System.out.println("0 - Any");
        System.out.println("1 - 18 Volt");
        System.out.println("2 - 24 Volt");

        System.out.print("Enter voltage: ");
        short voltage;
        try {
            String voltageInput = scanner.nextLine();
            switch (voltageInput) {
                case "0":
                    voltage = 0;
                    break;
                case "1":
                    voltage = 18;
                    break;
                case "2":
                    voltage = 24;
                    break;
                default:
                    System.out.println("Invalid option.");
                    return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        List<Appliance> foundAppliances = new ArrayList<>();
        for (Appliance a : appliances) {
            if (a instanceof Vacuum) {
                Vacuum vacuum = (Vacuum) a;
                if ((grade.equals("Any") || vacuum.getGrade().equalsIgnoreCase(grade)) &&
                        (voltage == 0 || vacuum.getVoltage() == voltage)) {
                    foundAppliances.add(vacuum);
                }
            }
        }

        displayAppliancesFromList(foundAppliances, 0);
    }

    @Override
    public void displayMicrowaves() {
        System.out.println("Possible options:");
        System.out.println("0 - Any");
        System.out.println("1 - Kitchen");
        System.out.println("2 - Work site");

        System.out.print("Enter room type: ");
        String roomTypeInput = scanner.nextLine();
        char roomType;
        switch (roomTypeInput) {
            case "0":
                roomType = 'A';
                break;
            case "1":
                roomType = 'K';
                break;
            case "2":
                roomType = 'W';
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }

        List<Appliance> foundAppliances = new ArrayList<>();
        for (Appliance a : appliances) {
            if (a instanceof Microwave) {
                Microwave microwave = (Microwave) a;
                if (roomType == 'A' || microwave.getRoomType() == roomType) {
                    foundAppliances.add(microwave);
                }
            }
        }

        displayAppliancesFromList(foundAppliances, 0);
    }

    @Override
    public void displayDishwashers() {
        System.out.println("Possible options:");
        System.out.println("0 - Any");
        System.out.println("1 - Quietest");
        System.out.println("2 - Quieter");
        System.out.println("3 - Quiet");
        System.out.println("4 - Moderate");

        System.out.print("Enter sound rating: ");
        String soundRatingInput = scanner.nextLine();
        String soundRating;
        switch (soundRatingInput) {
            case "0":
                soundRating = "Any";
                break;
            case "1":
                soundRating = "Qt";
                break;
            case "2":
                soundRating = "Qr";
                break;
            case "3":
                soundRating = "Qu";
                break;
            case "4":
                soundRating = "M";
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }

        List<Appliance> foundAppliances = new ArrayList<>();
        for (Appliance a : appliances) {
            if (a instanceof Dishwasher) {
                Dishwasher dishwasher = (Dishwasher) a;
                if (soundRating.equals("Any") || dishwasher.getSoundRatings().equalsIgnoreCase(soundRating)) {
                    foundAppliances.add(dishwasher);
                }
            }
        }

        displayAppliancesFromList(foundAppliances, 0);
    }

    @Override
    public void randomList() {
        System.out.println("Appliance Types");
        System.out.println("0 - Any");
        System.out.println("1 – Refrigerators");
        System.out.println("2 – Vacuums");
        System.out.println("3 – Microwaves");
        System.out.println("4 – Dishwashers");
        System.out.print("Enter type of appliance: ");
        String typeInput = scanner.nextLine();

        if (!typeInput.matches("[0-4]")) {
            System.out.println("Invalid input.");
            return;
        }

        System.out.print("Enter number of appliances: ");
        String numberInput = scanner.nextLine();
        int appliancesNumber;
        try {
            appliancesNumber = Integer.parseInt(numberInput);
            if (appliancesNumber <= 0) {
                System.out.println("Invalid input.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        List<Appliance> found = new ArrayList<>();
        for (Appliance a : appliances) {
            if (typeInput.equals("0") ||
                    (typeInput.equals("1") && a instanceof Refrigerator) ||
                    (typeInput.equals("2") && a instanceof Vacuum) ||
                    (typeInput.equals("3") && a instanceof Microwave) ||
                    (typeInput.equals("4") && a instanceof Dishwasher)) {
                found.add(a);
            }
        }

        // Shuffle the list of appliances
        found.sort((Comparator<? super Appliance>) new RandomComparer());

        // Display appliances
        displayAppliancesFromList(found, appliancesNumber);
    }

}
