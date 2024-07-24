package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private int accountId;
    private Customer customer;
    private double balance;
    private List<Transaction> transactions;

    public Account(int accountId, Customer customer) {
        this.accountId = accountId;
        this.customer = customer;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public Account(String string, double d) {
		// TODO Auto-generated constructor stub
	}

	public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction(transactions.size() + 1, new Date(), amount, "Credit", "Deposit"));
        } else {
            System.out.println("Deposit amount should be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                transactions.add(new Transaction(transactions.size() + 1, new Date(), amount, "Debit", "Withdrawal"));
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Withdrawal amount should be greater than zero.");
        }
    }

    public void transfer(double amount, Account targetAccount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                targetAccount.deposit(amount);
                transactions.add(new Transaction(transactions.size() + 1, new Date(), amount, "Debit", "Transfer to " + targetAccount.customer.getName()));
            } else {
                System.out.println("Insufficient balance for transfer.");
            }
        } else {
            System.out.println("Transfer amount should be greater than zero.");
        }
    }

    public List<Transaction> getLast10Transactions() {
        int start = Math.max(transactions.size() - 10, 0);
        return transactions.subList(start, transactions.size());
    }

}
