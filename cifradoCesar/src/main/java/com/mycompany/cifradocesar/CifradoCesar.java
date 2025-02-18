package com.mycompany.cifradocesar;
import java.util.*;

public class CifradoCesar {

    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        Scanner leer2=new Scanner(System.in);
        System.out.println("Introduce el número para cifrar");
        int num=leer2.nextInt();
        System.out.println("Introduce el mensaje a cifrar");
        String texto=leer.nextLine();
        
        Cifrar cadena=new Cifrar(texto,num);
        System.out.println(cadena.getCadena());
        texto=cadena.cifrar();
        System.out.println(texto);
        
        cadena=new Cifrar(texto,num);
        System.out.println(cadena.descifrar()); 
    }
}
