package Code.Interfaces;

/**
 * The exceptionInterface interface defines a contract for classes that handle exceptions.
 * It provides a default method for printing an exception message.
 */
public interface exceptionInterface {

    /**
     * Prints the specified message to the standard output.
     *
     * @param message the message to be printed
     */
    default void printMessage(String message) {
        System.out.println(message);
    }
}