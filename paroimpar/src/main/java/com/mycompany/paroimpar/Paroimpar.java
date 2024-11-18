package com.mycompany.paroimpar;
import java.util.Scanner;
public class Paroimpar {

    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        System.out.println("Introduce un numero entero: ");
        int numero=leer.nextInt();
        if(numero%2==0)
            System.out.println("El numero es par");
        else
            System.out.println("El numero es impar");
     }
}
