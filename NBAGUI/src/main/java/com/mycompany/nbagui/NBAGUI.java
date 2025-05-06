package com.mycompany.nbagui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import javafx.scene.image.Image;

public class NBAGUI extends Application {
    private ConectorSQL conexion;
    private ManejarFichero fich;
    
    private static Scene escenaPrincipal;
    private VistaInicioController inicioController;
    private VistaPrincipalController principalController;
    
    @Override
    public void start(Stage escenarioPrincipal) throws IOException, SQLException {        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaInicio.fxml"));
        Parent vistaInicio = loader.load();        
        
        inicioController = loader.getController();
        inicioController.setNBAGUI(this);
        if(inicioController.cargarConfiguracionInicial()){
            fich = inicioController.getmIni();
            conexion = new ConectorSQL(fich.getDbUrl(), fich.getUsuario(), fich.getPsswd());

            loader = new FXMLLoader(getClass().getResource("VistaPrincipal.fxml"));
            vistaInicio = loader.load();

            principalController = loader.getController();
            principalController.setNBAGUI(this);
            principalController.setConectorSQL(conexion); 

            escenaPrincipal = new Scene(vistaInicio);
            escenarioPrincipal.setScene(escenaPrincipal);
            escenarioPrincipal.setTitle("NBA");
            escenarioPrincipal.getIcons().add(new Image("file:./src/main/resources/com/mycompany/nbagui/icono32.png"));
            escenarioPrincipal.show();
        }
        
        else{            
            escenaPrincipal = new Scene(vistaInicio);
            escenarioPrincipal.setScene(escenaPrincipal);
            escenarioPrincipal.setTitle("NBA");
            escenarioPrincipal.getIcons().add(new Image("file:./src/main/resources/com/mycompany/nbagui/icono32.png"));
            escenarioPrincipal.show();
        }
    }

    public void cambiarVista(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml + ".fxml"));
        Parent nuevaVista = loader.load();

        if (fxml.equals("VistaPrincipal")) {
            principalController = loader.getController();
            principalController.setNBAGUI(this);
        } else if (fxml.equals("VistaInicio")) {
            inicioController = loader.getController();
            inicioController.setNBAGUI(this);
            inicioController.setmIni(fich);
        }

        escenaPrincipal.setRoot(nuevaVista);
        
    }

    public void setFich(ManejarFichero fich) {
        this.fich = fich;
    }
    
    

    public static void main(String[] args) {
        launch();
    }
}