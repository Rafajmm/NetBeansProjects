package com.mycompany.problema3;
import java.util.*;
/**
 *
 * @author rafa
 */
public class Tren {
   private int numVagones;
    private ArrayList<Vagon> vagones=new ArrayList<>();
    private String salida;
    private String llegada;
    private double precioPC;
    private double precioT;
    
    public Tren(int numVagones, String salida, String llegada, double precioPC, double precioT) {
        this.numVagones = numVagones;
        this.salida=salida;
        this.llegada=llegada;
        this.precioPC=precioPC;
        this.precioT=precioT;       
        
        int nPC=(int)Math.round(numVagones*0.2);
        for (int i=0;i<numVagones;i++){
            boolean tipo=(i<nPC); 
            vagones.add(new Vagon(tipo));
        }
    }

    public int getNumVagones() {
        return numVagones;
    }

    public ArrayList<Vagon> getVagones() {
        return vagones;
    }

    public String getSalida() {
        return salida;
    }

    public String getLlegada() {
        return llegada;
    }

    public double getPrecioPC() {
        return precioPC;
    }

    public double getPrecioT() {
        return precioT;
    }

    public void setNumVagones(int numVagones) {
        this.numVagones = numVagones;
    }

    public void setVagones(ArrayList<Vagon> vagones) {
        this.vagones = vagones;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public void setPrecioPC(double precioPC) {
        this.precioPC = precioPC;
    }

    public void setPrecioT(double precioT) {
        this.precioT = precioT;
    }

    @Override
    public String toString() {
        return "Tren{" + "numVagones=" + numVagones + ", vagones=" + vagones + ", salida=" + salida + ", llegada=" + llegada + ", precioPC=" + precioPC + ", precioT=" + precioT + '}';
    }
    
    
    
    public void llenarTren(){
        for(Vagon uno : vagones){
            uno.llenarVagon();
        }
    }
    
    public double ventas(){
        double total=0.0;
        for(Vagon uno: vagones){
            if(uno.getTipo()){
                total+=uno.contarOcupados()*precioPC;
            }
            else{
                total+=uno.contarOcupados()*precioT;
            }
        }
        return total;
    }
    
}
