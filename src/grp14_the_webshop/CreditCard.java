package grp14_the_webshop;

import java.util.Date;

/**
 * @author Grp. 14
 */
public class CreditCard {

    String cardHolder;
    int cardNumber;
    Date expDate;

    enum cardType {
        DAN_KORT, VISA,
    }

}
