package webshop.view.fxml;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;

public class RootWindowController {

    @FXML
    private Button optionsButton;

    @FXML
    void initialize() {
        BackgroundImage optionsButtonImage = new BackgroundImage(new Image("/res/menuButton.png"),null,null,null,null);
        optionsButton.setBackground(new Background(optionsButtonImage));
        optionsButton.setPadding(Insets.EMPTY);
    }

}