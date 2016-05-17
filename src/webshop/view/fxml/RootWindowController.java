package webshop.view.fxml;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import webshop.view.GUIController;

import java.io.IOException;
import java.net.URL;

public class RootWindowController {

    private boolean searchShown = false;
    private ShopAreaController shopAreaController;
    private SignupScreenController signupScreen;
    private LoginScreenController loginScreen;

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

        showShopArea();

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
        setCenterFromString("LoginScreen.fxml");
    }

    public void showProfile() {
        //TODO Shows the profile of the current user, if they are logged in.
    }

    public void showShopArea() {
        FXMLLoader loader = createLoaderFromResource(getClass().getResource("ShopArea.fxml"));
        try {
            borderPane.setCenter(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        shopAreaController = loader.getController();
        shopAreaController.loadItems(GUIController.getProducts());
    }

    public void showBasket() {
        setCenterFromString("BasketScreen.fxml");
    }

    private FXMLLoader createLoaderFromResource(URL resource) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(resource);
        return loader;
    }

    public void showProduct(ProductNode product) {
        FXMLLoader loader = createLoaderFromResource(getClass().getResource("ProductInformationScreen.fxml"));
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
        setCenterFromString("SignupScreen.fxml");
    }

    private void setCenterFromString(String url) {
        FXMLLoader loader = createLoaderFromResource(getClass().getResource(url));
        try {
            borderPane.setCenter(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loginSuccesful() {
        showShopArea();
        loginButton.setText("Profile");
    }

    public synchronized void addToBasket(ProductNode node) {
        addToBasket(node, 1);
    }

    public void addToBasket(ProductNode node, int amount) {
        GUIController.getWebshopInstance().addItem(node.getProduct(), amount);
        System.out.println(node.getProduct() + " was added");
    }
}