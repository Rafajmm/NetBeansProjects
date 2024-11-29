package com.mycompany.actividad516;
import java.util.*;

public class Actividad516 {
    
    public static int busca(int t[], int clave) {
      int posicion = -1;
      int i = 0;
      while (i < t.length && t[i] != clave) {
         i++;
      }

      if (i < t.length) {
         posicion = i;
      }

      return posicion;
   }
    
    public static void main(String[] args) {
      boolean mapa[][] = {{true,  true,  false, false, false}, 
                          {false, true,  true,  false, false}, 
                          {false, true,  true,  true,  false}, 
                          {true,  false, false, true,  false}, 
                          {true,  false, false, false, true}   
                         };
      System.out.println("Lugar de origen: ");
      int origen = new Scanner(System.in).nextInt();
      System.out.println("Lugar de destino: ");
      int destino = new Scanner(System.in).nextInt();

      int lugares[] = new int[1]; 
      lugares[0] = origen;

      int copia[];

      do {
         copia = Arrays.copyOf(lugares, lugares.length); 
         
         System.out.println(Arrays.toString(lugares));
         for (int lugar : copia) {
            for (int i = 0; i < mapa.length; i++) {
               if (mapa[lugar][i]) { //podemos llegar de lugar a i
                  if (busca(lugares, i) == -1) {
                     lugares = Arrays.copyOf(lugares, lugares.length + 1);
                     lugares[lugares.length - 1] = i;
                  }
               }
            }
         }
      } while (!Arrays.equals(lugares, copia));

      if (busca(lugares, destino) != -1) {
         System.out.println("Es posible ir de " + origen + " a " + destino);
      } else {
         System.out.println(destino + " es inaccesible desde " + origen);
      }
   }

   
}