package com.mycompany.ejercicio1examen;
import java.util.*;

public class Ejercicio1Examen {
    
    public static String[] toArray(String resultado[],String palabra){
        if(palabra.length()>3){
            resultado=Arrays.copyOf(resultado,resultado.length+1);           
            resultado[resultado.length-1]=palabra+" ";
            
        }
            
        return resultado;
    }
    
    public static String conjuntoStrings(String conjunto, String palabra){
        
        if(palabra.length()>3){
           conjunto+=(" "+palabra); 
        }
        
        return conjunto;
    }
    
    public static String[] guardarSubs(String url){
//        String inv="";
//        for(int i=url.length()-1;i>=0;i--){
//           inv+=url.charAt(i);
//        }
        String conjunto[]=new String[0];
        int pos,cont=0;
        while(url.indexOf('?')!=-1){
        pos=url.indexOf('?');
        url=url.substring(pos+1);
        }
        
        
        while(url.indexOf('&')!=-1){
        pos=url.indexOf('&');
        conjunto=Arrays.copyOf(conjunto, conjunto.length+1);
        conjunto[cont]=url.substring(0, pos);
        cont++;
        url=url.substring(pos+1);
        }
        
        return conjunto;
    }
    
    public static void main(String[] args) {
        String resultado[]=new String[0];
        Scanner leer=new Scanner(System.in);
        String palabra="",conjunto="";
        
        //esto para devolver array
//        while(!palabra.equalsIgnoreCase("fin")){
//            System.out.println("Introduce palabras. Usa 'fin' para terminar");
//            palabra=leer.next();
//            resultado=toArray(resultado,palabra);
//            
//        }
//        System.out.println(Arrays.toString(resultado));

        while(!palabra.equalsIgnoreCase("fin")){
            System.out.println("Introduce palabras. Usa 'fin' para terminar");
            palabra=leer.next();
            conjunto=conjuntoStrings(conjunto,palabra);
            
        }
        
        System.out.println(conjunto);
        
        //////////////
        String conj[];
        System.out.println("Introduce la url");
        String url=leer.next();
        
        conj=guardarSubs(url);
        System.out.println(Arrays.toString(conj));
        }
        
        
    
}        
   

    