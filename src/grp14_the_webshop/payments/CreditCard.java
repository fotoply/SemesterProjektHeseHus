package grp14_the_webshop.payments;

import grp14_the_webshop.Money;
import grp14_the_webshop.payments.Payment;

import java.util.Date;

/**
 * @author Grp. 14
 */
public class CreditCard extends Payment {

    String cardHolder;
    int cardNumber;
    Date expDate;

    public CreditCard(Money amount) {
        super(amount);
    }

    enum cardType {
        DAN_KORT, VISA,
    }

}
