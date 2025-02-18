package com.mycompany.ejercicio823;

abstract class Poligono {
    protected double base;
    protected double altura;
    
    Poligono(){
        base=0;
        altura=0;
    }
    Poligono(double base, double altura){
        setBase(base);
        setAltura(altura);
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public void setBase(double base) {
        if(base>0){
            this.base = base;
        }
    }

    public void setAltura(double altura) {
        if(altura>0){
            this.altura = altura;
        }
    }

    abstract double area();
}
