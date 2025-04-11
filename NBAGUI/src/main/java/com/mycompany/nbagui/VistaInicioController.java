/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.nbagui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author usuario
 */
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
    
}
