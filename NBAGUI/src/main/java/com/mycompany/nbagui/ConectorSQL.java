package com.mycompany.nbagui;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    
    // Métodos para manejar partidos
    public ObservableList<Partido> obtenerTodosLosPartidos() throws SQLException {
        ObservableList<Partido> partidos = FXCollections.observableArrayList();
        String cons = "SELECT p.equipo_local, el.Conferencia as conferencia_local, " +
                     "p.puntos_local, p.puntos_visitante, p.equipo_visitante, " +
                     "ev.Conferencia as conferencia_visitante, p.temporada " +
                     "FROM partidos p " +
                     "JOIN equipos el ON p.equipo_local = el.Nombre " +
                     "JOIN equipos ev ON p.equipo_visitante = ev.Nombre " +
                     "ORDER BY p.temporada ASC";

        try (PreparedStatement pst = getConexion().prepareStatement(cons);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                Partido partido = new Partido(
                    rs.getString("equipo_local"),
                    rs.getString("conferencia_local"),
                    rs.getInt("puntos_local"),
                    rs.getInt("puntos_visitante"),
                    rs.getString("equipo_visitante"),
                    rs.getString("conferencia_visitante"),
                    rs.getString("temporada")
                );
                partidos.add(partido);
            }
        }
        return partidos;
    }

    public void insertarPartido(Partido partido, int codigo) throws SQLException {
        String cons = "INSERT INTO partidos (codigo, equipo_local, puntos_local, puntos_visitante, equipo_visitante, temporada) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = getConexion().prepareStatement(cons)) {
            pst.setInt(1, codigo);
            pst.setString(2, partido.getEquipoLocal());
            pst.setInt(3, partido.getPuntosLocal());
            pst.setInt(4, partido.getPuntosVisitante());
            pst.setString(5, partido.getEquipoVisitante());
            pst.setString(6, partido.getTemporada());
            pst.executeUpdate();
        }
    }

    public void actualizarPartido(Partido partido) throws SQLException {
        String cons = "UPDATE partidos SET puntos_local = ?, puntos_visitante = ? " +
                     "WHERE equipo_local = ? AND equipo_visitante = ? AND temporada = ?";

        try (PreparedStatement pst = getConexion().prepareStatement(cons)) {
            pst.setInt(1, partido.getPuntosLocal());
            pst.setInt(2, partido.getPuntosVisitante());
            pst.setString(3, partido.getEquipoLocal());
            pst.setString(4, partido.getEquipoVisitante());
            pst.setString(5, partido.getTemporada());
            pst.executeUpdate();
        }
    }

    public void eliminarPartido(Partido partido) throws SQLException {
        String cons = "DELETE FROM partidos WHERE equipo_local = ? AND equipo_visitante = ? AND temporada = ?";

        try (PreparedStatement pst = getConexion().prepareStatement(cons)) {
            pst.setString(1, partido.getEquipoLocal());
            pst.setString(2, partido.getEquipoVisitante());
            pst.setString(3, partido.getTemporada());
            pst.executeUpdate();
        }
    }

    // Métodos para obtener datos de filtros
    public ObservableList<String> obtenerTemporadas() throws SQLException {
        ObservableList<String> temporadas = FXCollections.observableArrayList();
        temporadas.add("Todas");
        
        String cons = "SELECT DISTINCT temporada FROM partidos ORDER BY temporada ASC";

        try (PreparedStatement stmt = getConexion().prepareStatement(cons);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                temporadas.add(rs.getString("temporada"));
            }
        }
        return temporadas;
    }

    public ObservableList<String> obtenerConferencias() throws SQLException {
        ObservableList<String> conferencias = FXCollections.observableArrayList();
        conferencias.add("Todas");
        
        String cons = "SELECT DISTINCT Conferencia FROM equipos ORDER BY Conferencia";

        try (PreparedStatement stmt = getConexion().prepareStatement(cons);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                conferencias.add(rs.getString("Conferencia"));
            }
        }
        return conferencias;
    }

    public ObservableList<String> obtenerEquipos() throws SQLException {
        ObservableList<String> equipos = FXCollections.observableArrayList();
        equipos.add("Todos");
        
        String cons = "SELECT Nombre FROM equipos ORDER BY Nombre";

        try (PreparedStatement pst = getConexion().prepareStatement(cons);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                equipos.add(rs.getString("Nombre"));
            }
        }
        return equipos;
    }

    //Método para obtener la conferencia de un equipo
    public String obtenerConferenciaEquipo(String nombreEquipo) throws SQLException {
        String cons = "SELECT Conferencia FROM equipos WHERE Nombre = ?";
        try (PreparedStatement pst = getConexion().prepareStatement(cons)) {
            pst.setString(1, nombreEquipo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString("Conferencia");
            }
        }
        return "Desconocida";
    }
    
}