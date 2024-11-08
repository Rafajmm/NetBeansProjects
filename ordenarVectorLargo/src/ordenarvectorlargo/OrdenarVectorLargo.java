package ordenarvectorlargo;
import java.util.*;
public class OrdenarVectorLargo {

    public static void main(String[] args) {
        int cantidad[]={5,5000,50000,5000000,50000000},n=cantidad[(int)(Math.random()*(cantidad.length-1))];
        int numeros[]=new int[n];
        for(int i=0;i<numeros.length;i++){
            numeros[i]=(int)(Math.random()*n);
        }
        System.out.println(n);
        int numeros2[]=Arrays.copyOf(numeros, numeros.length);
        Arrays.sort(numeros2);
        System.out.println(Arrays.toString(numeros));
        System.out.println(Arrays.toString(numeros2));
    }
    
}
