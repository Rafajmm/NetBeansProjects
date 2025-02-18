package com.mycompany.ejercicio823;

public class Triangulo extends Poligono{
    Triangulo(double base,double altura){
        super(base,altura);
    }
    
    @Override
    double area(){
        return (base*altura)/2;
    }
}
