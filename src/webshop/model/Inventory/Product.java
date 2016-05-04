/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshop.model.Inventory;

import webshop.model.Money;

/**
 * @author Karim
 */
public class Product {
    private String name;
    private String description;
    private String type;
    private Money price;
    private int productID;
    private boolean currentlySelling;   

    public Product(String name, String description, String type, Money price, int productID, boolean currentlySelling) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
        this.productID = productID;
        this.currentlySelling = currentlySelling;
    }

    
    
    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (productID != product.productID) return false;
        if (currentlySelling != product.currentlySelling) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (type != null ? !type.equals(product.type) : product.type != null) return false;
        return price != null ? price.equals(product.price) : product.price == null;

    }

    @Override
    public int hashCode() {
        final int magicPrime = 524287;
        int result = name != null ? name.hashCode() : 0;
        result = magicPrime * result + (description != null ? description.hashCode() : 0);
        result = magicPrime * result + (type != null ? type.hashCode() : 0);
        result = magicPrime * result + (price != null ? price.hashCode() : 0);
        result = magicPrime * result + productID;
        result = magicPrime * result + (currentlySelling ? 1 : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return this.productID;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isCurrentlySelling() {
        return currentlySelling;
    }
}
