package webshop.view.fxml;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import webshop.view.GUIController;

import java.io.IOException;

public class RootWindowController {

    private boolean searchShown = false;
    private webshop.view.fxml.shopAreaController shopAreaController;

    @FXML
    private Button optionsButton;

    @FXML
    private BorderPane centerPane;

    @FXML
    void initialize() {
        optionsButton.setPadding(Insets.EMPTY);
        showShopArea();
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

    @FXML
    private void loginButtonPressed() {
        if(GUIController.getWebshopInstance().isLoggedIn()) {
            showProfile();
        } else {
            showLoginScreen();
        }
    }

    public void showLoginScreen() {
        //TODO Shows the login screen. Should probably check if the user is already logged in.
    }

    public void showProfile() {
        //TODO Shows the profile of the current user, if they are logged in.
    }

    public void showShopArea() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("shopArea.fxml"));
        try {
            centerPane.setCenter(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        shopAreaController = loader.getController();
        shopAreaController.loadItems(GUIController.getProducts());
        //TODO make it show the general shop grid-view.
    }

    public void showBasket() {
        //TODO Shows the basket of the current user, if any
    }

    public webshop.view.fxml.shopAreaController getShopAreaController() {
        return shopAreaController;
    }
}