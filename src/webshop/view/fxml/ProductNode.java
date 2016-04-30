package webshop.view.fxml;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import webshop.Product;

public class ProductNode extends AnchorPane {

    private Product product;

    public ProductNode(Product product) {
        this.product = product;

        ImageView imageView = new ImageView();
        imageView.setImage(new Image("/res/placeholderProductIcon.png"));
        imageView.setX(12);
        imageView.setY(12);
        imageView.setFitHeight(126);
        imageView.setFitHeight(126);
        getChildren().add(imageView);

        Text nametext = new Text(10,4,product.getName());
        getChildren().add(nametext);

        Text pricetext = new Text(120,140,product.getPrice().getAmountAsString());
        getChildren().add(pricetext);

        setPrefWidth(150);
        setPrefHeight(150);
    }

    public Product getProduct() {
        return product;
    }
}
