package webshop.view.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import webshop.view.GUIController;

import java.util.Date;

public class LoginScreenController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void loginPressed(ActionEvent event) {
        if(GUIController.getWebshopInstance().loginWithEmail(emailField.getText(),passwordField.getText())) {
            GUIController.getRootInstance().loginSuccesful();
        } else {
            //TODO Display some sort of error message
        }

    }

    @FXML
    void signUpClicked(MouseEvent event) {
        GUIController.getRootInstance().showSignupScreen();
    }

}
