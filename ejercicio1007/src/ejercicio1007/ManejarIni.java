/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1007;

import java.util.*;
import java.io.*;

/**
 *
 * @author usuario
 */
public class ManejarIni {
    private LinkedHashMap<String,String> contenido=new LinkedHashMap<>();
    
    ManejarIni(String ruta){
       lectura(ruta); 
    }
    
    public void lectura(String ruta){
        BufferedReader leer=null;      
        
        if(comprobarExtension(ruta)){   
            try{
                leer=new BufferedReader(new FileReader(ruta));
                String linea=leer.readLine().trim();
                
                while(linea!=null){
                  if(!linea.startsWith("[") && !linea.startsWith(";") && !linea.startsWith("#")){  //comprobamos 
                      String lin[]=linea.split("=");
                      if(lin.length<2){
                          contenido.put(lin[0].trim(),null); //si la variable está vacía (por ejemplo, "Edition=") añadimos null como valor.
                      }
                      else{
                          contenido.put(lin[0].trim(),lin[1].trim());
                      }                      
                  }
                  linea=leer.readLine();
                }
                leer.close();
            }            
            
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public boolean cambiar(String key, String value){
       if(contenido.containsKey(key)){
           contenido.replace(key, value);
           return true;
       }
       else return false;
    }
    
    public boolean añadir(String key, String value){
        if(contenido.containsKey(key)) return false;
        else{
            contenido.put(key, value);
            return true;
        }
    }
    
    public String consultar(String key){
        if(contenido.containsKey(key)){
            return contenido.get(key);
        }
        else return null;
    }
    
    public boolean borrar(String key){
        if(contenido.containsKey(key)){
            contenido.remove(key);            
            return true;
        }
        else return false;
    }
    
    public void leer(String rutaUso, String rutaNueva){
        BufferedWriter escribir=null;
        try{
            escribir=new BufferedWriter(new FileWriter(rutaUso));
        
            for(Map.Entry<String,String> entrada: contenido.entrySet()){
                escribir.write(entrada.getKey()+"="+entrada.getValue());
                escribir.newLine();
            }
            escribir.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        lectura(rutaNueva);
    }
    
    public boolean comprobarExtension(String ruta){
        String fin="";        
        for(int i=ruta.length()-1;i>ruta.length()-5;i--){
            fin+=ruta.charAt(i);
        }
        return fin.equals("ini.");
    }    
    
    public LinkedHashMap getContenido(){
        return contenido;
    }
}
