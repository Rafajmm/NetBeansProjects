package com.mycompany.calculadoratests;

import java.util.Scanner;

public class CalculadoraTests {
    public static void main(String[] args) {
        Calcu calculadora = new Calcu();
        boolean salir = false;
        Scanner leer = new Scanner(System.in);
        
        while (!salir) {
            System.out.println("Elige que quieres hacer (+,-,*,/) o introduce 's' para salir");
            char opcion = leer.next().charAt(0);
            
            if (opcion == 's') {
                salir = true;
                continue;
            }
            
            System.out.println("Introduce un número: ");
            int a = leer.nextInt();
            System.out.println("Introduce otro número: ");
            int b = leer.nextInt();
            
            switch(opcion) {
                case '+': 
                    System.out.println("La suma es: " + calculadora.sumar(a, b));
                    break;
                    
                case '-': 
                    System.out.println("La resta es: " + calculadora.restar(a, b));
                    break;
                    
                case '*': 
                    System.out.println("La multiplicación es: " + calculadora.multiplicar(a, b));
                    break;
                    
                case '/':                    
                    System.out.println("La división es: "+calculadora.dividir(a, b));
                    break;               
            }
            
        }
    }
}