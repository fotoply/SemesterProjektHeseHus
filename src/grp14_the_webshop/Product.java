/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp14_the_webshop;

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

    public Money getPrice() {
        return price;
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
        if (type != null ? !type.equals(product.type) : product.type != null) return false;
        return price != null ? price.equals(product.price) : product.price == null;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setPrice(Money price) {
        this.price = price;
    }

    public boolean isCurrentlySelling() {
        return currentlySelling;
    }
}
