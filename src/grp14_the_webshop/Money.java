package grp14_the_webshop;

import java.math.BigDecimal;

/**
 * Created 4/22/16
 *
 * @author Niels Norberg
 */
public class Money {

    private BigDecimal amount;

    public Money() {
        this.amount = new BigDecimal(0);
    }

    public Money(String amount) {
        this.amount = new BigDecimal(amount);
    }

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getAmountAsString() {
        return amount.toString();
    }

    public void subtract(Money money) {
        subtract(money.amount.toString());
    }

    public void subtract(String amount) {
        this.amount = this.amount.subtract(new BigDecimal(amount));
    }

    public void add(Money money) {
        add(money.amount.toString());
    }

    public void add(String amount) {
        this.amount = this.amount.add(new BigDecimal(amount));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;

        Money money = (Money) o;

        return amount.equals(money.amount);

    }
}
