package webshop.view.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import webshop.view.GUIController;

public class ProductInformationScreenController {

    private ProductNode product;

    @FXML
    private ImageView productImage;

    @FXML
    private Text titleText;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TextField quantityTextField;

    @FXML
    private Text textPrice;


    @FXML
    void initialize() {
        quantityTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            correctAmountValue(oldValue);
        });
    }

    private void correctAmountValue(String oldValue) {
        if (!isTextfieldValidAmount()) {
            quantityTextField.setText(oldValue);
        }
    }

    private boolean isTextfieldValidAmount() {
        if (quantityTextField.getText().isEmpty()) {
            return true;
        }
        try {
            Integer.parseInt(quantityTextField.getText());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @FXML
    void addToBasketClicked(ActionEvent event) {
        int amount = 1;
        if (!quantityTextField.getText().isEmpty()) {
            amount = getAmountFromTextfield();
        }
        GUIController.getRootInstance().addToBasket(product, amount);
    }

    private int getAmountFromTextfield() {
        return Integer.valueOf(quantityTextField.getText());
    }

    public void setProduct(ProductNode product) {
        this.product = product;
        this.productImage.setImage(RootWindowController.getDefaultImage());
        this.titleText.setText(product.getName());
        this.descriptionTextArea.setText(product.getDescription());
        this.textPrice.setText(product.getPrice());
    }
}
