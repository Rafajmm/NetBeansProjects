package ejercicio618;
import java.util.*;

public class Ejercicio618 {

    public static String camel(String frase){
        
        int pos;
        frase=frase.toLowerCase();
        
        while(frase.indexOf(' ')!=-1){
        pos=frase.indexOf(' ');
        frase=frase.substring(0, pos)+frase.toUpperCase().charAt(pos+1)+frase.substring(pos+1+1);
        }
        
        return frase;
    }
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        System.out.println("Introduce una frase");
        String frase=leer.nextLine();
        System.out.println(camel(frase));
        
        
    }
    
}
