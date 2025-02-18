package com.mycompany.testherencia2;

public class Producto {
    protected String nombre;
    protected String fechaCaducidad;
    protected String numeroLote;
    
    Producto(String nombre, String fechaCaducidad, String numeroLote){
        this.nombre=nombre;
        this.fechaCaducidad=fechaCaducidad;
        this.numeroLote=numeroLote;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void mostrar() {
        System.out.println("Producto{" + "nombre: " + nombre + ", fechaCaducidad: " + fechaCaducidad + ", numeroLote: " + numeroLote + "}");
    }
    
    
}
