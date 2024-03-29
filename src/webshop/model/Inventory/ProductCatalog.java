package webshop.model.Inventory;

import webshop.model.Money;
import webshop.model.PersistenceFacade;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {

    private PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();
    private List<Product> productList;

    public ProductCatalog() {
        productList = new ArrayList<>();

        //addTestProducts();
    }

    private void addTestProducts() {
        productList.add(new Product("Baseball T-Shirt", "Simple and fresh  new Zine 2nd Inning white baseball t-shirt.",
                "T-Shirt", new Money("599.95"), 0, false));

        productList.add(new Product("Polo T-Shirt", "A Nice Polo T-shirt",
                "T-Shirt", new Money("475.95"), 1, true));

        productList.add(new Product("Black Jeans", "Stylish black rinser colorway with a slight stretch modern straight leg construction for a comfortable fit.",
                "Jeans", new Money("999.95"), 2, true));

        productList.add(new Product("Denim Jacket", "Stylish black denim body with an integrated black zip up hoodie and soft fleece lined black knit sleeves.",
                "Jackets", new Money("1499.95"), 3, true));
    }

    public Product findProduct(int productID) {
        for (Product product : productList) {
            if (productID == product.getProductID()) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getAllProducts() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < productList.size(); i++) {
            sb.append("ID: ");
            sb.append(productList.get(i).getID());
            sb.append(" ");
            sb.append(productList.get(i).getName());
            sb.append("\n");
        }

        return sb.toString();
    }


    public List searchProduct(String searchTerms) {
        return persistenceFacade.searchProduct(searchTerms);

    }
}
