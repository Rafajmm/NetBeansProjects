/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicioslistas;
import java.util.*;
/**
 *
 * @author usuario
 */
public class EjerciciosListas {
    
    public static void montarM(int n, int q, ArrayList matriz){
        for(int i=0;i<n;i++){
            List<Double> fila=new ArrayList<>();
            for(int j=0;j<q;j++){
                fila.add((Math.random())*10);
            }
            matriz.add(fila);
        }
    }
    public static ArrayList productoM(int n, int m, int q, ArrayList<ArrayList<Double>> matriz, ArrayList<ArrayList<Double>> matriz2){
        double sum=0.0;
        
        ArrayList<ArrayList<Double>> matrizP=new ArrayList<>();
        montarM(n, m, matriz);
        montarM(m, q, matriz2);
        
        for(int i=0;i<n;i++){
            ArrayList<Double> fila=new ArrayList<>();
            for(int k=0;k<q;k++){
                sum=0.0;
                for(int j=0;j<m;j++){
                
                
                    sum+=matriz.get(i).get(j)*matriz2.get(j).get(k);
                    
                }
                fila.add(sum);
            }
            matrizP.add(fila);
        }
        
        return matrizP;
    }
    
    public static boolean esPrimo(int numero){
        int contador = 2;
        boolean primo=true;
        while ((primo) && (contador!=numero)){
            if (numero % contador == 0)
            primo = false;
            contador++;
        }
        return primo;
    }
    
    public static void primosL(int n, ArrayList<Integer> lista){
        boolean cond=true;
        while(cond){                       
            if(lista.get(lista.size()-1)>n){
                lista.remove(lista.size()-1);                
            }
            else{
                cond=false;
            }
        }
        for(int i=0; i<lista.size();i++){
            if(!esPrimo(lista.get(i))){
                lista.remove(lista.get(i));
                i-=1;
            }
        }
        for(int i=0;i<n;i++){
            if(esPrimo(i) && !lista.contains(i)){
                lista.add(i);
            }
        }
        
    }
    
    //public static ArrayList<A>
    public static void main(String[] args) {
        ArrayList<Integer> vector=new ArrayList<>();
        for(int i=0;i<100;i++){
            vector.add(i);
        }
        
        for(int i=0;i<vector.size();i++){
            System.out.println(vector.get(i));
        }
        
        Integer array[]=vector.toArray(new Integer[0]);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
        
        System.out.println("----------------------------------------------------------------");
        
        /* Ejercicio 2
        ArrayList<String> palabras=new ArrayList<>();
        
        Scanner tecla=new Scanner(System.in);
        System.out.println("Introduce una lista de palabras separadas por un espacion");
        String arrayS[]=tecla.nextLine().split(" ");
        System.out.println(Arrays.toString(arrayS));
        
        for(int i=0; i<arrayS.length; i++){
            palabras.add(arrayS[i]);            
        }
        
        //palabras.removeIf(letra -> letra.contains("a"));
        
        for(String palabra : palabras){
            if(palabra.contains("a")){
                palabras.remove(palabra);
            }
        }
        
        for(String palabra : palabras){
            System.out.println(palabra);
        }
        */
        
        System.out.println("----------------------------------------------------------------");
        
        ArrayList<Integer> lNum=new ArrayList<>();
        ArrayList<Integer> lNum2=new ArrayList<>();
        ArrayList<Integer> lNum3=new ArrayList<>();
        int alea;
        for(int i=0; i<9999;i++){
            alea=(int)((Math.random()*100)+1);
            lNum.add(alea);
            alea=(int)((Math.random()*100)+1);
            lNum2.add(alea);
        }
        
        for(int i=0; i<9999;i++){
            if(lNum.get(i)>lNum2.get(i)){
                lNum3.add(lNum.get(i));
            }
            else if(lNum.get(i)<lNum2.get(i)){
                lNum3.add(lNum2.get(i));
            }
            else{
               lNum3.add(lNum2.get(i)); 
            }
        }
        
        int suma=0;
        
        for(int i=0;i<lNum3.size();i++){
            suma+=lNum3.get(i);
        }
        int media=(suma/lNum3.size());
        System.out.println(media);
        
        System.out.println("----------------------------------------------------------------");
        
        ArrayList<Integer> listaO=new ArrayList<>();
        ArrayList<Integer> listaR=new ArrayList<>();
        for(int i=0;i<20;i++){
            listaO.add((int)((Math.random()*20)+1));
        }
        
        for(int i=0;i<listaO.size();i++){
            for(int z=0;z<listaO.get(i);z++){
                listaR.add(listaO.get(i));
            }
        }
        System.out.println(listaR.toString());
        
        System.out.println("----------------------------------------------------------------");
        
        System.out.println(listaO.toString());
        
        int aux;
        boolean cond=false;
        
        while(!cond){
            cond=true;
            for(int i=0;i<(listaO.size()-1);i++){
               if(listaO.get(i)>listaO.get(i+1)){
                   aux=listaO.get(i);
                   listaO.set(i, listaO.get(i+1));
                   listaO.set(i+1, aux);                   
                   cond=false;
               }               
           }           
        }
        
        System.out.println(listaO.toString());
        
        System.out.println("----------------------------------------------------------------");
        
        
        primosL(20,listaO);
        System.out.println(listaO.toString());
        
        
        System.out.println("----------------------------------------------------------------");
        
        ArrayList<ArrayList<Double>> matriz1=new ArrayList<>();
        ArrayList<ArrayList<Double>> matriz2=new ArrayList<>();
        ArrayList<ArrayList<Double>> matriz3=productoM(2,3,4,matriz1,matriz2);
        
        System.out.println(matriz3.toString());
        
        
        
        
    }
}
