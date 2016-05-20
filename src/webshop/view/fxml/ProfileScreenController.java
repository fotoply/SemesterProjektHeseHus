/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshop.view.fxml;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileScreenController implements Initializable {
    @FXML
    private Text addressID;
    @FXML
    private Text phoneID;
    @FXML
    private Text emailID;
    @FXML
    private Text birthdayID;
    @FXML
    private Text nameText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
