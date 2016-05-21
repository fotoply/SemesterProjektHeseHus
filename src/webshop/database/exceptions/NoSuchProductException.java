package webshop.database.exceptions;

public class NoSuchProductException extends RuntimeException {

    public NoSuchProductException(int productId) {
        super("No product for ID: " + productId);
    }

    public NoSuchProductException() {
        super("No product were found");
    }
}
