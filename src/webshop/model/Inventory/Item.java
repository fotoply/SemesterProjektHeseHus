package webshop.model.Inventory;

public class Item {

    private Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Gets the product associated with this item
     * @return A product instance or null if none.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Gets the quantity of associated product
     * @return An int representing how many of the product that is associated with this item.
     */
    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (quantity != item.quantity) return false;
        return product != null ? product.equals(item.product) : item.product == null;

    }

    @Override
    public int hashCode() {
        final int magicPrime = 524287;
        int result = product != null ? product.hashCode() : 0;
        result = magicPrime * result + quantity;
        return result;
    }
}
