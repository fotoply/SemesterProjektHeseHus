package webshop.database.exceptions;

public class NoSuchCustomerException extends RuntimeException {

    public NoSuchCustomerException(int customerId) {
        super("No customer for ID: " +customerId);
    }
}
