/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.libretadirecciones;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;


public class VistaEstadisticasController implements Initializable {

    //Se invoca justo después de que se ha cargado el archivo FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //Array de nombre de meses
        String[] meses = {"Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"};

        //Los convierto a lista obervable
        nombreMeses.addAll(Arrays.asList(meses));

        //Asigno los nombres de meses a categorías
        ejeX.setCategories(nombreMeses);

        //Etiquetas de los ejes
        ejeX.setLabel("Mes de nacimiento");
        ejeY.setLabel("Número de personas");
    }    

    @FXML
    private BarChart<String, Integer> graficoBarras;

    @FXML
    private CategoryAxis ejeX;

    @FXML
    private NumberAxis ejeY;

    private ObservableList<String> nombreMeses = FXCollections.observableArrayList();

    //Set mes de cada persona para el eje Y
    public void setDatosPersona(List<Persona> personas) {

        //Array con cantidad de personas por mes de nacimiento
        int[] numMes = new int[12];
        for (Persona p : personas) {
            int mes = p.getFechaDeNacimiento().getMonthValue() - 1;
            numMes[mes]++;
        }

        //Genero la serie
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.setName("Mes de nacimiento");
        for (int i = 0; i < numMes.length; i++) {
            series.getData().add(new XYChart.Data<>(nombreMeses.get(i), numMes[i]));
        }

        //Añado la serie al gráfico
        graficoBarras.getData().add(series);

    }

}
