package webshop.model.payments;

import webshop.model.Money;

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
