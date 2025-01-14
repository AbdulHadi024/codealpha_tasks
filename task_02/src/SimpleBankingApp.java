import java.util.Scanner;

public class SimpleBankingApp {

    // Declare variables for account balance and other necessary information
    private static double balance = 0.0; // Initial balance
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        // Display the menu and perform actions based on user input
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character after the integer input

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting the application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 4);
    }

    // Method to display the main menu
    public static void displayMenu() {
        System.out.println("\n***** Simple Banking Application *****");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Please choose an option (1-4): ");
    }

    // Method to handle deposits
    public static void deposit() {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to handle withdrawals
    public static void withdraw() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn successfully.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance for this withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check the account balance
    public static void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }
}
