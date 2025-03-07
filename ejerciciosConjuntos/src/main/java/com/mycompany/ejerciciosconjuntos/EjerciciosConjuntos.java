/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejerciciosconjuntos;
import java.util.*;
/**
 *
 * @author usuario
 */
public class EjerciciosConjuntos {

    public static void main(String[] args) {
        System.out.println("---------------------------------------Ejercicio1------------------------------------------------------");
        /*
        int contador=0;
        Scanner teclado=new Scanner(System.in);
        TreeSet<String> palabras=new TreeSet<>();
        
        System.out.println("Introduce palabras");
        while(contador<10){
            System.out.println("");
            String palabra=teclado.next();
            palabras.add(palabra);
            contador++;
        }
        
        for(String palabra: palabras){
            System.out.println(palabra);
        }
        */
        
        System.out.println("---------------------------------------Ejercicio2------------------------------------------------------");
        
        ArrayList<Integer> numAl=new ArrayList<>();
        TreeSet<Integer> numO=new TreeSet<>();
        int alea;
        
        while(numO.size()<50){
            alea=(int)((Math.random()*100)+1);
                
                numO.add(alea);
            
        }
        
        System.out.println(numO);
        
        
        for(int i=1;i<101;i++){
            if(!numO.contains(i)){
                numAl.add(i);
            }
        }
        
        System.out.println(numAl);
        
        System.out.println("---------------------------------------Ejercicio3------------------------------------------------------");
        /*
        String inst=" ";
        int cont=0;
        
        String separado[]=new String[2];
        ArrayList<String> lista=new ArrayList<>();
        HashSet<Integer> conjunto=new HashSet<>();
        Scanner tecladoS=new Scanner(System.in);
        Scanner tecladoI=new Scanner(System.in);
        
        System.out.println("Introduce el número de instrucciones");
        int numero=tecladoI.nextInt();
        
        System.out.println("Introduce las instrucciones en el formato 'I X'. Introduce 'stop' para detener la entrada.");
        System.out.println("(1 para introducir, 2 para eliminar, 3 para imprimir. Ej: 1 9)");
        while(cont<numero){
            inst=tecladoS.nextLine();
            if(!inst.equals("stop") && inst.indexOf(" ")!=1){
                System.out.println("Formato no válido");
            }
            else{
                lista.add(inst);
                cont++;
            }
        }
        
        for(String num: lista){
            separado=num.split(" ");
            
            if(separado[0].equals("1")){
                conjunto.add(Integer.parseInt(separado[1]));
            }
            else if(separado[0].equals("2")){
                conjunto.remove(Integer.parseInt(separado[1]));
            }
            else{
                if(conjunto.contains(Integer.parseInt(separado[1]))){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
        */
        System.out.println("---------------------------------------Ejercicio3------------------------------------------------------");
        
        TreeSet<String> favo=new TreeSet<>();
        Scanner teclado=new Scanner(System.in);
        String p;
        
        System.out.println("Introduce diez palabras distintas");
        while(favo.size()<10){
            p=teclado.next();
            if(favo.contains(p)){
                System.out.println("Eso ya lo has introducido");
            }
            else{
                favo.add(p);
            }            
        }
        
        System.out.println(favo.descendingSet());
    }
}
