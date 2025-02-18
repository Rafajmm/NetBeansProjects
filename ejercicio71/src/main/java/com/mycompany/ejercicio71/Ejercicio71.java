/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio71;

/**
 *
 * @author usuario
 */
public class Ejercicio71 {
    
    public static boolean comparar(CuentaCorriente x, CuentaCorriente y){
        boolean igual=false;
        if(x.getDNI()==y.getDNI()){
            igual=true;
        }
        return igual;
    }

    public static void main(String[] args) {
        CuentaCorriente cuentaNueva=new CuentaCorriente("45921406C","Rafa");
        CuentaCorriente otraCuenta=new CuentaCorriente("60142954Z","Pepe");
        
        cuentaNueva.ingresar(1234.34);
        
        cuentaNueva.sacarDinero(500.0);
        
        cuentaNueva.mostrar();
        
        System.out.println(comparar(cuentaNueva,otraCuenta));
    }
}
