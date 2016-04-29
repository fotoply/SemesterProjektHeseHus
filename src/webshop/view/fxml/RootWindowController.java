package webshop.view.fxml;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;

public class RootWindowController {

    @FXML
    private Button optionsButton;

    @FXML
    void initialize() {
        //ImageView optionsButtonImage = new ImageView("/res/menuButton.png");
        //optionsButton.setGraphic(optionsButtonImage);
        optionsButton.setPadding(Insets.EMPTY);
    }

}