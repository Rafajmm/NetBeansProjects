package com.mycompany.testherencia2;

public class ProductoC extends Producto{
    protected double temperatura;
    
    ProductoC(String nombre, String fechaCaducidad, String numeroLote,double temperatura){
        super(nombre,fechaCaducidad,numeroLote);
        this.temperatura=temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void mostrar() {
        super.mostrar();
        System.out.println("{" + "temperatura: " + temperatura + "}");
    }       
}
