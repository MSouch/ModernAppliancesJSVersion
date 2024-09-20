package ModernAppliances;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        ModernAppliances modernAppliances = new MyModernAppliance();
        ModernAppliances.Options selectedOption = ModernAppliances.Options.None;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Current Directory: " + System.getProperty("user.dir"));

        while (selectedOption != ModernAppliances.Options.SaveExit) {
            modernAppliances.displayMenu();

            try {
                System.out.print("Please select an option: ");
                String userInput = scanner.nextLine();
                int userOption = Integer.parseInt(userInput);

                // Map user option to enum
                selectedOption = getOptionFromInput(userOption);

                // Execute the selected option
                switch (selectedOption) {
                    case Checkout:
                        modernAppliances.checkout();
                        break;
                    case Find:
                        modernAppliances.find();
                        break;
                    case DisplayType:
                        modernAppliances.displayType();
                        break;
                    case RandomList:
                        modernAppliances.randomList();
                        break;
                    case SaveExit:
                        modernAppliances.save();
                        break;
                    default:
                        System.out.println("Invalid option entered. Please try again.");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Exiting program. Goodbye!");
    }

    // Helper method to map user input to enum
    private static ModernAppliances.Options getOptionFromInput(int userOption) {
        switch (userOption) {
            case 1:
                return ModernAppliances.Options.Checkout;
            case 2:
                return ModernAppliances.Options.Find;
            case 3:
                return ModernAppliances.Options.DisplayType;
            case 4:
                return ModernAppliances.Options.RandomList;
            case 5:
                return ModernAppliances.Options.SaveExit;
            default:
                return ModernAppliances.Options.None;
        }
    }
}
