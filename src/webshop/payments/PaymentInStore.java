package webshop.payments;

import webshop.Money;

/**
 * @author Grp.14
 */
public class PaymentInStore extends Payment {
    private int reservationID;
    private String location;

    public PaymentInStore(Money amount, int reservationID, String location) {
        super(amount);
        this.reservationID = reservationID;
        this.location = location;
    }
}
