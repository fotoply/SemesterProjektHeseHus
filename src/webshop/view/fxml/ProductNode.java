package webshop.view.fxml;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import webshop.model.Inventory.Product;
import webshop.view.GUIController;

public class ProductNode extends AnchorPane {

    private Product product;

    public ProductNode(Product product) {
        this.product = product;

        //TODO Find a way to represent all of this as FXML or something, cause this is hard to edit
        Rectangle border = new Rectangle(150, 150, Color.LIGHTGREY);
        border.setOpacity(1);
        //border.setStroke(Color.DIMGREY);
        border.setWidth(150);
        border.setArcHeight(10);
        border.setArcWidth(10);

        getChildren().add(border);

        ImageView imageView = new ImageView();
        imageView.setImage(RootWindowController.getDefaultImage());
        imageView.setX(2);
        imageView.setY(13);
        imageView.setFitHeight(126);
        imageView.setFitHeight(126);
        getChildren().add(imageView);

        Text nametext = new Text(4, 12, product.getName().substring(0, Math.min(product.getName().length(), 15)));
        if (product.getName().length() > 15) {
            nametext.setText(nametext.getText().trim() + "...");
        }
        getChildren().add(nametext);

        Text pricetext = new Text(4, 145, product.getPrice().getAmountAsString());
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
