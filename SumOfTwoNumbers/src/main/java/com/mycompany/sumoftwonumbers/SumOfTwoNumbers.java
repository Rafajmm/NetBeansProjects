  //Suma de dos números
package com.mycompany.sumoftwonumbers;
import java.util.Arrays;
import java.util.Scanner;
public class SumOfTwoNumbers {

    public static void main(String[] args) {
        //Declaracion de variables
        Scanner leer=new Scanner(System.in);
        
        /*Comparacion de dos numeros
        System.out.println("Introduce un número: ");
        int a=leer.nextInt();
        System.out.println("Introduce otro número: ");
        int b=leer.nextInt();
        boolean c=(a==b);
        if(c==true) System.out.println("Los números son iguales");
        else System.out.println("los números NO son iguales");*/
        
        /* perimetro de rectangulo
        System.out.println("introduce la altura del rectángulo");
        int altura=leer.nextInt();
        System.out.println("introduce el ancho del rectangulo");
        int ancho=leer.nextInt();
        System.out.println("El perímetro del rectángulo es: "+(2*altura+2*ancho));*/
        
        /* numero igual o menor que cero
        System.out.println("Introduce un número: ");
        int n=leer.nextInt();
        if(n<=0){ 
            System.out.println("Si "); 
        }        
        else{
            System.out.println("No");
        }*/
        
        /*primeros números primos
        for(int i=2;i<100;i++){
            boolean primo=true;
            for(int u=2;u<i;u++){
                if(i%u==0){
                    primo=false;
                    break;
                }
            }
            if(primo){
                System.out.println(i);
            }            
        }*/
        
        /*
        System.out.println("introduce el númro de días a convertir: ");
        int num=leer.nextInt();
        int a=num/365, meses, dias;
        meses=(num-365*a)/30;
        dias=num-(365*a)-(30*meses);
        System.out.println(a+" años "+meses+" meses "+dias+" dias ");*/
        
        /*leer string por teclado
        System.out.println("Introduce tu nombre: ");
        String n=leer.nextLine();
        System.out.println("Hola "+n);*/
        
        /*numero pseudoaleatorio entre 0 y 120
        int r=(int)(Math.random()*121); //random devuelve un valor double entre 0 y 1
        System.out.println(r); */
        
        /*
        //generar numero aleatorio dentro de un rango (ejemplo entre 18 y 99)
        int rango=100-18; //primero se define el rango
        int nr=(int)(Math.random()*rango+18); //como randon genera numeros entre 0 y 1 multiplicamos por rango para que devuelva número entre 0 y 82 y sumamos 18 para asegurar q el número mínimo que vamos a tener es 18
        System.out.println(nr); */
        
        /*
        //generador de números aleatorios primitiva
        int rango=50-1,n;
        for(int i=0;i<6;i++){
            n=(int)(Math.random()*rango+1);
            System.out.println(n);
            
        } //en este caso existe la posibilidad de que se repita algún número */
        
        /*
        //Pido número por teclado y devuelve valor absoluto (math.abs())
        System.out.println("Introduce un número: ");
        double n=leer.nextDouble();
        if(n<0){
            n*=-1; 
        }
        System.out.println(n); */
        
        /* //introducir edad y devolver si es mayor de edad o no
        System.out.println("Introduce tu edad");
        int edad=leer.nextInt();
        if(edad<0){
            System.out.println("introduce un número positivo");
            edad=leer.nextInt();
        }
        if(edad<18){
            System.out.println("NO Mayor de edad");
        }        
        else System.out.println("Mayor de edad"); */
        
        /* el chikichiki
        System.out.println("Introduce un número del 1 al 4");
        int a=leer.nextInt();
        if(a!=1 && a!=2 && a!=3 && a!=4){
            System.out.println("No has introducido un numero valido");
        }
        else{
            if(a==1){
                System.out.println("El breakdance");
            }
            if(a==2){
                System.out.println("El cruzaito");
            }
            if(a==3){
                System.out.println("El Mickael Jackson");
            }
            if(a==4){
                System.out.println("El Robocop");
            }
        } 
        
        //de otra forma
        System.out.println("Introduce un número del 1 al 4");
        int a=leer.nextInt();
        if(a>=1 && a<=4){
           if(a==1){
               System.out.println("El breakdance");
            }
           if(a==2){
               System.out.println("El cruzaito");
            }
           if(a==3){
               System.out.println("El Mickael Jackson");
            }
           if(a==4){
               System.out.println("El Robocop");
            }    
        }
        else{
            System.out.println("No has introducido un numero valido");          
        } */
        
        /* devuelve el contenido de cada fila y sus columnas
        int matriz[][]={{1,2,3,4},{5,6,7,8}};
        for(int i=0;i<matriz.length;i++){          
            for(int j=0;j<matriz[i].length;j++){
                System.out.println("fila "+i+" columna "+j+": "+matriz[i][j]);
            }
        }*/
        
        /* bucle do while con int
        int numero;
        do{
            System.out.println("Introduce un número del 1 al 4: ");
            numero=leer.nextInt();
            if(numero<1 || numero>4){
                System.out.println("Numero no valido");
            }
        }    
        while(numero<1 || numero>4);
        
        switch(numero){
            case 1: System.out.println("Breakdance");
            break;
            case 2: System.out.println("cruzaito");
            break;
            case 3: System.out.println("Michael Jackson");
            break;
            case 4: System.out.println("Robocop");
            break;
        } */
        
        /*do while con char
        char n;
        do{
            System.out.println("Introduce un letra de la 'a' a la 'd': ");
            n=leer.next().charAt(0);
            System.out.println(n);
            if(n!='a' && n!='b' && n!='c' && n!='d'){
                System.out.println("letra no válida");
            }
        }    
        while(n!='a' && n!='b' && n!='c' && n!='d');
        
        switch(n){
            case 'a': System.out.println("Breakdance");
            break;
            case 'b': System.out.println("cruzaito");
            break;
            case 'c': System.out.println("Michael Jackson");
            break;
            case 'd': System.out.println("Robocop");
            break;
        } */
        
        /*//contador con for
        System.out.println("introduce un numero entero mayor que 0");
        int n=leer.nextInt();
        for(int i=n;i>=0;i--){
            System.out.println(n);
            n--;            
        } */
        
        /*//contador con while
        int n;
        do{
        System.out.println("introduce un número mayor que 0");
        n=leer.nextInt();
        }while(n<0);
        while(n>=0){
            System.out.println(n);
            n--;            
        } */
        
        /*//devolver números multiplos de 7 do while
        int n=0;
        do{
           System.out.println(n);
           n+=7;
        }while(n<=100); */
        
        /*múltiplos de 7 con while
        int n=0;
        while(n<=100){
            System.out.println(n);
            n+=7;
        } */
        
        /*múltiplos de 7 con for
        for(int n=0;n<100;n+=7){
            System.out.println(n);
        } */
        
        /*//evalua si un año es bisiesto
        Boolean bisiesto=false;
        System.out.println("Introduce un año");
        int n=leer.nextInt();
        if(n%100==0){
            if(n%4==0 && n%400==0){
                bisiesto=true;
            }    
            //else bisiesto=false;             
        }else{
            if(n%4==0){
                bisiesto=true;
            }
            //else bisiesto=false;
        }
        if(bisiesto==true){
            System.out.println("El año "+n+" es bisiesto");
        }
        else System.out.println("El año "+n+" NO es bisiesto"); */
        
        
        
        /*int n=1;
        
        while(n!=0){
            System.out.println("Introduce un número ");
            int nu=leer.nextInt();
            if(nu!=0){
            do{                
                System.out.println(n-1);
                n+=nu;
            }while(n<100 && n>-100);
            }
            else break;
        n=1;    
        }*/
        
        /*for(int i=1;i<=100;i++){
        System.out.println(i);
        }
        for(int i=0;i<100;i+=2){
            System.out.println(i);            
        } */
      
        
    }
}    