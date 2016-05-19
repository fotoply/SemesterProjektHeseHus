package webshop.view.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import webshop.view.GUIController;

public class SearchController {

    @FXML
    private TextField searchTextField;

    @FXML
    void initialize() {
        searchTextField.setOnAction(event -> {searchChanged(searchTextField.getText());});
    }

    private void searchChanged(String newValue) {
        try {
            GUIController.getRootInstance().getShopAreaController().loadItems(GUIController.getWebshopInstance().searchProduct(newValue));
        } catch (RuntimeException e) {
            GUIController.getRootInstance().getShopAreaController().clearArea();
        }

    }
}
