/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.libretadirecciones;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;


public class VistaPrincipalController {


    //Referencia a la clase principal

    private LibretaDirecciones libretaDirecciones;


    //Es llamada por la clase Principal para tener una referencia de vuelta de si misma

    public void setLibretaDirecciones(LibretaDirecciones libretaDirecciones) {

        this.libretaDirecciones = libretaDirecciones;

    }


    //Creo una nueva libreta de direcciones en XML vacía

    @FXML
    private void nuevo() {
        libretaDirecciones.getDatosPersona().clear();
    }


    //Abro un File Chooser para que el usario seleccione una libreta

    @FXML
    private void abrir() {

        FileChooser fileChooser = new FileChooser();


        //Filtro para la extensión

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(

                "XML files (*.xml)", "*.xml");

        fileChooser.getExtensionFilters().add(extFilter);


        //Muestro el diálogo de guardar

        File archivo = fileChooser.showOpenDialog(libretaDirecciones.getEscenaPrincipal().getWindow());


        if (archivo != null) {

            libretaDirecciones.cargaPersonas(archivo);

        }

    }


   


    //Abro un File Chooser para guardar como

    @FXML

    private void guardarComo() {


        FileChooser fileChooser = new FileChooser();


        //Filtro para la extensión

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(

                "XML files (*.xml)", "*.xml");

        fileChooser.getExtensionFilters().add(extFilter);


        //Muestro el diálogo de guardar

        File archivo = fileChooser.showSaveDialog(libretaDirecciones.getEscenaPrincipal().getWindow());


        if (archivo != null) {

            //Me aseguro de que tiene la extensión correcta

            if (!archivo.getPath().endsWith(".xml")) {

                archivo = new File(archivo.getPath() + ".xml");

            }

            libretaDirecciones.guardaPersonas(archivo);

        }

    }


    //Acerca de

    @FXML

    private void acercaDe() {

        //Muestro alerta

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("Acerca de");
       
        //configuro la ventana de mensaje de forma mínima (sin icono)

        alerta.initStyle(StageStyle.UTILITY);

        alerta.setContentText("Autor: Marco Jakob\nWebsite: http://code.makery.ch\nAdaptación 2018: Jairo García Rincón\nAdaptación 2025: Alejandro Cifuentes como proyecto de ejemplo para 1DAW");

        alerta.showAndWait();

    }


    //Salir

    @FXML

    private void salir() {

        System.exit(0);

    }
    
    //Gráfico
    @FXML
    private void grafico() {
      libretaDirecciones.crearGrafico();
    }
    
    //PDF
    @FXML
    private void pdf() throws IOException {
      libretaDirecciones.crearPDF();
    }

}