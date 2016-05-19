package webshop.model.payments;

import webshop.model.Money;

import java.util.Date;

public class CreditCard extends Payment {

    String cardHolder;
    int cardNumber;
    Date expDate;

    /**
     * Constructor for the CreditCard class.
     * Calls the super constructor, which is located in the Payment class.
     * Used to handle payment by credit card.
     * @param amount The amount to be paid.
     */
    public CreditCard(Money amount) {
        super(amount);
    }

    enum cardType {
        DAN_KORT, VISA,
    }

}
