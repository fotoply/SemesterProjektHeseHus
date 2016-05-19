package webshop.database;

import webshop.model.Inventory.Item;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

public interface IDatabaseFacade {

    boolean emailExists(String email);

    ResultSet getCustomer(int customerId);

    ResultSet getProduct(int productId);

    ResultSet getOrder(int orderId);

    int getCustomerIdFromEmail(String email);

    void saveCustomer(String name, String address, String email, String password, Date birthday, int phoneNumber, String passwordsalt, int currentorderid);

    int getNextCustomerId();

    void saveOrder(int orderId, int customerId, String finalPrice, String tax, String shippingCharges, String shippingAddress, String status, Date date, List<Item> items);

    ResultSet getProductByType(String searchTerms);

    ResultSet getProductByName(String searchTerms);
}
