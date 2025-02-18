package com.mycompany.ejercicio913;
import java.util.*;

public class Futbolista implements Comparable,Liga{
    protected String dni;
    protected String nombre;
    protected int edad;
    protected int goles;

    public Futbolista(String dni, String nombre, int edad, int goles) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.goles = goles;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    @Override
    public String toString() {
        return "Futbolista{" + "dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", goles=" + goles + '}';
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
        final Futbolista other = (Futbolista) obj;
        if (this.edad != other.edad) {
            return false;
        }
        if (this.goles != other.goles) {
            return false;
        }
        if (!this.dni.equalsIgnoreCase(other.dni)) {
            return false;
        }
        return this.nombre.equalsIgnoreCase(other.nombre);
    }
    
    @Override
    public int compareTo(Object otro){
        Futbolista otroF=(Futbolista) otro;
        
        return this.dni.compareToIgnoreCase(otroF.dni);
    }
    
    
    
}
