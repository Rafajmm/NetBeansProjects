package com.mycompany.testherencia2;

public class ProductoR extends Producto{
    protected String codigoSupervision;
    
    ProductoR(String nombre, String fechaCaducidad, String numeroLote,String codigoSupervision){
        super(nombre,fechaCaducidad,numeroLote);
        this.codigoSupervision=codigoSupervision;
    }

    public void setCodigoSupervision(String codigoSupervision) {
        this.codigoSupervision = codigoSupervision;
    }
    
    public String getCodigoSupervision() {
        return codigoSupervision;
    }

    public void mostrar() {
        super.mostrar();
        System.out.println("{" + "codigoSupervision: " + codigoSupervision + "}");
    }

        
}
