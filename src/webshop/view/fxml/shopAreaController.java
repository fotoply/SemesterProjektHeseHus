package webshop.view.fxml;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.TilePane;
import webshop.Product;

import java.io.IOException;
import java.util.List;

public class ShopAreaController {

    @FXML
    private TilePane productArea;

    @FXML
    void initialize() {
        productArea.setHgap(4);
    }

    public void addNewItem(Node node) {
        productArea.getChildren().add(node);
    }

    public void loadItems(List<Product> products) {
        for (Product product : products) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ProductNode.fxml"));
            try {
                addNewItem(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            ((ProductNode)loader.getController()).setProduct(product);
        }
    }
}