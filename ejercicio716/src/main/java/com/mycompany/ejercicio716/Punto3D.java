package com.mycompany.ejercicio716;
import java.util.*;

public class Punto3D extends Punto2D{
    protected double z;
    
    Punto3D(double x,double y, double z){
//        super.x=x;
//        super.y=y;   Aunque de esta forma funciona teniendo los atributos protected es mejor usar el constructor de la superclase
        super(x,y);
        this.z=z;
    }
    
    double getZ(){
        return this.z;
    }
    void setZ(double z){
        this.z=z;
    }
    
    void desplazarZ(double z){
        this.z+=z;
    }
    
    void desplaza(double x, double y, double z){
        super.desplaza(x,y);
        this.z+=z;
    }
    
    void mostrar(){
        super.muestra();
        System.out.println("z: "+this.z);
    }
    
    double distanciaEuclidea(Punto3D otro){
        double dis;
        
        double deltaX=otro.x-this.x;
        double deltaY=otro.y-this.y;
        double deltaZ=otro.z-this.y;
        dis=Math.sqrt(deltaX*deltaX+deltaY*deltaY+deltaZ*deltaZ);
        
        return dis;
    }

    @Override
    public String toString() {        
        return super.toString()+" Punto3D{" + "z=" + z + '}';
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
        final Punto3D other = (Punto3D) obj;
        return Double.doubleToLongBits(this.z) == Double.doubleToLongBits(other.z);
    }
    
    
    
    void id(){
        System.out.println("Punto 3D");
    }
    
    
}
