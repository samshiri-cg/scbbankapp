package main;

import java.util.Date;

public class Transaction {
    private int transactionId;
    private Date date;
    private double amount;
    private String type; // credit or debit
    private String description;

    public Transaction(int transactionId, Date date, double amount, String type, String description) {
        this.transactionId = transactionId;
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.description = description;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
