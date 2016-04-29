package webshop.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import webshop.view.fxml.RootWindowController;

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
        loader.setLocation(getClass().getResource("fxml/RootWindow.fxml"));
        Scene scene = new Scene(loader.load());
        rootInstance = loader.getController();
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
