package webshop.view.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import webshop.view.GUIController;

import java.time.Instant;
import java.util.Date;

public class SignupScreenController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    private PasswordField repeatPasswordField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField repeatEmailField;

    @FXML
    private DatePicker dateOfBirthPicker;

    @FXML
    void signupPressed(ActionEvent event) {
        //TODO verify that all data is valid
        //TODO Find a way to display what data is invalid and why

        if(!emailField.getText().equalsIgnoreCase(repeatEmailField.getText())) {
            return;
        }

        if(!passwordField.getText().equalsIgnoreCase(repeatPasswordField.getText())) {
            return;
        }

        GUIController.getWebshopInstance().createCustomer(nameField.getText(), addressField.getText(), emailField.getText(), passwordField.getText(), Date.from(Instant.from(dateOfBirthPicker.getValue().atStartOfDay())), Integer.parseInt(phoneField.getText()));
        GUIController.getRootInstance().showLoginScreen();
    }


}
