package primerarray;
import java.util.*;

public class Primerarray {

    public static void generarAlea(int miarray[]){
        for(int i=0;i<miarray.length;i++){
            miarray[i]+=1;
        }
        
    }
    public static void imprimirNumeros(){
        
    }
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
                
        int edades[]={1,2,3,4,5,6};
        generarAlea(edades);
        System.out.println(Arrays.toString(edades));
    }
    
}
