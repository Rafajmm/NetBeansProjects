package com.mycompany.edtarea12;

public class Dinero {
    private static final double tasaC=0.92;
    
    public double dolarEuro(double dollars) {
        return dollars*tasaC;
    }
    
    public double euroDolar(double euros) {
        return euros/tasaC;
    }
}
