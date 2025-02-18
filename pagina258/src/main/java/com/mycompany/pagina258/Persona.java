/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pagina258;
import java.util.*;

/**
 *
 * @author usuario
 */
public class Persona {
    protected String nombre;
    protected int edad;
    protected double estatura;
    
    Persona(){
        nombre="Pepa";
        edad=28;
        estatura=1.74;
    }

    Persona(String nombre, int edad, double estatura) {
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getEstatura() {
        return estatura;
    }
    
    void mostrar(){
        System.out.println("Edad "+getEdad()+" Nombre "+getNombre()+" Estatura "+getEstatura());
    }
    
}
