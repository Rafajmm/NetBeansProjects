package com.mycompany.multiplo;
import java.util.Scanner;
public class Multiplo {

    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        System.out.println("Introduce un numero entero: ");
        int a=leer.nextInt();
        System.out.println("Introduce otro numero entero: ");
        int b=leer.nextInt();
        if(a>b){
            if(a%b==0)
                System.out.println("El primer numero introducido es multiplo del segundo");
            else
                System.out.println("El primer numero introducido NO es multiplo del segundo");
        }
        else{
            if(b%a==0)
                System.out.println("El segundo numero introducido es multiplo del primero");
            else
                System.out.println("El segundo numero introducido NO es multiplo del primero");
        }
    }
}
