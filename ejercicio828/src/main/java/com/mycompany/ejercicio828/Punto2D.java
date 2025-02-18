package com.mycompany.ejercicio828;
import java.util.*;

public class Punto2D implements Comparable{
    // Atributos que representan las coordenadas del punto
    protected double x;
    protected double y;

    // Constructor que inicializa el punto con las coordenadas x y
    Punto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    Punto2D(){}

    // Método que incrementa el componente x en la cantidad dx
    public void desplazax(double dx) {
        this.x += dx;
    }

    // Método que incrementa el componente y en la cantidad dy
    public void desplazay(double dy) {
        this.y += dy;
    }

    // Método que desplaza ambos componentes según las cantidades dx y dy
    public void desplaza(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    // Método que calcula y devuelve la distancia euclídea entre el punto invocante y otro
    public double distanciaEuclidea(Punto2D otro) {
        double deltaX = this.x - otro.x;
        double deltaY = this.y - otro.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    // Método que muestra por consola la información relativa al punto
    public void muestra() {
        System.out.println("x: "+this.x);
        System.out.println("y: "+this.y);
    }

    // Métodos getter para acceder a las coordenadas, si fuera necesario
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "Punto2D{" + "x=" + x + ", y=" + y + '}';
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
        final Punto2D other = (Punto2D) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        return Double.doubleToLongBits(this.y) == Double.doubleToLongBits(other.y);
    }
    
    @Override
    public int compareTo(Object obj){
        int comp;
        Punto2D otro=(Punto2D) obj;
        
        if(this.x+this.y > otro.x+otro.y){
            comp=-1;
        }
        else if(this.x+this.y < otro.x+otro.y){
            comp=1;
        }
        else{
            comp=0;
        }
        
        return comp;
    }
    
    void id(){
        System.out.println("Punto 2D");
    }

    
}

