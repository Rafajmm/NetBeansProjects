package ejercicioconcadenas;
import java.util.*;

public class EjercicioconCadenas {
    
    public static boolean palindromoRafa(String cadena){
        boolean resul=false;
        int longitud=cadena.length();
        String cadena2="",otra;
        Character c;
        
        for(int i=(longitud-1); i>=0;i--){
           c=cadena.charAt(i);
           otra=c.toString();
           cadena2+=otra;
        }
        
        if(cadena.equalsIgnoreCase(cadena2)){
            resul=true;
        }
        
        return resul;
    }
    
    public static boolean palindromo2Rafa(String cadena){
        boolean resul=false;        
        int cont2=0,cont1=cadena.length()-1;
        
        
        while(cont1>=0){
            if(cadena.charAt(cont1)==cadena.charAt(cont2)){
                
                resul=true;
                
                cont1--;
                cont2++;
            }
            else{
                cont1=-1;
                resul=false;
            }
        }
        
        return resul;
    }
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        System.out.println("Introduce una palabra o frase: ");
        String cadena=leer.nextLine();
        System.out.println(palindromo2Rafa(cadena));
    }
    
}
