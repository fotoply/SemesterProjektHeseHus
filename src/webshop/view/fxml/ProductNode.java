package webshop.view.fxml;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import webshop.Product;
import webshop.view.GUIController;

public class ProductNode extends AnchorPane {

    private Product product;

    public ProductNode(Product product) {
        this.product = product;

        //TODO Find a way to represent all of this as FXML or something, cause this is hard to edit
        Rectangle border = new Rectangle(150, 150, Color.TRANSPARENT);
        border.setStroke(Color.DIMGREY);
        border.setWidth(150);

        getChildren().add(border);

        ImageView imageView = new ImageView();
        imageView.setImage(GUIController.getRootInstance().getDefaultImage());
        imageView.setX(2);
        imageView.setY(16);
        imageView.setFitHeight(126);
        imageView.setFitHeight(126);
        getChildren().add(imageView);

        Text nametext = new Text(4, 12, product.getName());
        getChildren().add(nametext);

        Text pricetext = new Text(105, 140, product.getPrice().getAmountAsString());
        getChildren().add(pricetext);

        setPrefWidth(150);
        setPrefHeight(150);

        setOnMouseClicked(event -> {
            clicked();
        });
    }

    private void clicked() {
        GUIController.getRootInstance().showProduct(this);
    }

    public Product getProduct() {
        return product;
    }

    public String getDescription() {
        return product.getDescription();
    }

    public String getName() {
        return product.getName();
    }

    public String getPrice() {
        return product.getPrice().getAmountAsString();
    }
}
