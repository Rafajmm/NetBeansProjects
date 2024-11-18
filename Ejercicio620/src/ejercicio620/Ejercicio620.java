package ejercicio620;
import java.util.*;


public class Ejercicio620 {

    public static void ordenarPalabras(String frase){
        String palabras[]=frase.split(" ");
        System.out.println(palabras.length);
        
      
    }
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        System.out.println("Introduce una frase: ");
        String frase=leer.nextLine();
        ordenarPalabras(frase);
        
        
    }
    
}
