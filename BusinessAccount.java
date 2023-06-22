class BusinessAccount implements BankAccount {
    private String accountNumber;
    private String accountPin;
    private String brandName;
    private String phoneNo;
    private String licenseNo;
    private double balance;

    public BusinessAccount(String accountNumber, String accountPin, String brandName, String phoneNo, String licenseNo, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountPin = accountPin;
        this.brandName = brandName;
        this.phoneNo = phoneNo;
        this.licenseNo = licenseNo;
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

    public String getBrandName() {
        return brandName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getLicenseNo() {
        return licenseNo;
    }
}
