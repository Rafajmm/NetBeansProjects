package com.mycompany.nbagui;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author rafa
 */
public class VistaPrincipalController implements Initializable {
    private NBAGUI nba;
    @FXML 
    private ChoiceBox<String> choiceConferencias;
    @FXML 
    private ChoiceBox<String> choiceTemporadas;
    @FXML 
    private ChoiceBox<String> choiceTemporadas2;
    @FXML 
    private ChoiceBox<String> choiceEquiposLocal;
    @FXML 
    private ChoiceBox<String> choiceEquiposVisitante;
    @FXML 
    private Button buttonAplicar;
    
    @FXML 
    private TableView<Partido> tablaPartidos;
    @FXML 
    private TableColumn<Partido, String> colEquipoLocal;
    @FXML 
    private TableColumn<Partido, String> colConferenciaLocal;
    @FXML 
    private TableColumn<Partido, Integer> colPuntosLocal;
    @FXML 
    private TableColumn<Partido, Integer> colPuntosVisitante;
    @FXML 
    private TableColumn<Partido, String> colEquipoVisitante;
    @FXML 
    private TableColumn<Partido, String> colConferenciaVisitante;
    @FXML 
    private TableColumn<Partido, String> colTemporada;
    
    @FXML 
    private Label labelEstadistica1;
    @FXML 
    private Label labelEstadistica2;
    @FXML 
    private Label labelEstadistica3;
    @FXML 
    private Label labelEstadistica4;
    @FXML 
    private Label labelEstadistica5;
    
    private ObservableList<Partido> todosLosPartidos = FXCollections.observableArrayList();
    private FilteredList<Partido> partidosFiltrados = new FilteredList<>(todosLosPartidos);
    private ObservableList<String> temporadasDisponibles = FXCollections.observableArrayList();
    private ObservableList<String> conferenciasDisponibles = FXCollections.observableArrayList();
    private ObservableList<String> equiposDisponibles = FXCollections.observableArrayList();
    
    private ConectorSQL conector;
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void setConectorSQL(ConectorSQL conector) {
        this.conector = conector;
        
    }
    
       
    
    public void setNBAGUI(NBAGUI nba){
        this.nba=nba;
    }
    
    
}
