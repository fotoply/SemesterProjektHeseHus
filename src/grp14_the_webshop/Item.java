package grp14_the_webshop;

/**
 * @author Grp. 14
 */
public class Item {

    private int quantity;
    private double sumPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (quantity != item.quantity) return false;
        return Double.compare(item.sumPrice, sumPrice) == 0;

    }
}
