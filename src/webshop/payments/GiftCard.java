/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshop.payments;

import webshop.Money;

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
