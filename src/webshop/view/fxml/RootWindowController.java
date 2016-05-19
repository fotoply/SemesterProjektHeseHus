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

    @FXML
    private Button homeButton;

    public static Image getDefaultImage() {
        return new Image("/res/placeholderProductIcon.png");
    }

    @FXML
    void initialize() {
        optionsButton.setPadding(Insets.EMPTY);
        homeButton.setPadding(Insets.EMPTY);
        showShopArea();
    }

    public void showSearchOptions() {
        searchShown = true;
        FXMLLoader loader = createLoaderFromResource(getClass().getResource("SearchArea.fxml"));
        try {
            borderPane.setBottom(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO Should show a menu for search options in the left part of the center pane
    }

    public void hideSearchOptions() {
        searchShown = false;
        borderPane.setBottom(null);
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

    @FXML
    private void homeButtonPressed() {
        showShopArea();
    }

    public void showLoginScreen() {
        setCenterFromString("LoginScreen.fxml");
    }

    public void showProfile() {
        //TODO Shows the profile of the current user, if they are logged in.
    }

    public void showShopArea() {
        FXMLLoader loader = setCenterFromString("ShopArea.fxml");
        shopAreaController = loader.getController();
        shopAreaController.loadItems(GUIController.getWebshopInstance().searchProduct(""));
    }

    public void showBasket() {
        FXMLLoader loader = setCenterFromString("BasketScreen.fxml");
        if (GUIController.getWebshopInstance().getCurrentOrder() != null) {
            GUIController.getWebshopInstance().getCurrentOrder().setFinalPrice(GUIController.getWebshopInstance().getCurrentOrder().getTotalAmountOwedForProducts());
            ((BasketScreenController) loader.getController()).applyBasket(GUIController.getWebshopInstance().getCurrentOrder().getProductList(), GUIController.getWebshopInstance().getCurrentOrder().getTotalAmountOwedForProducts().toString());
        }
    }

    private FXMLLoader createLoaderFromResource(URL resource) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(resource);
        return loader;
    }

    public void showProduct(ProductNode product) {
        FXMLLoader loader = setCenterFromString("ProductInformationScreen.fxml");
        ((ProductInformationScreenController) loader.getController()).setProduct(product);
    }

    public ShopAreaController getShopAreaController() {
        return shopAreaController;
    }

    public void showSignupScreen() {
        setCenterFromString("SignupScreen.fxml");
    }

    private FXMLLoader setCenterFromString(String url) {
        FXMLLoader loader = createLoaderFromResource(getClass().getResource(url));
        try {
            borderPane.setCenter(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loader;
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