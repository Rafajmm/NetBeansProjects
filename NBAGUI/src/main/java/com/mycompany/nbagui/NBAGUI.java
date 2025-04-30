package com.mycompany.nbagui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class NBAGUI extends Application {
    private ConectorSQL conexion;
    private ManejarFichero fich;
    
    private static Scene escenaPrincipal;
    private VistaInicioController inicioController;
    private VistaPrincipalController principalController;
    
    @Override
    public void start(Stage escenarioPrincipal) throws IOException {
        // Cargar vista de inicio
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaInicio.fxml"));
        Parent vistaInicio = loader.load();
        
        
        inicioController = loader.getController();
        inicioController.setNBAGUI(this);
        if(inicioController.cargarConfiguracionInicial()){
            loader=new FXMLLoader(getClass().getResource("VistaPrincipal.fxml"));
            vistaInicio=loader.load();
            escenaPrincipal = new Scene(vistaInicio);
            escenarioPrincipal.setScene(escenaPrincipal);
            escenarioPrincipal.setTitle("NBA");
            escenarioPrincipal.show();
        }
        
        else{            
            escenaPrincipal = new Scene(vistaInicio);
            escenarioPrincipal.setScene(escenaPrincipal);
            escenarioPrincipal.setTitle("NBA");
            escenarioPrincipal.show();
        }
    }

    public static void cambiarVista(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(NBAGUI.class.getResource(fxml + ".fxml"));
        escenaPrincipal.setRoot(loader.load());
    }

    public static void main(String[] args) {
        launch();
    }
}