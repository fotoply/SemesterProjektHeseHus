package webshop.database.exceptions;

public class NoSuchOrderException extends RuntimeException {

    public NoSuchOrderException(int orderId) {
        super("No order for ID: " + orderId);
    }
}
