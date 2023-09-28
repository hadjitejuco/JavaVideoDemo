import java.util.Scanner;

public class BankSystem {

    // Transaction class definition
    static class Transaction {
        private String type;
        private double amount;
        private String description;

        public Transaction(String type, double amount, String description) {
            this.type = type;
            this.amount = amount;
            this.description = description;
        }

        @Override
        public String toString() {
            return "Type: " + type + ", Amount: $" + amount + ", Description: " + description;
        }
    }

    // Base BankAccount class definition
    static class BankAccount {
        private double balance;
        private Transaction[] transactions;
        private int transactionCount;

        public BankAccount(int capacity) {
            transactions = new Transaction[capacity];
            transactionCount = 0;
        }

        public void deposit(double amount, String description) {
            balance += amount;
            addTransaction(new Transaction("Deposit", amount, description));
        }

        public void withdraw(double amount, String description) {
            if (amount <= balance) {
                balance -= amount;
                addTransaction(new Transaction("Withdraw", amount, description));
            } else {
                System.out.println("Insufficient funds");
            }
        }

        private void addTransaction(Transaction transaction) {
            if (transactionCount < transactions.length) {
                transactions[transactionCount++] = transaction;
            } else {
                System.out.println("Transaction history capacity reached. Can't add more transactions.");
            }
        }

        public double checkBalance() {
            return balance;
        }

        public void displayTransactions() {
            for (int i = 0; i < transactionCount; i++) {
                System.out.println((i + 1) + ". " + transactions[i].toString());
            }
        }
    }

    // SavingsAccount class that inherits from BankAccount
    static class SavingsAccount extends BankAccount {
        private double interestRate;

        public SavingsAccount(int capacity, double interestRate) {
            super(capacity);
            this.interestRate = interestRate;
        }

        public void addInterest() {
            double interest = checkBalance() * interestRate;
            deposit(interest, "Interest Payment");
        }
    }

    // CheckingAccount class that inherits from BankAccount
    static class CheckingAccount extends BankAccount {
        private double overdraftLimit;

        public CheckingAccount(int capacity, double overdraftLimit) {
            super(capacity);
            this.overdraftLimit = overdraftLimit;
        }

        @Override
        public void withdraw(double amount, String description) {
            if (amount <= checkBalance() + overdraftLimit) {
                super.withdraw(amount, description);
            } else {
                System.out.println("Exceeds overdraft limit.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new SavingsAccount(100, 0.05); // Here, using SavingsAccount just as an example.

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            if(account instanceof SavingsAccount) {
                System.out.println("3. Add Interest");
            }
            System.out.println("4. Check Balance");
            System.out.println("5. Display Transactions");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter description: ");
                    String depositDescription = scanner.nextLine();
                    account.deposit(depositAmount, depositDescription);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter description: ");
                    String withdrawalDescription = scanner.nextLine();
                    account.withdraw(withdrawalAmount, withdrawalDescription);
                    break;
                case 3:
                    if(account instanceof SavingsAccount) {
                        ((SavingsAccount)account).addInterest();
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;
                case 4:
                    System.out.println("Current balance: $" + account.checkBalance());
                    break;
                case 5:
                    account.displayTransactions();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
