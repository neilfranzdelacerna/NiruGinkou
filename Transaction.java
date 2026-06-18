package javaexercise;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    /**
     * The type of transaction (e.g., "Deposit" or "Withdrawal").
     */
    private String type;
    /**
     * The amount of the transaction.
     */
    private double amount;
    /**
     * The timestamp of the transaction.
     */
    private LocalDateTime timeStamp;

    /**
     * Constructor for Transaction that initializes the type, amount, and
     * timestamp fields.
     *
     * @param theType
     * @param theAmount
     */
    public Transaction(final String theType, final double theAmount) {
        this.type = theType;
        this.setAmount(amount);
        this.timeStamp = LocalDateTime.now();
    }

    @Override
    public final String toString() {
        String time = timeStamp
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return String.format("%s: %.2f at %s", type, getAmount(), time);
    }

    /**
     * Getter method for the amount field.
     * @return returns the amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setter method for the amount field.
     * @param theAmount
     */
    public void setAmount(final double theAmount) {
        this.amount = theAmount;
    }

}
