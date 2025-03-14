package com.mycompany.problema2;
import java.util.*;

public class Atleta implements Comparable{
    private String nombre;
    private int numero;
    private String nacionalidad;
    private double tiempo;

    public Atleta(String nombre, int numero, String nacionalidad,double tiempo) {
        setNombre(nombre);
        setNumero(numero);
        setNacionalidad(nacionalidad);
        setTiempo(tiempo);
    }
    Atleta(){
        setNombre("x");
        setNumero(0);
        setNacionalidad("f");
        setTiempo(0.0);
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

    public double getTiempo() {
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

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }
    
    @Override
    public int compareTo(Object otro){
        Atleta other=(Atleta)otro;                
        return (int)(this.getTiempo()-other.getTiempo());
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atleta other = (Atleta) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (Double.doubleToLongBits(this.tiempo) != Double.doubleToLongBits(other.tiempo)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.nacionalidad, other.nacionalidad);
    }

    @Override
    public String toString() {
        return "Atleta{" + "nombre=" + nombre + ", numero=" + numero + ", nacionalidad=" + nacionalidad + ", tiempo=" + tiempo + '}';
    }

    
    
    
}
