package webshop.view.fxml;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import webshop.Product;

import java.util.List;

public class shopAreaController {

    @FXML
    private FlowPane productArea;

    @FXML
    void initialize() {

    }

    public void addNewItem(Node node) {
        productArea.getChildren().add(node);
    }

    public void loadItems(List<Product> products) {
        for (Product product : products) {
            AnchorPane base = new AnchorPane();
            ImageView imageView = new ImageView();
            imageView.setImage(new Image("/res/placeholderProductIcon.png"));
            imageView.setX(12);
            imageView.setY(12);
            imageView.setFitHeight(126);
            imageView.setFitHeight(126);
            base.getChildren().add(imageView);

            Text nametext = new Text(10,4,product.getName());
            base.getChildren().add(nametext);

            Text pricetext = new Text(120,140,product.getPrice().getAmountAsString());
            base.getChildren().add(pricetext);

            base.setPrefWidth(150);
            base.setPrefHeight(150);
            addNewItem(base);
        }
    }
}