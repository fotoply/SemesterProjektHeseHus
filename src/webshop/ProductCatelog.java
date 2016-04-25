/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Karim
 */
public class ProductCatelog {

    private List<Product> productList;

    public ProductCatelog() {
        productList = new ArrayList<>();
    }

    public Product findProduct(int itemID) {

        for (Product product : productList) {
            if (itemID == product.getProductID()) {
                return product;
            }

        }
        return null;
    }


}
