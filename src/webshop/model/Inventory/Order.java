package webshop.model.Inventory;

import webshop.model.Money;
import webshop.model.payments.GiftCard;
import webshop.model.payments.Payment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static int orderCount = 0;
    private Date date;
    private Money tax;
    private Money shippingCharges;
    private Money finalPrice;
    private String shippingAddress;
    private int orderID;
    private int customerID;
    private List<Item> productList;
    private Money currentlyPaid;
    private List<Payment> paymentMethods;
    private Status status = Status.IN_BASKET;

    public Order(String shippingCharges, String shippingAddress, int customerID) {
        this.shippingCharges = new Money(shippingCharges);
        this.shippingAddress = shippingAddress;
        this.orderID = orderCount;
        this.customerID = customerID;
        this.paymentMethods = new ArrayList<>();
        date = new Date();
        this.productList = new ArrayList<>();
        this.currentlyPaid = new Money();
        this.finalPrice = new Money();

        orderCount++;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Money getTax() {
        return tax;
    }

    public void setTax(Money tax) {
        this.tax = tax;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public List<Item> getProductList() {
        return productList;
    }

    public void setProductList(List<Item> productList) {
        this.productList = productList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addProduct(Product product, int amount) {
        productList.add(new Item(product, amount));

    }

    public Money getTotalAmountOwedForProducts() {
        Money owed = new Money();
        for (Item item : productList) {
            for (int i = 0; i < item.getQuantity(); i++) {
                owed.add(item.getProduct().getPrice());
            }
        }
        return owed;
    }

    public int amountOfProductInOrder(int productId) {
        for (Item item : productList) {
            if (item.getProduct().getProductID() == productId) {
                return item.getQuantity();
            }
        }
        return 0;
    }

    public void setPaymentMethod(Payment method) {
        this.paymentMethods.add(method);
    }

    public Money getTax(Money price) {
        return tax;
    }

    public Money getShippingCharges() {
        return shippingCharges;
    }

    public void setShippingCharges(Money shippingCharges) {
        this.shippingCharges = shippingCharges;
    }

    public Money getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Money finalPrice) {
        this.finalPrice = finalPrice;
    }

    public void payAmountForOrder(Money amount) {
        if (amount.compareTo(getTotalAmountOwedForProducts()) > 0) {
            throw new IllegalArgumentException("Trying to pay more than owed");
        } else {
            currentlyPaid.add(amount);
        }
    }

    private Money payWithGiftcard(Money amount) {
        if (amount.compareTo(getTotalAmountOwedForProducts()) > 0) {
            currentlyPaid.add(getTotalAmountOwedForProducts());
            amount.pay(getTotalAmountOwedForProducts());
            return amount;
        } else {
            currentlyPaid.add(amount);
            return new Money("0");
        }
    }

    public boolean applyGiftCard(int ID) {
        GiftCard temp = GiftCard.getGiftcard(ID);
        temp.setGiftCardAmount(ID, this.payWithGiftcard(temp.getGiftcardAmount(ID)));
        return isPaid();
    }

    public List<Item> getProducts() {
        return productList;
    }

    public boolean isPaid() {
        return getFinalPrice().compareTo(currentlyPaid) < 0;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public enum Status {
        IN_BASKET, SHIPPING_TO_SHOP, SHIPPING, ACCEPTED, CLOSED, FOR_VERIFICATION
    }

}
