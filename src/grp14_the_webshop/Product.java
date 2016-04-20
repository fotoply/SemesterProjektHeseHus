/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp14_the_webshop;

/**
 *
 * @author Karim
 */
public class Product {
    String type;
    Double price;
    int itemID;
    boolean currentlySelling;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (itemID != product.itemID) return false;
        if (type != null ? !type.equals(product.type) : product.type != null) return false;
        return price != null ? price.equals(product.price) : product.price == null;

    }
}
