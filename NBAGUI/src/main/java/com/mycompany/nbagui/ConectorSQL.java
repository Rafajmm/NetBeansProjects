/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nbagui;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ConectorSQL {

    private Connection conexion ;

    public ConectorSQL(String dbURL, String usuario, String password) throws SQLException {

        conexion = DriverManager.getConnection(dbURL, usuario, password);
        System.out.println("Base de datos conectada");

    }

    public void cerrar() throws SQLException {
        if (conexion != null) {
            conexion.close();
            System.out.println("Base de datos desconectada");
        }
    }
    
}