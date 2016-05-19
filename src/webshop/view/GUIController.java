package webshop.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import webshop.model.Inventory.Product;
import webshop.model.Money;
import webshop.model.Webshop;
import webshop.model.payments.GiftCard;
import webshop.view.fxml.RootWindowController;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class GUIController extends Application {

    private static RootWindowController rootInstance;
    private static Webshop webshopInstance;

    public static void main(String[] args) {
        launch(args);
        new GiftCard(new Money("2000"), 1);
        new GiftCard(new Money("200"), 2);
        new GiftCard(new Money("4000"), 3);
        new GiftCard(new Money("500"), 4);
        new GiftCard(new Money("3000"), 5);
    }

    public static RootWindowController getRootInstance() {
        return rootInstance;
    }

    public static Webshop getWebshopInstance() {
        return webshopInstance;
    }

    public static List<Product> getProducts() {
        return webshopInstance.getProducts();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        webshopInstance = Webshop.getInstance();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("fxml/RootWindow.fxml"));
        Scene scene = new Scene(loader.load());
        rootInstance = loader.getController();
        primaryStage.initStyle(StageStyle.UNIFIED);
        primaryStage.setScene(scene);
        primaryStage.show();
        //webshopInstance.createCustomer("testnavn", "testvej", 12345678, "test", "test", new Date());
    }
}
