/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pmp.fxpmp202203;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;

import com.pmp.fxpmp202203.dao.CitaTallerDao;
import com.pmp.fxpmp202203.dao.CitaTaller;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author obetancourth
 */
public class ListaController implements Initializable {


    @FXML
    private TableView<CitaTaller> tableCitas;
    @FXML
    private Button btnNuevo;
    /**
     * Initializes the controller class.
     */
    private CitaTallerDao dao;
    private ArrayList<CitaTaller> citas;
    private CitaTaller selectedCita = null;
    @FXML
    private TableColumn<CitaTaller, Integer> td_id;
    @FXML
    private TableColumn<CitaTaller, String> td_nombreCliente;
    @FXML
    private TableColumn<CitaTaller, String> td_modeloCarro;
    @FXML
    private TableColumn<CitaTaller, String> td_placaCarro;
    @FXML
    private TableColumn<CitaTaller, String> td_estadoCita;
    @FXML
    private Button btnDisplay;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnDisplay.setDisable(true);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
            
        dao = new CitaTallerDao();
        citas = dao.obtenerCitas();
        initColumns();
        tableCitas.setItems(FXCollections.observableArrayList(citas));
        //System.out.println("Citas: " + String.valueOf(citas.size()));
    }
    private void initColumns(){
        td_id.setCellValueFactory(new PropertyValueFactory("id"));
        td_nombreCliente.setCellValueFactory(new PropertyValueFactory("nombreCliente"));
        td_modeloCarro.setCellValueFactory(new PropertyValueFactory("modeloCarro"));
        td_placaCarro.setCellValueFactory(new PropertyValueFactory("placaCarro"));
        td_estadoCita.setCellValueFactory(new PropertyValueFactory("estadoCita"));
        
    }

    @FXML
    private void on_table_row_selected(MouseEvent event) {
        if(event.getButton().equals(MouseButton.PRIMARY)){
          setSelectedRow();
        }
    }

    @FXML
    private void on_table_row_selected(KeyEvent event) {
        //setSelectedRow();
    }
    
    private void setSelectedRow(){
        selectedCita = (CitaTaller) tableCitas.getSelectionModel().getSelectedItem();
        if (selectedCita != null) {
            btnDisplay.setDisable(false);
            btnUpdate.setDisable(false);
            btnDelete.setDisable(false);
        }
    }

    @FXML
    private void on_create_click(ActionEvent event) {
        System.out.println("Create");
    }

    @FXML
    private void on_read_click(ActionEvent event) {
        System.out.println("Read");
    }

    @FXML
    private void on_update_click(ActionEvent event) {
        System.out.println("Update");
    }

    @FXML
    private void on_delete_click(ActionEvent event) {
        System.out.println("Delete");
    }
    
}
