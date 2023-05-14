package Code.Interfaces;
import java.io.Serial;

/**
 * The custom exception class for handling local exceptions.
 * This exception is thrown when shipping can only be Prime Delivery for packages over 100kg.
 */
public class localException extends Exception {
    @Serial
    private static final long serialVersionUID = -3121055327488048910L;

    /**
     * Constructs a new localException with a default error message.
     */
    public localException() {
        super("Shipping can only be Prime Delivery for packages over 100kg.");
    }
}