/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pmp.fxpmp202203;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
/**
 * FXML Controller class
 *
 * @author obetancourth
 */
public class CalculadoraController implements Initializable {


    @FXML
    private Label txtDisplay;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnParentesis;
    @FXML
    private Button btnPercentage;
    @FXML
    private Button btnDivide;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btnMultiply;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btnSustract;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnSymbol;
    @FXML
    private Button btn0;
    @FXML
    private Button btnDecimal;
    @FXML
    private Button btnEqual;
    
    private String currentValue = "0";
    private String lastValue = "0";
    private Boolean decimalMode = false;
    private String action = "";
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void onClick_btns(ActionEvent event) {
        String btnClicked = ((Button) event.getTarget()).getId();
        System.out.println(btnClicked);
        switch (btnClicked) {
            case "btnClear":
                currentValue="0";
                lastValue="0";
                decimalMode=false;
                action = "";
                txtDisplay.setText(currentValue);
                break;
            case "btnDecimal":
                decimalMode = !currentValue.contains(".");
                break;
            case "btnEqual":
                if(!action.isEmpty()){
                    currentValue = operateAction(action, currentValue, lastValue);
                    txtDisplay.setText(currentValue);
                    lastValue = currentValue;
                    action = "";
                }
                
                break;
            case "btnSustract", "btnAdd", "btnDivide", "btnMultiply", "btnPercentage":
                action = btnClicked.replace("btn", "");
                if (!lastValue.equals(currentValue)){
                    currentValue = operateAction(action, currentValue, lastValue);
                    lastValue="";
                    txtDisplay.setText(currentValue);
                }
                lastValue = currentValue;
                break;
            default:
                String value = btnClicked.replace("btn", "");
                if (!action.isEmpty() && currentValue.equals(lastValue)){
                    currentValue = value;
                } else {
                    if (currentValue.equals("0") && !decimalMode){
                        currentValue = value;
                    } else {
                        if (decimalMode){
                            currentValue = currentValue + ".";
                            decimalMode = false;
                        }
                        currentValue = currentValue + value;
                    }
                }
                txtDisplay.setText(currentValue);
                break;
        }
        
    }
    
    private String operateAction(String _action, String _currentValue, String _lastValue) {
        Double a = Double.valueOf(_lastValue);
        Double b = Double.valueOf(_currentValue);
        Double c;
        switch(_action){
            case "Add":
                c = (a + b);
                break;
            case "Sustract":
                c = ( a - b);
                break;
            case "Divide":
                if (b == 0 ) {
                    return "ERROR";
                }
                c = (a/b);
                break;
            case "Multiply":
                c = (a * b);
                break;
            case "Percentage":
                if ( b >= 0 && b<= 100){
                    c = (a * (b / 100));
                    break;
                }
                return "Error";
            default:
                return "Error";
        }
        if( c % 1 != 0) {
            return String.format("%s", c);
        }
        return String.format("%.0f", c);
    }
    
    
    


}
