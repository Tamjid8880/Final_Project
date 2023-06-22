import java.util.Scanner;

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("Welcome to DIU Bank!");

        int choice;
        do {
            System.out.println("Choose an account type to create:");
            System.out.println("1. Regular Account");
            System.out.println("2. Student Account");
            System.out.println("3. Savings Account");
            System.out.println("4. Business Account");
            System.out.println("5. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String regularName = scanner.next();
                    System.out.print("Enter your phone number: ");
                    String regularPhoneNo = scanner.next();
                    System.out.print("Enter your PIN: ");
                    String regularPin = scanner.next();
                    System.out.print("Enter the initial deposit amount: $");
                    double regularDepositAmount = scanner.nextDouble();

                    RegularAccount regularAccount = new RegularAccount(generateAccountNumber(), regularPin, regularName, regularPhoneNo, regularDepositAmount);
                    bank.addAccount(regularAccount);
                    bank.saveAccountDetails(regularAccount);
                    bank.performTransactions(regularAccount);
                    break;
                case 2:
                    System.out.print("Enter your student ID: ");
                    String studentId = scanner.next();
                    System.out.print("Enter your phone number: ");
                    String studentPhoneNo = scanner.next();
                    System.out.print("Enter your student email: ");
                    String studentEmail = scanner.next();
                    System.out.print("Enter your PIN: ");
                    String studentPin = scanner.next();
                    System.out.print("Enter the initial deposit amount: $");
                    double studentDepositAmount = scanner.nextDouble();

                    StudentAccount studentAccount = new StudentAccount(generateAccountNumber(), studentPin, studentId, studentPhoneNo, studentEmail, studentDepositAmount);
                    bank.addAccount(studentAccount);
                    bank.saveAccountDetails(studentAccount);
                    bank.performTransactions(studentAccount);
                    break;
                case 3:
                    System.out.print("Enter your name: ");
                    String savingsName = scanner.next();
                    System.out.print("Enter your phone number: ");
                    String savingsPhoneNo = scanner.next();
                    System.out.print("Enter your PIN: ");
                    String savingsPin = scanner.next();
                    System.out.print("Enter the initial deposit amount: $");
                    double savingsDepositAmount = scanner.nextDouble();

                    SavingsAccount savingsAccount = new SavingsAccount(generateAccountNumber(), savingsPin, savingsName, savingsPhoneNo, savingsDepositAmount);
                    bank.addAccount(savingsAccount);
                    bank.saveAccountDetails(savingsAccount);
                    bank.performTransactions(savingsAccount);
                    break;
                case 4:
                    System.out.print("Enter your brand name: ");
                    String brandName = scanner.next();
                    System.out.print("Enter your phone number: ");
                    String businessPhoneNo = scanner.next();
                    System.out.print("Enter your license number: ");
                    String licenseNo = scanner.next();
                    System.out.print("Enter your PIN: ");
                    String businessPin = scanner.next();
                    System.out.print("Enter the initial deposit amount: $");
                    double businessDepositAmount = scanner.nextDouble();

                    BusinessAccount businessAccount = new BusinessAccount(generateAccountNumber(), businessPin, brandName, businessPhoneNo, licenseNo, businessDepositAmount);
                    bank.addAccount(businessAccount);
                    bank.saveAccountDetails(businessAccount);
                    bank.performTransactions(businessAccount);
                    break;
                case 5:
                    System.out.println("Thank you for using DIU Bank!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    public static String generateAccountNumber() {
        // Generate a random account number (you can modify this based on your requirements)
        return "ACC" + System.currentTimeMillis();
    }
}