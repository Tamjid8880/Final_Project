import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account added successfully!");
    }

    public BankAccount findAccount(String accountNumber, String accountPin) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.getAccountPin().equals(accountPin)) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found!");
    }

    public void performTransactions(BankAccount account) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Choose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Pay Bill");
            System.out.println("5. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Balance: $" + account.getBalance());
                    break;
                case 4:
                    if (account instanceof RegularAccount) {
                        System.out.println("Bill payment options:");
                        System.out.println("1. Utility Bill");
                        System.out.println("2. Rent");
                        System.out.println("3. Education Fee");
                        int billChoice = scanner.nextInt();

                        switch (billChoice) {
                            case 1:
                                System.out.print("Enter the utility bill amount: $");
                                double utilityBillAmount = scanner.nextDouble();
                                account.withdraw(utilityBillAmount);
                                System.out.println("Utility bill paid successfully!");
                                break;
                            case 2:
                                System.out.print("Enter the rent amount: $");
                                double rentAmount = scanner.nextDouble();
                                account.withdraw(rentAmount);
                                System.out.println("Rent paid successfully!");
                                break;
                            case 3:
                                System.out.print("Enter the education fee amount: $");
                                double educationFeeAmount = scanner.nextDouble();
                                account.withdraw(educationFeeAmount);
                                System.out.println("Education fee paid successfully!");
                                break;
                            default:
                                System.out.println("Invalid choice!");
                        }
                    } else {
                        System.out.println("This option is not available for this account type!");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    public void saveAccountDetails(BankAccount account) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("account_details.txt", true))) {
            writer.write("Account Number: " + account.getAccountNumber());
            writer.newLine();
            writer.write("Account Pin: " + account.getAccountPin());
            writer.newLine();

            if (account instanceof RegularAccount) {
                RegularAccount regularAccount = (RegularAccount) account;
                writer.write("Account Type: Regular Account");
                writer.newLine();
                writer.write("Name: " + regularAccount.getName());
                writer.newLine();
                writer.write("Phone No: " + regularAccount.getPhoneNo());
                writer.newLine();
            } else if (account instanceof StudentAccount) {
                StudentAccount studentAccount = (StudentAccount) account;
                writer.write("Account Type: Student Account");
                writer.newLine();
                writer.write("Student ID: " + studentAccount.getStudentId());
                writer.newLine();
                writer.write("Phone No: " + studentAccount.getPhoneNo());
                writer.newLine();
                writer.write("Student Email: " + studentAccount.getStudentEmail());
                writer.newLine();
            } else if (account instanceof SavingsAccount) {
                writer.write("Account Type: Savings Account");
                writer.newLine();
                SavingsAccount savingsAccount = (SavingsAccount) account;
                writer.write("Name: " + savingsAccount.getName());
                writer.newLine();
                writer.write("Phone No: " + savingsAccount.getPhoneNo());
                writer.newLine();
            } else if (account instanceof BusinessAccount) {
                BusinessAccount businessAccount = (BusinessAccount) account;
                writer.write("Account Type: Business Account");
                writer.newLine();
                writer.write("Brand Name: " + businessAccount.getBrandName());
                writer.newLine();
                writer.write("Phone No: " + businessAccount.getPhoneNo());
                writer.newLine();
                writer.write("License No: " + businessAccount.getLicenseNo());
                writer.newLine();
            }

            writer.newLine();
            writer.flush();
            System.out.println("Account details saved successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred while saving account details!");
        }
    }
}

