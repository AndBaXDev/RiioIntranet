/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riiointranet.domain;

/**
 *
 * @author andbax
 */
public class Cliente {

    public Cliente(String identificacion, String nombre, String apellidos, String provincia, String canton, String distrito, String ubicacion, String email, String telefono, String codigoPostal) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.ubicacion = ubicacion;
        this.email = email;
        this.telefono = telefono;
        this.codigoPostal = codigoPostal;
    }

    public Cliente() {
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    private String identificacion;
    private String nombre;
    private String apellidos;
    private String provincia;    
    private String canton;
    private String distrito;        
    private String ubicacion;
    private String email;
    private String telefono;
    private String codigoPostal;

}
