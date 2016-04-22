/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp14_the_webshop.payments;

import grp14_the_webshop.Money;
import grp14_the_webshop.payments.Payment;

/**
 * @author Karim
 */
public class GiftCard extends Payment {
    private int id;

    public GiftCard(Money amount, int id) {
        super(amount);
        this.id = id;
    }
}
