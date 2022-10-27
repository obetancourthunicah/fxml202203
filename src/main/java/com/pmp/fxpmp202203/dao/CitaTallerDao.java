/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.fxpmp202203.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.Exception;
import java.util.ArrayList;
//import com.pmp.pmp202203.CitaTaller;
/**
 *
 * @author obetancourth
 */
public class CitaTallerDao {
    /*
    nombreCliente;
    telefonoCliente;
    placaCarro;
    modeloCarro;
    motivoCita;
    anioCita;
    mesCita;
    diaCita;
    hora24Cita;
    estadoCita
    */
    private Connection conn = null;
    public CitaTallerDao(){
        try {
        conn = Conexion.getConnection();
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS CITATALLER ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + "nombreCliente TEXT ,"
                + "telefonoCliente TEXT ,"
                + "placaCarro TEXT ,"
                + "modeloCarro TEXT ,"
                + "motivoCita TEXT ,"
                + "anioCita INTEGER ,"
                + "mesCita INTEGER ,"
                + "diaCita INTEGER ,"
                + "hora24Cita INTEGER ,"
                + "estadoCita TEXT"
                + ");";
        Statement comandoSQLCreate = conn.createStatement();
        comandoSQLCreate.executeUpdate(sqlCreateTable);
        comandoSQLCreate.close();
        } catch(Exception ex){
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }
    
    public void insertCita(CitaTaller newCita){
        try{
            String sqlInsert = "INSERT INTO CITATALLER (nombreCliente, " +
                    "telefonoCliente, placaCarro, modeloCarro, motivoCita, " +
                    "anioCita, mesCita, diaCita, hora24Cita, estadoCita) values (" +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement comandoInsert = conn.prepareStatement(sqlInsert);
            
            comandoInsert.setString(1, newCita.getNombreCliente());
            comandoInsert.setString(2, newCita.getTelefonoCliente());
            comandoInsert.setString(3, newCita.getPlacaCarro());
            comandoInsert.setString(4, newCita.getModeloCarro());
            comandoInsert.setString(5, newCita.getMotivoCita());
            comandoInsert.setInt(6, newCita.getAnioCita());
            comandoInsert.setInt(7, newCita.getMesCita());
            comandoInsert.setInt(8, newCita.getDiaCita());
            comandoInsert.setInt(9, newCita.getHora24Cita());
            comandoInsert.setString(10, newCita.getEstadoCita());
            
            int registroAgregados = comandoInsert.executeUpdate();
            System.out.println(registroAgregados);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());        
        }
        
    }
    
    public void updateCita(CitaTaller updateCita) {
        try {
            String sqlStrUpdate = "UPDATE CITATALLER set nombreCliente = ? ,m" +
                " telefonoCliente = ?," +
                " placaCarro = ?," +
                " modeloCarro = ?," +
                " motivoCita = ?," +
                " anioCita = ?," +
                " mesCita = ?," +
                " diaCita = ?," +
                " hora24Cita = ?," +
                " estadoCita = ? where id = ?;";
            PreparedStatement comando = this.conn.prepareStatement(sqlStrUpdate);
            comando.setString(1, updateCita.getNombreCliente());
            comando.setString(2, updateCita.getTelefonoCliente());
            comando.setString(3, updateCita.getPlacaCarro());
            comando.setString(4, updateCita.getModeloCarro());
            comando.setString(5, updateCita.getMotivoCita());
            comando.setInt(6, updateCita.getAnioCita());
            comando.setInt(7, updateCita.getMesCita());
            comando.setInt(8, updateCita.getDiaCita());
            comando.setInt(9, updateCita.getHora24Cita());
            comando.setString(10, updateCita.getEstadoCita());
            comando.setInt(11, updateCita.getId());
            comando.executeUpdate();
            comando.close();
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void deleteCita(CitaTaller deleteCita) {
         try {
            String sqlStrDelete = "DELETE FROM CITATALLER where id = ?;";
            PreparedStatement comando = this.conn.prepareStatement(sqlStrDelete);
            comando.setInt(1, deleteCita.getId());
            comando.executeUpdate();
            comando.close();
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<CitaTaller> obtenerCitas() {
        try {
            String sqlstr = "SELECT * from CITATALLER;";
            Statement comando = conn.createStatement();
            ArrayList citas = new ArrayList<CitaTaller>();
            ResultSet registros = comando.executeQuery(sqlstr);
            while (registros.next()){
                CitaTaller citaTaller = new CitaTaller();
                citaTaller.setId(registros.getInt("id"));
                citaTaller.setNombreCliente(registros.getString("nombreCliente"));
                citaTaller.setTelefonoCliente(registros.getString("telefonoCliente"));
                citaTaller.setPlacaCarro(registros.getString("placaCarro"));
                citaTaller.setModeloCarro(registros.getString("modeloCarro"));
                citaTaller.setMotivoCita(registros.getString("motivoCita"));
                citaTaller.setAnioCita(registros.getInt("anioCita"));
                citaTaller.setMesCita(registros.getInt("mesCita"));
                citaTaller.setDiaCita(registros.getInt("diaCita"));
                citaTaller.setHora24Cita(registros.getInt("hora24Cita"));
                citaTaller.setEstadoCita(registros.getString("estadoCita"));
                citas.add(citaTaller);
            }
            return citas;
        } catch (Exception ex){
            System.err.println(ex.getMessage());
            return new ArrayList<CitaTaller>();
        }
    }
}
 