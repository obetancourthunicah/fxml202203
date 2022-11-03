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
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author obetancourth
 */
public class FormularioController implements Initializable {


    @FXML
    private Label lblTitulo;
    @FXML
    private TextField txtNomberCliente;
    @FXML
    private TextField txtTelefonoCliente;
    @FXML
    private TextField txtPlacaCarro;
    @FXML
    private TextField txtModeloCarro;
    @FXML
    private TextField txtMotivoCita;
    @FXML
    private TextField txtAnioCita;
    @FXML
    private TextField txtMesCita;
    @FXML
    private TextField txtDiaCita;
    @FXML
    private TextField txtHoraCita;
    @FXML
    private TextField txtEstadoCita;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void btnGuardar_click(ActionEvent event) {
    }

    @FXML
    private void btnCancelar_click(ActionEvent event) {
    }

}
