package com.mycompany.nbagui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VistaPrincipalController implements Initializable {
    private NBAGUI nba;
    @FXML 
    private ChoiceBox<String> choiceConferencias;
    @FXML 
    private ChoiceBox<String> choiceConferencias2;
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
    private Button buttonConf;
    
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
    private ManejarFichero mIni;
    private static final String rutaConfig = "./config.ini"; 
    private static final String rutaConfig2="./config.xml";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        cargarConfiguracionInicial();
        try {
            conector=new ConectorSQL(mIni.getDbUrl(),mIni.getUsuario(),mIni.getPsswd());
        } 
        catch (SQLException ex) {
            Logger.getLogger(VistaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cargarTodosLosDatos();
        actualizarEstadisticas();
        configurarTabla();
        
    }
    
    public void abrirConfiguracion(){
        try {
            nba.cambiarVista("VistaInicio");
        } catch (IOException ex) {
            mostrarAlerta("Error","Error al cambiar de vista","No se ha podido abrir el menú de configuración");
        }
    }
    
    public void setConectorSQL(ConectorSQL conector) {
        this.conector = conector;
        
    }           
    
    public void setNBAGUI(NBAGUI nba){
        this.nba=nba;
    }
    
    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    public ManejarFichero getmIni() {
        return mIni;
    }        
    
    public boolean cargarConfiguracionInicial() {
        try {
            mIni = new ManejarFichero(rutaConfig);           
            conector=new ConectorSQL(mIni.getDbUrl(),mIni.getUsuario(),mIni.getPsswd());
            return true;
        } 
        catch (Exception e) {
            try{
                mIni = new ManejarFichero(rutaConfig2);                
                conector=new ConectorSQL(mIni.getDbUrl(),mIni.getUsuario(),mIni.getPsswd());
                return true;
            }
            catch(Exception ex){
                mostrarAlerta("Error", "No se pudo cargar la configuración", "Se abrirá el menú de configuración.");    
                return false;
            }
        }
    }
    
    public void iniciar() {
        try {
            if (conector.getConexion() != null && !conector.getConexion().isClosed()) {
                cargarTodosLosDatos();
            } else {
                mostrarAlerta("Error", "Conexión cerrada (metodo iniciar)", "La conexión a la base de datos está cerrada");
            }
        } catch (SQLException e) {
            mostrarErrorBD("Error al verificar conexión", e);
        }
    }

    
    private void configurarTabla() {
        colEquipoLocal.setCellValueFactory(new PropertyValueFactory<>("equipoLocal"));
        colConferenciaLocal.setCellValueFactory(new PropertyValueFactory<>("conferenciaLocal"));
        colPuntosLocal.setCellValueFactory(new PropertyValueFactory<>("puntosLocal"));
        colPuntosVisitante.setCellValueFactory(new PropertyValueFactory<>("puntosVisitante"));
        colEquipoVisitante.setCellValueFactory(new PropertyValueFactory<>("equipoVisitante"));
        colConferenciaVisitante.setCellValueFactory(new PropertyValueFactory<>("conferenciaVisitante"));
        colTemporada.setCellValueFactory(new PropertyValueFactory<>("temporada"));
        
        tablaPartidos.setItems(partidosFiltrados);
    }
    
    private void cargarTodosLosDatos() {
        try {            
            if (conector.getConexion() == null || conector.getConexion().isClosed()) {
                mostrarAlerta("Error", "Conexión cerrada (método cargar todos los datos)", "La conexión a la base de datos está cerrada");
                return;
            }

            cargarTemporadas();
            cargarConferencias();
            cargarEquipos();
            cargarDatosPartidos();
        } catch (SQLException e) {
            mostrarErrorBD("Error al cargar datos", e);
        }
    }
    
    public void cargarDatosPartidos() {
        
        String cons = "SELECT p.equipo_local, el.Conferencia as conferencia_local, " +
                       "p.puntos_local, p.puntos_visitante, p.equipo_visitante, " +
                       "ev.Conferencia as conferencia_visitante, p.temporada " +
                       "FROM partidos p " +
                       "JOIN equipos el ON p.equipo_local = el.Nombre " +
                       "JOIN equipos ev ON p.equipo_visitante = ev.Nombre " +
                       "ORDER BY p.temporada ASC";
        
        try (Connection conn = conector.getConexion();
             PreparedStatement pst = conn.prepareStatement(cons);
             ResultSet rs = pst.executeQuery()) {
            
            todosLosPartidos.clear();
            
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
                todosLosPartidos.add(partido);
            }
            
        } 
        catch (SQLException e) {
            mostrarErrorBD("Error al cargar partidos", e);
        }
    }
    
    private void cargarTemporadas() throws SQLException {
        temporadasDisponibles.clear();
        temporadasDisponibles.add("Todas");
        
        String cons = "SELECT DISTINCT temporada FROM partidos ORDER BY temporada ASC"; 

        try (PreparedStatement pst = conector.getConexion().prepareStatement(cons);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                temporadasDisponibles.add(rs.getString("temporada"));
            }

            choiceTemporadas.setItems(temporadasDisponibles);
            choiceTemporadas2.setItems(temporadasDisponibles);
                        
            choiceTemporadas.getSelectionModel().selectFirst();
            choiceTemporadas2.getSelectionModel().selectFirst();
        }
    }
    
    private void cargarConferencias() {
        conferenciasDisponibles.clear();
        conferenciasDisponibles.add("Todas");
        
        String query = "SELECT DISTINCT Conferencia FROM equipos ORDER BY Conferencia";
        
        try (Connection conn = conector.getConexion();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                conferenciasDisponibles.add(rs.getString("Conferencia"));
            }
            
            choiceConferencias.setItems(conferenciasDisponibles);
            choiceConferencias2.setItems(conferenciasDisponibles);
            
            choiceConferencias.getSelectionModel().selectFirst();
            choiceConferencias2.getSelectionModel().selectFirst();
        } catch (SQLException e) {
            mostrarErrorBD("Error al cargar conferencias", e);
        }
    }
    
    private void cargarEquipos() {
        equiposDisponibles.clear();
        equiposDisponibles.add("Todos");
        
        String cons = "SELECT Nombre FROM equipos ORDER BY Nombre";
        
        try (Connection conn = conector.getConexion();
             PreparedStatement pst = conn.prepareStatement(cons);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                equiposDisponibles.add(rs.getString("Nombre"));
            }
            
            choiceEquiposLocal.setItems(equiposDisponibles);
            choiceEquiposVisitante.setItems(equiposDisponibles);
            
            choiceEquiposLocal.getSelectionModel().selectFirst();
            choiceEquiposVisitante.getSelectionModel().selectFirst();
        } catch (SQLException e) {
            mostrarErrorBD("Error al cargar equipos", e);
        }
    } 
    
    @FXML
    private void aplicarFiltros() {
        try {            
            String tempInicio = choiceTemporadas.getSelectionModel().getSelectedItem();
            String tempFin = choiceTemporadas2.getSelectionModel().getSelectedItem();
            String confLocal = choiceConferencias.getSelectionModel().getSelectedItem();
            String confVisitante = choiceConferencias2.getSelectionModel().getSelectedItem();
            String equipoLocal = choiceEquiposLocal.getSelectionModel().getSelectedItem();
            String equipoVisitante = choiceEquiposVisitante.getSelectionModel().getSelectedItem();

            if (tempInicio == null || tempFin == null || confLocal == null || 
                confVisitante == null || equipoLocal == null || equipoVisitante == null) {
                mostrarAlerta("Error", "Selección incompleta", "Todos los filtros deben tener una selección válida");
                return;
            }

            if (!tempInicio.equals("Todas") && !tempFin.equals("Todas")) {
                int añoInicio = convertirTemporadaANumero(tempInicio);
                int añoFin = convertirTemporadaANumero(tempFin);

                if (añoInicio > añoFin) {
                    mostrarAlerta("Error", "Rango inválido", 
                        "La temporada final (" + tempFin + ") no puede ser anterior a la inicial (" + tempInicio + ")");
                    return;
                }
            }

            if (!equipoLocal.equals("Todos") && !equipoVisitante.equals("Todos") && 
                equipoLocal.equals(equipoVisitante)) {
                mostrarAlerta("Error", "Equipos duplicados", 
                    "No puede seleccionar el mismo equipo (" + equipoLocal + ") como local y visitante");
                return;
            }

            Predicate<Partido> predicado = p -> true;

            if (!tempInicio.equals("Todas") && !tempFin.equals("Todas")) {
                final int añoInicio = convertirTemporadaANumero(tempInicio);
                final int añoFin = convertirTemporadaANumero(tempFin);
                predicado = predicado.and(p -> {
                    int añoPartido = convertirTemporadaANumero(p.getTemporada());
                    return añoPartido >= añoInicio && añoPartido <= añoFin;
                });
            }

            if (!confLocal.equals("Todas")) {
                predicado = predicado.and(p -> p.getConferenciaLocal().equals(confLocal));
            }

            if (!confVisitante.equals("Todas")) {
                predicado = predicado.and(p -> p.getConferenciaVisitante().equals(confVisitante));
            }

            if (!equipoLocal.equals("Todos")) {
                predicado = predicado.and(p -> p.getEquipoLocal().equals(equipoLocal));
            }

            if (!equipoVisitante.equals("Todos")) {
                predicado = predicado.and(p -> p.getEquipoVisitante().equals(equipoVisitante));
            }

            partidosFiltrados.setPredicate(predicado);
            actualizarEstadisticas();

        } catch (Exception e) {
            mostrarAlerta("Error", "Error al aplicar filtros", e.getMessage());
            e.printStackTrace();
        }
    }
    
    private int convertirTemporadaANumero(String temporada) {
        try {
            String[] partes = temporada.split("/");
            int año = Integer.parseInt(partes[0]);
            return año < 50 ? 2000 + año : 1900 + año; 
        } catch (Exception e) {
            return 0; 
        }
    }

    
    private void actualizarEstadisticas() {
        if (partidosFiltrados.isEmpty()) {
            limpiarEstadisticas();
            return;
        }
        
        long totalPartidos = partidosFiltrados.size();
        labelEstadistica1.setText("Partidos mostrados: " + totalPartidos);
        
        double avgLocal = partidosFiltrados.stream().mapToInt(Partido::getPuntosLocal).average().orElse(0);
        labelEstadistica2.setText(String.format("Media local: %.1f", avgLocal));
        
        double avgVisitante = partidosFiltrados.stream().mapToInt(Partido::getPuntosVisitante).average().orElse(0);
        labelEstadistica3.setText(String.format("Media visitante: %.1f", avgVisitante));
        
        long ganadosLocal = partidosFiltrados.stream().filter(p -> p.getPuntosLocal() > p.getPuntosVisitante()).count();
        labelEstadistica4.setText("Victorias local: "+ganadosLocal);
        
        long ganadosVisitante = partidosFiltrados.stream().filter(p -> p.getPuntosVisitante() > p.getPuntosLocal()).count();
        labelEstadistica5.setText("Victorias visitante: "+ganadosVisitante);
    }
    
    private void limpiarEstadisticas() {
        labelEstadistica1.setText("No hay datos");
        labelEstadistica2.setText("");
        labelEstadistica3.setText("");
        labelEstadistica4.setText("");
        labelEstadistica5.setText("");
    }
    
    private void mostrarErrorBD(String mensaje, SQLException e) {
        mostrarAlerta("Error de BD", mensaje, e.getMessage());
        e.printStackTrace();
    }
       
}
