package webshop.model;

import java.math.BigDecimal;

/**
 * Created 4/22/16
 *
 * @author Niels Norberg
 */
public class Money implements Comparable {

    private BigDecimal amount;

    /**
     * Creates a new money object which represents an arbitrary currency.
     */
    public Money() {
        this("0");
    }

    /**
     * Creates a new money object which represents an arbitrary currency.
     *
     * @param amount the starting amount for the new object
     * @throws IllegalArgumentException If the starting amount is less than 0
     */
    public Money(String amount) {
        this(new BigDecimal(amount));
    }

    /**
     * Creates a new money object which represents an arbitrary currency.
     *
     * @param amount the starting amount for the new object
     * @throws IllegalArgumentException If the starting amount is less than 0
     */
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

    /**
     * @return true if the current money object is negative
     */
    public boolean isNegative() {
        return Money.isNegative(this.amount);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @return amount as a human readable string
     */
    public String getAmountAsString() {
        return amount.toPlainString();
    }

    /**
     * Subtracts the amount in the given money object from the current money object
     *
     * @param money
     */
    public void pay(Money money) {
        pay(money.amount.toString());
    }

    /**
     * Subtracts the amount from the current money object
     *
     * @param amount
     * @throws IllegalArgumentException If the amount passed is less than 0
     */
    public void pay(String amount) {
        if (!isNegative(this.amount.subtract(new BigDecimal(amount)))) {
            this.amount = this.amount.subtract(new BigDecimal(amount));
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    /**
     * Adds the value of the <code>money</code> object to the current object
     *
     * @param money
     */
    public void add(Money money) {
        add(money.amount.toString());
    }

    /**
     * Adds a specified amount of money to the current object
     *
     * @param amount
     * @throws IllegalArgumentException If the amount is less than 0
     */
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

        return amount != null ? amount.equals(money.amount) : money.amount == null;

    }

    @Override
    public int hashCode() {
        final int magicPrime = 524287;
        return amount != null ? amount.hashCode() : 0;
    }

    @Override
    public String toString() {
        return ""+ amount.toPlainString();
    }
}
