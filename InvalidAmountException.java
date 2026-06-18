package javaexercise;

public class InvalidAmountException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Holds the message passed from the constructor.
     */
    private String message;

    /**
     * Constructor for the InvalidAmountException class.
     * @param e
     */
    public InvalidAmountException(final String e) {
        this.message = e;
    }

    /**
     * Returns the message stored in the exception.
     * @return The message stored in the exception.
     */
    public String getMessage() {
        return message;
    }

}
