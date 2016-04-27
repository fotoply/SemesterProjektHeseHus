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
        
        productList.add(new Product("Baseball T-Shirt", "Simple and fresh  new Zine 2nd Inning white baseball t-shirt.",
                "T-Shirt", new Money("599.95"), 0, false));
        
        productList.add(new Product("Polo T-Shirt", "A Nice Polo T-shirt",
                "T-Shirt", new Money("475.95"), 1, true));
        
        productList.add(new Product("Black Jeans", "Stylish black rinser colorway with a slight stretch modern straight leg construction for a comfortable fit.",
                "Jeans", new Money("999.95"), 2, true));
        
        productList.add(new Product("Denim Jacket", "Stylish black denim body with an integrated black zip up hoodie and soft fleece lined black knit sleeves.",
                "Jackets", new Money("1499.95"), 3, true));
        
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
