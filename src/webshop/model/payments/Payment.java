/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshop.model.payments;

import webshop.model.Money;

/**
 * @author Karim
 */
public abstract class Payment {
    private Money amount;

    public Payment(Money amount) {
        this.amount = amount;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;

    }

    private enum Status {
        NOT_PAID, RESERVED_IN_STORE, PAID
    }
}
