/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.libretadirecciones;

import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author usuario
 */
public class VistaPersonaController implements Initializable{
    @FXML
    private TableView tablaPersonas;

    @FXML
    private TableColumn nombreColumn;

    @FXML
    private TableColumn apellidosColumn;

    @FXML
    private Label nombreLabel;

    @FXML
    private Label apellidosLabel;

    @FXML
    private Label direccionLabel;

    @FXML
    private Label codigoPostalLabel;

    @FXML
    private Label ciudadLabel;

    @FXML
    private Label fechaDeNacimientoLabel;

    // Referencia a la clase principal
    private LibretaDirecciones libretaDirecciones;

    //El constructor es llamado ANTES del método initialize
    public VistaPersonaController() {

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializo la tabla con las dos primera columnas
        String nombre = "nombre";
        String apellidos = "apellidos";

        nombreColumn.setCellValueFactory(new PropertyValueFactory<>(nombre));
        apellidosColumn.setCellValueFactory(new PropertyValueFactory<>(apellidos));
        
        //Borro los detalles de la persona
        mostrarDetallesPersona(null);
        
        //Escucho cambios en la selección de la tabla y muestro los detalles en caso de cambio

        //OPCIÓN 1: a través de una expresión lambda
        //La expresión lambda evita tener que crear una clase que implemente la interfaz ChangeListener y sobreescribir el método changed(...)

//        tablaPersonas.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue) -> mostrarDetallesPersona((Persona)newValue));
        
        //OPCIÓN 2: evitar la expresión lambda y escribir todo el código a sobreescribir de la interfaz dentro del argumento del método 'addListener(ChangeListener cl)'
        //Hemos de realizar dos imports:
        //import javafx.beans.value.ChangeListener;
        //import javafx.beans.value.ObservableValue;
        tablaPersonas.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener()
                {
                    @Override public void changed(ObservableValue o,Object oldValue, Object newValue){
                        mostrarDetallesPersona((Persona)newValue);
                }
        });
        
        //OPCIÓN 3: realizar un proceso parecido a los comparadores que implementan Comparator: crear una clase nueva y usar una instancia que se pasa como argumento al método  'addListener(ChangeListener cl)'
        //Os dejo como ejercicio crear esta nueva clase que se usaría con el siguiente código
        //ListenerParaTabla cl = new ListenerParaTabla(this);
        
        //tablaPersonas.getSelectionModel().selectedItemProperty().addListener(cl);
    }
    
    //Es llamado por la aplicación principal para inicializar valores de la tabla
    //a través de una referencia recibida como argumento (mirar el método muestraVistaPersona() de la clase LibretaDirecciones)
    public void setLibretaDirecciones(LibretaDirecciones libretaDirecciones) 
    {
        this.libretaDirecciones = libretaDirecciones;

        //Añado la lista obervable a la tabla
        //Si en el método initialize no usamos los métodos setCellValueFactory, ahora tendríamos que recorrer la lista e
        //insertar los valores uno a uno en la tabla

        tablaPersonas.setItems(libretaDirecciones.getDatosPersona());
    }
    
    private void mostrarDetallesPersona(Persona persona){
        if(persona!=null){
             //Relleno los labels desde el objeto persona

            nombreLabel.setText(persona.getNombre());

            apellidosLabel.setText(persona.getApellidos());

            direccionLabel.setText(persona.getDireccion());

            codigoPostalLabel.setText(Integer.toString(persona.getCodigoPostal()));

            ciudadLabel.setText(persona.getCiudad());

            fechaDeNacimientoLabel.setText(UtilidadDeFechas.formato(persona.getFechaDeNacimiento()));
        }
        else{
            //Persona es null, vacío todos los labels.
            nombreLabel.setText("");

            apellidosLabel.setText("");

            direccionLabel.setText("");

            codigoPostalLabel.setText("");

            ciudadLabel.setText("");

            fechaDeNacimientoLabel.setText("");
        }
    }

//    @Override
//    public void changed(ObservableValue ov, Object t, Object t1) {
//        mostrarDetallesPersona((Persona)newValue);
//    }

    
    
    
    
}
