/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.problema1;

/**
 *
 * @author usuario
 */
public class App {
    public static Tanque instanciar(String id, double contenido){
        Tanque t=new Tanque(id,contenido);
        
        t.agregar(100.0);
        System.out.println(t);
        while(t.getContenido()>1.0){
            t.sacaMitad();
            System.out.println(t.getContenido());
        }
        
        return t;
    }
    public static void main(String[] args) {
        System.out.println(instanciar("dt54",450.0));
    }
}
