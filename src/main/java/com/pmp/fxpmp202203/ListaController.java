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
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dao = new CitaTallerDao();
        citas = dao.obtenerCitas();
        initColumns();
        tableCitas.setItems(FXCollections.observableArrayList(citas));
        //System.out.println("Citas: " + String.valueOf(citas.size()));
    }
    private void initColumns(){
        td_id.setCellValueFactory(new PropertyValueFactory("id"));
        td_nombreCliente.setCellValueFactory(new PropertyValueFactory("nombreCliente"));
        
    }
    
}
