package webshop;

import java.math.BigDecimal;

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
        if (Money.isNegative(amount)) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else {
            this.amount = amount;
        }
    }

    public static boolean isNegative(String amount) {
        return isNegative(new BigDecimal(amount));
    }

    public static boolean isNegative(BigDecimal amount) {
        return amount.compareTo(BigDecimal.ZERO) < 0;
    }

    public boolean isNegative() {
        return amount.compareTo(BigDecimal.ZERO) < 0;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getAmountAsString() {
        return amount.toPlainString();
    }

    public void pay(Money money) {
        pay(money.amount.toString());
    }

    public void pay(String amount) {
        if (!isNegative(this.amount.subtract(new BigDecimal(amount)))) {
            this.amount = this.amount.subtract(new BigDecimal(amount));
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public void add(Money money) {
        add(money.amount.toString());
    }

    public void add(String amount) {
        if (isNegative(amount)) {
            throw new IllegalArgumentException("Cannot add negative money, use pay instead");
        }
        this.amount = this.amount.add(new BigDecimal(amount));
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Money)) return 0;
        return amount.compareTo(((Money) o).amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;

        Money money = (Money) o;

        return amount.equals(money.amount);

    }

    @Override
    public int hashCode() {
        return amount != null ? amount.hashCode() : 0;
    }
}
