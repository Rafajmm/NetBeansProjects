package actividad53;
import java.util.*;

/**
 *
 * @author usuario
 */
public class Actividad53 {

    public static void generarAlea(int miarray[]){
        for(int i=0;i<miarray.length;i++){
            miarray[i]+=1;
        }
        
    }
    public static void imprimirNumeros(){
        
    }
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);      
        int cantidad=leer.nextInt(),numero;
        int numeros[]=new int[cantidad];
        
        for(int i=0;i<cantidad;i++){
            numeros[i]=leer.nextInt();
        }
        System.out.println(Arrays.toString(numeros));
        for(int i=(numeros.length-1);i>=0;i--){
            System.out.println(numeros[i]);
        }
        
    }
    
}