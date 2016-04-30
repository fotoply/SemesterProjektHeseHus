package webshop.view.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import webshop.view.GUIController;

public class LoginPopupController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void loginPressed(ActionEvent event) {
        GUIController.getWebshopInstance().loginWithEmail(emailField.getText(),passwordField.getText());
    }

    @FXML
    void signUpClicked(MouseEvent event) {

    }

}
