package webshop.model.Inventory;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import webshop.model.Money;
import webshop.model.Webshop;
import webshop.model.database.DatabaseConnector;

/**
 * Created 5/4/16
 *
 * @author Niels Norberg
 */
public class PostgresDatabaseProduct extends Product {

    DatabaseConnector databaseConnector = Webshop.getDatabaseConnector();

    public PostgresDatabaseProduct(String name, String description, String type, Money price, int productID, boolean currentlySelling) {
        super(name, description, type, price, productID, currentlySelling);
    }

    @Override
    public Money getPrice() {
        throw new NotImplementedException();
        //TODO connect to the database and get the data from there.
    }
}
