package webshop.model.Inventory;

import webshop.model.Money;

/**
 * Created 5/4/16
 *
 * @author Niels Norberg
 */
public class DatabaseProduct extends Product {

    public DatabaseProduct(String name, String description, String type, Money price, int productID, boolean currentlySelling) {
        super(name, description, type, price, productID, currentlySelling);
    }

    @Override
    public Money getPrice() {
        return super.getPrice();
    }
}
