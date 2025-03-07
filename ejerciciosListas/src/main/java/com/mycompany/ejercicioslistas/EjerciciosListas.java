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
    
    public static ArrayList<Double> montarL(int cantidad,int minimo,int maximo){
        ArrayList<Double> lista=new ArrayList<>();       
        double alea;
        int cont=0;
        if(cantidad<=(maximo-minimo)+1){
            while(cont!=cantidad){
                alea=(int)((Math.random()*((maximo+1)-minimo))+minimo);
                if(!lista.contains(alea)){
                    lista.add(alea);
                    cont++;
                }
            }
        }
        else{
            while(cont!=cantidad){
                alea=(int)(Math.random()*cantidad);
                if(!lista.contains(alea)){
                    lista.add(alea);
                    cont++;
                }
            }
        }
        return lista;
    }
    
    public static void partir(ArrayList<Double> origen, double pivote, ArrayList<Double> mayores,ArrayList<Double> menores){
        for(int i=0;i<origen.size();i++){
            if(origen.get(i)>=pivote){
                mayores.add(origen.get(i));
                
            }
            else{
                menores.add(origen.get(i));
                
            }
        }
        origen.removeAll(origen);
    }
    
    public static Double calcularPivote(ArrayList<Double> lista){
        Double mediana=0.0;
        int posicion=(int)(lista.size()/2);
        mediana=lista.get(posicion);
        
        
        return mediana;
    }
    
    public static void ordenarM(ArrayList<Double> referencia){
        ArrayList<Double> mayores=new ArrayList<>();
        ArrayList<Double> menores=new ArrayList<>();
        if(referencia.size()>1){
            double pivote=calcularPivote(referencia);
            referencia.remove(calcularPivote(referencia));
            partir(referencia,pivote,mayores,menores);
            ordenar(mayores);
            ordenar(menores);
            referencia.addAll(menores);
            referencia.add(pivote);
            referencia.addAll(mayores);            
        }
       
    }
    
    public static void ordenar(ArrayList<Double> referencia){
        ArrayList<Double> mayores=new ArrayList<>();
        ArrayList<Double> menores=new ArrayList<>();
        if(referencia.size()>1){
            double pivote=referencia.get(0);
            referencia.remove(0);
            partir(referencia,pivote,mayores,menores);
            ordenar(mayores);
            ordenar(menores);
            referencia.addAll(menores);
            referencia.add(pivote);
            referencia.addAll(mayores);            
        }
       
    }
    
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
        
        
        //primosL(20,listaO);
        //System.out.println(listaO.toString());
        
        
        System.out.println("----------------------------------------------------------------");
        
        ArrayList<ArrayList<Double>> matriz1=new ArrayList<>();
        ArrayList<ArrayList<Double>> matriz2=new ArrayList<>();
        ArrayList<ArrayList<Double>> matriz3=productoM(2,3,4,matriz1,matriz2);
        
        System.out.println(matriz3.toString());
        
        System.out.println("----------------------------------------------------------------");
        
        ArrayList<Integer> listaI=new ArrayList<>();
        ArrayList<Integer> listaP=new ArrayList<>();
        
        for(int i=1;i<101;i++){
            if(i%2==0){
                listaP.add(i);
            }
            else{
                listaI.add(i);
            }
        }
        
        ArrayList<Integer> resul=new ArrayList<>();
        for(int i=0; i<listaP.size();i++){
            resul.add(listaI.get(i));
            resul.add(listaP.get(i));
        }
        
        System.out.println(resul.toString());
        
        System.out.println("----------------------------------------------------------------");
        
        ArrayList<Double> origen=montarL(20,1,200);
        ArrayList<Double> mayores=new ArrayList<>();
        ArrayList<Double> menores=new ArrayList<>();
        
        System.out.println(origen.toString());
//        partir(origen,10.0,mayores,menores);
//                
//        System.out.println(mayores.toString());
//        System.out.println(menores.toString());
        
        ordenarM(origen);
        System.out.println(origen);
        
        TreeMap<String,String> ejemplo=new TreeMap<>();
        ejemplo.put("hola", "8");
        ejemplo.size();
    }
}
