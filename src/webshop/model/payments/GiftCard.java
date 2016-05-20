package webshop.model.payments;

import webshop.model.Money;

import java.util.HashMap;
import java.util.Map;

public class GiftCard extends Payment {
    private static Map<Integer, GiftCard> giftCards = new HashMap<>();
    private int id;

    /**
     * The constructor for the GiftCard class,
     * used to create a GiftCard object containing the value of the GiftCard.
     *
     * @param amount The available amount on the Gift Card.
     * @param id     The Gift Card's ID number.
     */
    public GiftCard(Money amount, int id) {
        super(amount);
        this.id = id;
        giftCards.put(this.id, this);
    }

    public static GiftCard getGiftcard(int id) {
        return giftCards.get(id);
    }

    public Money getGiftcardAmount(int id) {
        return giftCards.get(id).getAmount();
    }

    public int getID() {
        return this.id;
    }

    public void setGiftCardAmount(int id, Money amount) {
        this.setAmount(amount);
        //giftCards.get(id).setAmount(amount);
    }

    public

}

