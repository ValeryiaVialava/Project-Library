package exceptions;

public class NoAvailableResourceException extends RuntimeException {
    public NoAvailableResourceException(String message) {
        super(message);
    }
}
