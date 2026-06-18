package javaexercise;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class BankAccountManager implements Bank {
    /**
     * Holds the accounts in a map with their IDs as keys.
     */
    private Map<Integer, BankAccount> accounts;
    /**
     * Holds the next available ID for a new account.
     */
    private int id;

    /**
     * Initializes the BankAccountManager with an empty account map and sets the
     * initial ID to 0.
     */
    public BankAccountManager() {
        accounts = new HashMap<>();
        id = 0;
    }

    final List<Transaction> filterTransactionsAtOrAbove(final double amount,
            final List<Transaction> txList) {
        List<Transaction> filteredList = new ArrayList<>();
        for (Transaction tx : txList) {
            if (tx.getAmount() >= amount) {
                filteredList.add(tx);
            }
        }
        return filteredList;
    }

    final List<Transaction> sortTransactionsByAmount(final List<Transaction>
    txList) {
        txList.sort(
                (tx1, tx2) -> Double.compare(tx1.getAmount(), tx2.getAmount()));
        return txList;
    }

    @Override
    public final int addAccount(final BankAccount account) {
        accounts.put(id, account);
        return id++;
    }

    @Override
    public final BankAccount getAccount(final int accountid) {
        if (accounts.containsKey(id)) {
            return accounts.get(id);
        } else {
            System.out.println("Account with ID " + id + " does not exist.");
            return null;
        }
    }

    /**
     * Lists all accounts in the bank along with their IDs and balances.
     */
    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            System.out.println("Accounts in Bank:");
            for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
                System.out.println("ID: " + entry.getKey() + ", Balance: "
                        + entry.getValue().getBalance());
            }
        }
    }
}
