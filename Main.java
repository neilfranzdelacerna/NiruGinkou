package javaexercise;

final class Main {

    private Main() { }
    /**
     * Used to initialize the balance of the account.
     */
    private static final double INIT = 1000.125;
    /**
     * Used to test depositing zero amount.
     */
    private static final double ZERO = 0.0;
    /**
     * Used to test depositing a negative amount,
     * which should trigger an exception.
     */
    private static final double NEG = -500.0;
    /**
     * Used to test withdrawing a small amount
     * that is less than the current balance.
     */
    private static final double WITHDRAW_SMALL = 500.0;
    /**
     * Used to test withdrawing a large amount that.
     */
    private static final double WITHDRAW_LARGE = 1500.0;
    /**
     * Used to test withdrawing a negative amount.
     */
    private static final double NEG_WITHDRAW = -100.0;
    /**
     * Used to test depositing an amount when the account is frozen.
     */
    private static final double FROZEN_DEPOSIT = 11500.0;
    /**
     * Used to test withdrawing an amount when the account is frozen.
     */
    private static final double FINAL_WITHDRAW = 100.0;

    public static void main(final String[] args) {

        BankAccount acc1 = new SavingsAccount("Test0");
        SavingsAccount sa = (SavingsAccount) acc1;
        System.out.println("Account Owner: " + sa.getOwnerName());
        System.out.println();

        double amount = INIT;
        acc1.deposit(amount);
        System.out.printf("Amount deposited: %.2f%n", amount);
        System.out.println("Current balance: " + acc1.getBalance());
        System.out.println();

        amount = ZERO;
        acc1.deposit(amount);
        System.out.printf("Amount deposited: %.2f%n", amount);
        System.out.println();

        amount = NEG;
        acc1.deposit(amount);
        System.out.printf("Amount deposited: %.2f%n", amount);
        System.out.println();

        amount = 500;
        acc1.withdraw(amount);
        System.out.printf("Amount withdrawn: %.2f%n", amount);
        System.out.println("Current balance: " + acc1.getBalance());
        System.out.println();

        amount = 1500;
        acc1.withdraw(amount);
        System.out.printf("Amount withdrawn: %.2f%n", amount);
        System.out.println();

        amount = -100;
        acc1.withdraw(amount);
        System.out.printf("Amount withdrawn: %.2f%n", amount);
        System.out.println();

        acc1.freezeAccount();
        amount = 11500;
        acc1.deposit(amount);
        System.out.println();

        amount = 100;
        acc1.unfreezeAccount();
        acc1.withdraw(amount);
        System.out.printf("Amount withdrawn: %.2f%n", amount);
        System.out.println("Current balance: " + acc1.getBalance());
        System.out.println();

        acc1.getTransactionHistory();
        for (Transaction t : acc1.getTransactionHistory()) {
            System.out.println(t);
        }
        System.out.println();

        BankAccountManager accM1 = new BankAccountManager();
        int assignedID = accM1.addAccount(acc1);
        System.out.println("Account added successfully with ID: " + assignedID);
        System.out.println();

        assignedID = accM1.addAccount(new SavingsAccount("Test1"));
        System.out.println("Account added successfully with ID: " + assignedID);
        System.out.println();

        accM1.listAccounts();
        System.out.println();

        amount = -500;
        acc1.deposit(amount);
        System.out.printf("Amount deposited: %.2f%n", amount);
        System.out.println("Current balance: " + acc1.getBalance());
        System.out.println();

        acc1.freezeAccount();
        amount = 11500;
        acc1.deposit(amount);
        System.out.println();

        amount = -100;
        acc1.unfreezeAccount();
        acc1.withdraw(amount);
        System.out.println("Amount withdrawn: " + amount);

        amount = 1500;
        acc1.withdraw(amount);
        System.out.println();
        System.out.println("Filtering transactions at or above 200: "
                + accM1.filterTransactionsAtOrAbove(200,
                        acc1.getTransactionHistory()));
        System.out.println();
        System.out.println("Sorting transactions by amount: "
                + accM1.sortTransactionsByAmount(acc1.getTransactionHistory()));
    }

}
