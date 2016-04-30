package webshop.view.fxml;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class RootWindowController {

    private boolean searchShown = false;

    @FXML
    private Button optionsButton;

    @FXML
    private BorderPane centerPane;

    @FXML
    void initialize() {
        optionsButton.setPadding(Insets.EMPTY);
    }

    public void showSearchOptions() {
        searchShown = true;
        //centerPane.setLeft();
        //TODO Should show a menu for search options in the left part of the centerpane
    }

    public void hideSearchOptions() {
        searchShown = false;
        centerPane.setLeft(null);
        //TODO Hide the search menu again.
    }

    @FXML
    private void menuButtonPressed() {
        if(searchShown) {
            hideSearchOptions();
        } else  {
            showSearchOptions();
        }
    }

    public void showLoginScreen() {
        //TODO Shows the login screen. Should probably check if the user is already logged in.
    }

    public void showProfile() {
        //TODO Shows the profile of the current user, if they are logged in.
    }

}