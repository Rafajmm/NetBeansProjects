package com.mycompany.nbagui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class VistaInicioController implements Initializable {

    @FXML private TextField tfIP;
    @FXML private TextField tfUsuario;
    @FXML private TextField tfContraseña;
    @FXML private Button butonAceptar;
    @FXML private Button botonSalir;
    
    private NBAGUI nbagui;
    private ManejarIni mIni;
    private static final String rutaConfig = "./config.ini"; // Cambiado a ruta relativa más simple
    private ConectorSQL conector;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarEventos();
    }
    
    private void configurarEventos() {
        butonAceptar.setOnAction(e -> manejarConexion());
        botonSalir.setOnAction(e -> System.exit(0));
    }
    
    public void cargarConfiguracionInicial() {
        try {
            mIni = new ManejarIni(rutaConfig);
            tfIP.setText(mIni.getDbUrl());
            tfUsuario.setText(mIni.getUsuario());
            tfContraseña.setText(mIni.getPsswd());
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo cargar la configuración", "Se creará un archivo de configuración nuevo.");
            crearConfiguracionPorDefecto();
        }
    }
    
    public void manejarConexion() {
        // Validar campos
        if (tfIP.getText().isEmpty() || tfUsuario.getText().isEmpty()) {
            mostrarAlerta("Error", "Campos vacíos", 
                         "Debe completar al menos IP y Usuario");
            return;
        }
        
        // Actualizar configuración
        mIni.cambiar("dbUrl", tfIP.getText());
        mIni.cambiar("usuario", tfUsuario.getText());
        mIni.cambiar("psswd", tfContraseña.getText());
        mIni.guardarArchivo(rutaConfig); // Guardar cambios
        
        // Intentar conectar 
        try {
            conector = new ConectorSQL(mIni.getDbUrl(),mIni.getUsuario(),mIni.getPsswd());
            //nbagui.cambiarVista("VistaPrincipal"); // Cambiar a vista principal si conexión exitosa
            mostrarAlerta("Éxito", "Conexión establecida", "Configuración guardada correctamente");
        } catch (Exception e) {
            mostrarAlerta("Error", "Error de conexión", "No se pudo establecer conexión: " + e.getMessage());
        }
    }
    
    private void crearConfiguracionPorDefecto() {
        mIni.cambiar("dbUrl", "localhost");
        mIni.cambiar("usuario", "root");
        mIni.cambiar("psswd", "");
        mIni.guardarArchivo(rutaConfig);
    }
    
    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    
    public void setNBAGUI(NBAGUI nbagui) {
        this.nbagui = nbagui;
    }
    
    public void Salir(){
        System.exit(0);
    }
}