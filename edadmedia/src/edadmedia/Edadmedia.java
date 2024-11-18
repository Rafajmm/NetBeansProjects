package edadmedia;
import java.util.Arrays;
import java.util.Scanner;
public class Edadmedia {
    public static void main(String[] args) {
        
        int n=0,suma=0,contador=0;
        double media=0;
        Scanner leer=new Scanner(System.in);
        
        while(n!=-1){
            System.out.println("introduce una edad. Usa '-1' para calcular: ");
            n=leer.nextInt();
            if(n>=18 && n<=100){
                suma+=n;
                contador++;
                media=(double)suma/contador;
            }
        }
        if(media==0) System.out.println("no has introducido ninguna edad mayor de 18");
        else System.out.println("la media de edad es: "+media);    
    
        
    }    
}
