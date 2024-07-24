package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Account;

class AccountTest {

    private Account account;

    @BeforeEach
    void init() {
        // Initialize a new Account object before each test
        account = new Account("12345", 100.0); // Starting balance of 100.0
    }

    @Test
    void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001); // Check if balance is updated correctly
    }

    @Test
    void testWithdraw() {
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance(), 0.001); // Check if balance is updated correctly
    }

    @Test
    void testWithdrawInvalidAmount() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-50.0); // Try to withdraw a negative amount
        });

        assertEquals("Invalid withdraw amount or insufficient balance", exception.getMessage());
        assertEquals(100.0, account.getBalance(), 0.001); // Balance should remain unchanged
    }

    @Test
    void testWithdrawInsufficientBalance() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200.0); // Try to withdraw more than the current balance
        });

        assertEquals("Invalid withdraw amount or insufficient balance", exception.getMessage());
        assertEquals(100.0, account.getBalance(), 0.001); // Balance should remain unchanged
    }
}
