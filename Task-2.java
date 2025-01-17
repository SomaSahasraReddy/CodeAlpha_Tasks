import java.util.Scanner;

public class SimpleBankingApp {
    private double balance;

    public SimpleBankingApp() {
        this.balance = 0.0; // Initial balance is set to 0
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited: $%.2f%n", amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew: $%.2f%n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds for this withdrawal.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.printf("Current balance: $%.2f%n", balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleBankingApp bankApp = new SimpleBankingApp();
        int choice;

        do {
            System.out.println("\n--- Simple Banking Application ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankApp.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankApp.withdraw(withdrawAmount);
                    break;
                case 3:
                    bankApp.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting the application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}