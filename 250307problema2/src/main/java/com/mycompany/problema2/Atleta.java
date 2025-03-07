package com.mycompany.problema2;
import java.util.*;

public class Atleta implements Comparable{
    String nombre;
    int numero;
    String nacionalidad;
    HashMap<String,Double> tiempo=new HashMap<>();

    public Atleta(String nombre, int numero, String nacionalidad,HashMap<String,Double> tiempo) {
        setNombre(nombre);
        setNumero(numero);
        setNacionalidad(nacionalidad);
        setTiempo(tiempo);
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public HashMap<String, Double> getTiempo() {
        return tiempo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setTiempo(HashMap<String, Double> tiempo) {
        this.tiempo = tiempo;
    }
    
    @Override
    public int compareTo(Object otro){
        Atleta other=(Atleta)otro;
        int resul=0;
        
        return this.tiempo.values()-other.tiempo.values();
    }
}
