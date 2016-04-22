package webshop.payments;

import webshop.Money;

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
