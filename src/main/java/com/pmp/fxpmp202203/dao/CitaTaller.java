/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.fxpmp202203.dao;

/**
 *  PJO  Plain Java Object
 * @author obetancourth
 */
public class CitaTaller {

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public Integer getAnioCita() {
        return anioCita;
    }

    public void setAnioCita(Integer anioCita) {
        this.anioCita = anioCita;
    }

    public Integer getMesCita() {
        return mesCita;
    }

    public void setMesCita(Integer mesCita) {
        this.mesCita = mesCita;
    }

    public Integer getDiaCita() {
        return diaCita;
    }

    public void setDiaCita(Integer diaCita) {
        this.diaCita = diaCita;
    }

    public Integer getHora24Cita() {
        return hora24Cita;
    }

    public void setHora24Cita(Integer hora24Cita) {
        this.hora24Cita = hora24Cita;
    }

    public String getEstadoCita() {
        // Transformacion de Datos
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        // Validar la entrada de datos
        this.estadoCita = estadoCita;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String nombreCliente;
    private String telefonoCliente;
    private String placaCarro;
    private String modeloCarro;
    private String motivoCita;
    private Integer anioCita;
    private Integer mesCita;
    private Integer diaCita;
    private Integer hora24Cita;
    private String estadoCita;
    private Integer id;

}
