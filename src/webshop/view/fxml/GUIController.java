package webshop.view.fxml;/**
 * Created 4/29/16
 *
 * @author Niels Norberg
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIController extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static RootWindowController rootInstance;

    public static RootWindowController getRootInstance() {
        return rootInstance;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("RootWindow.fxml"));
        Scene scene = loader.load();
        rootInstance = loader.getController();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
