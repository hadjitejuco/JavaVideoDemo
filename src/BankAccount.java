public class BankAccount {
    private String accountId;
    private String accountName;
    private double balance;

    public BankAccount(String accountId, String accountName, double initialBalance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.balance = initialBalance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }

    // Get account details
    public String getAccountDetails() {
        return "Account ID: " + accountId + ", Name: " + accountName + ", Balance: $" + balance;
    }
}
