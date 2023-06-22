class RegularAccount implements BankAccount {
    private String accountNumber;
    private String accountPin;
    private String name;
    private String phoneNo;
    private double balance;

    public RegularAccount(String accountNumber, String accountPin, String name, String phoneNo, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountPin = accountPin;
        this.name = name;
        this.phoneNo = phoneNo;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountPin() {
        return accountPin;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
