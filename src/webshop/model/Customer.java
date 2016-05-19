package webshop.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import webshop.model.Inventory.Order;
import webshop.model.Inventory.Product;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private String address;
    private String email;
    private byte[] password;
    private int phoneNumber;
    private Date birthday;
    private String name;
    private byte[] salt = new byte[32];
    private List<MemberShipCard> memberShipCards;
    private List<Order> orderList;
    private Order currentOrder;
    private int customerID;

    /**
     * A constructor to the class Customer is used to create a new customer.
     * There is no control of the parameters in the constructor, it has to be checked before
     * calling the constructor.
     *
     * @param name        The name of the customer.
     * @param address     The current address of the customer.
     * @param email       The contact email of the customer.
     * @param password    The password of the customer, the inputted password will be hashed before it gets saved, by calling the "setPassword" method.
     * @param dayOfBirth  The day of birth of the customer.
     * @param phoneNumber The phone number of the customer.
     */
    public Customer(String name, String address, String email, String password, Date dayOfBirth, int phoneNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.birthday = dayOfBirth;
        this.phoneNumber = phoneNumber;
        SecureRandom rnd = new SecureRandom();
        rnd.nextBytes(salt);
        setPassword(password);
        }

      public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();

        Customer c = new Customer("Bob", "bob", "bob", password, new Date(), 10203040);
        System.out.println("Hashed password is: ");
        System.out.println(toBase64(c.getPasswordHash(password)));
        password = input.nextLine();
        System.out.println("And again");
        System.out.println(toBase64(c.getPasswordHash(password)));

    }

    public int getCustomerID() {
        return this.customerID;
    }

    public static byte[] fromBase64(String base64String) {
        return DatatypeConverter.parseBase64Binary(base64String);
    }

    public static String toBase64(byte[] array) {
        return DatatypeConverter.printBase64Binary(array);
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = getPasswordHash(password);
    }

    /**
     * Sets the status for the current order to "FOR_VERIFICATION".
     * is used when the customer need til verify the current basket
     */
    public void checkoutBasket() {
        if (currentOrder != null) {
            currentOrder.setStatus(Order.Status.FOR_VERIFICATION);
        }
    }

    /**
     * Returns the current order.
     *
     * @return the current order instants
     */
    public Order getCurrentOrder() {
        return currentOrder;
    }

    /**
     * Sets the order to the currentOrder.
     *
     * @param currentOrder set object of order to the current order
     */
    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    /**
     * A constructor to make a new order on a specific customer.
     *
     * @param customerID the id for the customer that you want to create a new order for.
     */
    public void createNewOrder(int customerID) {
        //Shippingcharges sat til 0.
        currentOrder = new Order("0", address, customerID);
    }

    public void linkMemberShipCard(int id) {
    /*    MemberShipCard e = MemberShipCard.getMemberShipCard(id);
        memberShipCards.add(e);*/
        throw new NotImplementedException();
    }

    /**
     * Adds a product to the current order.
     *
     * @param product a object of the class product
     * @param amount  the amount of the product that should be add to the current order.
     */
    public void addProduct(Product product, int amount) {
        this.currentOrder.addProduct(product, amount);
    }

    //TODO implement constant-time comparison to avoid timing attacks
    public boolean isCorrectPassword(String comparisonPassword) {
        return Arrays.equals(password, getPasswordHash(comparisonPassword));
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    /**
     * Is used to hash the password.
     *
     * @param password the password that should be hashed.
     * @return the hashed password.
     */
    private byte[] getPasswordHash(String password) {
        KeySpec keySpecification = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory secretKeyFactory;
        byte[] hash = new byte[32];
        try {
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hash = secretKeyFactory.generateSecret(keySpecification).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return hash;
    }

    /**
     * Cancel the current order, set the status of the order to IN_BASKET
     */
    public void cancelOrder() {
        currentOrder.setStatus(Order.Status.IN_BASKET);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setCustomerID(int customerId) {
        this.customerID = customerId;
    }
}
