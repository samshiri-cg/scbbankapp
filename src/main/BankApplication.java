package main;

public class BankApplication {
    public static void main(String[] args) {
        // Create customers and accounts
        Customer customer1 = new Customer(1, "siri", "123 Main St");
        Account account1 = new Account(101, customer1);

        // Deposit example
        account1.deposit(1000);

        // Withdraw example
        account1.withdraw(500);

        // Transfer example
        Customer customer2 = new Customer(2, "chandu", "456 SRIBAL St");
        Account account2 = new Account(102, customer2);
        account2.deposit(500);
        account1.transfer(200, account2);

        // Show balance
        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());

        // Display last 10 transactions
        System.out.println("Last 10 transactions for Account 1:");
        for (Transaction transaction : account1.getLast10Transactions()) {
            System.out.println(transaction.getTransactionId() + ": " + transaction.getAmount() + " " + transaction.getType() + " " + transaction.getDescription());
        }
    }
}
