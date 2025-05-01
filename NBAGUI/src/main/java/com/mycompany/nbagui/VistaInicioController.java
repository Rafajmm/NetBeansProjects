package com.mycompany.nbagui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class VistaInicioController implements Initializable {

    @FXML 
    private TextField tfIP;
    @FXML
    private TextField tfUsuario;
    @FXML
    private TextField tfContraseña;
    @FXML
    private Button butonAceptar;
    @FXML
    private Button botonSalir;
    @FXML
    private RadioButton gini;
    @FXML
    private RadioButton gxml;
    private ToggleGroup grupo;
    
    private NBAGUI nbagui;
    private ManejarFichero mIni;
    private static final String rutaConfig = "./config.ini"; 
    private static final String rutaConfig2="./config.xml";
    private ConectorSQL conector;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        grupo = new ToggleGroup();
        gini.setToggleGroup(grupo);
        gxml.setToggleGroup(grupo);
        gini.setSelected(true);
    }

    
    public boolean cargarConfiguracionInicial() {
        try {
            mIni = new ManejarFichero(rutaConfig);
            tfIP.setText(mIni.getDbUrl());
            tfUsuario.setText(mIni.getUsuario());
            tfContraseña.setText(mIni.getPsswd());
            conector=new ConectorSQL(mIni.getDbUrl(),mIni.getUsuario(),mIni.getPsswd());
            return true;
        } 
        catch (Exception e) {
            try{
                mIni = new ManejarFichero(rutaConfig2);
                tfIP.setText(mIni.getDbUrl());
                tfUsuario.setText(mIni.getUsuario());
                tfContraseña.setText(mIni.getPsswd());
                conector=new ConectorSQL(mIni.getDbUrl(),mIni.getUsuario(),mIni.getPsswd());
                return true;
            }
            catch(Exception ex){
                mostrarAlerta("Error", "No se pudo cargar la configuración", "Se abrirá el menú de configuración.");    
                return false;
            }
        }
    }
    
    public void manejarConexion() {
        mIni.resetearAtributos();
        mIni.toString();
        if (tfIP.getText().isEmpty() || tfUsuario.getText().isEmpty()) {
            mostrarAlerta("Error", "Campos vacíos", "Debe completar al menos IP y Usuario");
            return;
        }
        
        mIni.cambiar("dbUrl", tfIP.getText());
        mIni.cambiar("usuario", tfUsuario.getText());
        mIni.cambiar("psswd", tfContraseña.getText());
        
        if(gini.isSelected()){
            mIni.guardarArchivo(rutaConfig); 
        }
        else{
            mIni.guardarArchivo(rutaConfig2);            
        }

        try {
            conector = new ConectorSQL(mIni.getDbUrl(),mIni.getUsuario(),mIni.getPsswd());
            nbagui.cambiarVista("VistaPrincipal");
            mostrarAlerta("Éxito", "Conexión establecida", "Configuración guardada correctamente");
        } catch (Exception e) {
            mostrarAlerta("Error", "Error de conexión", "No se pudo establecer conexión (método manejarConexion): " + e.getMessage());
        }
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

    public ManejarFichero getmIni() {
        return mIni;
    }
    
    public void setmIni(ManejarFichero mIni) {
        this.mIni = mIni;
        if(mIni != null) {
            tfIP.setText(mIni.getDbUrl());
            tfUsuario.setText(mIni.getUsuario());
            tfContraseña.setText(mIni.getPsswd());
        }
    }
    
    public void Salir(){
        System.exit(0);
    }
}