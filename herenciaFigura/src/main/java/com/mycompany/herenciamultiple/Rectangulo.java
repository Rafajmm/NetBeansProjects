package com.mycompany.herenciamultiple;

public class Rectangulo extends Figura {
    
    
    Rectangulo(double base, double altura){
        super.base=base;
        super.altura=altura;
    }

    Rectangulo(double base, double altura, double radio, double radioM, double[] x, double[] y, int[] color) {
        super(base, altura, radio, radioM, x, y, color);
    }
    
    
    double area(){
        double area=base*altura;
        return area;
    }
    
    
}
