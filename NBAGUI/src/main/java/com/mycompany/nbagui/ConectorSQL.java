package com.mycompany.nbagui;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ConectorSQL {

    private Connection conexion;
    private String dbURL;
    private String usuario;
    private String password;

    public ConectorSQL(String dbURL, String usuario, String password) throws SQLException {
        this.dbURL = dbURL;
        this.usuario = usuario;
        this.password = password;
        reconectar();
    }

    public void reconectar() throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
        conexion = DriverManager.getConnection(dbURL, usuario, password);
        System.out.println("Base de datos conectada");
    }

    public Connection getConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            reconectar();
        }
        return conexion;
    }

    public void cerrar() throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
            System.out.println("Base de datos desconectada");
        }
    }
}