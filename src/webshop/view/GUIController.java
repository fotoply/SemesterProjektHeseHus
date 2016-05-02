package webshop.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import webshop.model.Inventory.Product;
import webshop.model.Webshop;
import webshop.view.fxml.RootWindowController;

import java.io.IOException;
import java.util.List;

public class GUIController extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static RootWindowController rootInstance;
    private static Webshop webshopInstance;

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
    }
}
