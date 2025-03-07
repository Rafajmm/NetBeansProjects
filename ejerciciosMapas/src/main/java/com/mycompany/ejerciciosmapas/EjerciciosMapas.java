package com.mycompany.ejerciciosmapas;
import java.util.*;

public class EjerciciosMapas {

    public static void main(String[] args) {        
        String palabra=" ";
        Scanner teclado=new Scanner(System.in);
        TreeMap<String, Integer> lista=new TreeMap<>();
        
        while(!palabra.equals("stop")){
            System.out.println("Introduce palabras. Introduce 'stop' para salir.");
            palabra=teclado.next();
            if(!lista.containsKey(palabra)){
                lista.put(palabra, 1);
            }
            else{
               lista.replace(palabra, lista.get(palabra), lista.get(palabra)+1);
               
            }
        }
        
        System.out.println(lista);
        
        Set<Map.Entry<String,Integer>> entradas=lista.entrySet();
        ArrayList<String> listaPalabra=new ArrayList<>();
        TreeMap<Integer,ArrayList<String>> frecuencias=new TreeMap<>();
        
        for(Map.Entry<String,Integer> ent : entradas){
            
            if(!frecuencias.containsKey(ent.getValue())){
                ArrayList<String> uno=new ArrayList<>();
                uno.add(ent.getKey());
                frecuencias.put(ent.getValue(), uno);
            }
            else{
                listaPalabra=frecuencias.get(ent.getValue());
                listaPalabra.add(ent.getKey());
                frecuencias.put(ent.getValue(), listaPalabra);
            }
        }
        
        System.out.println(frecuencias);
    }
}
