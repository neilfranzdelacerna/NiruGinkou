package javaexercise;

import java.util.List;
import java.util.ArrayList;

public class BankAccount {
    protected double balance;
    protected boolean isFrozen;
    List<Transaction> transactionHistory;

    public BankAccount() {
        balance = 0.0;
        isFrozen = false;
        transactionHistory = new ArrayList<>();
    }
    
    public void deposit(double amount) {
        if (!isFrozen) {
            if (amount > 0) {
                // Round the incoming amount and the final balance
                amount = Math.round(amount * 100.0) / 100.0;
                balance = Math.round((balance + amount) * 100.0) / 100.0;
                
                transactionHistory.add(new Transaction("Deposit", amount));
            } else {
                System.out.println("Invalid amount. Must be greater than 0.");
            }
        } else {
            System.out.println("Account is FROZEN. Unable to transact.");
            return;
        }
        
    }
    
    public void withdraw(double amount) {
        if (!isFrozen) {
            amount = Math.round(amount * 100.0) / 100.0;
            if (amount <= balance && amount > 0) {
                balance = Math.round((balance - amount) * 100.0) / 100.0;
                transactionHistory.add(new Transaction("Deposit", amount));
            } else if(amount > balance){
                System.out.println("Insufficient funds. Current balance: " + balance);
            }else {
            	System.out.println("Invalid amount. Must be greater than 0.");
            }
        } else {
            System.out.println("Account is FROZEN. Unable to transact.");
            return;
        }
    }
    
	public List<Transaction> getTransactionHistory() {
		return transactionHistory;
	}
    
    public double getBalance() {
        return balance;
    }
    
    public void freezeAccount() {
        isFrozen = true;
    }
    
    public void unfreezeAccount() {
        isFrozen = false;
    }
    
    public boolean isFrozen() {
        return isFrozen;
    }
}