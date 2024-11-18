package ejercicio619clase;
import java.util.Scanner;

public class Ejercicio619Clase{
    
    public static void reemplazar(String texto){
        Scanner leer=new Scanner(System.in);
        String palabra,sustituta;
        System.out.println("El texto es el siguiente: "+texto);
        System.out.println("Introduce la palabra a sustituir: ");
        palabra=leer.next();
        System.out.println("Introduce la sustituta: ");
        sustituta=leer.next();
        System.out.println(texto.replaceAll(palabra, sustituta));
        
    }

   public static void main(String[] args) {
      System.out.println("Escriba el texto:");
      String texto = new Scanner(System.in).nextLine();
      
      reemplazar(texto);
      
   }
}
