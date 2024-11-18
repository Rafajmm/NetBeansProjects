
package funcioncomparar;
import java.util.*;

public class FuncionComparar {

    public static int funcionComparar(int a, int b){
        int resul=0;
        if(a>b){
            resul=1;
        }
        if(a<b){
            resul=-1;
        }
        return resul;   
    }
    public static void main(String[] args) {

        System.out.println(funcionComparar(4,3));
        
        
    }
    
}
