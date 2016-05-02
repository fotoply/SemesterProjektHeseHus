package webshop.view.fxml;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import webshop.model.Inventory.Product;

import java.util.List;

public class ShopAreaController {

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
            addNewItem(new ProductNode(product));
        }
    }
}