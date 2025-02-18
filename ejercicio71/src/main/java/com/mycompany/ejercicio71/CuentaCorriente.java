/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio71;

/**
 *
 * @author usuario
 */
public class CuentaCorriente {
    private String DNI;
    private String nombre;
    private double saldo=0.0;
             
        


    CuentaCorriente(String DNI, String nombre, double saldo){
        this.DNI=DNI;
        this.nombre=nombre;
        this.saldo=saldo;
    }
    
    CuentaCorriente(String DNI, String nombre){
        this(DNI, nombre, 0.0);
    }
    
    public String getDNI(){
        return this.DNI; 
    }
    
    public String getNombre(){
        return this.nombre; 
    }
    
    public double getSaldo(){
        return this.saldo; 
    }
    
    public boolean sacarDinero(double dinero){
        boolean posible;
        if(dinero<this.saldo){
            this.saldo-=dinero;
            posible=true;
        }
        else{
            posible=false;
        }
        return posible;
    }
    
    public void ingresar(double dinero){
        this.saldo+=dinero;
    }
    
    public void mostrar(){
        System.out.println("DNI: "+this.DNI+" Nombre: "+this.nombre+" saldo: "+this.saldo);
    }

}
