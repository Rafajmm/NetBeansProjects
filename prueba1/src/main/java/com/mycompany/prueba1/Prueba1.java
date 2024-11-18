package com.mycompany.prueba1;
import java.util.Scanner;
public class Prueba1 {

    public static void main(String[] args) {
        double a,b,c,raiz,r1,r2,d;
        
        Scanner leer=new Scanner(System.in);
        System.out.println("Introduce a: ");
        a=leer.nextDouble();
        
        
       
        System.out.println("Introduce b: ");
        b=leer.nextInt();
        
        System.out.println("Introduce c: ");
        c=leer.nextInt();
        if(b==0){
            r1=Math.sqrt(c/a);
            r2=-r1;
            System.out.println("las respuestas son "+r1+" y "+r2);
    }
        if(c==0){
            r1=0;
            r2=(b/a);
            System.out.println("las respuestas son "+r1+" y "+r2);            
    }
        if(b==0 && c==0){
            r1=Math.sqrt(a);
            System.out.println("Las soluciones son: "+r1+" y "+(-r1));
        }
        else{
            d=2*a;
            raiz=Math.sqrt(b*b-(4*a*c));
            r1=(-b+raiz)/d;
            r2=(-b-raiz)/d;
            System.out.println("la primera solucion es: " +r1);
            System.out.println("la segunda solucion es: "+r2);
        }
        
        
    }
}
