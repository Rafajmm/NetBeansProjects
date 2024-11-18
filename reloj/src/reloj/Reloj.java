package reloj;
import java.util.Scanner;
public class Reloj {

    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        System.out.println("introduce la hora");
        int h=leer.nextInt();
        System.out.println("introduce los minutos");
        int m=leer.nextInt();
        System.out.println("introduce la segundos");
        int s=leer.nextInt();
        System.out.println("La hora introducida es: "+h+":"+m+":"+s+". Introduce los segundos que quieres sumar a la hora: ");
        long seg=leer.nextLong();
        
        for(int i=0;i<seg;i++){
            s++;
            if(s==60){
                s=0;
                m++;
                if(m==60){
                    m=0;
                    h++;
                }
                if(h==24){
                    h=0;
                }
            }
        }
        System.out.println("La hora modificada es: "+h+":"+m+":"+s);
    }
    
}
