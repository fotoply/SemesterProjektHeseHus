package webshop.view.fxml;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import webshop.Product;

public class ProductNode {

    @FXML
    private ImageView productImage;

    @FXML
    private Text priceTextField;

    @FXML
    private Text titleTextField;

    public void setProduct(Product product) {
        productImage.setImage(new Image("/res/placeholderProductIcon"));
        priceTextField.setText(product.getPrice().getAmountAsString());
        titleTextField.setText(product.getName());
    }
}
