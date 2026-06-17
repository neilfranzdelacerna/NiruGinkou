package javaexercise;


import java.util.List;
import java.util.ArrayList;

public class BankAccount {
    /**
     * Holds the current balance of the account.
     */
    private double balance;
    /**
     * Holds the status of the account. If true, the account is frozen
     */
    private boolean isFrozen;
    /**
     * Holds the transaction history of the account.
     */
    private List<Transaction> transactionHistory;

    /**
     * Initializes a new BankAccount with a
     * balance of 0 and an empty transaction history.
     * The account is not frozen by default.
     */
    public BankAccount() {
        balance = 0.0;
        isFrozen = false;
        transactionHistory = new ArrayList<>();
    }

    /**
     * Deposits the specified amount into the account.
     * @param amount
     */
    public void deposit(final double amount) {
        try {
            if (isFrozen) {
                throw new AccountFrozenException("Account is FROZEN. "
                        + "Unable to transact.");
            }
            if (amount <= 0) {
                throw new InvalidAmountException("Invalid amount. "
                        + "Must be greater than 0.");
            }

            //amount = Math.round(amount * 100.0) / 100.0;
            //balance = Math.round((balance + amount) * 100.0) / 100.0;

            transactionHistory.add(new Transaction("Deposit", amount));
        } catch (AccountFrozenException | InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Withdraws the specified amount from the account.
     * @param amount
     */
    public void withdraw(final double amount) {
        try {
            if (isFrozen) {
                throw new AccountFrozenException(
                        "Account is FROZEN. Unable to transact.");
            }
            if (amount <= 0) {
                throw new InvalidAmountException(
                        "Invalid amount. Must be greater than 0.");
            }
            if (amount > balance) {
                throw new InvalidAmountException(
                        "Insufficient funds. Current balance: " + balance);
            }

            //amount = Math.round(amount * 100.0) / 100.0;
            //balance = Math.round((balance - amount) * 100.0) / 100.0;
            transactionHistory.add(new Transaction("Deposit", amount));
        } catch (AccountFrozenException | InvalidAmountException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    /**
     * gets transaction history of the account.
     * @return returns the transaction history of the account.
     */
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    /**
     * Returns the current balance of the account.
     * @return the current balance of the account.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Freezes the account, preventing any transactions
     * from being made until it is unfrozen.
     */
    public void freezeAccount() {
        isFrozen = true;
    }

    /**
     * Unfreezes the account, allowing transactions to be made again.
     */
    public void unfreezeAccount() {
        isFrozen = false;
    }

    /**
     * Returns whether the account is currently frozen.
     * @return true if the account is frozen, false otherwise.
     */
    public boolean isFrozen() {
        return isFrozen;
    }
}
