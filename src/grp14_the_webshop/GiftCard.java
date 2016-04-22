/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp14_the_webshop;

/**
 * @author Karim
 */
public class GiftCard {
    private int id;
    private Money amount;

    public GiftCard(int id, String amount) {
        this.id = id;
        this.amount = new Money(amount);
    }

    public Money getAmount() {
        return amount;
    }
}
