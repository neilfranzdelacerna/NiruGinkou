package javaexercise;

public interface Bank {
    /**
     * Adds a new account to the bank.
     * @param account
     * @return returns the id of the newly created account.
     */
    int addAccount(BankAccount account);

    /**
     * Retrieves an account by its ID.
     * @param id
     * @return returns the requested account, null if account does not exist.
     */
    BankAccount getAccount(int id);
}
