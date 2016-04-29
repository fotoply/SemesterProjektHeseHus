package webshop.view.fxml;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class RootWindowController {

    @FXML
    private Button optionsButton;

    @FXML
    private BorderPane centerPane;

    @FXML
    void initialize() {
        //ImageView optionsButtonImage = new ImageView("/res/menuButton.png");
        //optionsButton.setGraphic(optionsButtonImage);
        optionsButton.setPadding(Insets.EMPTY);
    }

    public void showSearchOptions() {
        //TODO Should show a menu for search options in the left part of the centerpane
    }

    public void hideSearchOptions() {

    }

    public void showLoginScreen() {

    }

    public void showProfile() {

    }

}