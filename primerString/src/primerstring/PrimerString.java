package primerstring;
import java.util.*;

public class PrimerString {
    

    public static void primeraCadena(String cadena){
        int longitud=cadena.length();
        int contador=0;
        for(int i=0;i<longitud;i++){
            contador++;
            if(cadena.charAt(i)==' '){
                contador++;
            }
            else{
                if(contador%2==0){
                    System.out.print(cadena.toUpperCase().charAt(i)+"");
                }
                else{
                    System.out.print(cadena.toLowerCase().charAt(i)+"");
                }
            }
        }
    }
    
    public static boolean compCadenas(String cadena, String cadena1){
        boolean valor=false;
        if(cadena.equals(cadena1)){           
            valor=true;
        }
        return valor;
    }
    
    public static String nombreApellidos(String nombre,String apellido1,String apellido2){
        String nombreComp;
        nombreComp=nombre+" "+apellido1+" "+apellido2;
        return nombreComp;
    }
    
    public static void main(String[] args) {
        String nombre,apellido1,apellido2;
        Scanner leer=new Scanner(System.in);
        System.out.println("Introduce una nombre ");
        nombre=leer.nextLine();
        System.out.println("Introduce el primer apellido ");
        apellido1=leer.nextLine();
        System.out.println("Introduce el segundo apellido ");
        apellido2=leer.nextLine();
        System.out.println(nombreApellidos(nombre,apellido1,apellido2));
        //System.out.println(cadena.compareTo(cadena1));
        //System.out.println(compCadenas(cadena,cadena1));
    
        
    }
                
    }
    

