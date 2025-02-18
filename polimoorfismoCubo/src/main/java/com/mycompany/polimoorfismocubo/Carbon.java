package com.mycompany.polimoorfismocubo;

public class Carbon extends Cubo{
    Carbon(){
        super();
        super.setNombre("Carbon");
        super.setTextura("Negro");
        super.setExperiencia(12);
    }
    
    
    public void destruir(){
        super.destruir();
        System.out.println("Toma un carbón");
    }
}
