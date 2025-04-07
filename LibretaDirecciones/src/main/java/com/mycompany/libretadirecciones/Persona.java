/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libretadirecciones;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.Month;
/**
 *
 * @author usuario
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private String direccion;
    private String ciudad;
    private Integer codigoPostal;
    private LocalDate fechaDeNacimiento;
    
    public Persona(){
        this(null,null);
    }
    
    public Persona(String nombre, String apellidos){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.direccion="Mi direccioin";
        this.ciudad="Baza";
        this.codigoPostal=18800;
        this.fechaDeNacimiento=LocalDate.of(1974, 6, 15);
    }

    public Persona(String nombre, String apellidos, String direccion, String ciudad, Integer codigoPostal, LocalDate fechaDeNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }       

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @XmlJavaTypeAdapter(AdaptadorDeFechas.class)
    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;

    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
        public void clear(){
        this.nombre="";

        this.apellidos="";

        this.direccion="";

        this.ciudad="";

        this.codigoPostal=0;

        this.fechaDeNacimiento= LocalDate.of(1970, 1, 1);
    }
    
}
