package grp14_the_webshop;

/**
 * @author Grp. 14
 */
public class Item {

    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        return quantity == item.quantity;

    }

    @Override
    public int hashCode() {
        return quantity;
    }
}
