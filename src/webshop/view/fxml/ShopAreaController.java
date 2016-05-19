package webshop.view.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import webshop.model.Inventory.Product;
import webshop.view.GUIController;

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
        clearArea();
        for (Product product : products) {
            addNewItem(new ProductNode(product));
        }
    }

    @FXML
    void showBasketClicked(ActionEvent event) {
        GUIController.getRootInstance().showBasket();
    }

    public void clearArea() {
        productArea.getChildren().clear();
    }
}