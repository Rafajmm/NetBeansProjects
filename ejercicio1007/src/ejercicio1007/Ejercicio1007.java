/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1007;
import java.io.*;
import java.util.*;
/**
 *
 * @author usuario
 */
public class Ejercicio1007 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       String linea1="En un lugar de la Mancha,";
//       String linea2="de cuyo nombre no quiero acordarme!!";
//       BufferedWriter out=null;
//     
//       try{
//           out=new BufferedWriter(new FileWriter("../quijote.txt"));
//           for(int i=0;i<linea1.length();i++){
//               out.write(linea1.charAt(i));
//           }
//           
//           out.newLine();
//           out.write(linea2);
//       }
//       catch(IOException e){
//           System.out.println(e.getMessage());
//       }
//       finally{
//           if(out!=null){
//               try{
//                   out.close();
//               }
//               catch(IOException e2){
//                   System.out.println(e2.getMessage());
//               }
//           }
//       }
        String ruta="C:\\Users\\usuario\\Desktop\\xampp-control.ini";
        ManejarIni uno=new ManejarIni(ruta);
        System.out.println(uno.getContenido());
        
        System.out.println(uno.cambiar("Editiones","3"));
        System.out.println(uno.getContenido());

        System.out.println(uno.añadir("prueba", "5"));
        System.out.println(uno.getContenido());
        System.out.println(uno.consultar("prueba"));
        System.out.println(uno.consultar("miau"));
        System.out.println(uno.borrar("prueba"));
        System.out.println(uno.borrar("miau"));
        System.out.println(uno.getContenido());


    }    
}
