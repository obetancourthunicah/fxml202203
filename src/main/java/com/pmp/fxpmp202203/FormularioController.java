/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pmp.fxpmp202203;

import com.pmp.fxpmp202203.dao.CitaTaller;
import com.pmp.fxpmp202203.dao.CitaTallerDao;
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
    
    private CitaTaller cita;
    private CitaTallerDao citas;
    
    private boolean mustReload = false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    // Metodos
    public void setCitasDao(CitaTallerDao dao){
        citas = dao;
    }
    public void setCita(CitaTaller selectedCita){
        cita = selectedCita;
    }
    
    public void setMode(String mode){
        if (mode.equalsIgnoreCase("INS")){
            
        } else {
            if (cita != null) {
                txtNomberCliente.setText(cita.getNombreCliente());
                txtTelefonoCliente.setText(cita.getTelefonoCliente());
                txtPlacaCarro.setText(cita.getPlacaCarro());
                txtModeloCarro.setText(cita.getModeloCarro());
                txtMotivoCita.setText(cita.getMotivoCita());
                txtAnioCita.setText(String.valueOf(cita.getAnioCita()));
                txtMesCita.setText(String.valueOf(cita.getMesCita()));
                txtDiaCita.setText(String.valueOf(cita.getDiaCita()));
                txtHoraCita.setText(String.valueOf(cita.getHora24Cita()));
                txtEstadoCita.setText(cita.getEstadoCita());
            } 
            if(mode.equalsIgnoreCase("DEL") || mode.equalsIgnoreCase("DSP")){
                txtNomberCliente.setEditable(false);
                txtNomberCliente.setDisable(true);
                txtTelefonoCliente.setEditable(false);
                txtPlacaCarro.setEditable(false);
                txtModeloCarro.setEditable(false);
                txtMotivoCita.setEditable(false);
                txtAnioCita.setEditable(false);
                txtMesCita.setEditable(false);
                txtDiaCita.setEditable(false);
                txtHoraCita.setEditable(false);
                txtEstadoCita.setEditable(false);
                
                txtTelefonoCliente.setDisable(true);
                txtPlacaCarro.setDisable(true);
                txtModeloCarro.setDisable(true);
                txtMotivoCita.setDisable(true);
                txtAnioCita.setDisable(true);
                txtMesCita.setDisable(true);
                txtDiaCita.setDisable(true);
                txtHoraCita.setDisable(true);
                txtEstadoCita.setDisable(true);
                
                btnGuardar.setVisible(!mode.equalsIgnoreCase("DSP"));
            }
            switch (mode) {
                case "UPD":
                    lblTitulo.setText("Editando Cita");
                    break;
                case "DEL":
                    lblTitulo.setText("Eliminando Cita");
                    break;
                case "DSP":
                    lblTitulo.setText("Detalle de Cita");
                    break;
               
            }
        }     
    }
    
    public boolean getMustReload(){
        return mustReload;
    }
    
    @FXML
    private void btnGuardar_click(ActionEvent event) {
        cita.setNombreCliente(txtNomberCliente.getText());
        cita.setTelefonoCliente(txtTelefonoCliente.getText());
        cita.setPlacaCarro(txtPlacaCarro.getText());
        cita.setModeloCarro(txtModeloCarro.getText());
        cita.setMotivoCita(txtMotivoCita.getText());
        cita.setAnioCita(Integer.valueOf(txtAnioCita.getText()));
        cita.setMesCita(Integer.valueOf(txtMesCita.getText()));
        cita.setDiaCita(Integer.valueOf(txtDiaCita.getText()));
        cita.setHora24Cita(Integer.valueOf(txtHoraCita.getText()));
        cita.setEstadoCita(txtEstadoCita.getText());
        switch(mode){
            case "INS":
                citas.insertCita(cita);
                break;
            case "UPD":
                citas.updateCita(cita);
                break;
            case "DEL":
                citas.deleteCita(cita);
                break;
        }
        mustReload = true;
        //App.closeModal(null);
    }

    @FXML
    private void btnCancelar_click(ActionEvent event) {
        mustReload = false;
        //App.closeModal(null);
    }

}
