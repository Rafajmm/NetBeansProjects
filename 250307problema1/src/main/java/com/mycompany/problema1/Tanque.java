package com.mycompany.problema1;
import java.util.*;

public class Tanque {
    String id;
    double capacidad=500.0;
    double contenido;

    public Tanque(String id, double contenido) {
        this.id = id;
        setContenido(contenido);
    }

    public String getId() {
        return id;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public double getContenido() {
        return contenido;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContenido(double contenido) {
        if(contenido<=getCapacidad()){
            this.contenido = contenido;
        }
        else{
            System.out.println("Esa cantidad hace que se supere la capacidad del deposito. Establecida capacidad maxima: "+getCapacidad());
        }
    }
    
    public double agregar(double litros){
        if(litros+getContenido()<=getCapacidad()){
            setContenido(litros+getContenido());
        }
        else{
            setContenido(500.0);
            System.out.println("Esa cantidad hace que se supere la capacidad del deposito. Establecida capacidad maxima: "+getCapacidad());
        }
        return getContenido();
    }
    
    public double sacar(double litros){
        if(agregar(-litros)>=0){
            return agregar(-litros);
        }
        else{
            setContenido(0.0);
            System.out.println("La cantidad excede el contenido. Establecido deposito vacio"+getContenido());
            return getContenido();
        }
    }
    
    public void sacaMitad(){
        if(getContenido()!=0){
            setContenido(getContenido()/2);
        }
        else{
            System.out.println("El deposito esta vacio.");
        }
    }

    @Override
    public String toString() {
        return "Tanque{" + "id=" + id + ", capacidad=" + capacidad + ", contenido=" + contenido + '}';
    }
    
    
}
