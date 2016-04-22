package grp14_the_webshop;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created 4/22/16
 *
 * @author Niels Norberg
 */
public class Money implements Comparable {

    private BigDecimal amount;

    public Money() {
        this("0");
    }

    public Money(String amount) {
        this(new BigDecimal(amount));
    }

    public Money(BigDecimal amount) {
        if(amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else {
            this.amount = amount;
        }
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
    public int compareTo(Object o) {
        if(!(o instanceof Money)) return 0;
        return amount.compareTo(((Money) o).amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;

        Money money = (Money) o;

        return amount.equals(money.amount);

    }
}
