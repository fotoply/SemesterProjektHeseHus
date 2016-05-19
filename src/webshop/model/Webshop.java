package webshop.model;

import webshop.model.Inventory.Order;
import webshop.model.Inventory.Product;
import webshop.model.Inventory.ProductCatalog;

import java.util.Date;
import java.util.List;

public class Webshop {
    private static Webshop instance;
    private int currentCustomerID = -1;
    private CustomerManager customerManager;
    private ProductCatalog productCatalog = new ProductCatalog();
    private PaymentType payingBy;

    private Webshop() {
        customerManager = new CustomerManager();
    }

    public static Webshop getInstance() {
        if (instance == null) {
            instance = new Webshop();
        }
        return instance;
    }

    public void setCurrentCustomerID(int currentCustomerID) {
        this.currentCustomerID = currentCustomerID;
    }

    public Product findProduct(int productID) {

        return productCatalog.findProduct(productID);

    }

    public String getAllProducts() {

        return productCatalog.getAllProducts();
    }

    public Order getCurrentOrder() {
        return customerManager.getCustomer(currentCustomerID).getCurrentOrder();
    }

    public void createNewOrder() {
        customerManager.getCustomer(currentCustomerID).createNewOrder(currentCustomerID);
    }

    public void addItem(Product product, int amount) {
        if (getCurrentOrder() == null) {
            createNewOrder();
        }
        customerManager.getCustomer(currentCustomerID).addProduct(product, amount);
    }

    public Customer createCustomer(String name, String address, int phoneNumber, String email, String password, Date dayOfBirth) {
        return customerManager.createCustomer(name, address, phoneNumber, email, password, dayOfBirth);
    }

    public int getCustomerIdFromEmail(String email) {
        return customerManager.getCustomerIDFromEmail(email);
    }

    public boolean loginWithCustomer(int customerId, String password) {
        if (customerManager.getCustomer(customerId).isCorrectPassword(password)) {
            return true;
        }
        return false;
    }

    public boolean isValidEmail(String email) {
        return PersistenceFacade.getInstance().confirmEmail(email);
        //return customerManager.getCustomerIDFromEmail(email) > -1;
    }

    public boolean loginWithEmail(String email, String password) {
        setCurrentCustomerID(getCustomerIdFromEmail(email));
        System.out.println("Current customer ID: " + getCustomer());
        return loginWithCustomer(currentCustomerID, password);
    }

    public String checkoutBasket() {
        customerManager.getCustomer(currentCustomerID).checkoutBasket();
        return "Basket was checked out";
    }

    public List<Product> searchProduct(String searchTerms) {
        return productCatalog.searchProduct(searchTerms);
    }

    public void cancelOrder() {
        customerManager.getCustomer(currentCustomerID).cancelOrder();
    }

    public Customer getCustomer() {
        return customerManager.getCustomer(currentCustomerID);
    }

    public void deleteCustomer() {
        customerManager.deleteCustomer(currentCustomerID);
    }

    public boolean isOrderPaidFor() {
        return getCurrentOrder().isPaid();
    }

    public boolean applyGiftCard(int giftcardId) {
        return true;
    }

    public PaymentType getPayingBy() {
        return payingBy;
    }

    public void setPayingBy(PaymentType payingBy) {
        this.payingBy = payingBy;
    }

    public boolean isLoggedIn() {
        try {
            customerManager.getCustomer(currentCustomerID);
        } catch (Exception ignored) {
            return false;
        }
        return currentCustomerID != -1;
    }

    public List<Product> getProducts() {
        return productCatalog.getProductList();
    }

    public enum PaymentType {IN_SHOP, CREDIT_CARD}
}
