package com.mycompany.testherencia2;

public class ProductoF extends Producto{
    protected String fechaEnvasado;
    protected String paisOrigen;

    ProductoF(String nombre, String fechaCaducidad, String numeroLote, String fechaEnvasado, String paisOrigen) {
        super(nombre, fechaCaducidad, numeroLote);
        this.fechaEnvasado = fechaEnvasado;
        this.paisOrigen = paisOrigen;
    }

    public void setFechaEnvasado(String fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getFechaEnvasado() {
        return fechaEnvasado;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }


    public void mostrar() {
        super.mostrar();
        System.out.println("{" + "fechaEnvasado: " + fechaEnvasado + ", paisOrigen: " + paisOrigen + '}');
    }
    
    
    
}
