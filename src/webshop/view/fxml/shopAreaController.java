package webshop.view.fxml;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.TilePane;

public class ShopAreaController {

    @FXML
    private TilePane productArea;

    @FXML
    void initialize() {

    }

    public void addNewItem(Node node) {
        productArea.getChildren().add(node);
    }
}