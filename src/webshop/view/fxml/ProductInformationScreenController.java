package webshop.view.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import webshop.view.GUIController;

public class ProductInformationScreenController {

    ProductNode product;

    @FXML
    private ImageView productImage;

    @FXML
    private Text titleText;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TextField quantityTextField;

    @FXML
    void addToBasketClicked(ActionEvent event) {
        GUIController.getRootInstance().addToBasket(product);
    }

}
