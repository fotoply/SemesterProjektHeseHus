/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshop.model.payments;

import webshop.model.Money;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Karim
 */
public class GiftCard extends Payment {
    private int id;
    private static Map<Integer, GiftCard> giftCards = new HashMap<>();

    public GiftCard(Money amount, int id) {
        super(amount);
        this.id = id;
        giftCards.put(this.id, this);
    }

    public static GiftCard getGiftcard (int id) {
        return giftCards.get(id);
    }

    public Money getGiftcardAmount(int id) {
        giftCards.get(id).getAmount();
    }

    public void setGiftCardAmount(int id, Money amount) {
        giftCards.get(id).setAmount(amount);
    }
}

