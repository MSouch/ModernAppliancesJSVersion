package ModernAppliances;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ModernAppliances modernAppliances = new MyModernAppliance();
        ModernAppliances.Options option = ModernAppliances.Options.None;

        Scanner scanner = new Scanner(System.in);

        System.out.println(System.getProperty("user.dir"));
        
        while (option != ModernAppliances.Options.SaveExit) {
            modernAppliances.displayMenu();

            try {
                String userInput = scanner.nextLine();
                int userOption = Integer.parseInt(userInput); // Convert input to integer

                // Map user option to enum value
                switch (userOption) {
                    case 1:
                        option = ModernAppliances.Options.Checkout;
                        modernAppliances.checkout();
                        break;
                    case 2:
                        option = ModernAppliances.Options.Find;
                        modernAppliances.find();
                        break;
                    case 3:
                        option = ModernAppliances.Options.DisplayType;
                        modernAppliances.displayType();
                        break;
                    case 4:
                        option = ModernAppliances.Options.RandomList;
                        modernAppliances.randomList();
                        break;
                    case 5:
                        option = ModernAppliances.Options.SaveExit;
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
    }
}
