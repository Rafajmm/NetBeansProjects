/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.libretadirecciones;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class VistaPrincipalController implements Initializable {

    private LibretaDirecciones libretaDirecciones;
    private TableView tablaPersonas;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setLibretaDirecciones(LibretaDirecciones libretaDirecciones){
        this.libretaDirecciones = libretaDirecciones;

        //Añado la lista obervable a la tabla
        //Si en el método initialize no usamos los métodos setCellValueFactory, ahora tendríamos que recorrer la lista e
        //insertar los valores uno a uno en la tabla

        tablaPersonas.setItems(libretaDirecciones.getDatosPersona());
    }
    
}
