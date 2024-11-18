package autoevaluacion;
import java.util.*;

public class Autoevaluacion {

    public static void datosEnteros(int a){
        
    } 
    public static void main(String[] args) {
        
        Scanner leer=new Scanner(System.in);
        int c=1,min=0,max=0,suma=0,contador=0;
        
        while(c!=0){
            System.out.println("Introduce los números que quieras. Introduce 0 para detener.");
            int a=leer.nextInt();
            
            if(a==0){
                c=a;
            }
            
            else{
                contador++;
                suma+=a;
                if(a>max){
                    max=a;
                }
                if(a<min){
                    min=a;
                }
            }
        }
        System.out.println("El minimo es: "+min+" el maximo es: "+max+" y la media es: "+(suma/contador));
    }
    
}
