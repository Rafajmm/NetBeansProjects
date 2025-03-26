package com.mycompany.pruebabasedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author usuario
 */
public class BaseDatos {
    String url="jdbc:mysql://localhost/";
    String nombreBD;
    String usuario;
    String contraseña;
    Connection con;
    
    BaseDatos(String url, String nombreBD, String usuario, String contraseña){
        this.url=url;
        this.nombreBD=nombreBD;
        this.usuario=usuario;
        this.contraseña=contraseña;
        try{
            con=DriverManager.getConnection(this.url+this.nombreBD,this.usuario,this.contraseña);
        }
        catch(SQLException e){
            System.out.println("no se ha podido establecer conexion.\n"+e.getMessage());
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombreBD() {
        return nombreBD;
    }

    public void setNombreBD(String nombreBD) {
        this.nombreBD = nombreBD;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Connection getCon() {
        return con;
    }
    
    
    public void nuevaCon(String nombreBD){
        setNombreBD(nombreBD);
        try{
            con=DriverManager.getConnection(this.url+this.nombreBD,this.usuario,this.contraseña);
        }
        catch(SQLException e){
            System.out.println("no se ha podido establecer conexion.\n"+e.getMessage());
        }
    }
}
