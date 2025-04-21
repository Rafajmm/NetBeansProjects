package com.mycompany.nbagui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class NBAGUI extends Application {
    
    private static Scene escenaPrincipal;
    private VistaInicioController inicioController;
    
    @Override
    public void start(Stage escenarioPrincipal) throws IOException {
        // Cargar vista de inicio
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaInicio.fxml"));
        Parent vistaInicio = loader.load();
        
        // Obtener controlador y configurar
        inicioController = loader.getController();
        inicioController.setNBAGUI(this);
        inicioController.cargarConfiguracionInicial(); // Nueva función
        
        // Configurar escena
        escenaPrincipal = new Scene(vistaInicio);
        escenarioPrincipal.setScene(escenaPrincipal);
        escenarioPrincipal.setTitle("NBA");
        escenarioPrincipal.show();
    }

    public static void cambiarVista(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(NBAGUI.class.getResource(fxml + ".fxml"));
        escenaPrincipal.setRoot(loader.load());
    }

    public static void main(String[] args) {
        launch();
    }
}