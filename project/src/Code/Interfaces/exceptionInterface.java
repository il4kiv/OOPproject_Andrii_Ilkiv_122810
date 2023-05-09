package Code.Interfaces;

// for default

public interface exceptionInterface {      // (default method implementation)
    default void printMessage(String message) {
        System.out.println(message);
    }
}