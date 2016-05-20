package webshop.model.payments;

import webshop.model.Money;

public class PaymentInStore extends Payment {
    private int reservationID;
    private String location;

    /**
     * Handles payment of reserved goods in a physical store.
     *
     * @param amount        The amount to be paid by the customer.
     * @param reservationID The reservation ID sent to the customer, when he/she reserved their product(s) online.
     * @param location      The location of the physical store the products were ordered to.
     */
    public PaymentInStore(Money amount, int reservationID, String location) {
        super(amount);
        this.reservationID = reservationID;
        this.location = location;
    }
}
