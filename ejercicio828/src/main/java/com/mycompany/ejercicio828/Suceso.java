package com.mycompany.ejercicio828;
import java.util.*;

public class Suceso extends Punto3D{
    protected double t;
    private String descripcion;
    
    Suceso(double x, double y, double z, double t,String descripcion){
        super(x,y,z);
        this.t=t;
        this.descripcion=descripcion;
    }
    
    double getT(){
        return this.t;
    }
    
    void setT(double t){
        this.t=t;
    }
    
    void desplazart(double t){
        this.t+=t;
    }
    
    void desplaza(double x, double y, double z,double t){
        super.desplaza(x,y,z);
        this.t+=t;
    }
    
    void mostrar(){
        super.muestra();
        System.out.println("t: "+this.t);
    }
    
    void id(){
        System.out.println("Punto 4D");
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
        if(!super.equals(obj)){
            return false;
        }
        final Suceso other = (Suceso) obj;
        if (Double.doubleToLongBits(this.t) != Double.doubleToLongBits(other.t)) {
            return false;
        }
        return Objects.equals(this.descripcion, other.descripcion);
    }            
}
