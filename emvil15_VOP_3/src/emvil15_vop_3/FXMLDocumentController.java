/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emvil15_vop_3;

import arrays.ArrayTester;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import poly_and_strings.*;
import urban_population.UrbanPopulationStatistics;


/**
 *
 * @author VilleV
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ToggleGroup caseGrp;
    @FXML
    private RadioButton upperCase;
    @FXML
    private RadioButton lowerCase;
    @FXML
    private RadioButton flipCase;
    @FXML
    private TextField inputField;
    @FXML
    private TextField outputField;
    @FXML
    private TextField arraySizeField;
    @FXML
    private Button fillBtn;
    @FXML
    private Button sortBtn;
    @FXML
    private Button reverseBtn;
    
    private ArrayTester arrayTester;
    
    @FXML
    private TextArea arrayOutputArea;
    @FXML
    private Button urbanRunBtn;
    @FXML
    private TextArea urbanOutputArea;
    
    private UrbanPopulationStatistics urbPop;
    private static final String FILENAME = "ByBefolkning.txt";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void caseHandler(ActionEvent event) {
        StringManipulable stringManip;
        
        if(upperCase.isSelected()) {
            stringManip = new ToUpperManip(inputField.getText());
        } else if (lowerCase.isSelected()) {
            stringManip = new ToLowerManip(inputField.getText());
        } else {
            stringManip = new FlipUpperLowerManip(inputField.getText());
        }
        
        outputField.setText(stringManip.manip());
        
    }

    @FXML
    private void fillBtnHandler(ActionEvent event) {
        
        arrayTester = new ArrayTester(Integer.parseInt(arraySizeField.getText()));
        
        arrayOutputArea.appendText(arrayTester.toString());
        
    }

    @FXML
    private void sortBtnHandler(ActionEvent event) {
        
        if(arrayTester != null) {
            
            arrayTester.sort();
            
            arrayOutputArea.appendText("Sorted:" + arrayTester.toString());
            
        } else {
            arrayOutputArea.appendText("Error: arrayTester not initialized.");
        }
        
    }

    @FXML
    private void reverseBtnHandler(ActionEvent event) {
        
        if(arrayTester != null) {
            
            arrayTester.reverse();
            
            arrayOutputArea.appendText("Reversed:" + arrayTester.toString());

        } else {
            arrayOutputArea.appendText("Error: arrayTester not initialized.");
        }
        
    }

    @FXML
    private void urbanRunBtnHandler(ActionEvent event) {
        
        urbPop = new UrbanPopulationStatistics(FILENAME);
        
        urbanOutputArea.appendText(urbPop.toString());
        
    }

    

    
}
