package actividad511;
import java.util.*;

public class Actividad511 {

    public static int[] guardarPosiciones(int vector[], int clave){
        int resul[]=new int[0],j=0;
        for(int i=0;i<vector.length;i++){
            
            if(vector[i]==clave){
                resul=Arrays.copyOf(resul, resul.length+1);
                resul[j]=i;
                j++;
            }
        }
        return resul;
    }
    public static void main(String[] args) {
        int vector[]={1,7,2,3,3,4,5,6,7,7};
        System.out.println(Arrays.toString(guardarPosiciones(vector,7)));
    }
    
}
