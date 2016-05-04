package webshop.model.Inventory;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
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
        throw new NotImplementedException();
        //TODO connect to the database and get the data from there.
    }
}
