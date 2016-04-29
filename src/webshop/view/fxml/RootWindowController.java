package webshop.view.fxml;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class RootWindowController {

    @FXML
    private Button optionsButton;

    @FXML
    void initialize() {
        //ImageView optionsButtonImage = new ImageView("/res/menuButton.png");
        //optionsButton.setGraphic(optionsButtonImage);
        optionsButton.setPadding(Insets.EMPTY);
    }

    public void showSearchOptions() {

    }

    public void hideSearchOptions() {

    }

    public void showLoginScreen() {

    }

    public void showProfile() {

    }

}