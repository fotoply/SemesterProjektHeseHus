package webshop.view.fxml;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import webshop.view.GUIController;

import java.io.IOException;

public class RootWindowController {

    private boolean searchShown = false;
    private ShopAreaController shopAreaController;

    @FXML
    private Button loginButton;

    @FXML
    private Button optionsButton;

    @FXML
    private BorderPane borderPane;

    public static Image getDefaultImage() {
        return new Image("/res/placeholderProductIcon.png");
    }

    @FXML
    void initialize() {
        optionsButton.setPadding(Insets.EMPTY);
        showShopArea();
    }

    public void showSearchOptions() {
        searchShown = true;
        //borderPane.setLeft();
        //TODO Should show a menu for search options in the left part of the center pane
    }

    public void hideSearchOptions() {
        searchShown = false;
        borderPane.setLeft(null);
        //TODO Hide the search menu again.
    }

    @FXML
    private void menuButtonPressed() {
        if (searchShown) {
            hideSearchOptions();
        } else {
            showSearchOptions();
        }
    }

    @FXML
    private void loginButtonPressed() {
        if (GUIController.getWebshopInstance().isLoggedIn()) {
            showProfile();
        } else {
            showLoginScreen();
        }
    }

    public void showLoginScreen() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("LoginScreen.fxml"));
        try {
            borderPane.setCenter(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showProfile() {
        //TODO Shows the profile of the current user, if they are logged in.
    }

    public void showShopArea() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ShopArea.fxml"));
        try {
            borderPane.setCenter(loader.load());
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

    public void showProduct(ProductNode product) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ProductInformationScreen.fxml"));
        try {
            borderPane.setCenter(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((ProductInformationScreenController) loader.getController()).setProduct(product);
    }

    public ShopAreaController getShopAreaController() {
        return shopAreaController;
    }

    public void showSignupScreen() {
        FXMLLoader loader = createFXMLLoader();
        try {
            borderPane.setCenter(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO create and display signup screen
    }

    private FXMLLoader createFXMLLoader() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SignupScreen.fxml"));
        return loader;
    }

    public void loginSuccesful() {
        showShopArea();
        loginButton.setText("Profile");
    }

    public void addToBasket(ProductNode node) {
        //TODO Fix concurrentModificationException issue.
        //synchronised keyword does not fix it.. For some odd reason
        addToBasket(node, 1);
    }

    public void addToBasket(ProductNode node, int amount) {
        GUIController.getWebshopInstance().addItem(node.getProduct(), amount);
        System.out.println(node.getProduct() + " was added");
    }
}