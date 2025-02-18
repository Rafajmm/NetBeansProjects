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
public class Empleado extends Persona implements Comparable{
    protected int salario;
    protected String estatura;
    
    Empleado(){
        super();
        salario=1795;
        estatura="XL";
    }
    Empleado(String nombre, int edad, double estaturaD, int salario, String estatura){
        super(nombre,edad,estaturaD);
        setSalario(salario);
        setEstatura(estatura);
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public int getSalario() {
        return salario;
    }

    void mostrar(){
        super.mostrar();
        System.out.println("Estatura "+estatura+" Salario "+getSalario());
    }

    @Override
    public String toString() {
        return "Empleado{" + "salario=" + salario + ", estatura=" + estatura + '}';
    }
    
    
    
    @Override
    public int compareTo(Object otro){
        Empleado otroE=(Empleado) otro;
        return this.salario-otroE.salario;
    }
       
}
