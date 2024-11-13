package mezclar2arrays;
import java.util.*;

public class Mezclar2Arrays {
    
    public static int[] generaArray(){
        int[] array=new int[(int)(Math.random()*11)];
        for(int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*100);
        }
        return array;
    }
    
    public static int[] mezclarStrings(int[] primero, int[] segundo){
        int mezcla[]=new int[primero.length+segundo.length],condicion1=primero.length,condicion2=segundo.length,i=0,j=0,k=0;
        while(i<condicion1 || j<condicion2){
            if(i<condicion1){
                mezcla[k]=primero[i];
                k++;
                i++;
            }
            if(j<condicion2){
                mezcla[k]=segundo[j];
                k++;
                j++;
            }
        }        
        return mezcla;      
    }
    
    
    
    public static void main(String[] args) {
        int primero[]=generaArray(),segundo[]=generaArray(),mezcla[]=mezclarStrings(primero,segundo);
        
        
        System.out.println(Arrays.toString(primero)+" + "+Arrays.toString(segundo)+" = "+Arrays.toString(mezcla));
    }
    
}
