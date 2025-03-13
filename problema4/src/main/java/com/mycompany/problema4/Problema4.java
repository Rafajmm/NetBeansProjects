/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.problema4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rafa
 */
public class Problema4 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
//        ArrayList<Integer> nums=new ArrayList<>();
//        for(Integer num : nums){
//            num=(int)(Math.random()*10);
//        }
        Candado c1=new Candado(new ArrayList<>(Arrays.asList(3,3,3)));
        Candado c2=new Candado(new ArrayList<>(Arrays.asList(3,2,3)));
        c1.cambiarNumero(1, 3);
        
        System.out.println(c1.getEstado());
        System.out.println(c1.getComb());
        System.out.println(c1.puedeAbrir());
        System.out.println(c1.mismaCombinacion(c2));
        
        System.out.println("--------------------------------------------------------------------------------------");
        
        ArrayList<Candado> miau=new ArrayList<>();
        for(int i=0;i<5;i++){
            miau.add(new Candado(new ArrayList<>(Arrays.asList(3,i,2))));
        }
        
        System.out.println(miau);
    }
}
