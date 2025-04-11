package com.mycompany.nbagui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * JavaFX NBAGUI
 */
public class NBAGUI extends Application {
    
    private static Scene escenaPrincipal;

    private BorderPane layoutPrincipal;

    private AnchorPane vistaInicio;
    
    private ObservableList datosPersona=FXCollections.observableArrayList(); 
    
    private ConectorSQL conexion;
    

    @Override
    public void start(Stage stage) throws IOException {
        escenaPrincipal = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(escenaPrincipal);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        escenaPrincipal.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NBAGUI.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}