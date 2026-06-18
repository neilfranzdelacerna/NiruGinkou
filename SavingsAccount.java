package javaexercise;

public class SavingsAccount extends BankAccount {
    /**
     * The name of the account owner.
     */
    private String ownerName;

    /**
     * Constructor for SavingsAccount that initializes the ownerName field.
     *
     * @param nameOwner
     */
    public SavingsAccount(final String nameOwner) {
        super();
        this.ownerName = nameOwner;

    }

    /**
     * Getter method for the ownerName field.
     * @return returns the ownername.
     */
    public String getOwnerName() {
        return ownerName;
    }

}
