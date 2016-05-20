package webshop.exceptions;

public class NoSuchProductException extends RuntimeException {

    public NoSuchProductException(int productId) {
        super("No product for ID: " + productId);
    }
}
