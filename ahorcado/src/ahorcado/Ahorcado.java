package ahorcado;
import java.util.*;

public class Ahorcado {
    
    public static String ahorcado(String palabra){
        Scanner leer=new Scanner(System.in);
        String solucion="",solucion1,solucion2;
        char letra;
        int contador=7,longitud=palabra.length(),pos;
        
        System.out.println("La palabra tiene "+longitud+" letras.");
        
        for(int i=0;i<longitud;i++){
            solucion+="_";
        }
        
        while(contador>0){
            
            System.out.println(solucion);
            System.out.println("Introduce una letra: ");
            letra=leer.next().charAt(0);
            pos=palabra.indexOf(letra);            
            
            if(pos!=-1){
                solucion1=solucion.substring(0, pos);
                solucion2=solucion.substring(pos+1);
                solucion=solucion1+letra+solucion2;
            }
            
            if(solucion.indexOf('_')==-1){
                System.out.println("¡Has ganado!");
                contador=0;                
            }
            
            else {
                contador--;
                System.out.println("Te quedan "+contador+" intentos");
                if(contador==0){
                    System.out.println("Lo siento, has perdido.");
                }
            }
            
        }
        
        return solucion;
    }
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        System.out.println("Juego del ahorcado. Introduce la palabra a adivinar:");
        String palabra=leer.next();
        System.out.println(ahorcado(palabra));
            
            
        
            
    }
}
    

