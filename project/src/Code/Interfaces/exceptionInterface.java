package Code.Interfaces;

// for default

public interface exceptionInterface {
    default void printMessage(String message) {
        System.out.println(message);
    }
}