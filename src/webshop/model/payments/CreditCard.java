package webshop.model.payments;

import webshop.model.Money;

import java.util.Date;

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
