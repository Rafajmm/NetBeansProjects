package com.mycompany.libretadirecciones;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;

import javafx.stage.Stage;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.BorderPane;


public class LibretaDirecciones extends Application 
{


    private static Scene escenaPrincipal;

    private BorderPane layoutPrincipal;

    private AnchorPane vistaPersona;


    @Override
    public void start(Stage escenarioPrincipal) {
         try {
            FXMLLoader vista = new FXMLLoader(LibretaDirecciones.class.getResource("VistaPrincipal.fxml"));
            
            layoutPrincipal = vista.load();
            
            escenaPrincipal = new Scene(layoutPrincipal);
            
            escenarioPrincipal.setScene(escenaPrincipal);
            escenarioPrincipal.setTitle("Libreta de direcciones");
            escenarioPrincipal.show();
        
            muestraVistaPersona();

         } catch (Exception ex) {
              System.out.println(ex.getMessage());
         }
    }


    


    public void muestraVistaPersona() 
    {
     
         try {
             FXMLLoader vista = new FXMLLoader(LibretaDirecciones.class.getResource("VistaPersona.fxml"));
             
             vistaPersona = vista.load();
            
             layoutPrincipal.setCenter(vistaPersona);
              

         } catch (Exception ex) {
             System.out.println(ex.getMessage());
                     
         }      
    }



    //Método main

    public static void main(String[] args) {

        launch(args);

    }


}