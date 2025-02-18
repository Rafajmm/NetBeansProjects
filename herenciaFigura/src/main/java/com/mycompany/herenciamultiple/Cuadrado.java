package com.mycompany.herenciamultiple;

public class Cuadrado extends Rectangulo{
    
    Cuadrado(double lado){
        super(lado,lado);
    }

    Cuadrado(double lado, double radio, double radioM, double[] x, double[] y, int[] color) {
        super(lado, lado, radio, radioM, x, y, color);
    }
    
    
    
}
