package webshop.view.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import webshop.view.GUIController;

public class SearchController {

    @FXML
    private TextField searchTextField;

    @FXML
    void initialize() {
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {searchChanged(newValue);});
    }

    private void searchChanged(String newValue) {
        GUIController.getRootInstance().getShopAreaController().loadItems(GUIController.getWebshopInstance().searchProduct(newValue));

    }
}
