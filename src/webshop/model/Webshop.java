package webshop.model;

import webshop.model.Inventory.Order;
import webshop.model.Inventory.Product;
import webshop.model.Inventory.ProductCatalog;

import java.util.Date;
import java.util.List;

public class Webshop {
    private static Webshop instance;
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
        CustomerManager.setCurrentCustomerID(currentCustomerID);
    }

    public Product findProduct(int productID) {

        return productCatalog.findProduct(productID);

    }

    public String getAllProducts() {

        return productCatalog.getAllProducts();
    }

    public Order getCurrentOrder() {
        return getCurrentCustomer().getCurrentOrder();
    }

    public Customer getCurrentCustomer() {
        return customerManager.getCustomer(CustomerManager.getCurrentCustomerID());
    }

    public void createNewOrder() {
        getCurrentCustomer().createNewOrder(CustomerManager.getCurrentCustomerID());
    }

    public void addItem(Product product, int amount) {
        if (getCurrentOrder() == null) {
            createNewOrder();
        }
        getCurrentCustomer().addProduct(product, amount);
    }

    public Customer createCustomer(String name, String address, int phoneNumber, String email, String password, Date dayOfBirth) {
        return customerManager.createCustomer(name, address, phoneNumber, email, password, dayOfBirth);
    }

    public int getCustomerIdFromEmail(String email) {
        return customerManager.getCustomerIDFromEmail(email);
    }

    public boolean loginWithCustomer(int customerId, String password) {
        return customerManager.getCustomer(customerId).isCorrectPassword(password);
    }

    public boolean isValidEmail(String email) {
        return PersistenceFacade.getInstance().confirmEmail(email);
        //return customerManager.getCustomerIDFromEmail(email) > -1;
    }

    public boolean loginWithEmail(String email, String password) {
        setCurrentCustomerID(getCustomerIdFromEmail(email));
        System.out.println("Current customer ID: " + getCurrentCustomer().getCustomerID());
        return loginWithCustomer(CustomerManager.getCurrentCustomerID(), password);
    }

    public String checkoutBasket() {
        getCurrentCustomer().checkoutBasket();
        return "Basket was checked out";
    }

    public List<Product> searchProduct(String searchTerms) {
        return productCatalog.searchProduct(searchTerms);
    }

    public void cancelOrder() {
        getCurrentCustomer().cancelOrder();
    }


    public void deleteCustomer() {
        customerManager.deleteCustomer(CustomerManager.getCurrentCustomerID());
    }

    public boolean isOrderPaidFor() {
        return getCurrentOrder().isPaid();
    }

    public boolean applyGiftCard(int giftcardId) {
        getCurrentCustomer().getCurrentOrder().applyGiftCard(giftcardId);
        return true;
    }

    public PaymentType getPayingBy() {
        return payingBy;
    }

    public void setPayingBy(PaymentType payingBy) {
        this.payingBy = payingBy;
    }

    public boolean isLoggedIn() {
        return CustomerManager.getCurrentCustomerID() != -1;
    }

    public List<Product> getProducts() {
        return productCatalog.getProductList();
    }

    public enum PaymentType {IN_SHOP, CREDIT_CARD}
}
